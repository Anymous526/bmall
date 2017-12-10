package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.CloudCodes;
import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsAuto;
import com.amall.core.bean.CloudGoodsAutoExample;
import com.amall.core.bean.CloudStatistics;
import com.amall.core.bean.CloudStatisticsAuto;
import com.amall.core.bean.CloudStatisticsExample;
import com.amall.core.security.support.SecurityUserHolder;
import com.amall.core.service.cloud.ICloudCodesService;
import com.amall.core.service.cloud.ICloudGoodsAutoService;
import com.amall.core.service.cloud.ICloudGoodsService;
import com.amall.core.service.cloud.ICloudStatisticsAutoService;
import com.amall.core.service.cloud.ICloudStatisticsService;
@Component
public class CloudGoodsAutoPublicTools {
	
	@Autowired
	private ICloudStatisticsService cloudStatisticsService;
	
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	
	@Autowired
	private ICloudCodesService cloudCodesService;
	
	@Autowired
	private ICloudGoodsAutoService cloudGoodsAutoService;
	
	@Autowired
	private ICloudStatisticsAutoService cloudStatisticsAutoService;
	
	public Long addCloudGoods(CloudGoodsAuto cloudGoodsAuto){
		
		CloudGoods cloudGoods = new CloudGoods();
		
		Date date = new Date();
		cloudGoods.setAddtime(date);
		cloudGoods.setBeginTime(date);
		//long endTime = date.getTime() + cloudGoodsAuto.getTimeInterval()*Globals.HOUR*Globals.MILLISECOND_TO_SECOND;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + cloudGoodsAuto.getTimeInterval());
		cloudGoods.setEndTime(calendar.getTime());
		cloudGoods.setExchangeLimit(cloudGoodsAuto.getExchangeLimit());
		cloudGoods.setGoodsClassId(cloudGoodsAuto.getGoodsClassId());
		cloudGoods.setGoodsCount(cloudGoodsAuto.getGoodsCount());
		cloudGoods.setGoodsImgId(cloudGoodsAuto.getGoodsImgId());
		cloudGoods.setGoodsName(cloudGoodsAuto.getGoodsName());
		cloudGoods.setGoodsNumber(cloudGoodsAuto.getGoodsNumber());
		cloudGoods.setGoodsPackList(cloudGoodsAuto.getGoodsPackList());
		cloudGoods.setGoodsPrice(cloudGoodsAuto.getGoodsPrice());
		cloudGoods.setGoodsTag(cloudGoodsAuto.getGoodsTag());
		cloudGoods.setIgContent(cloudGoodsAuto.getIgContent());
		cloudGoods.setIsShow(true);
		cloudGoods.setGoodsSn("cloud"
				+ CommUtil.formatTime("yyyyMMddHHmmss", new Date()));
		
		cloudGoodsService.add(cloudGoods);
		Long goodsId = cloudGoods.getId();
		
		List<CloudStatistics> statisticsList = cloudStatisticsService.getObjectList(new CloudStatisticsExample());
		
		CloudStatistics cloudStatistics = null;
		
		if(statisticsList.isEmpty())
		{
			cloudStatistics = new CloudStatistics();
			cloudStatistics.setAddtime(new Date());
			cloudStatistics.setGoodsCount(1l);
			cloudStatisticsService.add(cloudStatistics);
		}
		else
		{
			cloudStatistics = statisticsList.get(0);
			cloudStatistics.setGoodsCount(cloudStatistics.getGoodsCount() + 1l);
			cloudStatisticsService.updateByObject(cloudStatistics);
		}
		
		/* 生成云码 */
		try
		{
			generalCodes(goodsId, cloudGoods.getGoodsCount());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			cloudGoodsService.deleteByKey(goodsId);
		}
		
		return goodsId;
	}
	
	/** 
	* @Title: generalCodes 
	* @Description: 生成云码
	* @param cloudGoodsId
	* @param counts
	* @throws 
	* @author tangxiang
	* @date 2016年1月28日
	*/
	public void generalCodes(long cloudGoodsId, int counts)
	{
		if(cloudGoodsId == 0 || counts == 0)
		{
			return;
		}
		
		int[] arr = new int[counts];
		
		for(int i = 0; i < counts; i++)
		{
			arr[i] = i + 1;
		}
		
		upsetArray(arr);
		
		List<CloudCodes> list = new ArrayList<>();
		
		CloudCodes cloudCodes = null;
		
		for(int code:arr)
		{
			cloudCodes = new CloudCodes();
			cloudCodes.setCloudGoodsId(cloudGoodsId);
			cloudCodes.setCode(code);
			list.add(cloudCodes);
		}
		
		cloudCodesService.add(list);
	}
	
	/** 
	* @Title: upsetArray 
	* @Description: 打乱数组
	* @param arr
	* @throws 
	* @author tangxiang
	* @date 2016年1月20日
	*/
	public void upsetArray(int[] arr)
	{
		int temp = 0;
		
		int randomNumber = 0;
		
    	Random random = new Random();
		
		for(int i = 0; i < arr.length; i++)
		{
			randomNumber = random.nextInt(arr.length);
			temp = arr[i];
			arr[i] = arr[randomNumber];
			arr[randomNumber] = temp;
		}
	}
	
	public void openAndPassAddCloudGoods(CloudGoods cloudGoods, String flag){
		
		CloudGoodsAutoExample cloudGoodsAutoExample = new CloudGoodsAutoExample();
		cloudGoodsAutoExample.createCriteria().andCloudGoodsIdEqualTo(cloudGoods.getId());
		List<CloudGoodsAuto> autos = cloudGoodsAutoService.getObjectList(cloudGoodsAutoExample);
		
		cloudGoodsAutoExample.clear();
		cloudGoodsAutoExample.createCriteria().andIsEnableEqualTo(true).andCloudGoodsIdEqualTo(cloudGoods.getId()).
					andRemainGoodsNumberGreaterThan(1);
		List<CloudGoodsAuto> autos2 = cloudGoodsAutoService.getObjectList(cloudGoodsAutoExample);
		if(autos.size() > 0){
			CloudGoodsAuto cloudGoodsAuto = autos.get(0);
			if (autos2.size() > 0) {
				Long cloudGoodsId = addCloudGoods(cloudGoodsAuto);
				cloudGoodsAuto.setCloudGoodsId(cloudGoodsId);
			}else
				cloudGoodsAuto.setCloudGoodsId(0l);
			cloudGoodsAuto.setRemainGoodsNumber(cloudGoodsAuto.getRemainGoodsNumber() - 1);
			if("open".equals(flag))
				cloudGoodsAuto.setOpenGoodsNumber(cloudGoodsAuto.getOpenGoodsNumber() + 1);
			else if("pass".equals(flag))	
				cloudGoodsAuto.setPassGoodsNumber(cloudGoodsAuto.getPassGoodsNumber() + 1);
			cloudGoodsAutoService.updateByObject(cloudGoodsAuto);
			
			CloudStatisticsAuto statisticsAuto = new CloudStatisticsAuto();
			statisticsAuto.setCloudGoodsAutoId(cloudGoodsAuto.getId());
			statisticsAuto.setCloudGoodsId(cloudGoods.getId());
			if("open".equals(flag))
				statisticsAuto.setIsOpen(true);
			else if("pass".equals(flag))	
				statisticsAuto.setIsPass(true);
			cloudStatisticsAutoService.add(statisticsAuto);
		}
	}
}
