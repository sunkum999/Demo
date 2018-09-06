package com.pepcus.bo.staticmethods;

import java.util.Random;

public class StaticMethod {
	//public StaticMethod() {System.out.println("StaticMethod(){}");}

	public static final String checkFinal(String str) {
		System.out.println("checkFinal("+str+")");
		return str != null?str:null;
	}
	
	public static String check(String str) {
		return str != null?str:null;
	}
	
	public String checkVoid() {
		String str = new Random(548514).nextInt()+"";
		System.out.println("checkVoid("+str+")");
		return "str";// != null?str:null;
	}

}
