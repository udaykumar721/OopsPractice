import java.util.Scanner;

public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio stockPortfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numStocks = scanner.nextInt();

        for (int i = 1; i <= numStocks; i++) {
            System.out.println("\nEnter details for Stock #" + i);
            System.out.print("Stock Name: ");
            String stockName = scanner.next();
            System.out.print("Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Share Price: ");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
        }

        stockPortfolio.printStockReport();
    }
}