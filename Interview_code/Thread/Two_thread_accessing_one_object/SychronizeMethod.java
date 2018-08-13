package com.abhay.file.main;

public class SychronizeMethod extends Thread {
	
	StringBuffer sb;
	SychronizeMethod(StringBuffer sb){
		this.sb = sb;
	}
	public void run(){
		synchronized (sb) {
			for (int i = 0; i < 10; i++) {
				System.out.println(sb);
			}
			System.out.println();
			char temp = sb.charAt(0);
			++temp;
			sb.setCharAt(0, temp);
		}
	}
	
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("A");
		new SychronizeMethod(s).start();
		new SychronizeMethod(s).start();
		new SychronizeMethod(s).start();
	}
}
