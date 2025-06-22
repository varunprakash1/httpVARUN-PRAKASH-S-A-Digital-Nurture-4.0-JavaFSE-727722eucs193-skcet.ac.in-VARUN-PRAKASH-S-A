public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp: " + name + " - Stock: " + stockName + " Price: " + stockPrice);
    }
}
