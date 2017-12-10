package com.amall.core.web.tools;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.system.ISysConfigService;

@Component
public class ImageViewTools {

	@Autowired
	private ISysConfigService configService;

	public String random_login_img() {
		String img = "";
		SysConfigWithBLOBs config = this.configService.getSysConfig();
		if (config.getLoginImgs().size() > 0) {
			Random random = new Random();
			Accessory acc = (Accessory) config.getLoginImgs().get(
					random.nextInt(config.getLoginImgs().size()));
			img = acc.getPath() + "/" + acc.getName();
		} else {
			img = "resources/style/common/images/login_img.jpg";
		}
		return img;
	}
}
