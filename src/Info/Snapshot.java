package Info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * a record of one interval, used in TableSequence
 * @author Thinkpad
 *
 */
public class Snapshot {
	public Calendar startTime;	// the start of the interval
	public double PFund;
	public double PRest;	// PRest + PFund = PTotal
	public double weight;	
	int[] UtilityState;	// to store the id of the car
	
	public Snapshot(Calendar astartTime, double aPFund){
		startTime=astartTime;
//		PFund=aPFund;
		refreshP(aPFund);
		weight=refreshWeight();
		UtilityState=new int[BasicInfo.chargeUtilityNum];
		for(int i=0;i!=BasicInfo.chargeUtilityNum;i++){
			UtilityState[i]=0;
		}
	}
	public double refreshP(double PFund){
		this.PFund=PFund;
		PRest=BasicInfo.PTotal-PFund;
		return PRest;
	}
	public double refreshWeight(){		//调用之前，可能需要刷新一下实时功率
		return BasicInfo.alpha*ElectricInfo.getPrice(startTime)+
				BasicInfo.beta*PRest;
	}
	public void refreshState(int Utility, int car){
		UtilityState[Utility]=car;
	}
	public void printSnapshot(){
		System.out.println("date: "+startTime.toString());
		System.out.println("PFund: "+PFund);
		System.out.println("PRest: "+PRest);
		System.out.println("Weight: "+weight);
		// printUtilityStates, remain to complete
		
	}
	
}

