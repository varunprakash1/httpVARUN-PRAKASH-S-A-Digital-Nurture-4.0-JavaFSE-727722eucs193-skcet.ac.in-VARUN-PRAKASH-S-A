public class StripePaymentAdapter implements PaymentProcessor{
    private StripePayment stripePayment;

    public StripePaymentAdapter(StripePayment stripePayment){
        this.stripePayment = stripePayment;
    }

    public void processPayment(double amount){
        stripePayment.makePayment(amount);
    }
}
