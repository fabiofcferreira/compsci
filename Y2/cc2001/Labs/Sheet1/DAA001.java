import java.util.Scanner;

class DAA001 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int size = 0;
    int number;
    int counter = 0;

    size = in.nextInt();

    for (int i = 0; i < size; i++) {
      number = in.nextInt();

      if (number == 42) counter++;
    }

    System.out.println(counter);
  }
}