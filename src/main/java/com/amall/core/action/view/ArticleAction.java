package com.amall.core.action.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.amall.core.bean.Article;
import com.amall.core.bean.ArticleExample;
import com.amall.core.service.article.IArticleService;
import com.amall.core.web.tools.CommUtil;
import net.sf.json.JSONArray;

@Controller
public class ArticleAction
{

	@Autowired
	private IArticleService articleService;

	@RequestMapping({ "/article_list_query.htm" })
	public void article_list_query (HttpServletRequest request , HttpServletResponse response)
		{
			ArticleExample articleExample = new ArticleExample ();
			articleExample.setOrderByClause ("addtime desc");
			articleExample.createCriteria ().andDisplayEqualTo (true);
			List <Article> list = this.articleService.getObjectList (articleExample);
			/* 返回的json字符串 */
			String jsonStr = "";
			if (list != null && !list.isEmpty ())
			{
				Map <String, String> map = new LinkedHashMap <String, String> ();
				Article article = null;
				/* 只取最近10条消息 */
				for (int i = 0 ; i < list.size () ; i++)
				{
					if (i == 10)
						break;
					article = list.get (i);
					String value = "<span class='wetop1'>[公告]" + article.getTitle () + "</span>" + "<span class='wetop2'>" + CommUtil.formatShortDate (article.getAddtime ()) + "</span>";
					map.put (article.getId ().toString () , value);
				}
				if (!map.isEmpty ())
				{
					jsonStr = JSONArray.fromObject (map).toString ();
				}
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (jsonStr);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/article_query_id.htm" })
	public void article_query_id (HttpServletRequest request , HttpServletResponse response , Long id)
		{
			if (id == null)
				return;
			Article article = this.articleService.getByKey (id);
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (article.getContent ());
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
}
