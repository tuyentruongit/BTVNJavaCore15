import java.util.InputMismatchException;
import java.util.Scanner;

public class main222 {
    public static void main(String[] args) {
        int a = 0;
        int c = 0;
        for (int i = 0; i < 2; i++) {

                   do {
                       try {
                           a = new Scanner(System.in).nextInt();
                           c+=a;
                       }catch (InputMismatchException e){
                           System.out.println("gì đáy");
                       }
                       if (c>=0 && c<= 30){
                           break;
                       }
                       System.out.println("hahaha");
                       c = c-a;
                   }while (true);
        }
        System.out.println(c);
    }
}
