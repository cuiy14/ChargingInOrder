package Info;

import java.util.Date;

public class CarInfo {
	static int sum=0;	// store the  num of the registed cars
	int id;	// store the id of the car from 1
	int type;	// type=0,预约型；type=1,委托型；type=2,即时性
	double chargePower;		//以千瓦为单位
	double currentSOC;
	double expectedSOC;		//为相应的比例
	double fullEnergy; 		//以千瓦时为单位
	Date arriveTime;
	Date leaveTime;
	int remainInterval;
	
	public CarInfo(int atype, double achargePower, double acurrentSOC, double aexpectedSOC,
			double afullEnergy, Date aarriveTime, Date aleaveTime){
		sum++;
		id=sum;
		type=atype;
		chargePower=achargePower;
		currentSOC=acurrentSOC;
		expectedSOC=aexpectedSOC;
		fullEnergy=afullEnergy;
		arriveTime=aarriveTime;
		leaveTime=aleaveTime;
		remainInterval= (int) Math.ceil(
				(aexpectedSOC-acurrentSOC)*fullEnergy/chargePower/(TimeTool.interval/60.0));
	}
	
	// whether to call this determined by the user
	public int refreshRecord(){
		currentSOC=currentSOC+TimeTool.interval/60.0*chargePower/fullEnergy;
		remainInterval-=1;
		return remainInterval;
	}
	
}
