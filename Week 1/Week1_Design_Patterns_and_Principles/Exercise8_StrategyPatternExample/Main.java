public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "Samrethi");
        context.setPaymentStrategy(creditCard);
        context.payAmount(1500.0);

        PaymentStrategy paypal = new PayPalPayment("samrethi@example.com");
        context.setPaymentStrategy(paypal);
        context.payAmount(2750.0);
    }
}
