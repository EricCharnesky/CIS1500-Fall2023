public class Ticket {
    int ticketNumber;
    String purchaserName;
    int verificationCode;

    public Ticket(int ticketNumber, String purchaserName, int verificationCode) {
        this.ticketNumber = ticketNumber;
        this.purchaserName = purchaserName;
        this.verificationCode = verificationCode;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public void setVerificationCode(int verificationCode) {
        this.verificationCode = verificationCode;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public int getVerificationCode() {
        return verificationCode;
    }

    public String getStringForFile(){
        return ticketNumber + "|" + purchaserName + "|" + verificationCode;
    }
}
