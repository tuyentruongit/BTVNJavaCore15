package entity;

import javax.sound.midi.MidiFileFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker extends Person implements InputInfor{
    private static int nextIdWorker = 1000;
    private int idWorker;
    private int level;

    public Worker() {
        this.idWorker=nextIdWorker;
        nextIdWorker++;
    }
    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getNextIdWorker() {
        return nextIdWorker;
    }

    public static void setNextIdWorker(int nextIdWorker) {
        Worker.nextIdWorker = nextIdWorker;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "idWorker=" + idWorker +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

        @Override
    public void inputInfor() {
        System.out.println("Nhập tên của công nhân");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ của công nhân");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại của công nhân");
       do {
           do {
               try {
                   this.setPhone(new Scanner(System.in).nextLine());
                   break;
               }
               catch (InputMismatchException e){
                   System.out.println("Dữ liệu bạn vừa nhập không đúng, Vui lòng nhập lại");
               }
           }while (true);
           if (regexPhoneNumber(getPhone())){
               break;
           }
           System.out.println("So dien thoai ban vua nhap khong dung vui long nhap lai");
       }while (true);
            System.out.println("Nhập bạc thợ của công nhân");
        do {
            this.setLevel(new Scanner(System.in).nextInt());
            if ( this.getLevel()<8&&this.getLevel()>0){
                break;
            }
            System.out.println("Người thợ có bậc cao nhất là 7 và bậc thấp nhất là 1, Vui long nhập lại");
        }while (true);
    }
    public boolean regexPhoneNumber(String phone){
        String regex =  "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
        if(phone.matches(regex)){
            return true;
        }
        return false;
    }

}
