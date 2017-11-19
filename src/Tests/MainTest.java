package Tests;

import java.io.IOException;
import java.util.Calendar;

import Info.ElectricInfo;
import Info.TableSequence;
import jxl.read.biff.BiffException;

public class MainTest {
	public static void main(String [] args) throws BiffException, IOException{
		//更新从现在往后1天变压器的剩余容量曲线&价格信息，存在TableSequence中，核对各时段的功率是否过载
		ElectricInfo electricInfo= new ElectricInfo();		//默认初始化electricInfo
		Calendar calendar=Calendar.getInstance();
		calendar.set(2017, 0, 3, 7, 0, 0);
		TableSequence tableSequence=new TableSequence(DataGenerator.gene(calendar));	//初始化表格除桩以外的几行
		for(int i=0;i!=tableSequence.intervals.size();i++){
			tableSequence.intervals.get(i).printSnapshot();
		}
		//读取当前的已注册的汽车需求信息，存在TableSequence中；写一个界面，用来注册车的信息，包括手动注册和文件注册
		
		/**考察上一时段的SnapShot,如果没有充满，则继续原位置充电；		// 算法设计
		*  假如有超载情形，按照弹出委托型处理，下一时段重新安排处理；
		*  再考虑新接入的车, 仍按照word中的优先级策略
		*
		*
		*/
		
		//安排完之后，按照桩位依次输出相应的状态及对应的车号；更新每辆车的SOC状态；以表格的形式展现；
		
	}
}
