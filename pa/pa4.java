

import java.util.ArrayList;
import java.util.Arrays;

public class pa4 {

    // A method, calculateAveragePrice, that takes the array of stock prices as input and returns the average price of the stocks.
    public static void calculateAveragePrice(String[] stockArray) {
        float sum = 0;
        int lenght = stockArray.length;
        for (String stock : stockArray) {
            sum = sum + Float.parseFloat(stock);
        }
        System.out.println("Average stock price is: " + sum / lenght);
    }

    // A method, findMaximumPrice, that takes the array of stock prices as input and returns the maximum price among all the stocks. 
    public static void findMaximumPrice(String[] stockArray) {
        String max = "0";
        for (String stock : stockArray) {
            if (Float.parseFloat(stock) > Float.parseFloat(max)) {
                max = stock;
            }
        }
        System.out.println("MAximum stock price is: " + max);
    }

    // A  method, countOccurrences, that takes the array of stock prices and a target price as input and returns the number of times the target price occurs in the array. 
    public static void countOccurrences(String[] stockArray, String targetPrice) {
        int count = 0;
        for (String stock : stockArray) {
            if (targetPrice.equals(stock)) {
                count++;
            }
        }
        System.out.println(targetPrice + " occured " + count + " time(s)");
    }

    // A method, calculateAveragePrice, that takes the ArrayList of stock prices as input and returns the average price of the stocks.
    public static void calculateAveragePrice(ArrayList<String> stockArrayList) {
        float sum = 0;
        int lenght = stockArrayList.size();
        for (String stock : stockArrayList) {
            sum = sum + Float.parseFloat(stock);
        }
        System.out.println("Average stock price is: " + sum / lenght);
    }

    // a method, findMaximumPrice, that takes the ArrayList of stock prices as input and returns the maximum price among all the stocks. 
    public static void findMaximumPrice(ArrayList<String> stockArrayList) {
        String max = "0";
        for (String stock : stockArrayList) {
            if (Float.parseFloat(stock) > Float.parseFloat(max)) {
                max = stock;
            }
        }
        System.out.println("Maximum stock price is: " + max);
    }

    // A method, countOccurrences, that takes the ArrayList of stock prices and a target price as input and returns the number of times the target price occurs in the array. 
    public static void countOccurrences(ArrayList<String> stockArrayList, String targetPrice) {
        int count = 0;
        for (String stock : stockArrayList) {
            if (targetPrice.equals(stock)) {
                count++;
            }
        }
        System.out.println(targetPrice + " occured " + count + " time(s)");
    }

    // A method, computeCumulativeSum, that takes the ArrayList of stock prices as input and returns a new ArrayList containing the cumulative sum of prices at each position.
    public static ArrayList<String> calculateCumulativeSum(ArrayList<String> stockArrayList) {
        float sum = 0;
        ArrayList<String> cuList = new ArrayList<>();
        for (String stock : stockArrayList) {
            sum = sum + Float.parseFloat(stock);
            cuList.add(String.valueOf(sum));
        }

        return cuList;

    }

    public static void main(String[] args) {
        // An array of stocks for the range of ten days
        String[] stockArray = { "50.20", "51.15", "52.00", "51.75", "50.90", "51.40", "52.25", "52.50", "53.10","54.00" };
        ArrayList<String> stockArrayList = new ArrayList<>();
        stockArrayList.addAll(Arrays.asList("50.20", "51.15", "52.00", "51.75", "50.90", "51.40", "52.25", "52.50", "53.10","54.00"));

        System.out.println("From the Array");
        calculateAveragePrice(stockArray);
        findMaximumPrice(stockArray);
        countOccurrences(stockArray, "50.20");
        System.out.println();

        System.out.println("From the ArrayList");
        calculateAveragePrice(stockArrayList);
        findMaximumPrice(stockArrayList);
        countOccurrences(stockArrayList, "51.75");
        System.out.println();

        var cumulative = calculateCumulativeSum(stockArrayList);
        for (int index = 0; index < cumulative.size(); index++) {
            System.out.println("Cumulative sum at position " + (index + 1) + " is: " + cumulative.get(index));

        }

    }
}


