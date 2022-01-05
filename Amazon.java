package app;
import java.util.*;

import javax.sql.rowset.spi.SyncResolver;


class Amazon {
    private static Scanner sc;
    static int n;
    static void intialpage(){
        Admin ad= new Admin();
        Merchant mer = new Merchant();
        User user = new User();

        System.out.println("1.Admin");
        System.out.println("2.Merchant");
        System.out.println("3.User");
        System.out.println("4.Exit");
        System.out.println("Enter your choice : ");
        sc = new Scanner(System.in);
        n= sc.nextInt();
        switch(n){
            case 1:
                ad.ad_min();
                break;
            case 2:
                mer.mer_chant();
                break;
            case 3:
                user.u_ser();
            case 4: 
                System.exit(0);
                break;
                
        }

    

    }
  
    public static void main(String[] args) {
        //objects
            intialpage();

}
}


class Admin {
    private static Scanner sc;
    static String name;
    static int pin,n;
    static String name_mer;
    static int pass_mer;
    static String name1[] = {"Mani","Prasanth"};
    static int pin1[] = {9751 , 75581};
    static ArrayList<String> merchant_name =new ArrayList<String>();
    static ArrayList<Integer>merchant_pass =new ArrayList<Integer>();
    static ArrayList<String>approval_waiting = new ArrayList<String>();
     //admin login
    static void login(){
        sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        name = sc.nextLine();
        System.out.print("Enter your pin : ");
        pin = sc.nextInt();
        
        if(name.equals("Mani") && pin == 9751 ){
            System.out.println("Logged successfully..!");
            homepage();
        }
        else{
            System.out.println("Invalid Input");
        }
        
    }
      //admin homepage
    static void homepage(){

        System.out.println("\033[H\033[2J");
        System.out.println("Add Merchant");
        System.out.println("Approved");
            System.out.print("Enter your choice : ");
           n= sc.nextInt();
            switch(n){
                case 1:
                    addMerchant();

                    break;
                case 2:
                    approval();
                    break;
                default:
                    System.out.println("Invalid input");
            }
             

        
    }
    static void approval() {
        for(int i=0;i<approval_waiting.size();i++){
            System.out.println(approval_waiting.get(i));
        System.out.println("Do you want to approved or not");
        
        sc.nextLine();
      String yno = sc.nextLine();
    
      if(yno.equals("yes")){
            merchant_name.add(approval_waiting.get(i));
      }
      else{
          System.out.println("Regected");
      }
      Amazon.intialpage();
    }
   

    }
    //addMerchant
    static void addMerchant(){
     
        sc.nextLine();
        System.out.println("Enter your Name : ");
        name_mer = sc.nextLine();
        merchant_name .add(name_mer);
        System.out.println("Enter your password : ");
        pass_mer = sc.nextInt();
        merchant_pass .add(pass_mer);
        System.out.println(merchant_name +" "+ merchant_pass); 
       Amazon.intialpage();

    }
    void ad_min() {
        System.out.println("Welcome admin");
      
        login();
    }
    
}

class Merchant{
    private static Scanner sc;
    static int cnt=0;
    static ArrayList<String> newname_mer =new ArrayList<String>();
    static ArrayList<Integer> newcode_mer =new ArrayList<Integer>();
    static void login_mer(){
         sc = new Scanner(System.in);
        System.out.println("1.New User");
        System.out.println("2.Exiting User");
        System.out.println("3.Exit");
        int n = sc.nextInt();
        switch(n){
            case 1:
              new_merchant();
             break;
            case 2:
            Exicitinguser();
             break;
            case 3:
             Amazon.intialpage();
        }
    }
    public static String newname_mer() {
        return null;
    }
    //exiciting user
    static void Exicitinguser(){
        sc.nextLine();
        System.out.println("Enter your name : ");
        String mer_name1 = sc.nextLine();
         if(Admin.merchant_name.contains(mer_name1)){
            Merchantpage();
        }
        else{
            if(Admin.approval_waiting.contains(mer_name1)){
                System.out.println("\033[H\033[2J");
                System.out.println("Waiting for approval");
                 login_mer();

            }
            else{
                System.out.println("Invalid user..! Create an account");
            }
        }
    }
    //Merchantpage
    static void Merchantpage(){
        System.out.println("1.Product");
        System.out.println("2.Offer");
        System.out.println("3.Exit");
    }
    //new_merchant
    static void new_merchant(){

       
        sc.nextLine();
        
        System.out.println("Enter your name : ");
        String mer_name = sc.nextLine();
       Admin.approval_waiting.add(mer_name);
        System.out.println("Enter your password : ");
        int mer_pass = sc.nextInt();
        newcode_mer.add(mer_pass);
        System.out.println(newname_mer +" "+ newcode_mer); 
      Amazon.intialpage();
  
        
      
    }
    void mer_chant(){
        System.out.println(" Welcome Merchant");
        login_mer();
    }
}

class User{
    void u_ser(){
        System.out.println("Welcome User");
    }
}