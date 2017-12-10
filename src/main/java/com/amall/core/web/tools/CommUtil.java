package com.amall.core.web.tools;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.im4java.core.ConvertCmd;
import org.im4java.core.GMOperation;
import org.im4java.core.IM4JavaException;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amall.common.constant.Globals;
import com.amall.core.bean.Accessory;
import com.amall.core.lucene.LuceneResult;
import com.amall.core.web.page.Pagination;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * <p>
 * Title: CommUtil
 * </p>
 * <p>
 * Description: 公共的工具类
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-28下午5:42:30
 * @version 1.0
 */
public class CommUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static final Whitelist user_content_filter = Whitelist.relaxed();
	static int totalFolder;
	static int totalFile;

	/**
	 * 用来保存订单流水计数，最大9999
	 */
	static int addedOrderNumber = Globals.NUBER_ZERO;

	static {
		user_content_filter.addTags(new String[] { "embed", "object", "param",
				"span", "div", "font" });
		user_content_filter.addAttributes(":all", new String[] { "style",
				"class", "id", "name" });
		user_content_filter.addAttributes("object", new String[] { "width",
				"height", "classid", "codebase" });
		user_content_filter.addAttributes("param", new String[] { "name",
				"value" });
		user_content_filter.addAttributes("embed",
				new String[] { "src", "quality", "width", "height",
						"allowFullScreen", "allowScriptAccess", "flashvars",
						"name", "type", "pluginspage" });

		totalFolder = 0;
		totalFile = 0;
	}

	/**
	 * 
	 * <p>
	 * Title: first2low
	 * </p>
	 * <p>
	 * Description: 将传入的字符串 第一个字符转换成小写
	 * </p>
	 * 
	 * @param str
	 *            传入的字符串
	 * @return String 第一个字符小写的字符串
	 */
	public static String first2low(String str) {
		String s = "";
		s = str.substring(0, 1).toLowerCase() + str.substring(1);
		return s;
	}
	
	public static String formatDate(Date date, String format) {
		SimpleDateFormat simple = new SimpleDateFormat(format);
		return simple.format(date);

	}

	/**
	 * 
	 * <p>
	 * Title: first2upper
	 * </p>
	 * <p>
	 * Description: 将传入的字符串 第一个字符转换成大写
	 * </p>
	 * 
	 * @param str
	 *            传入的字符串
	 * @return String 第一个字符大写的字符串
	 */
	public static String first2upper(String str) {
		String s = "";
		s = str.substring(0, 1).toUpperCase() + str.substring(1);
		return s;
	}

	/**
	 * 
	 * <p>
	 * Title: str2list
	 * </p>
	 * <p>
	 * Description: 将传入的字符串 转换为list存储
	 * </p>
	 * 
	 * @param str
	 *            传入的字符串
	 * @return String 存储字符串的list集合
	 */
	public static List<String> str2list(String s) throws IOException {
		List list = new ArrayList();
		if ((s != null) && (!s.equals(""))) {
			StringReader fr = new StringReader(s);
			BufferedReader br = new BufferedReader(fr);
			String aline = "";
			while ((aline = br.readLine()) != null) {
				list.add(aline);
			}
		}
		return list;
	}

	/**
	 * 
	 * <p>
	 * Title: formatDate
	 * </p>
	 * <p>
	 * Description: 将传入的字符串转换为日期类型
	 * </p>
	 * 
	 * @param s
	 *            传入日期格式的字符串
	 * @return Date 格式化后的日期
	 */
	public static Date formatDate(String s) {
		Date d = null;
		try {
			d = dateFormat.parse(s);
		} catch (Exception localException) {
		}
		return d;
	}

	/**
	 * 
	 * <p>
	 * Title: formatDate
	 * </p>
	 * <p>
	 * Description: 将传入的字符串，按照传入的指定格式 格式化，转换为日期类型
	 * </p>
	 * 
	 * @param s
	 *            日期格式的字符串
	 * @param format
	 *            指定的日期格式
	 * @return date 格式化后的日期
	 */
	public static Date formatDate(String s, String format) {
		Date d = null;
		try {
			SimpleDateFormat dFormat = new SimpleDateFormat(format);
			d = dFormat.parse(s);
		} catch (Exception localException) {
		}
		return d;
	}

	/**
	 * 
	 * <p>
	 * Title: formatTime
	 * </p>
	 * <p>
	 * Description: 将传入的object类型，按照传入的指定格式 格式化，转换为String类型
	 * </p>
	 * 
	 * @param format
	 *            指定的格式
	 * @param v
	 *            object
	 * @return String 转换后的字符串
	 */
	public static String formatTime(String format, Object v) {
		if (v == null)
			return null;
		if (v.equals(""))
			return "";
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(v);
	}

	/**
	 * 
	 * <p>
	 * Title: formatLongDate
	 * </p>
	 * <p>
	 * Description: 将传入的object类型，按照 yyyy-MM-dd HH:mm:ss 格式 格式化，转换为String类型
	 * </p>
	 * 
	 * @param v
	 *            object
	 * @return String 转换后的字符串
	 */
	public static String formatLongDate(Object v) {
		if ((v == null) || (v.equals("")))
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(v);
	}

	public static String format2Date(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	public static Date formatString2Date(String v) {
		Date date = new Date();
		try {
			if ((v == null) || (v.equals("")))
				return null;
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			date = df.parse(v);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * <p>
	 * Title: formatShortDate
	 * </p>
	 * <p>
	 * Description: 将传入的object类型，按照 yyyy-MM-dd 格式 格式化，转换为String类型
	 * </p>
	 * 
	 * @param v
	 *            object
	 * @return String 转换后的字符串
	 */
	public static String formatShortDate(Object v) {
		if (v == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(v);
	}

	public static String formatDate(Object v) {
		if (v == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(v);
	}

	/**
	 * 
	 * <p>
	 * Title: decode
	 * </p>
	 * <p>
	 * Description: 使用UTF-8编码类型对 传入的路径 解码
	 * </p>
	 * 
	 * @param s
	 *            传入的路径
	 * @return String 解码后的 路径
	 */
	public static String decode(String s) {
		String ret = s;
		try {
			ret = URLDecoder.decode(s.trim(), "UTF-8");
		} catch (Exception localException) {
		}
		return ret;
	}
	/**
	 *  Description: 使用UTF-8编码类型对 传入的路径 解码, 去除全部空字符
	 * @param s
	 * @return
	 */
	public static String decodeAndReplaceNULL(String s){
		String ret =s;
		try {
			ret = URLDecoder.decode(s.replace(" ", ""),"UTF-8");
		} catch (Exception e) {
		}
		return ret;
	}

	/**
	 * 
	 * <p>
	 * Title: encode
	 * </p>
	 * <p>
	 * Description: 使用UTF-8编码类型对 传入的路径 编码
	 * </p>
	 * 
	 * @param s
	 *            传入的路径
	 * @return String 编码后的 路径
	 */
	public static String encode(String s) {
		String ret = s;
		try {
			ret = URLEncoder.encode(s.trim(), "UTF-8");
		} catch (Exception localException) {
		}
		return ret;
	}

	/**
	 * 
	 * <p>
	 * Title: convert
	 * </p>
	 * <p>
	 * Description: 先将传入的 str按ISO-8859-1编码，转换为字节数组 再通过使用指定的 coding 解码指定的
	 * 此数组，构造一个新的 String。
	 * </p>
	 * 
	 * @param str
	 *            传入的字符串
	 * @param coding
	 *            指定的编码格式
	 * @return String 转换化的字符串
	 */
	public static String convert(String str, String coding) {
		String newStr = "";
		if (str != null)
			try {
				newStr = new String(str.getBytes("ISO-8859-1"), coding);
			} catch (Exception e) {
				return newStr;
			}
		return newStr;
	}

	/**
	 * 图片压缩处理
	 */
	public static void imgageCompression(String imgPath, int width, int height) {
		GMOperation op = new GMOperation();
		// 待处理图片的绝对路径
		op.addImage(imgPath);

		// 图片压缩比，有效值范围是0.0-100.0，数值越大，缩略图越清晰
		op.quality(50.0);

		// width 和height可以是原图的尺寸，也可以是按比例处理后的尺寸
		op.addRawArgs("-resize", width + "x" + height);

		op.addRawArgs("-gravity", "center");

		// 处理后图片的绝对路径
		op.addImage(imgPath);

		// 如果使用ImageMagick，设为false,使用GraphicsMagick，就设为true，默认为false
		ConvertCmd convert = new ConvertCmd(true);

		try {
			convert.run(op);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IM4JavaException e) {
			e.printStackTrace();
		}
	}

	public static void imgageCompression(String imgPath, String compressPath,
			int width, int height) {
		GMOperation op = new GMOperation();

		// 待处理图片的绝对路径
		op.addImage(imgPath);

		// 图片压缩比，有效值范围是0.0-100.0，数值越大，缩略图越清晰
		op.quality(50.0);

		// width 和height可以是原图的尺寸，也可以是按比例处理后的尺寸
		op.addRawArgs("-resize", width + "x" + height);

		op.addRawArgs("-gravity", "center");

		// 处理后图片的绝对路径
		op.addImage(compressPath);

		// 如果使用ImageMagick，设为false,使用GraphicsMagick，就设为true，默认为false
		ConvertCmd convert = new ConvertCmd(true);

		try {
			convert.run(op);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IM4JavaException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <p>
	 * Title: saveFileToServer
	 * </p>
	 * <p>
	 * Description: 保存文件到服务器 同时将 对应的信息存储到map中
	 * </p>
	 * 
	 * @param request
	 * @param filePath
	 *            文件路径
	 * @param addFilePathName
	 *            保存文件路径名称
	 * @param addFileName
	 *            保存文件名称
	 * @param extendes
	 * @return map 存储了文件上传过程中所有的参数
	 * @throws IOException
	 */

	public static Map saveFileToServer(HttpServletRequest request,
			String filePath, String addFilePathName, String addFileName,
			String[] extendes) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
				.getFile(filePath);
		Map map = new HashMap();
		if ((file != null) && (!file.isEmpty())) {
			String extend = file.getOriginalFilename()
					// 后缀名
					.substring(file.getOriginalFilename().lastIndexOf(".") + 1)
					.toLowerCase();
			if ((addFileName == null) || (addFileName.trim().equals(""))) {
				addFileName = UUID.randomUUID().toString() + "." + extend; // 文件名
			}
			if (addFileName.lastIndexOf(".") < 0) {
				addFileName = addFileName + "." + extend; // 文件名
			}
			float fileSize = Float.valueOf((float) file.getSize()).floatValue();
			List errors = new ArrayList();
			boolean flag = true;
			if (extendes != null) {
				for (String s : extendes) {
					if (extend.toLowerCase().equals(s))
						flag = true;
				}
			}
			if (flag) {
				File path = new File(addFilePathName);
				if (!path.exists()) {
					path.mkdir();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				DataOutputStream out = new DataOutputStream(
						new FileOutputStream(addFilePathName + File.separator
								+ addFileName));
				InputStream is = null;
				try {
					is = file.getInputStream();
					int size = (int) fileSize;
					byte[] buffer = new byte[size];
					while (is.read(buffer) > 0)
						out.write(buffer);
				} catch (IOException exception) {
					exception.printStackTrace();
				} finally {
					if (is != null) {
						is.close();
					}
					if (out != null) {
						out.close();
					}
				}
				if (isImg(extend)) {
					File img = new File(addFilePathName + File.separator
							+ addFileName);
					try {
						BufferedImage bis = ImageIO.read(img);
						int w = bis.getWidth();
						int h = bis.getHeight();
						imgageCompression(addFilePathName + File.separator
								+ addFileName, w, h);
						map.put("width", Integer.valueOf(w));
						map.put("height", Integer.valueOf(h));
					} catch (Exception localException) {
					}
				}
				String fileName = addFileName.substring(0,
						addFileName.indexOf("."));
				map.put("mime", extend);
				map.put("noExtFileName", fileName);
				map.put("fileName", addFileName);
				map.put("fileSize", Float.valueOf(fileSize));
				map.put("error", errors);
				map.put("oldName", file.getOriginalFilename());
			} else {
				errors.add("不允许的扩展名");
			}
		} else {
			map.put("width", Integer.valueOf(0));
			map.put("height", Integer.valueOf(0));
			map.put("mime", "");
			map.put("fileName", "");
			map.put("fileSize", Float.valueOf(0.0F));
			map.put("oldName", "");
		}
		return map;
	}

	public static Map saveGoodsImgToServer(HttpServletRequest request,
			String filePath, String addFilePathName, String addFileName,
			String[] extendes) throws IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
				.getFile(filePath);
		Map map = new HashMap();
		if ((file != null) && (!file.isEmpty())) {
			String extend = file.getOriginalFilename()
					// 后缀名
					.substring(file.getOriginalFilename().lastIndexOf(".") + 1)
					.toLowerCase();
			if ((addFileName == null) || (addFileName.trim().equals(""))) {
				addFileName = UUID.randomUUID().toString() + "." + extend; // 文件名
			}
			if (addFileName.lastIndexOf(".") < 0) {
				addFileName = addFileName + "." + extend; // 文件名
			}
			float fileSize = Float.valueOf((float) file.getSize()).floatValue();
			List errors = new ArrayList();
			boolean flag = true;
			if (extendes != null) {
				for (String s : extendes) {
					if (extend.toLowerCase().equals(s))
						flag = true;
				}
			}
			if (flag) {
				File path = new File(addFilePathName);
				if (!path.exists()) {
					path.mkdir();
				}

				String saveSrcFile = addFilePathName + File.separator + "src_"
						+ addFileName;

				String saveCompFile = addFilePathName + File.separator
						+ addFileName;

				DataOutputStream out = new DataOutputStream(
						new FileOutputStream(saveSrcFile));
				InputStream is = null;
				try {
					is = file.getInputStream();
					int size = (int) fileSize;
					byte[] buffer = new byte[size];
					while (is.read(buffer) > 0)
						out.write(buffer);
				} catch (IOException exception) {
					exception.printStackTrace();
				} finally {
					if (is != null) {
						is.close();
					}
					if (out != null) {
						out.close();
					}
				}
				/* 图片压缩 */
				if (isImg(extend)) {
					File srcImg = new File(saveSrcFile);
					try {
						BufferedImage bis = ImageIO.read(srcImg);
						map.put("srcWidth", bis.getWidth());
						map.put("srcHeight", bis.getHeight());
						map.put("srcFileSize", srcImg.length());

						imgageCompression(saveSrcFile, saveCompFile,
								Globals.FRAME_WIDTH, Globals.FRAME_HEIGHT);
						File compImg = new File(saveCompFile);
						bis = ImageIO.read(compImg);

						map.put("compWidth", bis.getWidth());
						map.put("compHeight", bis.getHeight());
						map.put("compFileSize", compImg.length());
					} catch (Exception localException) {
					}
				}
				String srcFileName = "src_"
						+ addFileName.substring(0, addFileName.indexOf("."));

				String compFileName = addFileName.substring(0,
						addFileName.indexOf("."));

				map.put("mime", extend);
				map.put("noExtSrcFileName", srcFileName);
				map.put("noExtCompFileName", compFileName);
				map.put("srcFileName", "src_" + addFileName);
				map.put("compFileName", addFileName);
				map.put("error", errors);
				map.put("oldName", file.getOriginalFilename());
			} else {
				errors.add("不允许的扩展名");
			}
		}

		return map;
	}

	/**
	 * 
	 * <p>
	 * Title: isImg
	 * </p>
	 * <p>
	 * Description: 判断是否是图片
	 * </p>
	 * 
	 * @param extend
	 *            文件的后缀名
	 * @return boolean
	 */
	public static boolean isImg(String extend) {
		boolean ret = false;
		List<String> list = new ArrayList();
		list.add("jpg");
		list.add("jpeg");
		list.add("bmp");
		list.add("gif");
		list.add("png");
		list.add("tif");
		for (String s : list) {
			if (s.equals(extend))
				ret = true;
		}
		return ret;
	}

	public static final void waterMarkWithImage(String pressImg,
			String targetImg, int pos, float alpha) {
		try {
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, 1);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);

			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			g.setComposite(AlphaComposite.getInstance(10, alpha / 100.0F));
			int width_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			int x = 0;
			int y = 0;

			if (pos == 2) {
				x = (width - width_biao) / 2;
				y = 0;
			}
			if (pos == 3) {
				x = width - width_biao;
				y = 0;
			}
			if (pos == 4) {
				x = width - width_biao;
				y = (height - height_biao) / 2;
			}
			if (pos == 5) {
				x = width - width_biao;
				y = height - height_biao;
			}
			if (pos == 6) {
				x = (width - width_biao) / 2;
				y = height - height_biao;
			}
			if (pos == 7) {
				x = 0;
				y = height - height_biao;
			}
			if (pos == 8) {
				x = 0;
				y = (height - height_biao) / 2;
			}
			if (pos == 9) {
				x = (width - width_biao) / 2;
				y = (height - height_biao) / 2;
			}
			g.drawImage(src_biao, x, y, width_biao, height_biao, null);

			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <p>
	 * Title: createSmall
	 * </p>
	 * <p>
	 * Description: 按倍率缩放图片
	 * </p>
	 * 
	 * @param source
	 * @param target
	 * @param width
	 * @param height
	 * @return
	 */
	public static boolean createSmall(String source, String target,
			float width, float height) {
		try {
			File sourceFile = new File(source);
			File targetFile = new File(target);
			BufferedImage bis = ImageIO.read(sourceFile);
			float w = bis.getWidth();
			float h = bis.getHeight();
			float nw = width;
			float nh = nw * h / w;
			ImageCompress.ImageScale(source, target, width, height);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean createSmall_old(String source, String target,
			int width) {
		try {
			File sourceFile = new File(source);
			File targetFile = new File(target);
			BufferedImage bis = ImageIO.read(sourceFile);
			int w = bis.getWidth();
			int h = bis.getHeight();
			int nw = width;
			int nh = nw * h / w;
			ImageScale is = new ImageScale();
			is.saveImageAsJpg(source, target, nw, nh);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean waterMarkWithText(String filePath, String outPath,
			String text, String markContentColor, Font font, int pos,
			float qualNum) {
		ImageIcon imgIcon = new ImageIcon(filePath);
		Image theImg = imgIcon.getImage();
		int width = theImg.getWidth(null);
		int height = theImg.getHeight(null);
		BufferedImage bimage = new BufferedImage(width, height, 1);
		Graphics2D g = bimage.createGraphics();
		if (font == null) {
			font = new Font("黑体", 1, 30);
			g.setFont(font);
		} else {
			g.setFont(font);
		}
		g.setColor(getColor(markContentColor));
		g.setBackground(Color.white);
		g.drawImage(theImg, 0, 0, null);
		FontMetrics metrics = new FontMetrics(font) {
		};
		Rectangle2D bounds = metrics.getStringBounds(text, null);
		int widthInPixels = (int) bounds.getWidth();
		int heightInPixels = (int) bounds.getHeight();
		int left = 0;
		int top = heightInPixels;

		if (pos == 2) {
			left = width / 2;
			top = heightInPixels;
		}
		if (pos == 3) {
			left = width - widthInPixels;
			top = heightInPixels;
		}
		if (pos == 4) {
			left = width - widthInPixels;
			top = height / 2;
		}
		if (pos == 5) {
			left = width - widthInPixels;
			top = height - heightInPixels;
		}
		if (pos == 6) {
			left = width / 2;
			top = height - heightInPixels;
		}
		if (pos == 7) {
			left = 0;
			top = height - heightInPixels;
		}
		if (pos == 8) {
			left = 0;
			top = height / 2;
		}
		if (pos == 9) {
			left = width / 2;
			top = height / 2;
		}
		g.drawString(text, left, top);
		g.dispose();
		try {
			FileOutputStream out = new FileOutputStream(outPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
			param.setQuality(qualNum, true);
			encoder.encode(bimage, param);
			out.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * <p>
	 * Title: createFolder
	 * </p>
	 * <p>
	 * Description: 根据传入的路径创建文件夹
	 * </p>
	 * 
	 * @param folderPath
	 * @return
	 */
	public static boolean createFolder(String folderPath) {
		boolean ret = true;
		try {
			File myFilePath = new File(folderPath);
			if ((!myFilePath.exists()) && (!myFilePath.isDirectory())) {
				ret = myFilePath.mkdirs();
				if (!ret)
					System.out.println("创建文件夹出错");
			}
		} catch (Exception e) {
			System.out.println("创建文件夹出错");
			ret = false;
		}
		return ret;
	}

	public static List toRowChildList(List list, int perNum) {
		List l = new ArrayList();
		if (list == null) {
			return l;
		}

		for (int i = 0; i < list.size(); i += perNum) {
			List cList = new ArrayList();
			for (int j = 0; j < perNum; j++)
				if (i + j < list.size())
					cList.add(list.get(i + j));
			l.add(cList);
		}
		return l;
	}

	public static List copyList(List list, int begin, int end) {
		List l = new ArrayList();
		if (list == null)
			return l;
		if (end > list.size())
			end = list.size();
		for (int i = begin; i < end; i++) {
			l.add(list.get(i));
		}
		return l;
	}

	public static boolean isNotNull(Object obj) {
		return (obj != null) && (!obj.toString().equals(""));
	}

	public static void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];

				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错 ");
			e.printStackTrace();
		}
	}

	public static boolean deleteFolder(String path) {
		boolean flag = false;
		File file = new File(path);

		if (!file.exists()) {
			return flag;
		}

		if (file.isFile()) {
			return deleteFile(path);
		}
		return deleteDirectory(path);
	}

	public static boolean deleteFile(String path) {
		boolean flag = false;
		File file = new File(path);

		if ((file.isFile()) && (file.exists())) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	public static boolean deleteDirectory(String path) {
		if (!path.endsWith(File.separator)) {
			path = path + File.separator;
		}
		File dirFile = new File(path);

		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			return false;
		}
		boolean flag = true;

		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			return false;
		}

		return dirFile.delete();
	}

	/**
	 * 
	 * <p>
	 * Title: showPageStaticHtml
	 * </p>
	 * <p>
	 * Description: 静态分页处理
	 * </p>
	 * 
	 * @param url
	 *            路径
	 * @param currentPage
	 *            当前页码
	 * @param pages
	 *            总页码数
	 * @return String 点击页码后的路径
	 */
	public static String showPageStaticHtml(String url, int currentPage,
			int pages) {
		String s = "";
		if (pages > 0) {
			if (currentPage >= 1) {
				s = s + "<a href='" + url + "_1.htm'>首页</a> ";
				if (currentPage > 1) {
					s = s + "<a href='" + url + "_" + (currentPage - 1)
							+ ".htm'>上一页</a> ";
				}
			}
			int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
			if (beginPage <= pages) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages) && (j < 6); j++) {
					if (i == currentPage)
						s = s + "<a class='this' href='" + url + "_" + i
								+ ".htm'>" + i + "</a> ";
					else
						s = s + "<a href='" + url + "_" + i + ".htm'>" + i
								+ "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage <= pages) {
				if (currentPage < pages) {
					s = s + "<a href='" + url + "_" + (currentPage + 1)
							+ ".htm'>下一页</a> ";
				}
				s = s + "<a href='" + url + "_" + pages + ".htm'>末页</a> ";
			}
		}
		return s;
	}

	/**
	 * 
	 * <p>
	 * Title: showPageHtml
	 * </p>
	 * <p>
	 * Description: 分页处理
	 * </p>
	 * 
	 * @param url
	 *            路径
	 * @param params
	 *            参数
	 * @param currentPage
	 *            当前页码数
	 * @param pages
	 *            总页码数
	 * @return String 点击页码后的路径
	 */
	public static String showPageHtml(String url, String params,
			int currentPage, int pages) {
		String s = "";
		if (pages > 0) {
			if (currentPage >= 1) {
				s = s + "<a href='" + url + "?currentPage=1" + params
						+ "'>首页</a> ";
				if (currentPage > 1) {
					s = s + "<a href='" + url + "?currentPage="
							+ (currentPage - 1) + params + "'>上一页</a> ";
				}
			}
			int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
			if (beginPage <= pages) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages) && (j < 6); j++) {
					if (i == currentPage)
						s = s + "<a class='this' href='" + url
								+ "?currentPage=" + i + params + "'>" + i
								+ "</a> ";
					else
						s = s + "<a href='" + url + "?currentPage=" + i
								+ params + "'>" + i + "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage <= pages) {
				if (currentPage < pages) {
					s = s + "<a href='" + url + "?currentPage="
							+ (currentPage + 1) + params + "'>下一页</a> ";
				}
				s = s + "<a href='" + url + "?currentPage=" + pages + params
						+ "'>末页</a> ";
			}
		}

		return s;
	}
	
	public static String showPageHtml1(String url, String params,
			int currentPage1, int pages1) {
		String s = "";
		if (pages1 > 0) {
			if (currentPage1 >= 1) {
				s = s + "<a href='" + url + "?currentPage1=1" + params
						+ "'>首页</a> ";
				if (currentPage1 > 1) {
					s = s + "<a href='" + url + "?currentPage1="
							+ (currentPage1 - 1) + params + "'>上一页</a> ";
				}
			}
			int beginPage = currentPage1 - 3 < 1 ? 1 : currentPage1 - 3;
			if (beginPage <= pages1) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages1) && (j < 6); j++) {
					if (i == currentPage1)
						s = s + "<a class='this' href='" + url
								+ "?currentPage1=" + i + params + "'>" + i
								+ "</a> ";
					else
						s = s + "<a href='" + url + "?currentPage1=" + i
								+ params + "'>" + i + "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage1 <= pages1) {
				if (currentPage1 < pages1) {
					s = s + "<a href='" + url + "?currentPage1="
							+ (currentPage1 + 1) + params + "'>下一页</a> ";
				}
				s = s + "<a href='" + url + "?currentPage1=" + pages1 + params
						+ "'>末页</a> ";
			}
		}

		return s;
	}

	/**
	 * 
	 * <p>
	 * Title: showPageFormHtml
	 * </p>
	 * <p>
	 * Description: 表单页码处理
	 * </p>
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pages
	 *            总页码数
	 * @return String 点击页码后的路径
	 */
	public static String showPageFormHtml(int currentPage, int pages) {
		String s = "";
		if (pages > 0) {
			if (currentPage >= 1) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return gotoPage(1)'>首页</a> ";
				if (currentPage > 1) {
					s = s
							+ "<a href='javascript:void(0);' onclick='return gotoPage("
							+ (currentPage - 1) + ")'>上一页</a> ";
				}
			}
			int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
			if (beginPage <= pages) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages) && (j < 6); j++) {
					if (i == currentPage)
						s = s
								+ "<a class='this' href='javascript:void(0);' onclick='return gotoPage("
								+ i + ")'>" + i + "</a> ";
					else
						s = s
								+ "<a href='javascript:void(0);' onclick='return gotoPage("
								+ i + ")'>" + i + "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage <= pages) {
				if (currentPage < pages) {
					s = s
							+ "<a href='javascript:void(0);' onclick='return gotoPage("
							+ (currentPage + 1) + ")'>下一页</a> ";
				}
				s = s
						+ "<a href='javascript:void(0);' onclick='return gotoPage("
						+ pages + ")'>末页</a> ";
			}
		}

		return s;
	}

	/**
	 * 
	 * <p>
	 * Title: showPageAjaxHtml
	 * </p>
	 * <p>
	 * Description: 异步分页处理
	 * </p>
	 * 
	 * @param url
	 *            路径
	 * @param params
	 *            参数
	 * @param currentPage
	 *            当前页码数
	 * @param pages
	 *            总页码数
	 * @return String 点击页码后的路径
	 */
	public static String showPageAjaxHtml(String url, String params,
			int currentPage, int pages) {
		String s = "";
		if (pages > 0) {
			String address = url + "?1=1" + params;
			if (currentPage >= 1) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage(\""
						+ address + "\",1,this)'>首页</a> ";
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage(\""
						+ address + "\"," + (currentPage - 1)
						+ ",this)'>上一页</a> ";
			}

			int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
			if (beginPage <= pages) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages) && (j < 6); j++) {
					if (i == currentPage)
						s = s
								+ "<a class='this' href='javascript:void(0);' onclick='return ajaxPage(\""
								+ address + "\"," + i + ",this)'>" + i
								+ "</a> ";
					else
						s = s
								+ "<a href='javascript:void(0);' onclick='return ajaxPage(\""
								+ address + "\"," + i + ",this)'>" + i
								+ "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage <= pages) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage(\""
						+ address + "\"," + (currentPage + 1)
						+ ",this)'>下一页</a> ";
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage(\""
						+ address + "\"," + pages + ",this)'>末页</a> ";
			}
		}

		return s;
	}

	public static String showPageAjaxHtml1(String url, String params,
			int currentPage, int pages) {
		String s = "";
		if (pages > 0) {
			String address = url + "?1=1" + params;
			if (currentPage >= 1) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage1(\""
						+ address + "\",1,this)'>首页</a> ";
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage1(\""
						+ address + "\"," + (currentPage - 1)
						+ ",this)'>上一页</a> ";
			}

			int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
			if (beginPage <= pages) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages) && (j < 6); j++) {
					if (i == currentPage)
						s = s
								+ "<a class='this' href='javascript:void(0);' onclick='return ajaxPage1(\""
								+ address + "\"," + i + ",this)'>" + i
								+ "</a> ";
					else
						s = s
								+ "<a href='javascript:void(0);' onclick='return ajaxPage1(\""
								+ address + "\"," + i + ",this)'>" + i
								+ "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage <= pages) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage1(\""
						+ address + "\"," + (currentPage + 1)
						+ ",this)'>下一页</a> ";
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage1(\""
						+ address + "\"," + pages + ",this)'>末页</a> ";
			}
		}

		return s;
	}

	public static String showPageAjaxHtml2(String url, String params,
			int currentPage, int pages) {
		String s = "";
		if (pages > 0) {
			String address = url + "?1=1" + params;
			if (currentPage >= 1) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage2(\""
						+ address + "\",1,this)'>首页</a> ";
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage2(\""
						+ address + "\"," + (currentPage - 1)
						+ ",this)'>上一页</a> ";
			}

			int beginPage = currentPage - 3 < 1 ? 1 : currentPage - 3;
			if (beginPage <= pages) {
				s = s + "第　";
				int i = beginPage;
				for (int j = 0; (i <= pages) && (j < 6); j++) {
					if (i == currentPage)
						s = s
								+ "<a class='this' href='javascript:void(0);' onclick='return ajaxPage2(\""
								+ address + "\"," + i + ",this)'>" + i
								+ "</a> ";
					else
						s = s
								+ "<a href='javascript:void(0);' onclick='return ajaxPage2(\""
								+ address + "\"," + i + ",this)'>" + i
								+ "</a> ";
					i++;
				}

				s = s + "页　";
			}
			if (currentPage <= pages) {
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage2(\""
						+ address + "\"," + (currentPage + 1)
						+ ",this)'>下一页</a> ";
				s = s
						+ "<a href='javascript:void(0);' onclick='return ajaxPage2(\""
						+ address + "\"," + pages + ",this)'>末页</a> ";
			}
		}

		return s;
	}

	public static void addIPageList2ModelAndView(String url, String staticURL,
			String params, Pagination pList, ModelAndView mv) {
		if (pList != null) {
			mv.addObject("objs", pList.getList());
			mv.addObject("totalPage", Pagination.cpn(pList.getTotalPage()));
			mv.addObject("pageSize", Pagination.cpn(pList.getPageSize()));
			mv.addObject("rows", Pagination.cpn(pList.getPageSize()));
			mv.addObject("currentPage", Pagination.cpn(pList.getPageNo()));
			mv.addObject(
					"gotoPageHTML",
					showPageHtml(url, params,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageFormHTML",
					showPageFormHtml(Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageStaticHTML",
					showPageStaticHtml(staticURL,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageAjaxHTML",
					showPageAjaxHtml(url, params,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			// 在同一个页面中如果有两个以上分页的话点击事件的方法会冲突，所以加了以下的方法
			/*mv.addObject(
					"gotoPageAjaxHTML1",
					showPageAjaxHtml1(url, params,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageAjaxHTML2",
					showPageAjaxHtml2(url, params,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));*/
		}
	}
	
	public static void addIPageList2ModelAndView1(String url, String staticURL,
			String params, Pagination pList, ModelAndView mv) {
		if (pList != null) {
			mv.addObject("objs1", pList.getList());
			mv.addObject("totalPage1", Pagination.cpn(pList.getTotalPage()));
			mv.addObject("pageSize1", Pagination.cpn(pList.getPageSize()));
			mv.addObject("rows1", Pagination.cpn(pList.getPageSize()));
			mv.addObject("currentPage1", Pagination.cpn(pList.getPageNo()));
			mv.addObject(
					"gotoPageHTML1",
					showPageHtml1(url, params,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageFormHTML1",
					showPageFormHtml(Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageStaticHTML1",
					showPageStaticHtml(staticURL,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
			mv.addObject(
					"gotoPageAjaxHTML1",
					showPageAjaxHtml1(url, params,
							Pagination.cpn(pList.getPageNo()),
							Pagination.cpn(pList.getTotalPage())));
		}
	}

	public static void addLucene2ModelAndView(String type, LuceneResult pList,
			ModelAndView mv) {
		if (pList != null) {
			if (type.equals("goods")) {
				mv.addObject("objs", pList.getGoods_list());
			}
			if (type.equals("store")) {
				mv.addObject("objs", pList.getStore_list());
			}
			mv.addObject("totalPage", Integer.valueOf(pList.getPages()));
			mv.addObject("pageSize", Integer.valueOf(pList.getPageSize()));
			mv.addObject("rows", Integer.valueOf(pList.getRows()));
			mv.addObject("currentPage", new Integer(pList.getCurrentPage()));
			mv.addObject("gotoPageFormHTML",
					showPageFormHtml(pList.getCurrentPage(), pList.getPages()));
		}
	}

	/**
	 * 
	 * <p>
	 * Title: randomChar
	 * </p>
	 * <p>
	 * Description: 在52个大小写字母中随机获得一个字母
	 * </p>
	 * 
	 * @return char 单个字母
	 */
	public static char randomChar() {
		char[] chars = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f',
				'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l',
				'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r',
				'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x',
				'X', 'y', 'Y', 'z', 'Z' };
		int index = (int) (Math.random() * 52.0D) - 1;
		if (index < 0) {
			index = 0;
		}
		return chars[index];
	}

	/**
	 * 
	 * <p>
	 * Title: splitByChar
	 * </p>
	 * <p>
	 * Description: 根据第二个参数 切割第一个参数获得新的字符串数组
	 * </p>
	 * 
	 * @param s
	 * @param c
	 * @return String[] 字符串数组
	 */
	public static String[] splitByChar(String s, String c) {
		String[] list = s.split(c);
		return list;
	}

	/**
	 * 
	 * <p>
	 * Title: requestByParam
	 * </p>
	 * <p>
	 * Description: 总request中获得参数
	 * </p>
	 * 
	 * @param request
	 * @param param
	 *            参数名称
	 * @return object 参数
	 */
	public static Object requestByParam(HttpServletRequest request, String param) {
		if (!request.getParameter(param).equals("")) {
			return request.getParameter(param);
		}
		return null;
	}

	/**
	 * 
	 * <p>
	 * Title: substring
	 * </p>
	 * <p>
	 * Description: 根据传入的所以截取 字符串，获得指定索要之后的字符串
	 * </p>
	 * 
	 * @param s
	 * @param maxLength
	 * @return String 截取后的字符串 +...
	 */
	public static String substring(String s, int maxLength) {
		if (!StringUtils.hasLength(s))
			return s;
		if (s.length() <= maxLength) {
			return s;
		}
		return s.substring(0, maxLength) + "...";
	}

	/**
	 * @Title: substringChinese
	 * @Description: 截取字符串，从中文开始的长度
	 * @param s
	 * @param maxLength
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月4日
	 */
	public static String substringChinese(String s, int maxLength) {
		if (!StringUtils.hasLength(s))
			return s;

		/* 第一个中文的索引 */
		int start = firstStringChinese(s);
		if ((s.length() - start) <= maxLength) {
			return s.substring(start, s.length()) + "...";
		}
		return s.substring(start, start + maxLength) + "...";
	}

	/**
	 * @Title: isChineseChar
	 * @Description: 判断是否是中文
	 * @param ca
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月4日
	 */
	public static boolean isChineseChar(char ca) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(ca);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: firstStringChinese
	 * @Description: 获取字符串中的第一个中文字符索引
	 * @param s
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月4日
	 */
	public static int firstStringChinese(String s) {
		StringBuilder builder = new StringBuilder(s);
		for (int i = 0; i < builder.length(); i++) {
			if (isChineseChar(builder.charAt(i)))
				return i;
		}

		return 0;
	}

	/**
	 * 
	 * <p>
	 * Title: substringfrom
	 * </p>
	 * <p>
	 * Description: 截取第二个字符串在第一个字符串第一次出现的位置之后的内容 默认是 ""
	 * </p>
	 * 
	 * @param s
	 * @param from
	 * @return String 新的字符串
	 */
	public static String substringfrom(String s, String from) {
		if (s.indexOf(from) < 0)
			return "";
		return s.substring(s.indexOf(from) + from.length());
	}

	/**
	 * 判断传人的参数是否是整形
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isInteger(Object s) {
		boolean bool = true;
		if (s != null) {
			try {
				int v = Integer.parseInt(s.toString());
			} catch (Exception localException) {
				bool = false;
			}
		}
		return bool;
	}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为int类型 默认是1
	 * 
	 * @param object
	 *            类型
	 * @return int类型
	 */
	public static int null2Int(Object s) {
		int v = 1;
		if (s != null)
			try {
				v = Integer.parseInt(s.toString());
			} catch (Exception localException) {
			}
		return v;
	}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为float类型 默认是 0.0F
	 * 
	 * @param object
	 *            类型
	 * @return float类型
	 */
	public static float null2Float(Object s) {
		float v = 0.0F;
		if (s != null)
			try {
				v = Float.parseFloat(s.toString());
			} catch (Exception localException) {
			}
		return v;
	}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为double类型 默认是0.0D
	 * 
	 * @param object
	 *            类型
	 * @return double类型
	 */
	public static double null2Double(Object s) {
		double v = 0.0D;
		if (s != null)
			try {
				v = Double.parseDouble(null2String(s));
			} catch (Exception localException) {
			}
		return v;
	}

	public static BigDecimal null2BigDecimal(Object s) {
		BigDecimal decimal = null;
		if (s != null)
			try {
				decimal = new BigDecimal(null2String(s));
			} catch (Exception localException) {
			}
		return decimal;
	}
	
	/**
	 * 隐藏手机号码中间4位
	 * @param t
	 * @return
	 */
	public static String hideTelePhone(String t){
		if(org.apache.commons.lang.StringUtils.isNotEmpty(t)){
			return t.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
		}
		return null;
	}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为boolean类型 默认是false
	 * 
	 * @param object
	 *            类型
	 * @return boolean类型
	 */
	public static boolean null2Boolean(Object s) {
		boolean v = false;
		if (s != null)
			try {
				v = Boolean.parseBoolean(s.toString());
			} catch (Exception localException) {
			}
		return v;
	}

	/**
	 * 判断是否为null，是就转换为"" ,不是就去掉空格转换为String类型
	 * 
	 * @param object
	 *            类型
	 * @return String类型
	 */
	public static String null2String(Object s) {
		return s == null ? "" : s.toString().trim();
	}

	/**
	 * 判断是否为null，不是就直接返回，是就转换为Long类型的 -1
	 * 
	 * @param object
	 * @return Long类型
	 */
	public static Long null2Long(Object s) {
		Long v = Long.valueOf(-1L);
		if (s != null)
			try {
				v = Long.valueOf(Long.parseLong(s.toString()));
			} catch (Exception localException) {
			}
		return v;
	}

	/**
	 * 将传入的值 转换为具体的描述 xx小时xx分钟xx秒
	 * 
	 * @param time
	 *            long类型
	 * @return String xx小时xx分钟xx秒
	 */
	public static String getTimeInfo(long time) {
		int hour = (int) time / 3600000;
		long balance = time - hour * 1000 * 60 * 60;
		int minute = (int) balance / 60000;
		balance -= minute * 1000 * 60;
		int seconds = (int) balance / 1000;
		String ret = "";
		if (hour > 0)
			ret = ret + hour + "小时";
		if (minute > 0)
			ret = ret + minute + "分";
		else if ((minute <= 0) && (seconds > 0))
			ret = ret + "零";
		if (seconds > 0)
			ret = ret + seconds + "秒";
		return ret;
	}

	/**
	 * 获得访问客户端ip
	 * 
	 * @param request
	 * @return String 从request中得到的ip
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获得字符串去掉前后空白之后的长度
	 * 
	 * @param s
	 * @param sub
	 *            实际传入的字符串内容
	 * @return int 字符串的实际长度
	 */
	public static int indexOf(String s, String sub) {
		return s.trim().indexOf(sub.trim());
	}

	/**
	 * 将传入的开始时间 和结束时间 计算出 具体的天 、小时、分钟、秒
	 * 
	 * @param begin
	 * @param end
	 * @return map key：时间单位描述（day、hour、min、second） value:具体对应的数
	 */
	public static Map cal_time_space(Date begin, Date end) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long l = end.getTime() - begin.getTime();
		long day = l / 86400000L;
		long hour = l / 3600000L - day * 24L;
		long min = l / 60000L - day * 24L * 60L - hour * 60L;
		long second = l / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L
				- min * 60L;
		Map map = new HashMap();
		map.put("day", Long.valueOf(day));
		map.put("hour", Long.valueOf(hour));
		map.put("min", Long.valueOf(min));
		map.put("second", Long.valueOf(second));
		return map;
	}

	/**
	 * 根据传入的长度返回，长度个随机字母和数字组成的字符串
	 * 
	 * @param length
	 *            长度
	 * @return String 字母和数字组成的字符串
	 */
	public static final String randomString(int length) {
		char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				.toCharArray();
		if (length < 1) {
			return "";
		}
		Random randGen = new Random();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}

	/**
	 * 根据传入的长度返回随机数字组成的字符串
	 * 
	 * @param length
	 *            长度
	 * @return String 字母和数字组成的字符串
	 */
	public static final String randomNumberString(int length) {
		char[] numberss = "0123456789".toCharArray();
		if (length < 1) {
			return "";
		}
		Random randGen = new Random();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numberss[randGen.nextInt(numberss.length)];
		}
		return new String(randBuffer);
		
		//短信验证码应急措施
		//return "123456";
	}

	/**
	 * 根据传入的长度返回，长度个 数字组成的字符串
	 * 
	 * @param length
	 *            长度
	 * @return String 数字组成的字符串
	 */
	public static final String randomInt(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = "0123456789".toCharArray();

		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
		}
		return new String(randBuffer);
	}

	/**
	 * 根据传入的两个毫秒值，得出两个时间之间 相差的天数
	 * 
	 * @param time1
	 *            后一个时间
	 * @param time2
	 *            前一个时间
	 * @return long 两个时间之间相差的天数
	 */
	public static long getDateDistance(String time1, String time2) {
		long quot = 0L;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000L / 60L / 60L / 24L;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}

	public static double div(Object a, Object b) {
		double ret = 0.0D;
		if ((!null2String(a).equals("")) && (!null2String(b).equals(""))) {
			BigDecimal e = new BigDecimal(null2String(a));
			BigDecimal f = new BigDecimal(null2String(b));
			if (null2Double(f) > 0.0D)
				ret = e.divide(f, 3, 1).doubleValue();
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	public static int divToInt(Object a, Object b) {
		int ret = 0;
		if ((!null2String(a).equals("")) && (!null2String(b).equals(""))) {
			BigDecimal e = new BigDecimal(null2String(a));
			BigDecimal f = new BigDecimal(null2String(b));
			if (null2Double(f) > 0.0D)
				ret = e.divide(f, 3, 1).intValue();
		}
		return Integer.valueOf(ret).intValue();
	}

	public static double subtract(Object a, Object b) {
		double ret = 0.0D;
		BigDecimal e = new BigDecimal(null2Double(a));
		BigDecimal f = new BigDecimal(null2Double(b));
		ret = e.subtract(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	public static double add(Object a, Object b) {
		double ret = 0.0D;
		BigDecimal e = new BigDecimal(null2Double(a));
		BigDecimal f = new BigDecimal(null2Double(b));
		ret = e.add(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	public static String mulBigDecimal(Object a, Object b) {
		BigDecimal e = null2BigDecimal(a);
		BigDecimal f = null2BigDecimal(b);
		BigDecimal ret = e.multiply(f);
		return ret.toString();
	}

	public static double mul(Object a, Object b) {
		BigDecimal e = new BigDecimal(null2Double(a));
		BigDecimal f = new BigDecimal(null2Double(b));
		double ret = e.multiply(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	public static double formatMoney(Object money) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(money)).doubleValue();
	}

	/**
	 * 将传入的 兆 转化为字节 M--KB--B
	 * 
	 * @param m
	 *            传入的兆大小
	 * @return int 字节大小
	 */
	public static int M2byte(float m) {
		float a = m * 1024.0F * 1024.0F;
		return (int) a;
	}

	/**
	 * 判断该值是否等于0
	 * 
	 * @param intValue
	 * @return true： 不为0 false：为0
	 */
	public static boolean convertIntToBoolean(int intValue) {
		return intValue != 0;
	}

	/**
	 * 获得完整的URL
	 * 
	 * @param request
	 * @return String url
	 */
	public static String getURL(HttpServletRequest request) {
		// 获得相对路径
		String contextPath = request.getContextPath().equals("/") ? ""
				: request.getContextPath();
		// 拼接url
		String url = "http://" + request.getServerName();
		if (null2Int(Integer.valueOf(request.getServerPort())) != 80)
			url = url + ":"
					+ null2Int(Integer.valueOf(request.getServerPort()))
					+ contextPath;
		else {
			url = url + contextPath;
		}
		return url;
	}

	public static String filterHTML(String content) {
		Whitelist whiteList = new Whitelist();
		String s = Jsoup.clean(content, user_content_filter);
		return s;
	}

	/**
	 * 根据窜入的类型和日期得到具体的日期数字
	 * 
	 * @param type
	 *            String类型的日期描述 y/M/d/H/m/s
	 * @param date
	 *            日期
	 * @return int 具体的日期时间
	 */
	public static int parseDate(String type, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (type.equals("y")) {
			return cal.get(1);
		}
		if (type.equals("M")) {
			return cal.get(2) + 1;
		}
		if (type.equals("d")) {
			return cal.get(5);
		}
		if (type.equals("H")) {
			return cal.get(11);
		}
		if (type.equals("m")) {
			return cal.get(12);
		}
		if (type.equals("s")) {
			return cal.get(13);
		}
		return 0;
	}

	/**
	 * @Title: getIntervalSecondDate
	 * @Description: 返回间隔多少秒的日期
	 * @param srcDate
	 * @param ms
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年12月15日
	 */
	public static Date getIntervalSecondDate(Date srcDate, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(srcDate);

		calendar.add(Calendar.SECOND, -second);

		return calendar.getTime();
	}
	
	public static void main(String[] arges){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.SECOND, -86400);
		
		System.out.println(calendar.getTime());
	}
	/**
	 * 获取图片的宽和高
	 * 
	 * @param imgurl
	 *            图片路径
	 * @return int 数组 长度为2 获取成功时 第一个为宽，第二个为高，获取失败值为空
	 */
	public static int[] readImgWH(String imgurl) {
		boolean b = false;
		try {
			URL url = new URL(imgurl);

			BufferedInputStream bis = new BufferedInputStream(url.openStream());

			byte[] bytes = new byte[100];

			OutputStream bos = new FileOutputStream(new File(
					"C:\\thetempimg.gif"));
			int len;
			while ((len = bis.read(bytes)) > 0) {
				bos.write(bytes, 0, len);
			}
			bis.close();
			bos.flush();
			bos.close();

			b = true;
		} catch (Exception e) {
			b = false;
		}
		int[] a = new int[2];
		if (b) {
			File file = new File("C:\\thetempimg.gif");
			BufferedImage bi = null;
			boolean imgwrong = false;
			try {
				bi = ImageIO.read(file);
				try {
					int i = bi.getType();
					imgwrong = true;
				} catch (Exception e) {
					imgwrong = false;
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (imgwrong) {
				a[0] = bi.getWidth();
				a[1] = bi.getHeight();
			} else {
				a = null;
			}

			file.delete();
		} else {
			a = null;
		}
		return a;
	}

	/**
	 * @Title: hideUserName
	 * @Description: 隐藏用户名(规则：2个字的隐藏后面一个，2个字以上的隐藏除了头和尾的其他所有字)
	 * @param name
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月16日
	 */
	public static String hideUserName(String name) {
		if (name != null && name.length() > 1) {
			StringBuilder newName = new StringBuilder(name);
			if (newName.length() == 2) {
				newName.setCharAt(1, '*');
				return newName.toString();
			}

			for (int i = 1; i < newName.length() - 1; i++) {
				newName.setCharAt(i, '*');
			}

			return newName.toString();
		}

		return name;
	}

	public static boolean del_acc(HttpServletRequest request, Accessory acc,
			String savePath) {
		boolean ret = true;
		boolean ret1 = true;
		if (acc != null) {
			String path = savePath + acc.getPath() + File.separator
					+ acc.getName();
			String small_path = savePath + acc.getPath() + File.separator
					+ acc.getName() + "_small." + acc.getExt();

			String middle_path = savePath + acc.getPath() + File.separator
					+ acc.getName() + "_middle." + acc.getExt();

			String src_path = savePath + acc.getPath() + File.separator
					+ "src_" + acc.getName();

			deleteFile(src_path);
			deleteFile(middle_path);
			ret = deleteFile(path);
			ret1 = deleteFile(small_path);
		}
		return (ret) && (ret1);
	}

	/**
	 * 判断文件路径是否存在
	 * 
	 * @param path
	 * @return true or flase
	 */
	public static boolean fileExist(String path) {
		File file = new File(path);
		return file.exists();
	}

	/**
	 * 
	 * <p>
	 * Title: splitLength
	 * </p>
	 * <p>
	 * Description: 获得 根据第二个字符串 截取第一个字符串获得的数组长度
	 * </p>
	 * 
	 * @param s
	 * @param c
	 * @return 数组长度
	 */
	public static int splitLength(String s, String c) {
		int v = 0;
		if (!s.trim().equals("")) {
			v = s.split(c).length;
		}
		return v;
	}

	/**
	 * 
	 * <p>
	 * Title: fileSize
	 * </p>
	 * <p>
	 * Description: 获得文件夹大小
	 * </p>
	 * 
	 * @param folder
	 * @return double 大小
	 */
	public static double fileSize(File folder) {
		totalFolder += 1;

		long foldersize = 0L;
		File[] filelist = folder.listFiles();
		if (filelist != null) {
			for (int i = 0; i < filelist.length; i++) {
				if (filelist[i].isDirectory()) {
					foldersize = (long) (foldersize + fileSize(filelist[i]));
				} else {
					totalFile += 1;
					foldersize += filelist[i].length();
				}
			}
		}
		return div(Long.valueOf(foldersize), Integer.valueOf(1024));
	}

	/**
	 * 
	 * <p>
	 * Title: fileCount
	 * </p>
	 * <p>
	 * Description: 统计问价夹下所有文件的数量
	 * </p>
	 * 
	 * @param file
	 * @return int 数量
	 */
	public static int fileCount(File file) {
		if (file == null) {
			return 0;
		}
		if (!file.isDirectory()) {
			return 1;
		}
		int fileCount = 0;
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				fileCount++;
			} else if (f.isDirectory()) {
				fileCount++;
				fileCount += fileCount(file);
			}
		}
		return fileCount;
	}

	/**
	 * 
	 * <p>
	 * Title: get_all_url
	 * </p>
	 * <p>
	 * Description: 获得所有URL
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	public static String get_all_url(HttpServletRequest request) {
		String query_url = request.getRequestURI();
		if ((request.getQueryString() != null)
				&& (!request.getQueryString().equals(""))) {
			query_url = query_url + "?" + request.getQueryString();
		}
		return query_url;
	}

	/**
	 * 
	 * <p>
	 * Title: getColor
	 * </p>
	 * <p>
	 * Description: 根据传入的 颜色数值 # xx xx xx 获得颜色对象
	 * </p>
	 * 
	 * @param color
	 * @return Color 对象
	 */
	public static Color getColor(String color) {
		if (color.charAt(0) == '#') {
			color = color.substring(1);
		}
		if (color.length() != 6)
			return null;
		try {
			int r = Integer.parseInt(color.substring(0, 2), 16);
			int g = Integer.parseInt(color.substring(2, 4), 16);
			int b = Integer.parseInt(color.substring(4), 16);
			return new Color(r, g, b);
		} catch (NumberFormatException nfe) {
		}
		return null;
	}

	public static Set<Integer> randomInt(int a, int length) {
		Set list = new TreeSet();
		int size = length;
		if (length > a) {
			size = a;
		}
		while (list.size() < size) {
			Random random = new Random();
			int b = random.nextInt(a);
			list.add(Integer.valueOf(b));
		}
		return list;
	}

	public static Double formatDouble(Object obj, int len) {
		Double ret = Double.valueOf(0.0D);
		String format = "0.0";
		for (int i = 1; i < len; i++) {
			format = format + "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		return Double.valueOf(df.format(obj));
	}

	/**
	 * 
	 * <p>
	 * Title: isChinese
	 * </p>
	 * <p>
	 * Description: 判断是否是中文
	 * </p>
	 * 
	 * @param c
	 *            char
	 * @return 是就返回true
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

		return (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)
				|| (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS)
				|| (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A)
				|| (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION)
				|| (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION)
				|| (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
	}

	public static boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = ch.length;
		float count = 0.0F;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			// 确定指定字符是否为字母或数字
			if (Character.isLetterOrDigit(c))
				continue;
			if (!isChinese(c)) {
				count += 1.0F;
				System.out.print(c);
			}
		}

		float result = count / chLength;

		return result > 0.4D;
	}

	public static <E> List<E> inverseArrayList(List<E> srcList) {
		List<E> list = new ArrayList<E>();
		if (srcList == null || srcList.isEmpty()) {
			return list;
		}

		for (int i = srcList.size() - 1; i >= 0; i--) {
			list.add(srcList.get(i));
		}

		return list;
	}

	/**
	 * @Title: generateOrderId
	 * @Description: 生成一个订单号，前12位为格林时间/2,后面为1- 9999 的自增数
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月11日 下午2:29:04
	 */
	public synchronized static String generateOrderId() {

		if (++addedOrderNumber > Globals.NUBER_ORDER_MAX) {
			addedOrderNumber = Globals.NUBER_ZERO;
		}

		Long time = System.currentTimeMillis() / Globals.NUBER_TWO;
		return time.toString() + addedOrderNumber;
	}

	/**
	 * 
	 * <p>
	 * Title: trimSpaces
	 * </p>
	 * <p>
	 * Description: 去掉IP地址字符串的前后空格
	 * </p>
	 * 
	 * @param IP
	 * @return
	 */
	public static String trimSpaces(String IP) {
		while (IP.startsWith(" ")) {
			IP = IP.substring(1, IP.length()).trim();
		}
		while (IP.endsWith(" ")) {
			IP = IP.substring(0, IP.length() - 1).trim();
		}
		return IP;
	}

	/**
	 * 
	 * <p>
	 * Title: isIp
	 * </p>
	 * <p>
	 * Description: 判断是否是IP地址
	 * </p>
	 * 
	 * @param IP
	 * @return boolean 是就返回true
	 */
	public static boolean isIp(String IP) {
		boolean b = false;
		IP = trimSpaces(IP);
		if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
			String[] s = IP.split("\\.");
			if ((Integer.parseInt(s[0]) < 255)
					&& (Integer.parseInt(s[1]) < 255)
					&& (Integer.parseInt(s[2]) < 255)
					&& (Integer.parseInt(s[3]) < 255))
				b = true;
		}
		return b;
	}

	/**
	 * 
	 * <p>
	 * Title: generic_domain
	 * </p>
	 * <p>
	 * Description: 获得服务器名称
	 * </p>
	 * 
	 * @param request
	 * @return string 服务器名称
	 */
	public static String generic_domain(HttpServletRequest request) {
		String system_domain = "localhost";
		String serverName = request.getServerName();
		if (isIp(serverName))
			system_domain = serverName;
		else {
			system_domain = serverName.substring(serverName.indexOf(".") + 1);
		}

		return system_domain;
	}

	/**
	 * 
	 * @todo 两个对象进行相除,返回百分数
	 * @date 2015年6月18日 下午7:05:16
	 * @return String
	 * @return
	 */
	public static int divide(Object a, Object b) {

		double aNew = Double.parseDouble(CommUtil.null2String(a));
		double bNew = Double.parseDouble(CommUtil.null2String(b));
		double r = 0.0D;
		if (bNew != 0) {
			r = (aNew / bNew) * 100;
		}
		return (int) Math.floor(r);
	}

	/**
	 * 根据cookie名取得对应cookie
	 * 
	 * @param name
	 * @param cookies
	 * @return
	 */
	public static Cookie getCookieValue(String name, Cookie[] cookies) {
		Cookie retCookie = null;

		if (null != cookies && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					/* 存在这个name,取出对应的值 */
					retCookie = cookie;
				}
			}
		}
		return retCookie;
	}

	/**
	 * 判断两个时间是否属于同一天
	 * 
	 * @param oldDate
	 * @param newDate
	 * @return
	 */
	public static boolean isSameDay(String oldDate, String newDate) {
		Date old = new Date(Long.valueOf(oldDate));
		Date newD = new Date(Long.valueOf(newDate));
		if (old.getYear() == newD.getYear()
				&& old.getMonth() == newD.getMonth()
				&& old.getDay() == newD.getDay()) {
			return true;
		}

		return false;
	}

	/**
	 * @Title: jsonToBean
	 * @Description: json字符串转换成bean
	 * @param jsonStr
	 *            一个json字符串，不是json数组
	 * @param clasz
	 * @return
	 * @return Object
	 * @author tangxiang
	 * @date 2015年8月8日 下午3:29:54
	 */
	public static Object jsonToBean(String jsonStr, Class clasz) {
		JSONObject obj = JSONObject.fromObject(jsonStr);
		return JSONObject.toBean(obj, clasz);
	}

	/**
	 * @Title: jsonToBeanList
	 * @Description: json数组转换成javabean list
	 * @param jsonStr
	 *            传入json 数组
	 * @param clasz
	 * @return
	 * @return List<Object>
	 * @author tangxiang
	 * @date 2015年8月7日 下午6:44:34
	 */
	public static List<Object> jsonToBeanList(String jsonStr, Class clasz) {
		List<Object> list = new ArrayList<Object>();
		JSONArray array = JSONArray.fromObject(jsonStr);

		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = array.getJSONObject(i);
			list.add(JSONObject.toBean(obj, clasz));
		}
		return list;
	}

	/**
	 * @Title: combinationJsonString
	 * @Description: 合入一个新json到json数组中
	 * @param newJsonStr
	 *            一个新json，不是json数组
	 * @param oldJsonStr
	 *            以前的json数组
	 * @param clasz
	 *            类
	 * @return
	 * @return String 新的json数组
	 * @author tangxiang
	 * @date 2015年8月8日 下午3:34:09
	 */
	public static String combinationJsonString(String newJsonStr,
			String oldJsonStr, Class clasz) {
		Object newObj = CommUtil.jsonToBean(newJsonStr, clasz);
		List<Object> oldObjList = CommUtil.jsonToBeanList(oldJsonStr, clasz);
		oldObjList.add(newObj);
		return CommUtil.beanListToJsonStr(oldObjList);
	}

	/**
	 * @Title: BeanToJsonStr
	 * @Description: javabean 转换成json字符串
	 * @param obj
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月8日 下午3:04:21
	 */
	public static String beanToJsonStr(Object obj) {
		JSONObject jsonObj = JSONObject.fromObject(obj);

		return jsonObj.toString();
	}

	/**
	 * @Title: jsonStrToMap
	 * @Description: json字符串转map
	 * @param str
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月9日
	 */
	public static Map<Object, Object> jsonStrToMap(String str) {
		JSONObject jsonObject = JSONObject.fromObject(str);
		return JSONObject.fromObject(jsonObject);
	}

	/**
	 * @Title: beanListToJsonStr
	 * @Description: javabean list 转化成json字符串
	 * @param list
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月8日 下午3:10:45
	 */
	public static String beanListToJsonStr(List<? extends Object> list) {
		JSONArray array = new JSONArray();
		for (Object obj : list) {
			array.add(obj);
		}

		return array.toString();
	}

	/**
	 * @Title: updateCookie
	 * @Description: 更新cookie
	 * @param cookie
	 * @param seconds
	 * @param response
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月8日 上午11:40:40
	 */
	public static void updateCookie(Cookie cookie, int seconds,
			HttpServletResponse response) {
		cookie.setMaxAge(seconds);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * @Title: addCookie
	 * @Description: 增加一个新cookie，按秒设置cookie存在时间
	 * @param key
	 * @param value
	 * @param secs
	 * @param response
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月8日 上午10:57:33
	 */
	public static void addCookie(String key, String value, int seconds,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(key.trim(), value.trim());
		cookie.setMaxAge(seconds);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * @Title: removeCookie
	 * @Description: 删除单个cookie
	 * @param name
	 * @param cookies
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月8日 上午10:39:14
	 */
	public static void removeCookie(String name, Cookie cookie,
			HttpServletResponse response) {
		cookie.setMaxAge(0);// 设置0立即删除
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * @Title: removeCookie
	 * @Description: 删除单个cookie
	 * @param name
	 * @param cookies
	 * @return void
	 * @author tangxiang
	 * @date 2015年8月8日 上午10:39:14
	 */
	public static void removeCookie(String name, HttpServletResponse response,
			Cookie[] cookies) {
		Cookie cookie = getCookieValue(name, cookies);
		cookie.setMaxAge(0);// 设置0立即删除
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * @Title: isContainTime
	 * @Description: 计算两个时间的间隔天数
	 * @param newDate
	 * @param oldDate
	 * @return
	 * @return int
	 * @author tangxiang
	 * @date 2015年8月28日 下午5:27:10
	 */
	public static int isContainTime(Date newDate, Date oldDate) {
	    
	    if(newDate == null || oldDate == null)
	    {
	        return -1;
	    }
	    
		Long newTime = newDate.getTime();
		Long oldTime = oldDate.getTime();

		Long days = (newTime - oldTime) / (1000 * 60 * 60 * 24);

		return days.intValue();
	}

	/**
	 * 计算两次时间的间隔
	 * 
	 * @param oldTime
	 * @param newTime
	 * @return 秒
	 */
	public static long getTimeInterval(String oldTime, String newTime) {
		return (Long.valueOf(newTime) - Long.valueOf(oldTime))
				/ Globals.MILLISECOND_TO_SECOND;
	}

	/**
	 * 订单状态转换成中文提示
	 */
	public static String getOrderFormStatusName(int statusId) {
		String returnStr = null;
		switch (statusId) {
		case Globals.CANCELLED_ORDER:
			returnStr = Globals.CANCELLED_ORDER_NAME;
			break;
		case Globals.WAIT_PAYMENT_ORDER:
			returnStr = Globals.WAIT_PAYMENT_ORDER_NAME;
			break;
		case Globals.PEND_PAYMENT_OF_OFF_LINE:
			returnStr = Globals.PEND_PAYMENT_OF_OFF_LINE_NAME;
			break;
		case Globals.SEND_OUT_GOOD_OF_PAY_ON_ARRIVE_GOOD:
			returnStr = Globals.SEND_OUT_GOOD_OF_PAY_ON_ARRIVE_GOOD_NAME;
			break;
		case Globals.HAVE_PAYMENT:
			returnStr = Globals.HAVE_PAYMENT_NAME;
			break;
		case Globals.HAVE_SEND_OUT_GOOD:
			returnStr = Globals.HAVE_SEND_OUT_GOOD_NAME;
			break;
		case Globals.HAVE_RECEIVED_GOOD:
			returnStr = Globals.HAVE_RECEIVED_GOOD_NAME;
			break;
		case Globals.BUYER_APPLY_RETURN_GOOD:
			returnStr = Globals.BUYER_APPLY_RETURN_GOOD_NAME;
			break;
		case Globals.RETURN_GOOD:
			returnStr = Globals.RETURN_GOOD_NAME;
			break;
		case Globals.RETURN_GOOD_END:
			returnStr = Globals.RETURN_GOOD_END_NAME;
			break;
		case Globals.SELLER_REFUSE_RETURN_GOOD:
			returnStr = Globals.SELLER_REFUSE_RETURN_GOOD_NAME;
			break;
		case Globals.RETURN_GOODS_FAIL:
			returnStr = Globals.RETURN_GOODS_FAIL_NAME;
			break;
		case Globals.COMPLETED_AND_EVALUATED:
			returnStr = Globals.COMPLETED_AND_EVALUATED_NAME;
			break;
		case Globals.FINISH:
			returnStr = Globals.FINISH_NAME;
			break;
		case Globals.FINISH_AND_NOT_EVALUATED:
			returnStr = Globals.FINISH_AND_NOT_EVALUATED_NAME;
			break;
		default:
			returnStr = "不存在状态";
			break;
		}
		return returnStr;
	}
	

}
