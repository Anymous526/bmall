package com.amall.core.action.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.service.user.IUserService;
@Controller
public class Testx extends TestCase {
	@Autowired
	private IUserService userService;

	public static void main(String[] args) {
	    Calendar c1 = new GregorianCalendar();
	    c1.set(Calendar.HOUR_OF_DAY, 0);
	    c1.set(Calendar.MINUTE, 0);
	    c1.set(Calendar.SECOND, 0);
	    System.out.println((c1.getTime()));
	    Calendar c2 = new GregorianCalendar();
	    c2.set(Calendar.HOUR_OF_DAY, 23);
	    c2.set(Calendar.MINUTE, 59);
	    c2.set(Calendar.SECOND, 59);
	    System.out.println(c2.getTime().toLocaleString());
	    SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String x = sdfs.format(c1.getTime());
	    String h = sdfs.format(c2.getTime());
	    try {
			Date s = sdfs.parse(x);
			Date d = sdfs.parse(h);
			 System.out.println("s="+s);
			 System.out.println("d="+d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Calendar cal = Calendar.getInstance();
	    int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    int year = cal.get(Calendar.YEAR);
	    int dow = cal.get(Calendar.DAY_OF_WEEK);
	    int dom = cal.get(Calendar.DAY_OF_MONTH);
	    int doy = cal.get(Calendar.DAY_OF_YEAR);

	    System.out.println("Current Date: " + cal.getTime());
	    System.out.println("Day: " + day);
	    System.out.println("Month: " + month);
	    System.out.println("Year: " + year);
	    System.out.println("Day of Week: " + dow);
	    System.out.println("Day of Month: " + dom);
	    System.out.println("Day of Year: " + doy);
	    
	    
        Date nowdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cals = Calendar.getInstance();
         //设置为当前时间 
        cals.setTime(nowdate);
        System.out.println("当前时间是：" + sdf.format(nowdate));
       //  当前日期月份-1 
        cals.add(Calendar.MONTH, -1);
        // 得到前一个月的第一天
        cals.set(Calendar.DAY_OF_MONTH, cals.getActualMinimum(Calendar.DAY_OF_MONTH));
        System.out.println("上个月的第一天是：" + sdf.format(cals.getTime()));
        // 得到前一个月的最后一天
        cals.set(Calendar.DAY_OF_MONTH, cals.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("上个月的最后一天是：" + sdf.format(cals.getTime()));
	   
        
        //获取当前月第一天：
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd "); 
            Calendar c = Calendar.getInstance();    
            c.add(Calendar.MONTH, 0);
            c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
            String first = format.format(c.getTime());
            System.out.println("===============first:"+first);
            try {
				Date date =format.parse(first);
				System.out.println("转换="+date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        // calendar.setTime(new Date());
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        // 打印
        DateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("这个月的最后一天"+formats.format(calendar.getTime()));
        SimpleDateFormat formatd = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
			formatd.parse(formats.format(calendar.getTime()));
			Date das =  formatd.parse(formats.format(calendar.getTime()));
			System.out.println("转换后="+das);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Calendar calendary = Calendar.getInstance();
        Date datesq = new Date(System.currentTimeMillis());
        calendary.setTime(datesq);
        calendary.add(Calendar.WEEK_OF_YEAR, -1);
       // calendary.add(Calendar.YEAR, -1);
        datesq = calendary.getTime();
        System.out.println("上一周==="+datesq);
        
        Random   rand   =   new   Random(); 
        SimpleDateFormat   formatl   =   new   SimpleDateFormat( "yyyy-MM-dd "); 
        Calendar   calsa   =   Calendar.getInstance(); 
        calsa.set(2016,   0,   1); 
        long   start   =   calsa.getTimeInMillis(); 
        System.out.println(start);
        calsa.set(2017,   0,   1); 
        long   end   =   calsa.getTimeInMillis(); 
        System.err.println(end);
        System.err.println((end-start));
        for(int   i   =   0;   i   <   1;   i++)   { 
        Date   d   =   new   Date(start   +   (long)(rand.nextDouble()   *   (end   -   start))); 
        System.out.println(d);
        System.out.println("随机时间="+formatl.format(d)); 
        }
        String a = "dd";
        a+="hh";
        System.err.println(a);
        StringBuffer buffer = new StringBuffer("ll");
        System.err.println(buffer);
        buffer.append("ff");
        System.err.println(buffer);
        
       
        
	}
	



}
