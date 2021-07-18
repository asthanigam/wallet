package services;

import java.util.List;

import models.Expense;
import models.EqualSplit;
import models.ExactExpense;
import models.Split;
import models.User;

public class ExpenseService {
    public static Expense createEqualExpense(double amt, User user, List<EqualSplit> equalSplits) {
        int totalSplits = equalSplits.size();
        double splitAmt = (double) Math.round(amt * 100 / totalSplits) / 100;
        for (EqualSplit spli : equalSplits) {
            spli.setAmt(splitAmt);
        }
        return new Expense(amt, user, equalSplits);

    }

    public static ExactExpense createExactExpense(double amt, User user, List<Split> splits) {
        return new ExactExpense(amt, user, splits);
    }
}
