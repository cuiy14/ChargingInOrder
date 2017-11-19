package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App extends JFrame {
	JPanel contentPanel=new JPanel();
	JPanel upPanel=new JPanel();
	JPanel downPanel=new JPanel();
	JPanel westPanel=new JPanel();
	JPanel centerPanel=new JPanel();
	
	public App(){
	super("电动汽车充电桩预约系统");
//	setResizable(false);
//	this.setSize(1500, 600);
	contentPanel.setLayout(new BorderLayout());
	buildUpPanel();
	contentPanel.add(upPanel, BorderLayout.NORTH);
	buildDownPanel();
	contentPanel.add(downPanel, BorderLayout.SOUTH);
	this.setContentPane(contentPanel);
	this.pack();
	this.setVisible(true);
	this.validate();
	}
	
	void buildUpPanel(){
		Label title=new Label("电动汽车充电桩预约");
		title.setSize(100, 40);
		Label mode=new Label("模式选择");
		JComboBox comboBox=new JComboBox();
		comboBox.addItem("手动输入");
		comboBox.addItem("批量导入");
		comboBox.addActionListener();		//////////////////////////////
		upPanel.setLayout(new BorderLayout());
		upPanel.add(title, BorderLayout.NORTH);
		upPanel.add(mode, BorderLayout.CENTER);
		upPanel.add(comboBox, BorderLayout.EAST);
	};
	
	void buildDownPanel(){
		downPanel.setLayout(new BorderLayout());
		//westpanel
		westPanel.setLayout(new GridLayout(4, 1));
		Label name=new Label("类型");
		westPanel.add(name);
		JRadioButton r1=new JRadioButton("委托型");
		JRadioButton r2=new JRadioButton("预约型");
		JRadioButton r3=new JRadioButton("及时型");
		westPanel.add(r1);
		westPanel.add(r2);
		westPanel.add(r3);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		r1.setSelected(true);
		downPanel.add(westPanel, BorderLayout.WEST);
		//centerpanel
		centerPanel.setLayout(new GridLayout(3, 4));
		Label socb=new Label("初始soc");
		centerPanel.add(socb);
		JTextField soct=new JTextField("0");
		centerPanel.add(soct);
		Label socb2=new Label("预期soc");
		centerPanel.add(socb2);
		JTextField soct2=new JTextField("1");
		centerPanel.add(soct2);
		Label powb=new Label("充电功率");
		centerPanel.add(powb);
		JTextField powt=new JTextField("0");
		centerPanel.add(powt);
		Label batb=new Label("电池容量");
		centerPanel.add(batb);
		JTextField batt=new JTextField("200");
		centerPanel.add(batt);
		Label arrb=new Label("到达时间(dd-hh-mm)");
		centerPanel.add(arrb);
		JTextField tt=new JTextField("00-07-35");
		centerPanel.add(tt);
		Label leab=new Label("离开时间(dd-hh-mm)");
		centerPanel.add(leab);
		JTextField tt2=new JTextField("00-10-40");
		centerPanel.add(tt2);
		downPanel.add(centerPanel, BorderLayout.CENTER);
	}
	
	public static void main(String args[]){
		App app=new App();
		
	}
	
}
