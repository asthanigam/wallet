package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.*;

public class ExpenseManager {
    private List<Expense>                    expenses;
    private List<ExactExpense>               exactExpenses;
    private Map<String, User>                userMap;
    private Map<String, Map<String, Double>> balanceSheet;

    public ExpenseManager() {
        exactExpenses = new ArrayList<>();
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<String, Double>());
    }

    public void addEqualExpense(String paidBy, double amt, List<EqualSplit> equalSplits) {
        Expense expense = ExpenseService.createEqualExpense(amt, userMap.get(paidBy), equalSplits);
        expenses.add(expense);
        for (EqualSplit split : expense.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmt());
            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmt());
            showBiils();
        }

    }

    public void addExpense(String paidBy, double amt, List<Split> splits) {
        ExactExpense exactExpense = ExpenseService.createExactExpense(amt, userMap.get(paidBy), splits);
        exactExpenses.add(exactExpense);
        for (Split split : exactExpense.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmt());
            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmt());
            showBiils();
        }

    }

    public void showBiils() {
        for (Map.Entry<String, Map<String, Double>> allBalaces : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalaces.getValue().entrySet()) {
                printBalance(allBalaces.getKey(), userBalance.getKey(), userBalance.getValue());
            }
        }
    }

    private void printBalance(String user1, String user2, Double value) {

        String userName1 = userMap.get(user1).getName();
        String userName2 = userMap.get(user2).getName();
        if (value < 0) {
            System.out.println(userName1 + "owes" + userName2 + "amount" + Math.abs(value));
        }
        else if (value > 0) {
            System.out.println(userName1 + " is owed" + userName2 + "amount" + Math.abs(value));
        }
        else {
            System.out.println(userName1 + "has baances clear with" + userName2);
        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Map<String, Double>> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public List<ExactExpense> getExactExpenses() {
        return exactExpenses;
    }

    public void setExactExpenses(List<ExactExpense> exactExpenses) {
        this.exactExpenses = exactExpenses;
    }

}
