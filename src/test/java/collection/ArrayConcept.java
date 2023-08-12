package collection;

public class ArrayConcept {

	public static void main(String[] args) {
		// An array is an index based homogeneous collection of data element
		// It is fixed in  size
		// It support adjacent memory allocate
		// it support data type and class type
		// It support duplicate value
		// It maintain insertion order

		int a[]=new int [5];
		a[0]=10;
		a[1]=20;
		a[2]=30;
		a[3]=40;
		a[4]=50;
		for(int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);	
		}
		System.out.println("  ");


		////////////////////====================================///////////////////


		String b[]=new String [5];
		b[0]="raju";
		b[1]="pradeep";
		b[2]="Kishan";
		b[3]="Monu";
		b[4]="Manoj";
		for(int i=0; i<b.length; i++)
		{
			System.out.println(b[i]);	
		}

		System.out.println("  ");


		//////////////////====================/////////////////


		Object b1[]=new String [5];
		b1[0]="20";
		b1[1]="pradeep";
		b1[2]="Kishan";
		b1[3]="70";
		b1[4]="Manoj";
		for(int i=0; i<b1.length; i++)
		{
			System.out.println(b1[i]);	
		}




	}

}
