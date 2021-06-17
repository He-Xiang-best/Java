package com.demo3.chart;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 购物车类
 * @author gxy
 *
 */
public class FoodList {
	ArrayList<Food> chart;
	int[] number;//保存用户选购商品的id号及其数量
	public FoodList(){
		chart=new ArrayList<Food>();
		chart.add(new Food(0,"香肠",3.80));
		chart.add(new Food(1,"苹果",5.00));
		chart.add(new Food(2,"酱油",12.00));
		chart.add(new Food(3,"饮料",23.80));
		number=new int[chart.size()];
		
	}
	public ArrayList<Food> getChart() {
		return chart;
	}
	public void setChart(ArrayList<Food> chart) {
		this.chart = chart;
	}
	public int[] getNumber() {
		return number;
	}
	public void setNumber(int number) {
		Arrays.fill(this.number, number);
	}
	/***
	 * 根据用户选购的商品号将number数组对应商品id号的数量加1
	 * @param ids 选购商品的id号数组
	 */
	public void setNum(String[] ids) {
		int intId=-1;
		for(String id:ids) {
			intId=Integer.parseInt(id);
			number[intId]+=1;
			//System.out.println("id:"+intId);
		}
	}
	/****
	 * 
	 * @param i 根据id号找到对应的商品
	 * @return 返回对应的商品具体信息
	 */
	public Food findFood(int i) {
		for(Food food:this.chart)
			if (food.getId()==i)
				return food;
		return null;
	}
	/**
	 * 购物车中选购商品的总价格
	 * @return 返回商品的总价格
	 */
	public double totalP() {
		double totalPrice=0;
		for(int i=0;i<number.length;i++) {
			if (number[i]>0) {
				//System.out.println("id1:"+i);
				totalPrice+=findFood(i).getPrice();
				//System.out.println("价格:"+totalPrice);
			}
		}
		return totalPrice;
	}
	/**
	 * 打印购物车中所有选购的商品名称
	 * @return 返回所有商品名称的字符串
	 */
	public String printFood() {
		String FoodMessage="";
		for(int i=0;i<number.length;i++)
			if (number[i]>0)
				FoodMessage=FoodMessage+findFood(i).getName()
				+"<br>";
		return FoodMessage;
	}
}




class Foodnum{
	int id;
	
	int number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
