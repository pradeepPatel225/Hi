package collection;
import java.util.*;

public class ArraylistConcept {

	public static void main(String[] args) {
		// An array is an index based homogeneous,hatrogeneous collection of data element
		// It is automate grow able in  size
		// It support adjacent memory allocate
		// it support only class type
		// It support duplicate value
		// it maintain insertion order
		// ArrayList is faster than LinkedList


		ArrayList<String> a=new ArrayList<String>();
		a.add("Kishan");
		a.add("Suraj");
		a.add("Karan");
		a.add("Sigma");
		a.add("Beta");
		a.add("gama");
		a.add("Kishan");
		//a.add(1, "Mohan");
		a.remove(2);
		System.out.println("Size===== "+a.size());

		for(int i=0; i<a.size(); i++)
		{
			System.out.println(a.get(i));	
		}
		System.out.println(" ");



		//////////////////====================/////////////////



		List<String> a1=new ArrayList<String>();
		a1.add("Kishan1");
		a1.add("Suraj2");
		a1.add("Karan3");
		a1.add("Sigma4");
		a1.add("Beta5");
		a1.add("gama6");
		a1.add("Kishan7");
		//a.add(1, "Mohan");
		a1.remove(2);
		System.out.println(a1.size());

		for(int i=0; i<a1.size(); i++)
		{
			System.out.println(a1.get(i));	
		}
		System.out.println(" ");



		//////////////////====================/////////////////



		ArrayList b=new ArrayList();
		String []str ={"Kishan","gama","Beta","Sigma","Karan","Pradeep","Sandeep"};
		b.add(str[3]);
		b.add(str[1]);
		b.add(100);
		b.add(str[0]);
		b.add(str[4]);
		b.add(str[5]);
		b.add(str[6]);
		//a.add(1, "Mohan");
		// a.remove(2);
		System.out.println(b.size());

		for(int i=0; i<b.size(); i++)
		{
			System.out.println(b.get(i));	
		}
		System.out.println(" ");


	}

}
