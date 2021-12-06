// package com.lzw.shiyan_06;
// /*
//  * 设计二
//  * 方案3：让Exercise含ArayList，提供next和hasNext，让其客户实现formateAndDisplay
//  */
// // import cbsc.cha4.OperationBase;
// /*
//  * 2015-8-4: add()
//  */
// import java.io.*;
//
// import java.util.Iterator;
// import java.util.Random;
// import java.util.ArrayList;
// import java.util.Scanner;
//
// public class Exercise_3_2_3 {
//
// 	private ArrayList<BinaryOperation_3_2> operationList = new ArrayList<BinaryOperation_3_2>();
// 	private int current=0; // only used for iterator
//
// 	private BinaryOperation_3_2 generateOperation(){
// 		Random random = new Random();
// 		int opValue = random.nextInt(2);
// 		if (opValue == 1){
// 			return new AdditionOperation();
// 		}
// 		return new SubstractOperation();
// 	}
// 	public void generateAdditionExercise( int operationCount){
// 		BinaryOperation_3_2 anOperation;
// 		/*
// 		 * 根据第7章内容添加以下一行代码
// 		 */
// 		operationList.clear();    //先清空再生成
//
// 		while (operationCount > 0 ){
// 			do {anOperation = new AdditionOperation();
// 			}while (operationList.contains(anOperation));
// 			operationList.add(anOperation);
// 			//System.out.println("count="+ operationList.size());
// 			operationCount--;
// 		}
// 	}
// 	public void generateBinaryExercise(int operationCount){
// 		BinaryOperation_3_2 anOperation;
// 		/*
// 		 * 根据第7章内容添加以下一行代码
// 		 */
// 		operationList.clear();    //先清空再生成
// 		while (operationCount > 0 ){
// 			do{anOperation = generateOperation();
// 			}while (operationList.contains(anOperation));
// 			operationList.add(anOperation);
// 			operationCount--;
// 		}
// 	}
// 	public void generateSubstractExercise(int operationCount){
// 		BinaryOperation_3_2 anOperation;
// 		/*
// 		 * 根据第7章内容添加以下一行代码
// 		 */
// 		operationList.clear();    //先清空再生成
// 		while (operationCount > 0 ){
// 			do{anOperation = new SubstractOperation();
// 			}while (operationList.contains(anOperation));
// 			operationList.add(anOperation);
// 			operationCount--;
// 		}
// 	}
// 	// --- 2015-8-4: begin
// 	public void add(BinaryOperation_3_2 anOperation){
// 		operationList.add(anOperation);
// 	}
// 	public boolean contains(BinaryOperation_3_2 anOperation){
// 		return operationList.contains(anOperation);
// 	}
// 	public int length(){
// 		return operationList.size();
// 	}
// 	// write Exercise in a file, each Operation as "3+5"
// 	public void writeExercise(){
// 		File wfile = new File("eq2.txt");
// 		try{
// 			Writer out = new FileWriter(wfile, true);
// 			for (BinaryOperation_3_2 op: operationList){
// 				out.write(op.toString()+",");
// 			}
// 			out.flush();
// 			out.close();
// 		}
// 		catch(IOException e){
// 			System.out.println("ERROR: "+e);
// 		}
// 	}
// 	public void writeCSVExercise(File aFile){
// 		try{
// 			Writer out = new FileWriter(aFile, true);
// 			for (BinaryOperation_3_2 op: operationList){
// 				out.write(op.toString()+",");
// 			}
// 			out.flush();
// 			out.close();
// 		}
// 		catch(IOException e){
// 			System.out.println("ERROR: "+e);
// 		}
// 	}
// 	// read in a file each  as "3+5", and convert to Operation， add in Exercise
// 	public Exercise_3_2_3 readCSVExercise(){
// 		Exercise_3_2_3 exercise = new Exercise_3_2_3();
// 		String eqString;
// 		BinaryOperation_3_2 op;
// 		Scanner sc = null;
// 		File rfile = new File("eq2.txt");
// 		try{
// 			sc = new Scanner(rfile);
// 			sc.useDelimiter(",\\n");
//
// 			while(sc.hasNext()){
// 				eqString = sc.next();
// 				op = new AdditionOperation();
// 				op.unsafeConstructor(eqString);
// 				exercise.add(op);
// 			}
// 		}
// 		catch(IOException e){
// 			System.out.println("ERROR: "+e);
// 		}
//
// 		return exercise;
// 	}
// 	public Exercise_3_2_3 readCSVExercise(File aFile){
// 		Exercise_3_2_3 exercise = new Exercise_3_2_3();
// 		String eqString;
// 		BinaryOperation_3_2 op;
// 		try{
// 			Scanner sc = new Scanner(aFile);
// 			sc.useDelimiter(",");
//
// 			while(sc.hasNext()){
// 				// 处理任意的\t，\f， \n等
// 				eqString = sc.next().replaceAll("\\s", "");
// 				op = new AdditionOperation();
// 				op.unsafeConstructor(eqString);
// 				exercise.add(op);
// 			}
// 		}
// 		catch(IOException e){
// 			System.out.println("ERROR: "+e);
// 		}
//
// 		return exercise;
// 	}
// 	// ---- 2015-8-4: ----- end
//
// 	// 下面两个方法用于实现遍历数据
// 	public boolean hasNext(){ 		// 若有元素返回true，否则返回false，
// 		return current <= operationList.size()-1;
// 	}
// 	public BinaryOperation_3_2 next(){		// 若有元素返回当前元素，移动到一个
// 		return operationList.get(current++);
// 	}
// 	public void printCurrent(){
// 		System.out.println("current="+current);
// 	}
// 	//根据第7章的需求添加一种获取元素的方法
// 	public BinaryOperation_3_2 getOperation(int index){
// 		if(index < operationList.size()) return operationList.get(index);
// 		else return null;
// 	}
// 	// for test
// 	public void all(){
// 		for (BinaryOperation_3_2 op:operationList){
// 			System.out.println(op.asString());
// 		}
// 	}
// 	// for test
// 	public void writeResults(File aFile){
// 		try{
// 			Writer out = new FileWriter(aFile, true);
// 			for (BinaryOperation_3_2 op: operationList){
// 				out.write(op.getResult()+",");
// 			}
// 			out.flush();
// 			out.close();
// 		}
// 		catch(IOException e){
// 			System.out.println("ERROR: "+e);
// 		}
// 	}
// 	// 方式2：使用ArrayList自带的Iterator,这像是一个适配器模式！
// 	public Iterator<BinaryOperation_3_2> iterator(){
// 		return operationList.iterator();
// 	}
// 	/*
// 	public void generateAdditionExerciseFromBase(int operationCount){
// 		OperationBase base = new OperationBase();
// 		BinaryOperation_3_2 anOperation;
// 		while (operationCount > 0 ){
// 			do {anOperation = new AdditionOperation();
// 			}while (operationList.contains(anOperation));
// 			operationList.add(anOperation);
// 			// System.out.println("count="+ operationList.size());
// 			operationCount--;
// 		}
// 	}
// 	*/
// }
