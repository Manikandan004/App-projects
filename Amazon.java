package app;
import java.util.*;

import javax.swing.plaf.synth.SynthStyleFactory;


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
            System.out.println("\033[H\033[2J");
                ad.ad_min();
                break;
            case 2:
            System.out.println("\033[H\033[2J");
                mer.mer_chant();
                break;
            case 3:
            System.out.println("\033[H\033[2J");
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
                System.out.println("\033[H\033[2J");
                    addMerchant();

                    break;
                case 2:
                System.out.println("\033[H\033[2J");
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
            approval_waiting.remove(i);
            homepage();
      }
      else{
          System.out.println("Regected");
      }
    
    }
    Amazon.intialpage();

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
            System.out.println("\033[H\033[2J");
              new_merchant();
             break;
            case 2:
            System.out.println("\033[H\033[2J");
            Exicitinguser();
             break;
            case 3:
            System.out.println("\033[H\033[2J");
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
        int p =0;
        System.out.println("1.Product");
        System.out.println("2.Update");
        System.out.println("3.Exit");
        System.out.println("Enter your Choice : ");
        p = sc.nextInt();

        switch(p){
            case 1:
            System.out.println("\033[H\033[2J");
            product.amazon_product();
                break;
            case 2:
            System.out.println("\033[H\033[2J");
            Update();
                break;
            case 3:
            System.out.println("\033[H\033[2J");
            Amazon.intialpage();
                
        }
    }
    //offer
    static void Update(){
        sc.nextLine();
        System.out.print("Enter your company name : ");
        String company_name = sc.nextLine();
        for(int i=0;i<product.product_details.size();i++){  
            if(product.product_details.get(i).get(1).contains(company_name)){
                // order.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                System.out.println("Enter the updated prize : ");
                    String prize = sc.nextLine();
                    product.product_details.get(i).set(2,prize);
               
                    product.productReview();
                    
            }
           
        }

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


class product {
    private static Scanner sc=new Scanner(System.in);
    static String pro_name,pro_company;
    static String pro_prize;
    static String pro_nickname;
   
   static ArrayList<String> chart = new ArrayList<String>();
    // static ArrayList<String> company = new ArrayList<String>();
    // static ArrayList<Integer> prize = new ArrayList<Integer>();
    static ArrayList<ArrayList<String>>product_details = new ArrayList<ArrayList<String>>();
    public static Object addProduct;
    static void amazon_product(){
        int n5=0;
        System.out.println("1.Add product");
        System.out.println("2.Remove product");
        System.out.println("3.Product Review");
        
        System.out.println("4.Exit");
        System.out.println("Enter your choice : ");
        n5=sc.nextInt();

        switch(n5){
            case 1:
                System.out.println("\033[H\033[2J");
                addProduct();
                break;
            case 2:
                System.out.println("\033[H\033[2J");
                 Removeproduct();
                break;
            case 3:
                System.out.println("\033[H\033[2J");
                 productReview();
            case 4:
                System.out.println("\033[H\033[2J");
                 Merchant.Merchantpage();
                break;

        }
    }
    //productreview
    static void productReview() {
        System.out.printf("%-15s%-15s%-15s%-15s\n","S.no","Pro_name","Brand","Prize");
        for(int i=0;i<product_details.size();i++){
                 System.out.printf("%-15s",i+1);
                 for(int j =0 ;j<product_details.get(i).size();j++){
                     System.out.printf("%-15s",product_details.get(i).get(j));
              }
              System.out.print("\n");
            }
            amazon_product();
    }


    //userMethod
    static void user_product(){
        
        System.out.printf("%-15s%-15s%-15s%-15s\n","S.no","Pro_name","Brand","Prize");
        for(int i=0;i<product_details.size();i++){
                 System.out.printf("%-15s",i+1);
                 for(int j =0 ;j<product_details.get(i).size();j++){
                     System.out.printf("%-15s",product_details.get(i).get(j));

                 }
              
              System.out.print("\n");
            }
            User.product_page();
            System.out.println("");

    }
    //addProdcut
    static void addProduct(){
         ArrayList<String> pro_details = new ArrayList<String>();
        sc.nextLine();
        System.out.print("Enter your product name : ");
        pro_name = sc.nextLine();
        pro_details.add(pro_name);
        System.out.print("2.Company Name : ");
        pro_company = sc.nextLine();
       pro_details.add(pro_company);
        System.out.print("3.Product prize : ");
        pro_prize = sc.nextLine();
        pro_details.add(pro_prize);
        product_details.add(pro_details);
        
        // System.out.println(product_details);
        amazon_product();

    }
    //removeproduct
    static void Removeproduct(){
      
         System.out.print("Remove : ");
        int num = sc.nextInt();
        product_details.remove(num);
        System.out.println(product_details);
        amazon_product();
    }

    public static void main(String[] args){
        sc =  new Scanner(System.in);
        amazon_product();
       

    }
}

class User{
        private static Scanner sc;
        static String name,name1;
        static int password,password1;
        static String product_name;
        static ArrayList<String> by_product = new ArrayList<String>();
        static ArrayList<String> buy = new ArrayList<String>();
        static ArrayList<String> chart= new ArrayList<String>();
        static ArrayList<String> user_name = new ArrayList<String>();
        static ArrayList<Integer> user_pass = new ArrayList<Integer>();
        static ArrayList<ArrayList<String> > order = new ArrayList<ArrayList<String>>();
         static void userInput(){
            int n=0;
                    System.out.println("1.New User");
                    System.out.println("2.Exciting user");
                    System.out.println("3.Exit");
                    System.out.print("Enter your choice ");
                    n = sc.nextInt();
                    switch(n){
                        case 1:
                        System.out.println("\033[H\033[2J");
                            newUser();
                            break;
                        case 2:
                        System.out.println("\033[H\033[2J");
                            exicitingUSer();
                            break;
                        case 3:
                        System.out.println("\033[H\033[2J");
                            System.exit(0);
                    }
        }
        //new user
        static void newUser(){
        sc.nextLine();
        System.out.println("Enter your name : ");
        name =  sc.nextLine();
        user_name.add(name);
        System.out.println("Enter your password : ");
        password = sc.nextInt();
        user_pass.add(password);
        System.out.println("Account added successfully..!");
        userInput();
        }
    
        //exciting user
        static void exicitingUSer(){
            sc.nextLine();
            System.out.println("Enter your name : ");
            name1 =  sc.nextLine();
            System.out.println("Enter your password : ");
            password1 = sc.nextInt();
    
            if(user_name.contains(name1) && user_pass.contains(password1)){
                userHome();
            }
            else{
                System.out.println("Invalid user, Create an account..!");
                userInput();
            }
        }
    
        //Userhomepage
        static void userHome(){
            int a=0;
            System.out.println("1.Product");
            System.out.println("2.Order");
            System.out.println("3.Add chart");
            System.out.println("4.Exit");
            System.out.println("Enter your choice : ");
            a=sc.nextInt();
            switch(a){
                case 1:
                System.out.println("\033[H\033[2J");
                    product.user_product();
                    break;
                case 2:
                System.out.println("\033[H\033[2J");
                    buyy();
                    break;
                case 3:
                    addChart();
                    break;
                case 4:
                System.out.println("\033[H\033[2J");
                    System.exit(0);
            }
        }
        
        //productpage
        static void product_page(){
            
          
            sc.nextLine();
            System.out.println("Product_name : ");
            product_name = sc.nextLine();
            //System.out.println(product.product_details);
            System.out.println(product_name);
           for(int i=0;i<product.product_details.size();i++){  
                if(product.product_details.get(i).get(0).contains(product_name)){
                    // order.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                    // buy.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                    chart.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                    System.out.println(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                    System.out.println("");
                    System.out.println("Enter buy if you want to buy this product : ");
                    String b = sc.nextLine();
                    
                    if(b.toLowerCase().equals("buy")){
                        by_product.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                        System.out.println("product placed successfully..!");
                    }
                  else{  
                  
                  
                    user_interest();
                  }
                }
               
            }
        }
        
        //buyornot
        static void user_interest(){
            System.out.println();
            int ch=0;
            // System.out.println("1.Order");
            System.out.println("2.Add to chart");
            System.out.println("3.Exit");
            System.out.println("Enter your choice : ");
            ch = sc.nextInt();
            switch(ch){
                // case 1:
                // System.out.println("\033[H\033[2J");
                //     break;
                case 2:
                System.out.println("\033[H\033[2J");
                    addChart1();
                case 3:
                System.out.println("\033[H\033[2J");
                    userHome();
            }             
        }
        //favourite
        static void favourite_page(){
            System.out.println("No fav..!");
        }
        //buyy
        static void buyy(){
          System.out.println(by_product);
          System.out.println("Please enter to continue");
          sc.nextLine();
          String s = sc.nextLine();
          if(s.equals("")){
              userHome();
          }
                
        }
        //buyview
        // static void buyView(){
        //     System.out.println(buy);
        // }
        //addchart
        static void addChart1(){
            System.out.println(chart);
               System.out.println("Please enter to continue");
               sc.nextLine();
               String s = sc.nextLine();
               if(s.equals("")){
                   userHome();
               }
            
            }          
        static void addChart(){
             System.out.println(chart);
                System.out.println("Please enter to continue");
                sc.nextLine();
                String s = sc.nextLine();
                if(s.equals("")){
                    space();
                }
             
             }             
         //spaceneeded
         static void space(){
            System.out.println();
            int ch=0;
            System.out.println("1.Buy");
            System.out.println("2.Remove");
            System.out.println("3.Exit");
            System.out.println("Enter your choice : ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                System.out.println("\033[H\033[2J");
                sc.nextLine();
                for(int i=0;i<product.product_details.size();i++){  
                    if(product.product_details.get(i).get(0).contains(product_name)){
                        chart.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                        System.out.println();
                        System.out.println("");
                        System.out.println("Enter buy if you want to buy this product : ");
                        String b = sc.nextLine();
                        
                        if(b.toLowerCase().equals("buy")){
                            by_product.add(product.product_details.get(i).get(1)+" "+product.product_details.get(i).get(2));
                            System.out.println("product placed successfully..!");
                        }
                    }
                    buyy();
                    break;
                }
                    
                case 2:
                System.out.println("\033[H\033[2J");
                    remove();
                case 3:
                System.out.println("\033[H\033[2J");
                    userHome();
            }
         }
        
        //remove
        static void remove(){
            
         System.out.print("Remove : ");
         int num = sc.nextInt();
         chart.remove(num);
         System.out.println(chart);
        }
    
    void u_ser(){
        System.out.println("Welcome User");
        sc =  new Scanner(System.in);
        userInput();
    }
}
