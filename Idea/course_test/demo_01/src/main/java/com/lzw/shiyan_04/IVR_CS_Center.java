package com.lzw.shiyan_04;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Example 5.1
 * 表驱动编程
 * 遗留：java如何运行字符串，如“menu_0_4()”。如果解决了，表驱动编程更有效。
 * 否则，临时办法。
 */
public class IVR_CS_Center {
	static final String[] MENU_0 = {"生活缴费","预约挂号","公交服务","天气预报","常用电话","违章查询","社保服务","公积金服务","","退出程序"};
	static final String[] MENU_0_0 = {"有线电视费","水费","电费","燃气费","一卡通费","手机缴费","返回上层"};
	static final String[] MENU_0_4 = {"日常生活","公安工商","快递服务","网购电话","公交咨询","医院电话","银行保险","交通运输","家政服务","返回上层"};
	static final String[] MENU_0_7 = {"航空服务","铁路服务","长途车服务","返回上层"};
	static final String[] MENU_0_4_1 = {"交警大队","各区街道","各派出所","出入境","投诉举报","返回上层","回主菜单"};
	static final String[] MENU_0_4_1_methods = {"f0","f1","f2","f3","f4","f5","f6"};
	static final String[] MENU_0_4_7 = {"航空电话","铁路电话","长途车电话","返回上层","回主菜单"};

	private Scanner sc = new Scanner(System.in);

	public void menu_0_UI(){
		int choice = 0 ;
		String exit = "n";
		boolean running = true;
		while (running){
			menu_0();
			try {
				choice = sc.nextInt();
				System.out.println("你选择了功能"+choice+",执行："+MENU_0 [choice]);
				if (choice == 0 || choice == 4){
					running = false;
				}else if (choice == 9 ){
					System.out.println("你确定要退出程序吗？[y/n]");
					exit = sc.next();
					if (exit.matches("[yY]")){
						running = false;
					}else {
						System.out.println("你选择了继续执行程序。");
					}
				}
			}catch (InputMismatchException e){
				System.out.println("输入不合法：只能输入1-9的数字.");
				sc.next();
			}
		}
		// System.out.println("退出主程序。");
		if (choice == 0 ){
			menu_0_0_UI();
		}else if (choice == 4 ){
			menu_0_4_UI();
		}
	}
	public void menu_0_0_UI(){
		System.out.println("Not implemented:menu_0_0_UI()");
	}
	public void menu_0_4_UI(){
		int choice = 0 ;
		boolean running = true;
		while (running){
			menu_0_4();
			try {
				choice = sc.nextInt();
				System.out.println("你选择了功能"+choice+",执行："+MENU_0_4[choice]);
				if (choice == 1 || choice == 7 || choice == 9){
					running = false;
				}
			}
			catch (InputMismatchException e){
				System.out.println("输入不合法：只能输入1-9的数字.");
				sc.next();
			}
		}
		System.out.println("退出程序: menu_0_4_UI");
		if (choice == 1 ){
			menu_0_4_1_UI();
		}else if (choice == 7 ){
			menu_0_4_7_UI();
		}else if (choice == 9 ){
			menu_0_UI();
		}
	}
	public void menu_0_4_1_UI() {
		int choice = 0 ;
		boolean running = true;
		while (running){
			menu_0_4_1();
			try {
				choice = sc.nextInt();
				System.out.println("你选择了功能"+choice+",执行："+MENU_0_4_1[choice]);
				if (choice == 5 || choice == 6){
					running = false;
				}
			}
			catch (InputMismatchException e){
				System.out.println("输入不合法：只能输入1-5的数字.");
				sc.next();
			}
		}
		System.out.println("退出程序: menu_0_4_1_UI");
		if (choice == 5 ){
			menu_0_4_UI();
		}else if (choice == 6 ){
			menu_0_UI();
		}

	}
	public void menu_0_4_7_UI(){
		System.out.println("Not yet implemented.");
	}
	public void menu_0(){
		// 以下应该是语音录音
		System.out.println("\n智慧城市的便民服务");
		drawLine();
		drawUesrSelection();
		drawLine();
		for (int i=0; i < MENU_0.length;i++){
			System.out.println(""+i+". "+MENU_0[i]);
		}
		drawLine();
		userPrompt();
	}
	public void menu_0_0(){
		// 以下应该是语音录音
		System.out.println("\n智慧城市的便民服务 -"+MENU_0[0]);
		drawLine();
		drawUesrSelection();
		drawLine();
		for (int i=0; i < MENU_0_0.length;i++){
			System.out.println(""+i+". "+MENU_0_0[i]);
		}
		drawLine();
		userPrompt();
	}

	public void menu_0_4(){
		// 以下应该是语音录音
		System.out.println("\n智慧城市的便民服务 - "+MENU_0[4]);
		drawLine();
		drawUesrSelection();
		drawLine();
		for (int i=0; i < MENU_0_4.length;i++){
			System.out.println(""+i+". "+MENU_0_4[i]);
		}
		drawLine();
		userPrompt();
	}
	public void menu_0_7(){
		// 以下应该是语音录音
		System.out.println("\n智慧城市的便民服务 - "+MENU_0[7]);
		drawLine();
		for (int i=0; i < MENU_0_7.length;i++){
			System.out.println(""+i+". "+MENU_0_7[i]);
		}
		drawLine();
		userPrompt();
	}
	public void menu_0_4_1(){
		// 以下应该是语音录音
		System.out.println("\n智慧城市的便民服务 -"+MENU_0[4]+"-"+MENU_0_4[1]);
		drawLine();
		drawUesrSelection();
		drawLine();
		for (int i=0; i < MENU_0_4_1.length;i++){
			System.out.println(""+i+". "+MENU_0_4_1[i]);
		}
		drawLine();
		userPrompt();
	}

	public void menu_0_4_7(){
		// 以下应该是语音录音
		System.out.println("\n智慧城市的便民服务 - "+MENU_0[4]+"-"+MENU_0_4[7]);
		drawLine();
		drawUesrSelection();
		drawLine();
		for (int i=0; i < MENU_0_4_7.length;i++){
			System.out.println(""+i+". "+MENU_0_4_7[i]);
		}
		drawLine();
		userPrompt();
	}
	private void userPrompt() {
		System.out.println("请选择......");
	}
	private void drawUesrSelection() {
		System.out.println("功能列表\n（请输入数字，按回车键）");
	}
	private void drawLine() {
		System.out.println("---------------------");
	}


}
