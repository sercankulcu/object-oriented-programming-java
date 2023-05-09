package Array;
/*
 * Here is a Java program that calculates the maximum profit that can be made by buying and 
 * selling a stock:
 * 
 * This program works by iterating through the prices array and keeping track of the minimum 
 * price seen so far. At each step, it calculates the potential profit by subtracting the 
 * current price from the minimum price, and updates the maximum profit if the result is higher. 
 * At the end, it returns the maximum profit.
 * */

public class BestTimeToBuyAndSellStock {
  public static int maxProfit(int[] prices) {
    // Edge case: return 0 if the array has fewer than 2 elements
    if (prices.length < 2) {
      return 0;
    }

    // Initialize variables to track the minimum price and maximum profit
    int minPrice = prices[0];
    int maxProfit = 0;

    // Iterate through the prices array, starting at the second element
    for (int i = 1; i < prices.length; i++) {
      // Update the minimum price if we find a lower one
      minPrice = Math.min(minPrice, prices[i]);
      // Update the maximum profit if we find a higher one
      maxProfit = Math.max(maxProfit, prices[i] - minPrice);
    }

    return maxProfit;
  }
  
  public static void main(String[] args)
  {
  	int[] prices = {7, 1, 5, 3, 6, 4};
  	int maxProfit = BestTimeToBuyAndSellStock.maxProfit(prices);
  	System.out.println("Max profit: " + maxProfit);
  }
}
