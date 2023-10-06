package entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkShop implements InputInfor {
    private static int nextIdWorkShop = 100;
    private int idWorkShop;
    private String nameWorkShop;
    private String describe;
    private float jobNumber;

    public WorkShop() {
        this.idWorkShop=nextIdWorkShop;
        nextIdWorkShop++;
    }

    public static int getNextIdWorkShop() {
        return nextIdWorkShop;
    }

    public static void setNextIdWorkShop(int nextIdWorkShop) {
        WorkShop.nextIdWorkShop = nextIdWorkShop;
    }

    public int getIdWorkShop() {
        return idWorkShop;
    }

    public void setIdWorkShop(int idWorkShop) {
        this.idWorkShop = idWorkShop;
    }

    public String getNameWorkShop() {
        return nameWorkShop;
    }

    public void setNameWorkShop(String nameWorkShop) {
        this.nameWorkShop = nameWorkShop;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(float jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Override
    public String toString() {
        return "WorkShop{" +
                "idWorkShop=" + idWorkShop +
                ", nameWorkShop='" + nameWorkShop + '\'' +
                ", describe='" + describe + '\'' +
                ", jobNumber=" + jobNumber +
                '}';
    }

    @Override
    public void inputInfor() {
        System.out.println("Nhập tên của phân xưởng ");
        this.setNameWorkShop(new Scanner(System.in).nextLine());
        System.out.println("Bạn hãy mô tả phân xưởng ");
        this.setDescribe(new Scanner(System.in).nextLine());
        System.out.println("Nhập hệ số công việc của phân xưởng ");
        do {
            do {
                try{
                    this.setJobNumber(new Scanner(System.in).nextFloat());
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Dữ liệu bạn vừa nhập không hợp lệ, Vui lòng nhập lại");
                }
            }while (true);
            if (this.getJobNumber()>0 && this.getJobNumber()<21){
                break;
            }
            System.out.println("Hệ số công việc lớn nhaapts là 20 và nhỏ nhất là 1 , Vui lòng nhập lại");
        }while (true);
    }
}
