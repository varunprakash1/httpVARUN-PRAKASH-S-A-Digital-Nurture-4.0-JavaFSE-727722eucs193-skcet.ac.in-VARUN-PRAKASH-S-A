public class Main {
    public static void main(String[] args) {
        StripePayment stripe = new StripePayment();
        PaymentProcessor stripeAdapter = new StripePaymentAdapter(stripe);
        stripeAdapter.processPayment(100.0);

        System.out.println();

        PaypalPayment paypal = new PaypalPayment();
        PaymentProcessor paypalAdapter = new PaypalPaymentAdapter(paypal);
        paypalAdapter.processPayment(150.0);
    }
}
