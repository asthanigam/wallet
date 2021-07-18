package models;

import java.util.List;

public class Expense {
    private String id;
    private User paidby;
    private double amt;
    private List<EqualSplit> splits;
    public Expense(double amt, User user, List<EqualSplit> splits)
    {
        this.amt = amt;
        this.paidby = user;
        this.splits = splits;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public User getPaidby() {
        return paidby;
    }
    public void setPaidby(User paidby) {
        this.paidby = paidby;
    }
    public double getAmt() {
        return amt;
    }
    public void setAmt(double amt) {
        this.amt = amt;
    }
    public List<EqualSplit> getSplits() {
        return splits;
    }
    public void setSplits(List<EqualSplit> splits) {
        this.splits = splits;
    }
    
}
