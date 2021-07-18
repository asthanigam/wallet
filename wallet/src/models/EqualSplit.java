package models;

public class EqualSplit {
private User user;
private double amt;
public EqualSplit(User user)
{
    this.setUser(user);
}
public User getUser() {
    return user;
}
public void setUser(User user) {
    this.user = user;
}
public double getAmt() {
    return amt;
}
public void setAmt(double amt) {
    this.amt = amt;
}

}
