package Info;

import java.util.Calendar;
import java.util.Date;

public class ElectricInfo {
	static public double ph;		//￥/kW·h	//虽然是static,在程序之初，还是要对其进行一次初始化
	static public double pv;
	static Calendar hstart;
	static Calendar hend;
//	double ph;		//￥/kW·h
//	double pv;
//	Calendar hstart;
//	Calendar hend;

	public ElectricInfo(double aph, double apv, Calendar astart, Calendar ahend){
		ph=aph;
		pv=apv;
		hstart=astart;
		hend=ahend;
	}
	
	public ElectricInfo(){		//默认电价政策
		ph=0.617;
		pv=0.307;
		hstart=Calendar.getInstance();
		hstart.set(2017, 0, 1, 6, 0);
		hend=Calendar.getInstance();
		hend.set(2017, 0,1,22,0);
	}
	
	public static double getPrice(Calendar startTime){
//		Calendar cal=Calendar.getInstance();
//		cal.setTime(startTime);
		Calendar cal=startTime;
		int minute=cal.get(Calendar.MINUTE);
		int start=hstart.get(Calendar.MINUTE)
				+hstart.get(Calendar.HOUR_OF_DAY)*60;
		int end=hend.get(Calendar.MINUTE)
				+hend.get(Calendar.HOUR_OF_DAY)*60;
		if(start<=minute && minute<end)
			return ph;
		else
			return pv;
	}
}
