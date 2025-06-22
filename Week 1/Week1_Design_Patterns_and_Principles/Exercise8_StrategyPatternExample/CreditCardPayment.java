public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName){
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
    }

    public void pay(double amount){
        System.out.println("Paid Rs."+amount+" using Credit Card ("+cardHolderName+")");
    }
}
