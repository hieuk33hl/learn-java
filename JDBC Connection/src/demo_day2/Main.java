package demo_day2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Lay ra toan bo
		System.out.println("1:Lấy ra toàn bộ danh sách");
		System.out.println("2:Lấy ra thông tin theo ID");
		System.out.println("3:Cập nhật 1 bản ghi theo ID");
		System.out.println("4:Xoá 1 bản ghi theo ID");
		System.out.println("0:Thoát");
		Scanner scanner = new Scanner(System.in);
		
		boolean cont = true;
		ArrayList<Contact> myContacts = ContactModel.all();
		do {
			System.out.println("Nhập chức năng[0-5]: ");
			String chon = scanner.nextLine();
			switch (chon) {
			case "1": {
				System.out.println("Danh sach ");
				for (int i = 0; i < myContacts.size(); i++) {
					System.out.println(myContacts.get(i).toString());
				}
				break;
			}
			case "2": {
				//	 Tim kiem thong tin theo id
				try {
					Scanner in = new Scanner(System.in);
					System.out.println("Nhap id: ");
					int id = Integer.parseInt(in.nextLine());
					
					Contact item = ContactModel.get(id);
					if(item != null) System.out.println(item.toString());
					else System.out.println("Khong tim ban ghi phu hop");
					in.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "3": {
				//	 Cap nhat thong tin 1 ban ghi co ma la 1 -> name = "BKD02K11 update" phone 09292
				Contact suaDoi = myContacts.get(0);
				suaDoi.setName("BKD02K11 update");
				if(ContactModel.update(suaDoi)) {
					System.out.println("Thanh cong");
				}
				else {
					System.out.println("That bai");
				}
				break;
			}
			case "4": {
				try {
					Scanner in = new Scanner(System.in);
					System.out.println("Nhập ID cần xoá: ");
					int id = Integer.parseInt(in.nextLine());
					
					Contact item = ContactModel.get(id);
					if(item != null) System.out.println(item.toString());
					else System.out.println("Khong tim ban ghi phu hop");
					in.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case "0": {
				cont = false;
			}
			default:
			}
			scanner.close();
		}while (cont);
	}
}
