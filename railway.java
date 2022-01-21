package app;
import java.util.*;
class Railway{
    private static Scanner sc =  new Scanner(System.in);
    static void Homepage(){

        Adminrailway a_dmin  = new Adminrailway();
        Userrailway us_er = new Userrailway();
    

            System.out.println("Welcome to Railway Ticket Booking..!");
            System.out.println("");
            System.out.println("1.Admin");
            System.out.println("2.User");
            System.out.println("3.Close");
            int n = 0;
            System.out.println("Your Choice : ");
            n = sc.nextInt();
            switch(n){
                case 1:
               a_dmin.adminpage();
                    break;
                case 2:
                us_er.u_ser();
                    break;
                case 3:
                System.exit(0);
                    break;
            }
    
}
public static void main(String []  args){
    Homepage();
}
}
class Adminrailway{
    static ArrayList<ArrayList<String>> t_details = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<String>>> train = new ArrayList<>();
    static String u_name,u_pass;
    static String ex_name,ex_pass;
    static ArrayList<String> us_name = new ArrayList<String>();
    static ArrayList<String> us_pass = new ArrayList<String>();
    static ArrayList<ArrayList<String>> user_details = new ArrayList<ArrayList<String>>();
    private static Scanner sc =  new Scanner(System.in);
    static void new_user(){
        int a=0;
        System.out.println("1.New User");
        System.out.println("2.Exciting User");
        System.out.println("3.Back to Homepage");
        System.out.println("Your choice : ");
        a = sc.nextInt();
        switch(a){
            case 1:
            System.out.println("\033[H\033[2J");
            n_user();
                break;
            case 2:
            ex_user();
                break;
            case 3:
                Railway.Homepage();
                break;
        }
    }
    static void n_user(){
        sc.nextLine();
        System.out.println("Your Name : ");
        u_name = sc.nextLine();
        us_name.add(u_name);
        System.out.println("Your password : ");
        u_pass = sc.nextLine();
        us_pass.add(u_pass);
        user_details.add(us_name);
        user_details.add(us_pass);
        
        System.out.println(user_details);
        new_user();
    }
    static void ex_user(){
        sc.nextLine();
        System.out.println("Your Name : ");
        ex_name = sc.nextLine();
        System.out.println("Your Pass : ");
        ex_pass = sc.nextLine();
        if(ex_name.equals("mk") && ex_pass.equals("04") || us_name.contains(ex_name) && us_pass.contains(ex_pass)){
            System.out.println("Welcome to Ticket booking :-)");
            booking();
        }
        else{
            System.out.println("Invalid User..!");
            new_user();
        }
        
    }
    static void booking(){
        sc.nextLine();
        System.out.println("Add Train");
        System.out.println("Remove train");
        System.out.println("View train");
        System.out.println("Back");
        int t =0;
        System.out.println("your choice : ");
        t = sc.nextInt();
        switch(t){
            case 1:
            System.out.println("\033[H\033[2J");
            addtrain();
                break;
            case 2:
            removetrain();
            System.out.println("\033[H\033[2J");
                break;
            case 3:
            System.out.println("\033[H\033[2J");
            viewtrain();
                break;
            case 4:
            Railway.Homepage();
        }
    }
    static void addtrain(){
        ArrayList<String> adtrain_temp = new ArrayList<String>();
        adtrain_temp.clear();
        sc.nextLine();
        System.out.println("Train Name : ");
        String t_name = sc.nextLine();
        adtrain_temp.add(t_name);
        System.out.println("Starting point : ");
        String s_point = sc.nextLine();
        adtrain_temp.add(s_point);
        System.out.println("Station 1 : ");
        String s_01 = sc.nextLine();
        adtrain_temp.add(s_01);
        System.out.println("Station 2 : ");
        String s_02 = sc.nextLine();
        adtrain_temp.add(s_02);
        System.out.println("Station 3 : ");
        String s_03 = sc.nextLine();
        adtrain_temp.add(s_03);
        System.out.println("Ending point : ");
        String e_point = sc.nextLine();
        adtrain_temp.add(e_point);
        t_details.add(adtrain_temp);

        emptyspace();
        booking();
    }
    static void removetrain(){
        sc.nextLine();
        System.out.println("Enter Train name : ");
        String tn = sc.nextLine();
        for(int i=0;i<t_details.size();i++){
            if(tn.equals(t_details.get(i).get(0))){
                t_details.remove(i);
                train.remove(i);
            }
        }
        viewtrain();
    }
    static void emptyspace(){
        ArrayList<ArrayList<String>> em_temp = new ArrayList<>();
        for(int i=0;i<10;i++){
            ArrayList<String> stop = new ArrayList<String>();
            for(int j = 0;j<5;j++){
                stop.add("0");
            
            }
            em_temp.add(stop);
        }
        train.add(em_temp);
    }
    static void viewtrain(){
        for(int i=0;i<train.size();i++){
            for(int j =0 ;j<10;j++){
                for(int k =0;k<5;k++){
                    System.out.print(train.get(i).get(j).get(k)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        booking();
    }
    void adminpage(){
        System.out.println("Hello Admin..!");
        new_user();
    }
}

class Userrailway{
    static String currentuser;
    static int n,sp,ep;
    private static Scanner sc =  new Scanner(System.in);
    static ArrayList<String>u_npass = new ArrayList<>();
    static ArrayList<ArrayList<String>>cancel = new ArrayList<>();
    static ArrayList<String>my_tic = new ArrayList<>();

    static ArrayList<ArrayList<String>> trainbooked = new ArrayList<>();
    static ArrayList<ArrayList<String>>u_account = new ArrayList<>();
    static void user_npass(){
        sc.nextLine();
        System.out.println("Enter your name : ");
        String uname = sc.nextLine();
        u_npass.add(uname);
        System.out.println("Enter your Password : ");
        String upass = sc.nextLine();
        u_npass.add(upass);
        u_account.add(u_npass);
        currentuser=uname;
        welcomepage();
    }
    static void welcomepage(){
        System.out.println("Book ticket");
        System.out.println("My Ticket");
        System.out.println("Cancel Ticket");
        System.out.println("Waiting List");
        int e =0;
        System.out.println("Your choice : ");
        e=sc.nextInt();
        switch(e){
            case 1:
            System.out.println("\033[H\033[2J");
            booktic();
                break;
            case 2:
            System.out.println("\033[H\033[2J");
            myticket(n,sp,ep);
                break;
            case 3:
            System.out.println("\033[H\033[2J");
                c_ticket();
                break;
        }
    }
    //myticket
    static void myticket(int n, int sp,int ep){
  
        System.out.println("Your Bookings...!");
        System.out.println();
            my_tic.add(Adminrailway.t_details.get(n-1).get(0)+" "+Adminrailway.t_details.get(n-1).get(sp)+" "+Adminrailway.t_details.get(n-1).get(ep));
            System.out.println(my_tic);
          
            welcomepage();
        }
    //cancelticket
    static void c_ticket(){
        System.out.println(cancel);
      
        System.out.print("Cancel ticket : ");
        sc.nextLine();
        String c_tic = sc.nextLine();
        for(int i=0;i<cancel.size();i++){
        if(c_tic.equals(cancel.get(i).get(0))){
            cancel.remove(i);
            System.out.println("Ticket Cancelled..!");
        }
    }
    welcomepage();

    }
    static void booktic(){
        ArrayList<String> tm_c = new ArrayList<>();
        tm_c.clear();
        for(int i =0;i<Adminrailway.t_details.size();i++){
            System.out.println(Adminrailway.t_details.get(i).get(0)+"   "+Adminrailway.t_details.get(i).get(1)+"    "+Adminrailway.t_details.get(i).get(5));
        }   
        System.out.println("Enter your train : ");
        n=sc.nextInt();
        sc.nextLine();
        System.out.println("starting point : ");
        sp = sc.nextInt();
        System.out.println("ending point : ");
        ep = sc.nextInt();
        System.out.println("Booking Successfully..!");
         //myticket(n-1,sp,ep);
         tm_c.add(Adminrailway.t_details.get(n-1).get(0));
        tm_c.add(Adminrailway.t_details.get(n-1).get(sp));
        tm_c.add(Adminrailway.t_details.get(n-1).get(ep));
        cancel.add(tm_c);
        s_eat(sp,ep,n-1);     
                
    }
    static void s_eat(int  sp,int ep,int u){
        ArrayList<String> tem_ar = new ArrayList<>();
        tem_ar.clear();
        // int rec = -1;
        for(int i=0;i<Adminrailway.train.get(u).size();i++){
            int flag=0,flag1=0;
            for(int j=sp-1;j<ep;j++){
                flag++;
                if(Adminrailway.train.get(u).get(i).get(j).equals("0")){
                    flag1++;
                }
            }
            if(flag==flag1){
                for(int j=sp-1;j<ep;j++){
                    Adminrailway.train.get(u).get(i).set(j,currentuser.substring(0,2));
                }
              
                // rec=i;
                tem_ar.add(currentuser.substring(0,2));
                tem_ar.add(Adminrailway.t_details.get(u).get(0));
                tem_ar.add(Integer.toString(sp));
                tem_ar.add(Integer.toString(ep));
                trainbooked.add(tem_ar);
                // return rec;
                break;
            }
            
        }
        System.out.println("Ticket Booked");
        // return rec;
        welcomepage();
        
       }

       //

    void u_ser(){
        System.out.println("Welcome");
        user_npass();
    }
}

