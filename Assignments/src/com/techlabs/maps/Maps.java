package com.techlabs.maps;

import java.util.*;

public class Maps {

	public static void main(String[] args)   {
		Map<Integer,String> map=new TreeMap<Integer,String>();
		map.put(2, "Anil");

		map.put(3, "Shubham");

		map.put(4, "Pradeep");

		map .put(1, "Praveen" );

		map.put(2, "Vismita");

		System.out.println(map);
		
		Set<Map.Entry<Integer,String>> set = map.entrySet();
		
		for(Map.Entry<Integer, String> entry :set) {
			System.out.println(entry.getKey() +" " +entry.getValue());
		}
		

}
}
