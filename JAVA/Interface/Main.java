package chap07.interFace.exam01;

public class Main {

	public static void main(String[] args) {
		
		// 자동 타입변환 
		Bank bank = new KBBank();
		bank.withDraw(100);
		bank.deposit(100);
		bank.findDormancyAccount("763231");
		Bank.BCAuth("KBBank");
		
		System.out.println("\n*************인스턴스 교체!!*************\n");
		
		bank = new SHBank();
		bank.withDraw(100);
		bank.deposit(100);
		bank.findDormancyAccount("4311");
		Bank.BCAuth("SHBank");
		
		System.out.println("\n*************카카오은행 연동 실패!!*************\n");
		
		/*bank = new KakaoBank();
		 *bank.withDraw(100);
		 *bank.deposit(100);
		 *bank.findDormancyAccount("4311");
		 */
		
		System.out.println("\n*************대학교 주은행 교체!!*************\n");
		
		bank = new KBBank();
		bank.withDraw(20000);
		bank.deposit(1000);
		bank.findDormancyAccount("855512");
		Bank.BCAuth("SHBank");

	}

}
