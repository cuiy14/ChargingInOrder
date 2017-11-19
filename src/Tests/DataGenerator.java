package Tests;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

import FileManage.GetExcelInfo;
import Info.ElectricInfo;
import Info.Snapshot;
import Info.TableSequence;
import Info.TimeTool;
import jxl.read.biff.BiffException;

public class DataGenerator {	// read the info from excel file
	
	//从参数给定的时间算起，给出接下来的24小时的基础负荷水平
	public static LinkedList<Snapshot> gene(Calendar calendar) throws BiffException, IOException{	//值传送，还是引用传送？	
		int numOfIntervals= (int)Math.ceil(24*60.0/TimeTool.interval);
		LinkedList<Snapshot> val = new LinkedList<Snapshot>();
		LinkedList<Double> lista=GetExcelInfo.readLine(constants.path,0,TimeTool.day);
		LinkedList<Double> listb=GetExcelInfo.readLine(constants.path,0,TimeTool.day+1);
		lista.removeFirst();
		listb.removeFirst();
		lista.addAll(listb);
		listb=lista;
		int originalsize=lista.size();
		for(int i=0;i!=originalsize-1;i++){
			lista.add(3*i+1,(listb.get(i)*0.66+listb.get(i)*0.33)*(1+(Math.random()-0.5)/0.5*0.05));
			lista.add(3*i+2,(listb.get(i)*0.33+listb.get(i)*0.66)*(1+(Math.random()-0.5)/0.5*0.05));
		}
		//构造返回值
		int startIndex=(int)Math.floor((calendar.get(Calendar.MINUTE)+
				calendar.get(Calendar.HOUR_OF_DAY)*60.0)/TimeTool.interval);
		for(int iter=0;iter!=numOfIntervals;iter++){
			Snapshot snapshot=new Snapshot(
					TimeTool.addMinute(calendar, TimeTool.interval*iter), lista.get(startIndex+iter)*0.4);	// to continue
			val.add(snapshot);
//			calendar.add(Calendar.MINUTE, TimeTool.interval);
		}
		return val;
	}
	public static void main(String args[]) throws BiffException, IOException{	//测试数据生产
		ElectricInfo electricInfo= new ElectricInfo();		//默认初始化electricInfo
		Calendar calendar=Calendar.getInstance();
		calendar.set(2017, 0, 3, 7, 0, 0);
		System.out.println(calendar.toString());
		TableSequence tableSequence=new TableSequence(DataGenerator.gene(calendar));	//初始化表格除桩以外的几行	//断点调试？
		System.out.println(tableSequence.intervals.size());
		tableSequence.intervals.get(0).printSnapshot();
//		for(int i=0;i!=tableSequence.intervals.size();i++){
//			tableSequence.intervals.get(i).printSnapshot();
//		}
	}
}
