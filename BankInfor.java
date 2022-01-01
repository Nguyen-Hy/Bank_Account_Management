package baiTapPremium.L38.b1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BankInfor {

//    private class BankOfTime{
//        private String releaseDate; //phat hanh
//        private String expirationDate; //het han
//    }

    private static int nextId = 100001;
    private String id;
    private String acountNumber;
    private String acountName;
    private String acountType;
    private double surplus;
    private String bankName;
    private Date startDate; //phat hanh
    private Date endDate; //het han


    public BankInfor() {
        setId(null);
        acountNumber = "";
        acountName = "";
        acountType = "";
        surplus = 0.0;
        bankName = "ABC_BANK";
        startDate = new Date();
        endDate = new Date();
    }

    public BankInfor(String id, String acountNumber, String acountName,
                     String acountType, double surplus,
                     String bankName, Date startDate, Date endDate) {
        this();
        this.setId(id);
        this.acountNumber = acountNumber;
        this.acountName = acountName;
        this.acountType = acountType;
        this.surplus = surplus;
        this.getBankName();
        this.startDate = startDate;
        this.endDate = endDate;

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        if( id != null ){
            this.id = id;
        }else{
            this.id = "WAB" + nextId;
            nextId ++;
        }
    }

    public String getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(String acountNumber) {
        this.acountNumber = acountNumber;
    }

    public String getAcountName() {
        return acountName.toUpperCase();
    }

    public void setAcountName(String acountName) {
        this.acountName = acountName;
    }

    public String getAcountType() {
        return acountType;
    }

    public void setAcountType(String acountType) {
        this.acountType = acountType;
    }

    public double getSurplus() {
        return surplus;
    }

    public void setSurplus(double surplus) {
       this.surplus = surplus;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName ) {
        this.bankName = bankName;
    }


    public static void setNextId(int nextId) {
        BankInfor.nextId = nextId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean addMoneyToAcount(double money){
       if( money > 0 ){
           surplus += money;
           return true;
       }else{
           return false;
       }
//       return surplus;
    }

    public boolean removeMoneyToAccount( double money ){
        if( surplus > money && money > 0  ){
            surplus -= money;
            return true;
        }else{
            return false;
        }
    }

}
