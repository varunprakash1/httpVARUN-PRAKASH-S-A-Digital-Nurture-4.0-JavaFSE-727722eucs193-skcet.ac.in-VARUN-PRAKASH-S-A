public class Main {
    public static void main(String[] args) {
        Notifier emaNotifier = new EmailNotifier();

        Notifier smsDecorator = new SMSNotifierDecorator(emaNotifier);

        Notifier fullNotifier = new SlackNotifierDecorator(smsDecorator);
        
        fullNotifier.send("System maintenance scheduled at 10 PM.");
    }
}
