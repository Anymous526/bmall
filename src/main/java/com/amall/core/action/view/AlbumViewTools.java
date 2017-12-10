package com.amall.core.action.view;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.service.image.IAlbumService;
import com.amall.core.web.tools.CommUtil;

@Component
public class AlbumViewTools
{

	@Autowired
	private IAlbumService albumService;

	@Autowired
	private IAccessoryService accessoryService;

	public List <Accessory> query_album (String id)
		{
			List <Accessory> list = new ArrayList <Accessory> ();
			AccessoryExample accessoryExample = new AccessoryExample ();
			if ((id != null) && (!id.equals ("")))
			{
				accessoryExample.clear ();
				accessoryExample.createCriteria ().andAlbumIdEqualTo (CommUtil.null2Long (id));
				list = accessoryService.getObjectList (accessoryExample);
			}
			else
			{
				accessoryExample.clear ();
				accessoryExample.createCriteria ().andAlbumIdIsNull ();
				list = accessoryService.getObjectList (accessoryExample);
			}
			return list;
		}
}
