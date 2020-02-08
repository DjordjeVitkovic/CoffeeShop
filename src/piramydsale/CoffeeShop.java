package piramydsale;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CoffeeShop {

    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    private String name;
    private int pib;
    private int price;
    private int wallet;
    private int recive;
    private boolean running = true;
    private int counterOfcoffes = 0;
    private String adminPass = "123";
    String p1 = "Esspreso";
    String p2 = "Cappucino";
    String p3 = "Latte";
    String p4 = "Mocha";
    String p5 = "V60";
    private ArrayList<String> products;
    private static ArrayList<Staff> staff;

    //Making object of the coffeeSchop, make just one, private constructor
    private CoffeeShop(String name) {

        //initialization filds, and arrays, some filds have his own range
        this.name = name;
        this.pib = r.nextInt(50000);
        String option = null;
        wallet = r.nextInt(800);
        products = new ArrayList<String>();
        staff = new ArrayList<Staff>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);

        //set minimum walue for the wallet
        while (wallet < 300) {
            wallet = r.nextInt(1500);
        }

        System.out.println("Wellcome to the CoffeShop " + name.toUpperCase() + " pib: " + pib);

        GAME:
        while (running || option.equals("6")) {

            System.out.println("What would want do do?");
            System.out.println("\t1.Buy coffee?\n\t2.Login admin?");
            option = sc.nextLine();

            while (!(option.equals("1")) && !(option.equals("2"))) {
                System.out.println("Invalid input!");
                option = sc.nextLine();
            }

            if (option.equals("1")) {

                while (wallet > 0) {

                    System.out.println("What you want to buy? ");
                    System.out.println("\t1.Esspreso\n\t2.Cappucino\n\t3.Latte\n\t4.Mocha\n\t5.V60\n\t6.Recive");
                    System.out.println("You have: " + wallet + " RSD in your wallet.");

                    option = sc.nextLine();

                    if (option.equals("1")) {

                        price = r.nextInt(200);
                        System.out.println("The price of your esspreso is: " + this.price + "RSD");
                        wallet -= this.price;
                        recive += this.price;
                        counterOfcoffes++;

                        if (wallet < 1) {
                            wallet += this.price;
                            recive -= this.price;
                            System.out.println("You don have money for  this esspresso.");
                            break;
                        }

                    } else if (option.equals("2")) {

                        price = r.nextInt(220);
                        System.out.println("The price of your cappucino is: " + this.price + "RSD");
                        wallet -= this.price;
                        recive += this.price;
                        counterOfcoffes++;
                        System.out.println("You have:" + wallet + " RSD more!");
                        if (wallet < 1) {
                            wallet += this.price;
                            recive -= this.price;
                            System.out.println("You don have money for  this cappucino.");
                            break;
                        }

                    } else if (option.equals("3")) {

                        price = r.nextInt(250);
                        System.out.println("The price of your latte is: " + this.price + "RSD");
                        wallet -= this.price;
                        recive += this.price;
                        counterOfcoffes++;
                        System.out.println("You have:" + wallet + " RSD more!");
                        if (wallet < 1) {
                            wallet += this.price;
                            recive -= this.price;
                            System.out.println("You don have money for  this latte.");
                            break;
                        }

                    } else if (option.equals("4")) {

                        price = r.nextInt(300);
                        System.out.println("The price of your mocha is: " + this.price + "RSD");
                        wallet -= this.price;
                        recive += this.price;
                        counterOfcoffes++;
                        System.out.println("You have:" + wallet + " RSD more!");
                        if (wallet < 1) {
                            wallet += this.price;
                            recive -= this.price;
                            System.out.println("You don have money for  this mocha.");
                            break;
                        }

                    } else if (option.equals("5")) {

                        price = r.nextInt(500);
                        System.out.println("The price of your V60 is: " + this.price + "RSD");
                        wallet -= this.price;
                        recive += this.price;
                        counterOfcoffes++;
                        System.out.println("You have:" + wallet + " RSD more!");

                        if (wallet < 1) {
                            wallet += this.price;
                            recive -= this.price;
                            System.out.println("You don have money for  this V60.");
                            break;
                        }

                    } else if (option.equals("6")) {
                        System.out.println("You leaving the CoffeeShop.");
                        break;

                    } else {
                        System.out.println("Invalid option!!");

                    }

                }
                if (option.equals("6")) {
                    System.out.println("Your resive is: " + recive);
                    break;

                }

                if (wallet < 1) {
                    System.out.println("You are spend all money you cant buy more!");
                    System.out.println("Your recive is:  " + recive + " and you buy " + counterOfcoffes + " coffes.");
                    System.out.println("U have: " + wallet + " RSD left");
                    break;
                }
                System.out.println("You have: " + wallet + " RSD more.");
                System.out.println("What would you want to do next: \n\t1.Continue shopping.\n\t2.Take recive and leave.");

                option = sc.nextLine();

                while (!option.equals("1") && !option.equals("2")) {
                    System.out.println("Invalid command!");
                    option = sc.nextLine();
                }

                if (option.equals("1")) {
                    System.out.println("What is your next product?");

                } else if (option.equals("2")) {
                    System.out.println("You leaving the CoffeeShop.");
                    System.out.println("Your recive is: " + recive);
                    break;
                }

                //Admin department
            } else if (option.equals("2")) {

                while (!option.equals("exit")) {

                    System.out.println("This is only for the admin! Please confirm your walidation with password");
                    String s = sc.nextLine();
                    //Checking password
                    if (s.equals(adminPass)) {
                        System.out.println("Wellcome Admin! What would you like to do?");
                        System.out.println("\t1. Hire a man?\n\t2. Fair?\n\t3.Show all emplyees");
                        s = sc.nextLine();
                        if (s.equals("1")) {
                            //Method for hire
                            hire();

                        } else if (s.equals("2")) {
                            //Fire
                            this.fire();
                        } else if (s.equals("3")) {
                            //Show
                            showAllEmploy();
                        } else {
                            //Another option
                            System.out.println("Invalid option!");
                            break;
                        }
                        //Incorect passowrd
                    } else {                         
                        System.out.println("You are not the admin plese back!");

                    }

                }
            }

        }
        System.out.println("Thank you for buying our coffee, see you later!!");

    }

    //Method for creating object, calling constructor
    private static CoffeeShop instance;

    public static CoffeeShop getInCoffeShop(String name) {
        if (instance == null) {
            instance = new CoffeeShop(name);
        }
        return instance;
    }

    //Method for employment, they call method from Staff class, and inserts objects in array
    public ArrayList<Staff> hire() {

        staff.add(Staff.hireMan());

        return staff;

    }

    //Quitting, using a name of staff
    public void fire() {

        System.out.println("Enter the name of workpeople:");
        String i = sc.nextLine();

        Staff forRemove = null;

        //Pass through staff array, and search for the required employee, and remove them form array
        for (int j = 0; j < staff.size(); j++) {

            if (staff.get(j).getEmployedName().equals(i)) {
                forRemove = staff.get(j);
                break;

            }
        }
        if (forRemove != null) {

            staff.remove(forRemove);

        } else {

            System.out.println("Ne postoji !");
        }

    }
    //Method for show all pepole
    public static void showAllEmploy() {

        System.out.println(staff);
    }

}
