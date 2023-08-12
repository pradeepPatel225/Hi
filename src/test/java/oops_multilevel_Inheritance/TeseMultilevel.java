package oops_multilevel_Inheritance;

public class TeseMultilevel {

	public static void main(String[] args) {
     MultilevelA objA=new MultilevelB();
     objA.Am1();
     objA.Am2();
     objA.Am3();
     objA.Am4();
     System.out.println(" ");
     MultilevelB obj=new MultilevelB();
     obj.Am1();
     obj.Am2();
     obj.Am3();
     obj.Am4();
     obj.Bm1();
     obj.Bm2();
     obj.Bm3();
     obj.Bm4();
     System.out.println(" ");
     MultilevelC objc=new MultilevelC();
     objc.Am1();
     objc.Am2();
     objc.Am3();
     objc.Am4();
     objc.Bm1();
     objc.Bm2();
     objc.Bm3();
     objc.Bm4();
     objc.Cm1();
     objc.Cm2();
     objc.Cm3();
     objc.Cm4();

     
     
     
     
     
    		 
	}

}
