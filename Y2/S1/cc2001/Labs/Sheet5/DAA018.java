import java.util.*;

public class DAA018 {
  public static void numCoins(int[] coins, int sum) {
    int[] minCoins = new int[sum+1];
    int[] coinsUsed = new int[sum+1];

    // Find minimum numbers of coins needed to complete required sum
    minCoins[0] = 0;
    for (int i = 1; i <= sum; i++) {
      minCoins[i] = 1000000000;

      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i && 1 + minCoins[i - coins[j]] < minCoins[i]) {
          coinsUsed[i] = coins[j];
          minCoins[i] = 1 + minCoins[i - coins[j]];
        }
      }
    }

    // Add every single coin
    int r = sum;
    int index = 0;
    int[] orderedCoins = new int[minCoins[sum]];
    while (r != 0) {
      orderedCoins[index++] = coinsUsed[r];

      r -= coinsUsed[r];
    }
    
    // Sort coins
    Arrays.sort(orderedCoins);

    // Print coins by ascending order
    FastPrint.out.printf("%d: [%d] ", sum, minCoins[sum]);
    for (int i = 0; i < orderedCoins.length; i++) {
      FastPrint.out.printf("%d", orderedCoins[i]);

      if (i < orderedCoins.length-1) {
        FastPrint.out.printf(" ");
      }
    }

    FastPrint.out.printf("\n");
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);
    
    int numCoins = 0;
    int[] coins;
    int questions = 0;
    int questionSum = 0;

    numCoins = in.nextInt();
    coins = new int[numCoins];

    // Read each coin value
    for (int i = 0; i < numCoins; i++) {
      coins[i] = in.nextInt();
    }

    // Read questions and answer them
    questions = in.nextInt();
    for (int i = 0; i < questions; i++) {
      questionSum = in.nextInt();

      numCoins(coins, questionSum);
    }

    FastPrint.out.close();
  }
}
