package com.tsm.ShoppingCart;

import java.util.*;

public class LineItemTest {

	public static void main(String[] args) {
		
		Product Apple = new Product(101,"Apple",20.0,0.0);
		Product Lays = new Product(201,"Lays",30.0,5.0);
		Product Mouse = new Product(301,"Mouse",200.0,20.0);
		Product Keyboard = new Product(401,"KeyBoard",300.0,14.0);
		Product AuxCable = new Product(501,"AuxCable",50.0,8.0);
		
		ArrayList<LineItem> shoppingkart = new ArrayList<>(Arrays.asList(
				
				new LineItem(1,2,Apple),
				new LineItem(2,1,Lays),
				new LineItem(3,3,Mouse),
				new LineItem(4,4,Keyboard),
				new LineItem(5,1,AuxCable)
				
				));
		
		System.out.println("+----+--------------+----------+----------+----------+----------+");
		System.out.println("| ID |     Name     | Quantity |  Price   | Discount |  Total   |");
		System.out.println("+----+--------------+----------+----------+----------+----------+");
		for (LineItem item : shoppingkart) {
		    System.out.printf("| %-2d | %-12s | %-8d | $%-7.2f | $%-7.2f | $%-7.2f |\n",
		            item.getId(), item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice(), item.getProduct().getDiscountPercent(), item.calculateLineItemCost());
		}
		System.out.println("+----+--------------+----------+----------+----------+----------+");
		System.out.println("|    |              |          |          |Net Total |  $%-7.2f |",);
		System.out.println("+----+--------------+----------+----------+----------+----------+");
			
		
		
		

	}

}
