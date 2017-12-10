package com.amall.core.action.kuaidi;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.amall.core.bean.KuaiDiResultItem;
import com.amall.core.bean.KuaiDiStatus;
import com.amall.core.bean.KuaiTakeLog;
import com.amall.core.service.kuaidi.IKuaidiService;
import com.amall.core.service.kuaidi.IKuaidiStatusService;
import com.amall.core.service.kuaidi.IKuaidiTakeLogService;
import com.amall.core.web.express.kuaidi100.Kuadi100Conifg;
import com.amall.core.web.express.kuaidi100.NoticeRequest;
import com.amall.core.web.express.kuaidi100.NoticeResponse;
import com.amall.core.web.express.kuaidi100.Result;
import com.amall.core.web.express.kuaidi100.ResultItem;

@Controller
public class KuaidiAction {
	
	Logger logger = Logger.getLogger (KuaidiAction.class);

	@Autowired
	IKuaidiService kuaidiService;
	
	@Autowired
	IKuaidiStatusService statusServcie;
	
	@Autowired
	IKuaidiTakeLogService kuaidiTakeLogService;
	
	/**
	 * 快递100回调推送
	 * <p>Title: kuaidi100Request</p>
	 * <p>Description: </p>
	 * @param request
	 * @param response
	 * @param param
	 * @throws IOException 
	 */
	@RequestMapping({ "/kuaidi100BackCall.htm" })
	public void kuaidi100BackCall(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		NoticeResponse resp = new NoticeResponse();
		resp.setResult(false);
		resp.setReturnCode("500");
		resp.setMessage("保存失败");
		try {
			String param = request.getParameter(Kuadi100Conifg.getPARAM_NAME());
			logger.info("快递返回值="+param);
			NoticeRequest nReq = Json.fromJson(NoticeRequest.class, param);

			Result result = nReq.getLastResult();
			// 更新快递状态 或新增
			KuaiDiStatus kuaiDiStatus = statusServcie.getKuaiDiStatus(result.getNu());
			if(kuaiDiStatus != null)
			{
				kuaiDiStatus.setStatus(result.getState());
				kuaiDiStatus.setTime(new Date());
				statusServcie.updateKuaiDiStauts(kuaiDiStatus);
			}
			else
			{
				logger.info("ok");
				kuaiDiStatus = new KuaiDiStatus();
				kuaiDiStatus.setStatus(result.getState());
				kuaiDiStatus.setTime(new Date());
				kuaiDiStatus.setKuaidiNum(result.getNu());
				kuaiDiStatus.setCompany(result.getCom());
				statusServcie.saveKuaiDiStatus(kuaiDiStatus);
			}
			
			
			
			//更新快递信息
			List<ResultItem> resList = result.getData();
			logger.info("快递信息记录数="+resList.size());
			//先删除以前的信息
			kuaidiService.delete(result.getNu());
			
			KuaiDiResultItem resultItem;
			
			//插入新信息
			for(ResultItem item:resList)
			{
				resultItem = new KuaiDiResultItem();
				resultItem.setContext(item.getContext());
				resultItem.setTime(item.getFtime());
				resultItem.setKuaidinum(result.getNu());
				kuaidiService.save(resultItem);
			}
			
			// ------ 结束
			
			//记录日志
			KuaiTakeLog log = new KuaiTakeLog();
			log.setCompany(kuaiDiStatus.getCompany());
			log.setKuaidinum(result.getNu());
			log.setState(kuaiDiStatus.getStatus());
			log.setTime(kuaiDiStatus.getTime());
			kuaidiTakeLogService.save(log);
			
			resp.setResult(true);
			resp.setReturnCode("200");
			resp.setMessage("保存成功");
			response.getWriter().print(Json.toJson(resp)); //这里必须返回，否则认为失败，过30分钟又会重复推送。
			logger.info("快递返回值状态："+result.getStatus());
		} catch (Exception e) {
			resp.setMessage("保存失败" + e.getMessage());
			response.getWriter().print(Json.toJson(resp));//保存失败，服务端等30分钟会重复推送。
		}
		
	}
		
	
}
