package phoneAssignment;

public class PhoneTester {

	public static void main(String[] args) {
		Galaxy s21ultra = new Galaxy("S21Ultra", 99, "Verizon", "Ring Ring Ring");
		IPhone iphone12 = new IPhone("X12", 100, "At&T","Zing");
		
		s21ultra.displayInfo();
		System.out.println(s21ultra.ring());
		System.out.println(s21ultra.unlock());
		
		iphone12.displayInfo();
		System.out.println(iphone12.ring());
		System.out.println(iphone12.unlock());
		
		

	}

}
