package models;

public class Split {
    private User   user;
    private double amt;

    public Split(User user, double d) {
        this.setUser(user);
        this.setAmt(d);
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double splitAmt) {
        this.amt = splitAmt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
