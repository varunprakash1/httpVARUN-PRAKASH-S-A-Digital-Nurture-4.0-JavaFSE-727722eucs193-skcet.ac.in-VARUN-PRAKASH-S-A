public class PaypalPaymentAdapter implements PaymentProcessor{
    private PaypalPayment paypalPayment;

    public PaypalPaymentAdapter(PaypalPayment paypalPayment){
        this.paypalPayment = paypalPayment;
    }

    public void processPayment(double amount){
        paypalPayment.sendPayment(amount);
    }
}
