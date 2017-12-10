 package com.amall.core.action.view;
 
 import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amall.core.bean.Document;
import com.amall.core.bean.DocumentExample;
import com.amall.core.service.IDocumentService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.virtual.JModelAndView;
 

/**
 * 
 * <p>Title: DocumentViewAction</p>
 * <p>Description: 链接文档 显示</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月25日下午2:40:17
 * @version 1.0
 */
 @Controller
 public class DocumentViewAction
 {
 
   @Autowired
   private ISysConfigService configService;
 
   @Autowired
   private IUserConfigService userConfigService;
 
   @Autowired
   private IDocumentService documentService;
 
   @RequestMapping({"/doc.htm"})
   public ModelAndView doc(HttpServletRequest request, HttpServletResponse response, String mark)
   {
     ModelAndView mv = new JModelAndView("doc.html", this.configService
       .getSysConfig(), this.userConfigService.getUserConfig(), 1, 
       request, response);
     DocumentExample documentExample = new DocumentExample();
     documentExample.clear();
     documentExample.createCriteria().andMarkEqualTo(mark);
     List<Document> objs = documentService.getObjectList(documentExample);
     Document obj = null;
     if (objs.size()>0 && objs !=null)
    	 obj = objs.get(0);
     
    // Document obj = this.documentService.getObjByProperty("mark", mark);
     mv.addObject("obj", obj);
     return mv;
   }
 }

