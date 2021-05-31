package Phonebook;

import java.util.Scanner;

public class PhonebookAPP {

	public static void main(String[] args) {
		boolean run= true;
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("******************************************");
			System.out.println("*         전화번호 관리 프로그램                *");
			System.out.println("******************************************");
			System.out.println("1.리스트 | 2. 등록 | 3. 삭제| 4. 검색 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("메뉴번호> ");
			
			int menuNum=scanner.nextInt();
			
		Switch(menuNum) {
			case 1: 
				System.out.println("<1.리스트>");
//				selectAll();
				break;
				
			case 2: 
				System.out.println("<2.등록>");
//				insertNew();
				break;
				
			case 3: 
				System.out.println("<3.삭제>");
//				delete();
				
			case 4: 
				System.out.println("<4.검색>");
//				search();
				
			case 5: 
				run(false);
	
				break;
				
		}
		System.out.println();
		}
		System.out.println("****************************************");
		System.out.prinltn("*                 감사합니다               *");
		System.out.println("*****************************************");
		scanner.close();
	
	}
	
	
	private static void selectAll() {
		
	}
	
	private static void insertNew() {
		
	}
	
	private static void delete() {
		
	}
	
	private static void search() {
		
	}
}
