package com.amall.core.action.buyer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import org.springframework.stereotype.Controller;

@Controller
public class VerificationCode
{

	/*
	 * private static int width = 102;
	 * private static int height = 28;
	 * private static int codeCount = 4;
	 * private static BufferedImage buffImg;
	 */
	// 给定范围获得随机颜色
	static Color getRandColor (int fc , int bc)
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

	static Color getFondColor ( )
		{
			Random random = new Random ();
			int r = random.nextInt (190) + 30;// 30-220
			int g = random.nextInt (190) + 30;// 30-220
			int b = random.nextInt (190) + 30;// 30-220
			return new Color (r , g , b);
		}

	public static BufferedImage createVerificationImage (int num1 , int num2 , int funNo)
		{
			// 在内存中创建图象
			int width = 100 , height = 30;
			BufferedImage image = new BufferedImage (width , height , BufferedImage.TYPE_INT_RGB);
			// 获取图形上下文
			Graphics g = image.getGraphics ();
			// 生成随机类
			Random random = new Random ();
			// 设定背景色
			g.setColor (getRandColor (240 , 250));
			g.fillRect (0 , 0 , width , height);
			// 设定字体
			g.setFont (new Font ("隶书" , Font.PLAIN + Font.ITALIC , 25));
			// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
			g.setColor (getFondColor ());
			for (int i = 0 ; i < 80 ; i++)
			{
				int x = random.nextInt (width);
				int y = random.nextInt (height);
				int xl = random.nextInt (12);
				int yl = random.nextInt (12);
				g.drawLine (x , y , x + xl , y + yl);
			}
			String funMethod = "";
			switch (funNo)
			{
				case 0 :
					funMethod = "+";
					break;
				case 1 :
					funMethod = "- ";
					break;
				case 2 :
					funMethod = "×";
					break;
			}
			String calc = num1 + " " + funMethod + " " + num2 + " = ?";
			g.setColor (new Color (20 + random.nextInt (110) , 20 + random.nextInt (110) , 20 + random.nextInt (110)));
			g.drawString (calc , 5 , 25);
			// 图象生效
			g.dispose ();
			return image;
		}
	/**
	 *
	 * @Description:正弦曲线Wave扭曲图片
	 * @since 1.0.0
	 * @Date:2012-3-1 下午12:49:47
	 * @return BufferedImage
	 */
	/*
	 * private BufferedImage twistImage() {
	 * Random random = new Random();
	 * double dMultValue = random.nextInt(7) + 3;// 波形的幅度倍数，越大扭曲的程序越高，一般为3
	 * double dPhase = random.nextInt(6);// 波形的起始相位，取值区间（0-2＊PI）
	 * BufferedImage destBi = new BufferedImage(buffImg.getWidth(),
	 * buffImg.getHeight(), BufferedImage.TYPE_INT_RGB);
	 * for (int i = 0; i < destBi.getWidth(); i++) {
	 * for (int j = 0; j < destBi.getHeight(); j++) {
	 * int nOldX = getXPosition4Twist(dPhase, dMultValue,
	 * destBi.getHeight(), i, j);
	 * int nOldY = j;
	 * if (nOldX >= 0 && nOldX < destBi.getWidth() && nOldY >= 0
	 * && nOldY < destBi.getHeight()) {
	 * destBi.setRGB(nOldX, nOldY, buffImg.getRGB(i, j));
	 * }
	 * }
	 * }
	 * return destBi;
	 * }
	 *//**
	 *
	 * @Description:获取扭曲后的x轴位置
	 * @since 1.0.0
	 * @Date:2012-3-1 下午3:17:53
	 * @param dPhase
	 * @param dMultValue
	 * @param height
	 * @param xPosition
	 * @param yPosition
	 * @return int
	 */
	/*
	 * private int getXPosition4Twist(double dPhase, double dMultValue,
	 * int height, int xPosition, int yPosition) {
	 * double PI = 3.1415926535897932384626433832799; // 此值越大，扭曲程度越大
	 * double dx = (double) (PI * yPosition) / height + dPhase;
	 * double dy = Math.sin(dx);
	 * return xPosition + (int) (dy * dMultValue);
	 * }
	 *//**
	 *
	 * @Description:BufferedImage初始化
	 * @since 1.0.0
	 * @Date:2012-3-1 上午11:07:18
	 * @return BufferedImage
	 */
	/*
	 * private BufferedImage buffImgInit() {
	 * buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	 * return buffImg;
	 * }
	 */
}
