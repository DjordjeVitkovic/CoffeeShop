package piramydsale;

import java.util.Random;
import java.util.Scanner;

public class Staff {

    private String employedName;
    private int employeID;
    private String function;
    private Staff s = null;

    public Staff() {

        Random r = new Random();

        this.employeID = r.nextInt(10000);

        Scanner sc = new Scanner(System.in);

        System.out.println("Input info of new employe :");
        System.out.println("Name: ");

        this.employedName = sc.nextLine();

        System.out.println("Function: ");
        this.function = sc.nextLine();

        System.out.println("Employe ID is: " + this.employeID);

    }

    public String getEmployedName() {
        return employedName;
    }

    public void setEmployedName(String employedName) {
        this.employedName = employedName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public static Staff hireMan() {

        return new Staff();

    }

    @Override
    public String toString() {
        return employedName;
    }

}
