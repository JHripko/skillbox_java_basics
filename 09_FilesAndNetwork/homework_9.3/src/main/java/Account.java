import java.util.Date;

public class Account {

    private String accountType;
    private String accountNumber;
    private String currency;
    private Date date;
    private String reference;
    private String operation;
    private Double coming;
    private Double expense;

    public Account(String accountType, String accountNumber, String currency,
                   Date date, String reference, String operation, Double coming, Double expense){
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.date = date;
        this.reference = reference;
        this.operation = operation;
        this.coming = coming;
        this.expense = expense;
    }


    public String getAccountType() {
        return accountType;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getDate() {
        return date;
    }

    public String getReference() {
        return reference;
    }

    public String getOperation() {
        return operation;
    }

    public Double getComing() {
        return coming;
    }

    public Double getExpense() {
        return expense;
    }
}
