package logicHandle;

import entity.Worker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LogicWoker {
    List<Worker> workers = new ArrayList<>();
    public void InputInforWorker(){
        System.out.println("Bạn muốn thêm bao nhiêu công nhân mới");
        int numberWorker;
        do {
            try{
                numberWorker = new Scanner(System.in).nextInt();
                break;
            }catch (InputMismatchException e ){
                System.out.println("Dữ liệu bạn vừa nhập không hợp lệ vui lòng nhập lại");
            }
        }while (true);
        for (int i = 0; i < numberWorker; i++) {
            System.out.println("Nhập thông tin của công nhân thứ "+(i+1));
            Worker worker = new Worker();
            worker.inputInfor();
            saveWorker(worker);
        }
    }

    private void saveWorker(Worker worker ) {
        workers.add(worker);
    }

    public void showWorker() {
        System.out.println(workers);
    }
    public Worker searchWorker ( int idWorker){
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getIdWorker()==idWorker){
                return workers.get(i);
            }
        }
        return null;
    }
    public boolean isEmptyWorker(){
       return workers.isEmpty();
    }
}
