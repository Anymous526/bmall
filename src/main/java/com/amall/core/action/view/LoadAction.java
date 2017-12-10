package com.amall.core.action.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.service.address.IAreaService;

@Controller
public class LoadAction
{

	@Autowired
	private IAreaService areaService;

	/**
	 * 加载区域
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@RequestMapping({ "/load_area.htm" })
	public void load_area (HttpServletRequest request , HttpServletResponse response , String pid)
		{
			AreaExample example = new AreaExample ();
			example.or ().andParentIdEqualTo (Long.valueOf (Long.parseLong (pid)));
			List <Area> areas = this.areaService.getObjectList (example);
			List <Map <String, Object>> list = new ArrayList <Map <String, Object>> ();
			for (Area area : areas)
			{
				Map <String, Object> map = new HashMap <String, Object> ();
				map.put ("id" , area.getId ());
				map.put ("areaName" , area.getAreaname ());
				list.add (map);
			}
			String temp = Json.toJson (list , JsonFormat.compact ());
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (temp);
				writer.close ();
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
}
