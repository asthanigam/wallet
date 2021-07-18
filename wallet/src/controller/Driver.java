package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.EqualSplit;
import models.Split;
import models.User;
import services.ExpenseManager;

public class Driver {

    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        expenseManager.addUser(new User("User1", "u1", "567"));
        expenseManager.addUser(new User("User2", "u2", "123"));
        expenseManager.addUser(new User("User3", "u3", "907"));
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter 1 to add expense and 2 to show bills");
        if (ob.nextInt() == 1) {
            List<Split> splits = new ArrayList<>();
            List<EqualSplit> equalSplits = new ArrayList<>();
            System.out.print("Enter user id");
            String paidBy = ob.next();
            System.out.print("Enter amt");
            double amt = ob.nextDouble();
            System.out.print("no. of users");
            int noOfUsers = ob.nextInt();
            System.out.println("Press 1 for equal split and press 2 for exact expense");
            int  option = ob.nextInt();
            if (option == 2) {
                for (int i = 0; i < noOfUsers; i++) {
                    System.out.println("user id and amt");
                    splits.add(new Split(expenseManager.getUserMap().get(ob.next()), ob.nextDouble()));
                }
                expenseManager.addExpense(paidBy, amt, splits);
            }
            else if (option == 1) {
                System.out.println("Equal Split");
                for (int i = 0; i < noOfUsers; i++) {
                    System.out.println("user id");
                    equalSplits.add(new EqualSplit(expenseManager.getUserMap().get(ob.next())));
                }
                expenseManager.addEqualExpense(paidBy, amt, equalSplits);
            }
            else {
                System.out.println("Wrong option");
            }
        }
        else if (ob.nextInt() == 2) {
            expenseManager.showBiils();
        }
        else {
            System.out.println("Wrong option");
        }
    }

}
