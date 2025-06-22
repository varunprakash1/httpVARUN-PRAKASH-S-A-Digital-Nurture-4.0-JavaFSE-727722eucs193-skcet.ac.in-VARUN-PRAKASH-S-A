public class FinanceForecast{
    public static double calculateFutureValue(double presentValue, double rate, int years){
        if(years == 0)
            return presentValue;
        return calculateFutureValue(presentValue, rate, years-1)*(1+rate);
    }

    public static double futureValueMemo(double presentValue, double rate, int years, double[] memo){
        if(years == 0)
            return presentValue;
        if(memo[years] != 0)
            return memo[years];
        memo[years] = futureValueMemo(presentValue, rate, years-1, memo)*(1+rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.05;
        int years = 5;

        System.out.println("Future Value using Recursion: " + calculateFutureValue(presentValue, growthRate, years));
        System.out.println();
        double[] memo = new double[years + 1];
        System.out.println("Future Value using memoization: " + futureValueMemo(presentValue, growthRate, years, memo));    
    }
}