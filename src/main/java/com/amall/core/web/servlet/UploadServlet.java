package com.amall.core.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.constant.Globals;
import com.amall.core.service.system.ISysConfigService;

/**
 * 
 * <p>Title: UploadServlet</p>
 * <p>Description: 文件上传</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-27上午1:17:48
 * @version 1.0
 */
public class UploadServlet extends HttpServlet {
	@Autowired
	private ISysConfigService configService;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得传入的路径
		String addPath = Globals.UPLOAD_ROOT_FILE_PATH
				+ "space"
				+ File.separator
				+ request.getParameter("path")
				+ File.separator;
		File f1 = new File(addPath);
		//判断路径是否存在，如果不存在就新建
		if (!f1.exists()) {
			f1.mkdirs();
		}
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List fileList = null;
		try {
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return;
		}
		Iterator it = fileList.iterator();
		String name = "";
		String extName = "";
		while (it.hasNext()) {
			FileItem item = (FileItem) it.next();
			//判断不是文件夹
			if (!item.isFormField()) {
				//获得文件名
				name = item.getName();
				long size = item.getSize();
				String type = item.getContentType();
				if ((name == null) || (name.trim().equals(""))) {
					continue;
				}
				//获得后缀名
				if (name.lastIndexOf(".") >= 0) {
					extName = name.substring(name.lastIndexOf("."));
				}
				File file = null;
				do {
					//防止重名
					name = UUID.randomUUID().toString();
					file = new File(addPath + name + extName);
				} while (file.exists());
				File addFile = new File(addPath + name + extName);
				try {
					//保存
					item.write(addFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//输出文件名+后缀名
		response.getWriter().print(name + extName);
	}
}
