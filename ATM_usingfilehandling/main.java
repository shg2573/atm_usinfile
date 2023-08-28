import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Date;
import java.io.RandomAccessFile;
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
class transaction{
    double bal;
    Scanner ob=new Scanner(System.in);
    public void addrec(String userfile, double a, double b, String c, Date d) throws IOException {
        String str=a+"::"+b+"::"+c+"::"+d;
        try{
            BufferedWriter wr=new BufferedWriter(new FileWriter(userfile,true));
            wr.write(str+"\n");
            wr.close();
        }catch (FileNotFoundException e){
            System.out.println("error");
        }
    }
    public void withdraw(String userfile) throws IOException {
        Date d=new Date();
        try{
            BufferedReader re=new BufferedReader(new FileReader(userfile));
            String l;
            while((l= re.readLine())!=null){
                String[] substr=l.split("::");
                bal= Double.parseDouble(substr[0]);
            }} catch (IOException e) {
            bal=0;
        }
        System.out.println("ENTER AMOUNT TO BE WITHDRAWED");
        double amt = ob.nextDouble();
        System.out.println("AMOUNT WITHDRAWED SUCCESSFULLY");
        bal = bal - amt;
        System.out.println("DATE "+d);
        System.out.println("UPDATED BALANCE IS " + bal);
        addrec(userfile,bal,amt,"DEBIT",d);
    }
    public void deposit(String userfile) throws IOException {
        Date d=new Date();
        try{
            BufferedReader re=new BufferedReader(new FileReader(userfile));
            String l;
            while((l= re.readLine())!=null){
                String[] substr=l.split("::");
                bal= Double.parseDouble(substr[0]);
            }
        }
        catch (IOException n) {
            bal=0;
        }
        System.out.println("ENTER AMOUNT TO BE DEPOSITED");
        double amt = ob.nextDouble();
        System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");
        bal = bal + amt;
        System.out.println("DATE "+d);
        System.out.println("UPDATED BALANCE IS " + bal);
        System.out.println("DATE "+d);
        addrec(userfile,bal,amt,"CREDIT",d);
    }
}
class login{
    public boolean check(String phno,String pass)throws IOException{
        BufferedReader re=new BufferedReader(new FileReader("cred.txt"));
        String l;
        while((l= re.readLine())!=null){
            String[] substr=l.split(",");
            if(substr[1].equals(phno)&&substr[2].equals(pass)){
                return(true);
            }
        }
        return(false);
    }
}

 class mdp{
    Scanner mc=new Scanner(System.in);
    transaction ob=new transaction();
    public void choice(String userfile) throws IOException,NullPointerException {
        int n=1;
        while(n == 1){
            System.out.println("PRESS 3 FOR WITHDRAWAL");
            System.out.println("PRESS 4 FOR DEPOSIT");
            System.out.println("PRESS 5 TO EXIST");
            int ch= mc.nextInt();
            System.out.println("-----------------------------------------------------");
            switch(ch){
                case 3:
                    ob.withdraw(userfile);
                    System.out.println("-----------------------------------------------------");
                    break;
                case 4:
                    ob.deposit(userfile);
                    System.out.println("-----------------------------------------------------");
                    break;
                default:
                    System.out.println("TRANSACTION COMPLETED");
                    System.out.println("-----------------------------------------------------");
                    n=0;
            }
        }
    }}
public class main {
    public static void main(String[] args) throws IOException{
        Scanner ob=new Scanner(System.in);
        info ob2=new info();
        login ob3=new login();
        while(true){
            System.out.println("----------------------------------------------------------------");
            System.out.println("WELCOME TO SBI BANK");
            System.out.println("PRESS 1 TO CREATE NEW ACCOUNT");
            System.out.println("PRESS 2 TO LOGIN INTO YOUR ACCOUNT");
            System.out.println("PRESS ANY KEY TO TERMINATE THE SESSION");
            int choice=ob.nextInt();
            System.out.println("----------------------------------------------------------------");
            if(choice==1) {
                System.out.println("PLEASE ENTER THE FOLLOWING DETAILS TO CREATE AN ACCOUNT");
                ob2.set();
                System.out.println("----------------------------------------------------------------");
                System.out.println("ACCOUNT CREATED SUCCESSFULLY");
                System.out.println("----------------------------------------------------------------");
            }
            if(choice==2) {
                String phno,pin;
                System.out.println("ENTER PHONE NUMBER");
                phno= ob.nextLine();
                phno= ob.nextLine();
                System.out.println("ENTER PIN");
                pin=ob.nextLine();
                System.out.println("pls wait");
                if (ob3.check(phno,pin)){
                    System.out.println("-----------------------------------------------------");
                    System.out.println("YOU ARE LOGGED IN");
                    System.out.println("DASHBOARD LOADING PLS WAIT...");
                    String userfile=phno+".txt";
                    mdp ch=new mdp();
                    ch.choice(userfile);
                    System.out.println("----------------------------------------------------------------");
                    //call dashboard
                }
                else{
                    System.out.println("INCORECT");
                }
            }
            else
                System.out.println("thank you");
        }
    }
}
