package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSwap {
	
	public static void main(String[] arg) {
		
		
		List<Integer> list = new ArrayList<>();
	
		
		for(int i=0; i<10; i++) {
			list.add(i+(int)(Math.random()*10));
		}
		int max=0;
		for(int i =0; i<list.size(); i++) {
				if(list.get(i)>max || max ==0) {
					max = list.get(i);
			}
		}
		int min=0;
		for(int i =0; i<list.size(); i++) {
				if(list.get(i)<min || min ==0) {
					min = list.get(i);
			}
		}
		for(int i =0; i<list.size(); i++) {
				for(int j=0; j<list.size(); j++) {
					if(list.get(i)<list.get(j)) {
						int swap = list.get(i);
						list.set(i, list.get(j));
						list.set(j, swap);
					}
				}
		}
		System.out.println(list);
		for(int i =0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				if(list.get(i)<list.get(j)) {
					int swap = list.get(i);
					list.set(i, list.get(j));
					list.set(j, swap);
				}
			}
	}
		System.out.println(max);
		System.out.println(min);
		System.out.println(list);
		
	}
	
	
	
}
