package app;

import java.util.*;

public class Atm {
  private static Scanner sc;
  // static int amount;
  static int balance = 0;
  static int amount1[] = { 100, 200, 500, 2000 };
  static int amount[] = { 0, 0, 0, 0 };
  static int[] storeamount;
  static int userinput;
  static int bal, n = 0;
  static int abc, rem;
  static int pin, trans;
  static String name[] = { "Mani", "Abith" };
  static int n1 = 0, i = 0;
  static int count = 0, tot = 0;
  static int ar[] = new int[10];
  static int oldpass[] = { 9751, 822069 };

  // homepage
  static void Homepage() {
    int n = 0;
    System.out.println("ATM machine");
    System.out.println("1. Admin");
    System.out.println("2. User Login");
    System.out.println("3. Exit");
    System.out.print("Enter your choice : ");
    n = sc.nextInt();

    switch (n) {
      case 1:
        System.out.print("Enter your Login id :");
        String login = sc.next();
        System.out.print("Enter your Password : ");
        int pass = sc.nextInt();
        if (login.equals("admin") && pass == 12345) {
          System.out.println("\033[H\033[2J");
          System.out.println("logged successfully");
          // System.out.println(" ");
          Adminpage();
        } else {
          System.out.println("Invalid id");
        }
        break;

      case 2:
        System.out.println("\033[H\033[2J");
        loginid();

        break;
      case 3:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid");
        break;

    }

  }

  // adminpage
  static void Adminpage() {
    System.out.println("\033[H\033[2J");
    int sw = 0;
    System.out.println("    logged successfully..!");
    System.out.println("1.Load amount");
    System.out.println("2.Show amount");
    System.out.println("3.Exit");
    System.out.println("4.Back");
    System.out.print("Enter your choice : ");
    sw = sc.nextInt();

    switch (sw) {
      case 1:
        addAmount();
        System.out.println("\033[H\033[2J");
        break;
      case 2:
        System.out.println("\033[h\033[2J");
        showAmount();

        break;

      case 3:
        System.out.println("\033[H\033[2J");
        System.exit(0);
        break;
      case 4:
        System.out.println("\033[H\033[2J");
        Homepage();
    }

  }

  // login id
  static void loginid() {
    System.out.print("Please enter your pin :");
    pin = sc.nextInt();
    sc.nextLine();
    System.out.print("Please enter your name :");

    String input = sc.next();
    if (pin == oldpass[0] && input.equals(name[0])) {
      bal = 10000;
      Usermodule(0);
    } else if (pin == oldpass[1] && input.equals(name[1])) {
      bal = 20000;
      Usermodule(1);
    } else {
      System.out.println("Invalid");
    }

  }

  // usermodule
  static void Usermodule(int i) {
    System.out.println("1.Withdraw");
    System.out.println("2.Show balance");
    System.out.println("3.Money Transaction");
    System.out.println("4.Exit");
    System.out.println("5.Back");
    System.out.println("6.Pinchange");

    System.out.print("enter your choice : ");
    n1 = sc.nextInt();

    switch (n1) {
      case 1:
        withDraw(i);
        break;
      case 2:
        showBalance(i);
        break;
      case 3:
        moneyTransaction(i);
        break;
      case 4:
        System.exit(0);
        break;
      case 5:
        System.out.println("\033[H\033[2J");
        Homepage();
      case 6:
        changePin(i);

    }
  }

  // change pin
  static void changePin(int i) {
    System.out.println("Enter old password : ");
    int pass = sc.nextInt();
    if (oldpass[i] == pass) {
      System.out.print("Enter New Password : ");
      int newpass = sc.nextInt();
      oldpass[i] = newpass;
      Homepage();

    } else {
      System.out.println("old & new passwords are same");
    }
  }

  // addAmount
  static void addAmount() {
    for (int i = 0; i < 4; i++) {

      System.out.print("Enter amount " + amount1[i] + "=");
      amount[i] += sc.nextInt();
      abc += amount[i] * amount1[i];
    }
    System.out.println("Amount added successfully..!");
    System.out.println();
    System.out.println("Press Enter to continue...!");
    sc.nextLine();
    String s = sc.nextLine();
    if (s.equals("")) {
      Adminpage();
    }
  }

  // showAmount
  static void showAmount() {
    System.out.println("\033[H\033[2J");
    for (int i = 0; i < 4; i++) {
      System.out.println("Enter amount : " + amount1[i] + "=" + amount[i]);

    }
    System.out.println(abc);

    System.out.println("Press enter to back..!");
    sc.nextLine();
    String s1 = sc.nextLine();
    if (s1.equals("")) {
      Adminpage();
    }

  }

  // remainder
  static void remainder(int userinput) {
    System.out.println("\033[H\033[2J");

    if (userinput % 100 == 0) {

      rem = userinput / 2000;
      userinput = userinput % 2000;// 500
      System.out.println("2000 " + rem);
      amount[3] -= rem;
      rem = userinput / 500;
      System.out.println("500 " + rem);
      amount[2] -= rem;
      userinput = userinput % 500;

      rem = userinput / 200;
      System.out.println("200 " + rem);
      amount[1] -= rem;
      rem = userinput / 100;
      System.out.println("100 " + rem);
      userinput = userinput % 100;
      amount[0] -= rem;
    } else {
      System.out.println("Invalid input");
    }
  }

  // withdraw
  static void withDraw(int i) {
    System.out.println("\033[H\033[2J");
    System.out.println("Withdraw amount : ");
    moneyTransaction(userinput);
    userinput = sc.nextInt();
    if (abc == 0) {
      System.out.println("Insufficient balance");
      Usermodule(i);
    } else if (abc >= userinput) {
      ifcondition(i);
    } else {
      System.out.println("Amount Exceeded..!");

      Usermodule(i);
    }

  }

  // withdra ifcondition
  static void ifcondition(int i) {

    if (userinput % 100 == 0) {
      bal -= userinput;
      abc -= userinput;
      System.out.println("Take your cash...!");
      System.out.println("");
      System.out.println("Press enter to back..!");
      sc.nextLine();
      String back = sc.nextLine();
      if (back.equals("")) {
        Usermodule(i);
      }
    } else {
      System.out.println("Invalid amount");
    }

  }

  // showbalance
  static void showBalance(int i) {
    System.out.println("\033[H\033[2J");
    System.out.println("Your current balance : " + bal);
    remainder(userinput);
    System.out.println("Press enter to back..!");
    sc.nextLine();
    String back = sc.nextLine();
    if (back.equals("")) {
      Usermodule(i);

    }
  }

  // moneytransaction
  static void moneyTransaction(int n) {
    ar[i] = n;
    i++;
  }

  static void ministatement() {
    for (int j = i - 1; j > i - 6; j--) {
      System.out.println("Amount : " + ar[j]);
    }
  }

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Homepage();
  }
}