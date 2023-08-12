package collection;
import java.util.*;

public class TreeShotConcept {

	public static void main(String[] args) {
		// TreeSet is child  class of Set interface
		// TreeSet does not support duplicate value
		//TreeSet does not maintain insertion order
		//It has not get name method because it does not maintain insertion order
		// TreeSet maintain shorting(ascending order)
		// It support only wrapper class and class type not data type
		TreeSet<Integer> a=new TreeSet<Integer>();
		a.add(57);
		a.add(100);
		a.add(14);
		a.add(44);
		a.add(23);
		a.add(34);
		a.add(89);
		a.add(78);
		a.add(100);
		for(Integer value:a)
		{
			System.out.println(value);	
		}
		System.out.println(" ");

		Set<String> a1=new TreeSet<String>();
		a1.add("Ramesh");
		a1.add("pradeep");
		a1.add("Pramod");
		a1.add("Ratnesh");
		a1.add("Deeraj");
		a1.add("Vipin");
		a1.add("pradeep");
		a1.add("Bipin");
		a1.add("Aman");
		for(String value:a1)
		{
			System.out.println(value);	
		}





	}

}
