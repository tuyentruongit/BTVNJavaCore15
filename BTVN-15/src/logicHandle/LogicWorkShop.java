package logicHandle;

import entity.WorkShop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LogicWorkShop {
    List<WorkShop> workShops = new ArrayList<>();


    public void inputInforWorkShop() {
        System.out.println("Bạn muốn thêm bao nhiêu phân xưởng mới ");
        int numberWorkShop = exception();
        for (int i = 0; i < numberWorkShop; i++) {
            System.out.println("Nhập thông tin của phân xưởng thứ "+(i+1));
            WorkShop workShop = new WorkShop();
            workShop.inputInfor();
            saveWorkShop(workShop);
        }

    }

    private void saveWorkShop(WorkShop workShop) {
        workShops.add(workShop);
    }

    private int exception() {
        int numberWorkShop=0;
       do {
           try{
               numberWorkShop = new Scanner(System.in).nextInt();
               break;
           }catch (InputMismatchException e){
               System.out.println("Dữ liệu bạn vừa nhập không hợp lệ , Vui lòng nhập lại ");
           }
       }while (true);
        return numberWorkShop;
    }

    public void printWorkShop() {
        System.out.println(workShops);
    }

    public WorkShop searchWorkShop(int idWorkShop) {
        for (int i = 0; i < workShops.size(); i++) {
            if (workShops.get(i).getIdWorkShop()==idWorkShop){
                return workShops.get(i);
            }
        }
        return null;
    }
    public boolean isEmptyWorkShop(){
        return workShops.isEmpty();
    }
}
