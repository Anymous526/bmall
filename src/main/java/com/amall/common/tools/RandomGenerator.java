package com.amall.common.tools;

import java.util.Random;

/**
 * @author tangxiang
 *
 */
public class RandomGenerator {

    /**
     * 获取26个字母随机串
     * @param length
     * @return
     */
    public static String getRandomLettersByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz";
        return getRandomString(base, length);
    }
    
    /**
     * 获取字母数字混合串
     * @param length
     * @return
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        return getRandomString(base, length);
    }
    
    /** 
    * @Title: getRandomHEXStringByLength 
    * @Description: 获取hex字符串
    * @param length
    * @return
    * @throws 
    * @author tangxiang
    * @date 2015年12月14日
    */
    public static String getRandomHEXStringByLength(int length)
    {
    	String base = "abcdef0123456789";
    	return getRandomString(base, length);
    }
    
    /**
     * 获取0-9数字字符串
     * @param length
     * @return
     */
    public static String getRandomNumberByLength(int length) {
        String base = "0123456789";
        return getRandomString(base, length);
    }
    
    private static String getRandomString(String base, int length)
    {
    	 Random random = new Random();
         StringBuffer sb = new StringBuffer();
         for (int i = 0; i < length; i++) {
             int number = random.nextInt(base.length());
             sb.append(base.charAt(number));
         }
         return sb.toString();
    	
         //短信验证码应急措施
    	//return "123456";
    }

}
