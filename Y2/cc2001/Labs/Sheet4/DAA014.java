import java.util.*;

class Order implements Comparable<Order> {
  private int number;
  private int duration;
  private int fine;
  private double rating;

  Order(int n, int d, int f) {
    number = n;
    duration = d;
    fine = f;

    rating = (double) fine / (double) duration;
  }
  
  public int getNumber () {
    return number;
  }

  public int getDuration() {
    return duration;
  }

  public int getFine() {
    return fine;
  }

  @Override
  public int compareTo(Order o) {
    return Double.compare(o.rating, rating);
  }

  public String toString() {
    return "----------\nDuration: " + duration + "\nFine: " + fine + "\nRating: " + rating + "\n----------";
  }
}

public class DAA014 {
  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int ordersNum = 0;
    Order[] orders;

    ordersNum = in.nextInt();
    orders = new Order[ordersNum];

    for (int i = 0; i < ordersNum; i++) {
      orders[i] = new Order(i+1, in.nextInt(), in.nextInt());
    }

    // Re-order orders by rating and its fine value alternatively
    Arrays.sort(orders);

    for (int i = 0; i < ordersNum; i++) {
      FastPrint.out.printf("%d", orders[i].getNumber());

      if (i < ordersNum-1) FastPrint.out.printf(" ");
    }
    FastPrint.out.printf("\n");

    FastPrint.out.close();
  }
}