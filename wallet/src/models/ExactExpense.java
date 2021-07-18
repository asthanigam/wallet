package models;

import java.util.List;

public class ExactExpense {
        private String id;
        private User paidby;
        private double amt;
        private List<Split> splits;
        public ExactExpense(double amt, User user, List<Split> splits)
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
        public List<Split> getSplits() {
            return splits;
        }
        public void setSplits(List<Split> splits) {
            this.splits = splits;
        }
        
    }
