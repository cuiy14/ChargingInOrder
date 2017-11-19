package Info;

import java.util.Calendar;

public class TimeTool {
	public static int interval=5;	//time in minutes
	public static int day=0;	// 正在运行第day天
	public static Calendar addMinute(Calendar cal,int minute){	// 返回在指定时间的基础上，延时minute min的Calendar对象
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(cal.getTime());
		calendar.add(Calendar.MINUTE, minute);
		return calendar;
	}
}
