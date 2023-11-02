package fileio2;

public class Transaction {
    private String accountName;
    private double amount;
    private String date;

    public Transaction(String accountName, double amount, String date) {
        this.accountName = accountName;
        this.amount = amount;
        this.date = date;
    }

    public String getStringForFile(){
        return accountName + "|" + amount + "|" + date;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }


}
