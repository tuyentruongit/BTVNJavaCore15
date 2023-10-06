package logicHandle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicMain {
     LogicWoker logicWoker = new LogicWoker();
     LogicWorkShop logicWorkShop = new LogicWorkShop();
     LogicTimesSheets logicTimesSheets = new LogicTimesSheets( logicWoker,  logicWorkShop);



    public  void run( ) {
       while (true){
           printMenu();
           int choiceFuntion = choiceFuntion();
           switch (choiceFuntion){
               case 1:
                   logicWoker.InputInforWorker();
                   break;
               case 2:
                   logicWoker.showWorker();
                   break;
               case 3:
                   logicWorkShop.inputInforWorkShop();
                   break;
               case 4:
                   logicWorkShop.printWorkShop();
                   break;
               case 5:
                   logicTimesSheets.createTimeSheets();
                   break;
               case 6:
                   logicTimesSheets.printTimesSheets();
                   break;
               case 7:
                   logicTimesSheets.sortTimesSheets();
                   break;
               case 8:
                   logicTimesSheets.incomeStatement();
                   break;
               case 9:
                   return;

           }
       }
    }

    private  int choiceFuntion() {
        int choice  ;
        do {
            do {
                try{
                    choice = new Scanner(System.in).nextInt();
                    break;
                }catch (InputMismatchException e ){
                    System.out.println("Dữ liệu bạn vừa nhập k hợp lệ, Vui lòng nhập lại ");
                }
            }while (true);
            if (choice>0 && choice<10){
                break;
            }
            System.out.println("Chức năng bạn vừa chọn không hợp lệ, Vui lòng chọn lại chức năng ");
        }while (true);
        return choice;
    }

    private  void printMenu() {
        System.out.println("PHẦN MỀM QUẢN LÝ GÌ ĐẤY Ạ");
        System.out.println("1. Nhập danh sách công nhân mới ");
        System.out.println("2. In danh sách công nhân đã có ");
        System.out.println("3. Nhập danh sách xưởng sản xuất mới ");
        System.out.println("4. In danh sách xưởng sản xuất đã có");
        System.out.println("5. Lập bảng chấm công cho từng công nhân ");
        System.out.println("6. In bảng chấm công ");
        System.out.println("7. Sắp xếp bảng danh sách phân công ");
        System.out.println("8. lập bảng kê thu nhập cho mỗi công nhân trong tháng ");
        System.out.println("9. Thoát ");
        System.out.println(" Bạn vui lòng chọn những chức năng trên");
    }
}
