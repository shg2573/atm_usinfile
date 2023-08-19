import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import create.*;

class info{
    private String name,phno;
    private int pin;
    public void set() throws IOException {
        Scanner ob=new Scanner(System.in);
        System.out.print("ENTER NAME: ");
        this.name=ob.nextLine();
        System.out.print("ENTER PHONE NUMBER: ");
        this.phno=ob.nextLine();
        System.out.print("SET YOUR USER PIN: ");
        this.pin=ob.nextInt();
        BufferedWriter wr=new BufferedWriter(new FileWriter("cred.txt",true));
        String text=name+","+phno+","+pin;
        wr.write(text+"\n");
        wr.close();
    }
}
class login{
    public String check(String phno,String pass)throws IOException{
        BufferedReader re=new BufferedReader(new FileReader("cred.txt"));
        String l;
        while((l= re.readLine())!=null){
            String[] substr=l.split(",");
            if(substr[1].equals(phno)&&substr[2].equals(pass)){
                return(substr[0]);
            }
        }
        return(" ");
    }
    }
    

public class mainc {
    public static void main(String[] args) throws IOException{
        Scanner ob=new Scanner(System.in);
        info ob2=new info();
        login ob3=new login();
       /* System.out.println("----------------------------------------------------------------");
        System.out.println("WELCOME TO SBI BANK");
        System.out.println("PLEASE ENTER THE FOLLOWING DETAILS TO CREATE AN ACCOUNT");
        System.out.println("----------------------------------------------------------------");
        ob2.set();
        System.out.println("----------------------------------------------------------------");
        System.out.println("ACCOUNT CREATED SUCCESSFULLY");
        System.out.println("----------------------------------------------------------------");
        */System.out.println("ENTER 1 FOR BANKING PROCESS ELSE PRESS ANY KEY");
        int n=ob.nextInt();
        System.out.println("----------------------------------------------------------------");
        String phno,pin;

        if(n==1) {
            System.out.println("ENTER PHONE NUMBER");
            phno= ob.nextLine();
            phno= ob.nextLine();
            System.out.println("ENTER PIN");
            pin=ob.nextLine();
            System.out.println("pls wait");
            String na=ob3.check(phno,pin);
            if (na.equals(" ")){
                System.out.println("error");
            }
            else{
                System.out.println("-----------------------------------------------------");
                System.out.println("WELCOME "+na);
                System.out.println("----------------------------------------------------------------");
            }
        }
        else System.out.println("thank you");
    }
}
