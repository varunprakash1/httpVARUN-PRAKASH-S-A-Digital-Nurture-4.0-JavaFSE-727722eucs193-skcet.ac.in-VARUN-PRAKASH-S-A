public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileApp1 = new MobileApp("Investor A");
        Observer webApp1 = new WebApp("Trader B");

        market.registerObserver(mobileApp1);
        market.registerObserver(webApp1);

        System.out.println("---- Price Update 1 ----");
        market.setStockData("TATA", 2430.75);

        System.out.println("---- Price Update 2 ----");
        market.setStockData("INFY", 1560.50);

        market.removeObserver(mobileApp1);

        System.out.println("---- Price Update 3 (only WebApp notified) ----");
        market.setStockData("RELIANCE", 2843.10);
    }
}
