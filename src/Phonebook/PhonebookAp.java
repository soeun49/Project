package Phonebook;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhonebookAp {

	public static void main(String[] args) {
		selectAll();
//		insertNew();
//		delete();
//		search();
		
	}

	private static void selectAll() {
		PhonebookDAO dao=new PhonebookDAOimpl();
		List<PhonebookVO> list=dao.getlist();
		
		Iterator <PhonebookVO> it=list.iterator();
		System.out.println("<1.리스트>");
		
		while(it.hasNext()) {
			PhonebookVO item=it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", 
					item.getId(),item.getName(),item.getMobile(),item.getPhonehome());
			
		}
		
	}
	
	private static void insertNew() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("<2.등록>");
		System.out.print(">이름: ");
		String name=scanner.next();
		System.out.print(">휴대전화: ");
		String mobile=scanner.next();
		System.out.print(">집전화: ");
		String phonehome=scanner.next();
		
		PhonebookVO vo=new PhonebookVO(null,name, mobile, phonehome);
		PhonebookDAO dao= new PhonebookDAOimpl();
		
		System.out.printf("등록되었습니다");
		
		scanner.close();
		
	}
	
	private static void delete() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int id = scanner.nextInt();
		
		PhonebookDAO dao=new PhonebookDAOimpl();
		
		System.out.println("삭제되었습니다");
		
		scanner.close();
		
	}
	
	private static void search() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("<4.검색>");
		System.out.print(">이름:");
		String keyword = scanner.next();
		
		PhonebookDAO dao=new PhonebookDAOimpl();
		List<PhonebookVO>list=dao.search(keyword);
		
		Iterator<PhonebookVO> it=list.iterator();
		
		while(it.hasNext()) {
			PhonebookVO vo=it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", 
					vo.getId(),vo.getName(),vo.getMobile(),vo.getPhonehome());
					}
				
		
	}
}
