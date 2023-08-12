package collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetConcept {

	public static void main(String[] args) {
		// LinkedHashSet is child class of Set interface
		//LinkedHashSet does not support duplicate value
		// LinkedHashSet maintain insertion order
		// It support only class type
		//


		LinkedHashSet<Integer> L=new LinkedHashSet<Integer>();
		L.add(20);
		L.add(25);
		L.add(2);
		L.add(100);
		L.add(40);
		L.add(80);
		L.add(47);
		L.add(80);

		for(Integer value: L)
		{
			System.out.println(value); 
		}

		System.out.println(" ");



		//////////////////====================/////////////////



		Set<String> L1=new LinkedHashSet<String>();
		L1.add("Pradeep");
		L1.add("Babita");
		L1.add("Priya");
		L1.add("Kiran");
		L1.add("Anushma");
		L1.add("Richa");
		L1.add("Simaran");
		L1.add("Priya");
		for(String value: L1)
		{
			System.out.println(value); 
		}


	}

}
