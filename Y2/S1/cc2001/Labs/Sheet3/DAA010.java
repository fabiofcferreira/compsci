import java.util.*;

public class DAA010 {
  public static int combinations(int n) {
    return (n * (n-1))/2;
  }

  public static int[] nearestBSearch(int[] arr, int key) {
    int middle = arr.length / 2;
    int low = 0;
    int high = arr.length-1;

    while (low < high) {
      middle = low + ((high - low) / 2);
      
      if (arr[middle] >= key) {
        high = middle;
      } else {
        low = middle + 1;
      }
    }

    if (low - 1 >= 0) {
      if (Math.abs((arr[low-1] - key)) < Math.abs((arr[low] - key))) return new int[] { arr[low - 1] };
      if (Math.abs((arr[low-1] - key)) == Math.abs((arr[low] - key))) return new int[] { arr[low - 1], arr[low] };
    }

    return new int[] { arr[low] };
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int n;
    int[] set;
    int[] sums;
    int q = 0;
    int qSum = 0;

    n = in.nextInt();
    set = new int[n];
    sums = new int[combinations(n)];

    // Read set of numbers
    for (int i = 0; i < n; i++) { 
      set[i] = in.nextInt();
    }

    // Calculate all possible sums
    int sumIndex = 0;
    for (int i = 0; i < n; i++) {
      for (int j =  i + 1; j < n; j++) {
        sums[sumIndex] = set[i] + set[j];

        sumIndex++;
      }
    }

    // Sort sums
    Arrays.sort(sums);

    // Read number of questions
    q = in.nextInt();

    // Read every question and answer it
    for (int i = 0; i < q; i++) {
      qSum = in.nextInt();

      int[] answers = nearestBSearch(sums, qSum);
      
      for (int a = 0; a < answers.length; a++) {
        if (answers[a] >= 0) {
          FastPrint.out.printf("%d", answers[a]);

          if (a < answers.length-1 && answers[a+1] >= 0) {
            FastPrint.out.printf(" ");
          }
        }
      }

      FastPrint.out.printf("\n");
    }

    FastPrint.out.close();
  }
}
