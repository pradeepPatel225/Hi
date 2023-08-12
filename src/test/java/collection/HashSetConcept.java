package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetConcept {

	public static void main(String[] args) {
		// HashSet is child  class of Set interface
		// HashSet does not support duplicate value
		//HashSet does not maintain insertion order
		// It support only wrapper class and class type not data type
		HashSet<String> a=new HashSet<String>();
		a.add("Vikash");
		a.add("Vinod");
		a.add("Ganesh");
		a.add("Pawan");
		a.add("Rohit");
		a.add("kritika");
		a.add("pappu");
		a.add("Rohit");
		for(String value:a)
		{
			System.out.println(value);  
		}

		System.out.println(" ");


		//////////////////====================/////////////////




		Set<Integer> b=new HashSet<Integer>();
		b.add(10);
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		b.add(70);
		b.add(80);

		for(Integer value:b)
		{
			System.out.println(value);  
		}

		System.out.println(" ");



		//////////////////====================/////////////////



		HashSet ab=new HashSet();
		int  []i = {10,20,30,10,50,60,70};
		ab.add(i[4]);
		ab.add(i[1]);
		ab.add(i[0]);
		ab.add(i[3]);
		ab.add(i[2]);
		ab.add(i[5]);
		ab.add("Pradeep");
		System.out.println(ab);



	}

}
