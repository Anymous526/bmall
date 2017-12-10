package com.amall.core.action.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.amall.common.constant.Globals;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.group.IGroupService;
import com.amall.core.service.store.IStoreService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;
import com.amall.core.web.tools.CommUtil;

@Controller
public class VerifyAction
{

	@Autowired
	private IUserService userService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private ISysConfigService configService;

	/**
	 * 
	 * <p>
	 * Title: validate_code
	 * </p>
	 * <p>
	 * Description: 验证码
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param code
	 * @param code_name
	 */
	@RequestMapping({ "/verify_code.htm" })
	public void validate_code (HttpServletRequest request , HttpServletResponse response , String code , String code_name)
		{
			HttpSession session = request.getSession (false);
			String verify_code = "";
			if (CommUtil.null2String (code_name).equals (""))
				verify_code = (String) session.getAttribute ("verify_code");
			else
			{
				verify_code = (String) session.getAttribute (code_name);
			}
			boolean ret = true;
			System.out.println ("verify_code = : " + verify_code);
			if ((verify_code != null) && (!verify_code.equals ("")) && (!CommUtil.null2String (code.toUpperCase ()).equals (verify_code)))
			{
				ret = false;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/verify_sms_code.htm" })
	public void verify_sms_code (HttpServletRequest request , HttpServletResponse response , String smscode)
		{
			Boolean ret = true;
			HttpSession session = request.getSession (false);
			String sessionCode = (String) session.getAttribute (Globals.SMS_CODE);
			String oldTime = (String) session.getAttribute (Globals.SMS_CODE_TIME);
			if (sessionCode == null || oldTime == null)
			{
				ret = false;
			}
			else
			{
				long interval = CommUtil.getTimeInterval (oldTime , String.valueOf (System.currentTimeMillis ()));
				int exceedTime = Integer.valueOf (this.configService.getSysConfig ().getSmsExceedTime ());
				long temp = exceedTime * Globals.SECOND_TO_MINUTE;
				if (!sessionCode.equals (smscode) || temp < interval)
				{
					ret = false;
				}
			}
			System.out.println ("verify_smscode = : " + smscode+","+ret);
			
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	/**
	 * 根据用户名和用户id查询用户是否存在 存在写出true ，不存在写出false
	 * 
	 * @param request
	 * @param response
	 * @param userName
	 * @param id
	 */
	@RequestMapping({ "/verify_username.htm" })
	public void verify_username (HttpServletRequest request , HttpServletResponse response , String userName , String id)
		{
			boolean ret = true;
			/*
			 * Map params = new HashMap();
			 * params.put("userName", userName);
			 * params.put("id", CommUtil.null2Long(id));
			 * List users = this.userService
			 * .query("select obj from User obj where obj.userName=:userName and obj.id!=:id",
			 * params, -1, -1);
			 */
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andUsernameEqualTo (userName).andIdNotEqualTo (CommUtil.null2Long (id));
			List <User> users = userService.getObjectList (userExample);
			if (users != null && users.size () > 0)
			{
				ret = true;
			}
			else
			{
				ret = false;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/verify_email.htm" })
	public void verify_email (HttpServletRequest request , HttpServletResponse response , String email , String id)
		{
			boolean ret = false;
			/*
			 * Map params = new HashMap();
			 * params.put("email", email);
			 * params.put("id", CommUtil.null2Long(id));
			 * List users = this.userService
			 * .query("select obj from User obj where obj.email=:email and obj.id!=:id",
			 * params, -1, -1);
			 */
			UserExample userExample = new UserExample ();
			userExample.clear ();
			// userExample.createCriteria().andEmailEqualTo(email).andIdEqualTo(CommUtil.null2Long(id));
			userExample.createCriteria ().andEmailEqualTo (email).andIdNotEqualTo (CommUtil.null2Long (id));
			List <User> users = userService.getObjectList (userExample);
			if (users != null)
			{
				ret = true;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/verify_storename.htm" })
	public void verify_storename (HttpServletRequest request , HttpServletResponse response , String store_name , String id)
		{
			boolean ret = true;
			/*
			 * Map params = new HashMap();
			 * params.put("store_name", store_name);
			 * params.put("id", CommUtil.null2Long(id));
			 * List users = this.storeService
			 * .query("select obj from Store obj where obj.store_name=:store_name and obj.id!=:id",
			 * params, -1, -1);
			 */
			StoreExample storeExample = new StoreExample ();
			storeExample.clear ();
			storeExample.createCriteria ().andStoreNameEqualTo (store_name).andIdEqualTo (CommUtil.null2Long (id));
			List <StoreWithBLOBs> users = storeService.getObjectList (storeExample);
			if ((users != null) && (users.size () > 0))
			{
				ret = false;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/verify_mobile.htm" })
	public void verify_mobile (HttpServletRequest request , HttpServletResponse response , String mobile , String id)
		{
			boolean ret = false;
			/*
			 * Map params = new HashMap();
			 * params.put("mobile", mobile);
			 * params.put("id", CommUtil.null2Long(id));
			 * List users = this.userService
			 * .query("select obj from User obj where obj.mobile=:mobile and obj.id!=:id",
			 * params, -1, -1);
			 */
			UserExample userExample = new UserExample ();
			userExample.clear ();
			userExample.createCriteria ().andMobileEqualTo (mobile).andIdEqualTo (CommUtil.null2Long (id));
			List <User> users = userService.getObjectList (userExample);
			if ((users != null) && (users.size () > 0))
			{
				ret = true;
			}
			response.setContentType ("text/plain");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setCharacterEncoding ("UTF-8");
			try
			{
				PrintWriter writer = response.getWriter ();
				writer.print (ret);
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}

	@RequestMapping({ "/verify.htm" })
	public void verify (HttpServletRequest request , HttpServletResponse response , String name) throws IOException
		{
			response.setContentType ("image/jpeg");
			response.setHeader ("Pragma" , "No-cache");
			response.setHeader ("Cache-Control" , "no-cache");
			response.setDateHeader ("Expires" , 0L);
			HttpSession session = request.getSession (false);
			int width = 73;
			int height = 27;
			BufferedImage image = new BufferedImage (width , height , 1);
			Graphics g = image.getGraphics ();
			Random random = new Random ();
			// g.setColor(getRandColor(200, 250));
			g.fillRect (0 , 0 , width , height);
			// g.setFont(new Font("Times New Roman", 0, fontRandom(10, 11)));
			/*
			 * for(int as = 0; as < 4; as++)
			 * {
			 * g.setFont(new Font("隶书",Font.ITALIC + Font.LAYOUT_NO_START_CONTEXT, fontRandom(10,
			 * 11)));
			 * }
			 */
			g.setColor (getRandColor (100 , 240));
			for (int i = 0 ; i < 45 ; i++)
			{
				int x = random.nextInt (width);
				int y = random.nextInt (height);
				int xl = random.nextInt (12);
				int yl = random.nextInt (12);
				g.drawLine (x , y , x + xl , y + yl);
			}
			String sRand = "";
			/*
			 * for (int i = 0; i < 6; i++) {
			 * String rand = drawRandomNum((Graphics2D)g);
			 * sRand = sRand + rand;
			 * g.setColor(
			 * new Color(20 + random.nextInt(110), 20 + random
			 * .nextInt(110), 20 + random.nextInt(110)));
			 * g.drawString(rand, randomJianju(5, 7) * i + 1, 24);
			 * }
			 */
			String rand = drawRandomNum ((Graphics2D) g);
			sRand = sRand + rand;
			// g.drawString(rand, randomJianju(5, 7) * 6 + 1, 24);
			if (CommUtil.null2String (name).equals (""))
				session.setAttribute ("verify_code" , sRand);
			else
			{
				session.setAttribute (name , sRand);
			}
			g.dispose ();
			ServletOutputStream responseOutputStream = response.getOutputStream ();
			ImageIO.write (image , "JPEG" , responseOutputStream);
			responseOutputStream.flush ();
			responseOutputStream.close ();
		}

//	private int randomJianju (int i , int j)
//		{
//			Random random = new Random ();
//			int x = (random.nextInt (i) + j);
//			return x;
//		}

	/**
	 *      * 画随机汉字
	 *      *
	 *      * @param g
	 *      * @return
	 *     
	 */
	private String drawRandomNum (Graphics2D g)
		{
			Random random = new Random ();
			StringBuffer sb = new StringBuffer ();
			// 设置颜色
			// g.setColor(Color.RED);
			g.setColor (new Color (20 + random.nextInt (150) , 20 + random.nextInt (150) , 20 + random.nextInt (150)));
			// 设置字体
			g.setFont (new Font ("宋体" , Font.BOLD , 20));
			// 准备常用汉字集
			String base = "0123456789ABCDEFGLJKHMNPQRSTUVWXYZ";
	//		String base = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
			
			
			int x = 5;
			// 控制字数
			for (int i = 0 ; i < 4 ; i++)
			{
				int max=20;
		        int min=14;
		        Random rand = new Random();
		        int s = random.nextInt(max)%(max-min+1) + min;
				
				// 设置字体旋转角度
				int degree = new Random ().nextInt () % 30;
				// 截取汉字
				String ch = base.charAt (new Random ().nextInt (base.length ())) + "";
				sb.append (ch);
				
				
				// 正向角度
				g.rotate (degree * Math.PI / 180 , x , 20);
				g.drawString (ch , x , 20);
				// g.setColor(new Color(20 + random.nextInt(50), 20 + random.nextInt(50), 20 +
				// random.nextInt(50)));
				
				
				
				// 反向角度
				
				g.rotate (-degree * Math.PI / 180 , x , 20);
				x += s;
			}
			return sb.toString ();
		}

//	private int fontRandom (int a , int b)
//		{
//			int c = (int) ((Math.random () * a) + b);
//			return c;
//		}

	private Color getRandColor (int fc , int bc)
		{
			Random random = new Random ();
			if (fc > 255)
				fc = 255;
			if (bc > 255)
				bc = 255;
			int r = fc + random.nextInt (bc - fc);
			int g = fc + random.nextInt (bc - fc);
			int b = fc + random.nextInt (bc - fc);
			return new Color (r , g , b);
		}
	/*
	 * @RequestMapping("/verify.htm")
	 * public void verificationCode(String picId, HttpServletRequest request, HttpServletResponse
	 * response, ModelMap model) {
	 * response.setCharacterEncoding("utf-8");
	 * response.addHeader("pragma", "no-cache");
	 * response.setContentType("image/*");
	 * int num1 = (int)(Math.random() * 10);
	 * int num2 = (int)(Math.random() * 10);
	 * int sum = num1+num2;
	 * //生成随机类
	 * Random random = new Random();
	 * int funNo = random.nextInt(3);//产生[0,2]之间的随机整数  
	 * sum = 0;
	 * switch (funNo) {
	 * case 0: sum = num1 + num2; break;
	 * case 1: sum = num1 - num2; break;
	 * case 2: sum = num1 * num2; break;
	 * }
	 * HttpSession session=request.getSession();
	 * session.setAttribute("verify_code", String.valueOf(sum));
	 * System.out.println("sum : " + sum);
	 * BufferedImage image = VerificationCode.createVerificationImage(num1, num2, funNo);
	 * try {
	 * ImageIO.write(image, "JPEG", response.getOutputStream());
	 * } catch (IOException e) {
	 * // 错误处理
	 * PrintWriter toClient;
	 * try {
	 * toClient = response.getWriter(); // 得到向客户端输出文本的对象
	 * response.setContentType("text/html;charset=utf-8");
	 * toClient.write("生成图片失败!");
	 * toClient.close();
	 * } catch (IOException e1) {
	 * e1.printStackTrace();
	 * }
	 * }
	 * }
	 */
}
