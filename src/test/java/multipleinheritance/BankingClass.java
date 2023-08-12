package multipleinheritance;

public class BankingClass implements BankingInterfaceA,BankingInterfaceB{

	public static void main(String[] args) {
		BankingClass objC=new BankingClass();
		objC.bonusCalculate();
		objC.calculateinterest();
		objC.fixdeposite();
		objC.moneydeposite();
		objC.moneyWithdraw();

	}

	public void moneydeposite() {
		System.out.println("I am moneydeposite");
		
	}

	public void moneyWithdraw() {
	System.out.println("I am moneywithdraw");	
	}

	public void fixdeposite() {
System.out.println("I am fixdeposite");		
	}

	public void calculateinterest() {
System.out.println("I am calculateinterest");		
	}

	public void bonusCalculate() {
		System.out.println("I am bonusCalculate");
	}

}
