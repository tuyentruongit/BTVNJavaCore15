package logicHandle;

import entity.Timesheets;
import entity.WorkShop;
import entity.WorkShopDetail;
import entity.Worker;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class LogicTimesSheets {
    LogicWoker logicWoker ;
    LogicWorkShop logicWorkShop;
    List<Timesheets> timesheets = new ArrayList<>();

    public LogicTimesSheets(LogicWoker logicWoker, LogicWorkShop logicWorkShop) {
        this.logicWoker = logicWoker;
        this.logicWorkShop = logicWorkShop;
    }

    public void createTimeSheets() {
        if (logicWoker.isEmptyWorker()){
            System.out.println("Chưa có công nhân, vui lòng thêm công nhân");
            return;
        }
        System.out.println("Bạn muôn lập bảng chấm công cho bao nhiêu nhân viên");
        int number = exeptionInputNumber();
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập Id của nhân viên thứ "+(i+1));
            Worker worker = searchWorker();
            if (logicWoker.isEmptyWorker()){
                System.out.println("Chưa có phân xưởng nào, vui lòng thêm phân xưởng");
                return;
            }
            List<WorkShopDetail> workShopDetails = new ArrayList<>();
            System.out.println("Công nhân trên đã làm ở bao nhiêu xưởng");
            int quantity = inputQuantity();
            int count = 0;
            for (int j = 0; j <quantity ; j++) {
                System.out.println("Nhập Id của xưởng thứ"+(j+1)+" mà nhân viên trên đã làm");
                WorkShop workShop = null;
                int idWorkShop ;
                do {
                    do {
                        try{
                            idWorkShop = new Scanner(System.in).nextInt();
                            break;
                        }catch (InputMismatchException e ){
                            System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
                        }
                    }while (true);
                    workShop=logicWorkShop.searchWorkShop(idWorkShop);
                    if (workShop!=null){
                        break;
                    }
                    System.out.println("Không có xưởng  nào có id như trên, Bạn vui long nhập lại id");
                }while (true);
                System.out.println("Nhập số ngày công bạn đã làm trong xưởng trên ");
                int workingDays = 0;
                do {
                    try{
                        workingDays = new Scanner(System.in).nextInt();
                        count = count +workingDays;
                    }catch (InputMismatchException e ){
                        System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
                    }
                    if (count>=0 && count<= 30){
                        break;
                    }
                    System.out.println("Mỗi công nhân chỉ có tối đa 30 công trong 1 tháng , vui lòng nhập lại ");
                    count = count-workingDays;
                }while (true);
                WorkShopDetail workShopDetail = new WorkShopDetail(workShop,workingDays);
                workShopDetails.add(workShopDetail);
            }
            Timesheets timesheets1 = new Timesheets(worker,workShopDetails);
            timesheets.add(timesheets1);
        }
    }

    private int inputQuantity() {
        int quantity = 0;
        do {
            try{
                quantity = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e ){
                System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
            }
        }while (true);
        return quantity;
    }

    private Worker searchWorker() {
        Worker worker ;
        int idWorker ;
        do {
            do {
                try{
                    idWorker = new Scanner(System.in).nextInt();
                    break;
                }catch (InputMismatchException e ){
                    System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
                }
            }while (true);
            worker=logicWoker.searchWorker(idWorker);
            if (worker!=null){
                break;
            }
            System.out.println("Không có công nhân nào có id như trên, Bạn vui long nhập lại id");
        }while (true);
        return worker;
    }

    private int exeptionInputNumber() {
        int number;
        do {
            try{
                number = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e ){
                System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
            }
        }while (true);
        return number;
    }

    public void printTimesSheets(){
        System.out.println(timesheets);

    }

    public void sortTimesSheets() {
        System.out.println("Bạn muốn sắp xếp bảng chấm công theo: ");
        System.out.println("1. Theo tên của công nhân");
        System.out.println("2. Theo tên của phân xưởng");
        System.out.println("3. Thoát");
        int typeSort ;
        do {
            try{
                typeSort = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e ){
                System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
            }
        }while (true);
        switch (typeSort){
            case 1:
                sortNameWorker();
                break;
            case 2:
                sortQuantityWorkShop();
                break;
            case 3:
                break;
        }
    }

    private void sortNameWorker() {
        Collections.sort(timesheets, new Comparator<Timesheets>() {
            @Override
            public int compare(Timesheets o1, Timesheets o2) {
                return (o1.getWorker().getName().compareTo(o2.getWorker().getName()));
            }
        });
        System.out.println(timesheets);
    }

    private  void sortQuantityWorkShop(){
        Collections.sort(timesheets, new Comparator<Timesheets>() {
            @Override
            public int compare(Timesheets o1, Timesheets o2) {
                return 0;
            }
        });
    }

    public void incomeStatement() {
        if (logicWoker.isEmptyWorker()){
            System.out.println("Chưa có công nhân, vui lòng thêm công nhân");
            return;
        }
        int number = 0;
        do {
            try{
                number = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e ){
                System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
            }
        }while (true);
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập Id của nhân viên thứ "+(i+1));
            Worker worker = null;
            int idWorker ;
            do {
                do {
                    try{
                        idWorker = new Scanner(System.in).nextInt();
                        break;
                    }catch (InputMismatchException e ){
                        System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
                    }
                }while (true);
                worker=logicWoker.searchWorker(idWorker);
                if (worker!=null){
                    break;
                }
                System.out.println("Không có công nhân nào có id như trên, Bạn vui long nhập lại id");
            }while (true);
        }

    }
}
