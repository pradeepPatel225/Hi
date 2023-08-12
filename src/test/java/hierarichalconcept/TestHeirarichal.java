package hierarichalconcept;

public class TestHeirarichal {

	public static void main(String[] args) {
		//System.out.println(" A obj=new A ");		
HierarichalA obja=new HierarichalA();
obja.A1();
obja.A2();
obja.A3();
System.out.println(" ");
//System.out.println(" A obj=new B");

//there method resolution will be happen refrense type not object type

HierarichalA obja1=new HierarichalB();
obja1.A1();
obja1.A2();
obja1.A3();
System.out.println(" ");
//System.out.println(" B obj=new B() ");
HierarichalB objB=new HierarichalB();
objB.A1();
objB.A2();
objB.A3();
objB.B1();
objB.B2();
objB.B3();
System.out.println(" ");
HierarichalC objC=new HierarichalC();
objC.A1();
objC.A2();
objC.A3();
objC.C1();
objC.C2();
objC.C3();



}
}
