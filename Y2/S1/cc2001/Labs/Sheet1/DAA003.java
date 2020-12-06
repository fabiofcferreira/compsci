import java.util.Scanner;

public class DAA003 {
  // Helper functions
  public static int charValue(Character ch) {
    if (Character.isDigit(ch)) {
      return Character.getNumericValue(ch);
    } else {
      int d = ch - 'A';

      if (d >= 25) d -= 1;
      if (d >= 23) d -= 1;
      if (d >= 11) d -= 1;

      return d;
    }
  }

  // Plate functions
  public static int getPlateGeneration(String plate) {
    // 1st generation
    if (Character.isAlphabetic(plate.charAt(0)) && Character.isDigit(plate.charAt(3)) && Character.isDigit(plate.charAt(6))) {
      return 1;
    }

    // 2nd generation
    if (Character.isDigit(plate.charAt(0)) && Character.isDigit(plate.charAt(3)) && Character.isAlphabetic(plate.charAt(6))) {
      return 2;
    }

    // 3rd generation
    if (Character.isDigit(plate.charAt(0)) && Character.isAlphabetic(plate.charAt(3)) && Character.isDigit(plate.charAt(6))) {
      return 3;
    }

    // 4th generation
    return 4;
  }

  public static long getGenerationMaxPlates(int generation) {
    if (generation == 1 || generation == 2 || generation == 3) {
      return 5290000;
    } else if (generation == 4) {
      return 27984100;
    }

    return 0;
  }

  public static long getPlateNumber(String plate) {
    int generation = getPlateGeneration(plate);
    long number = 0;

    String chars = plate.replace("-", "");

    if (generation == 1) {
      number = (charValue(chars.charAt(0)) * 23 * 10000) +
        (charValue(chars.charAt(1)) * 10000) +
        (charValue(chars.charAt(2)) * 1000) +
        (charValue(chars.charAt(3)) * 100) + 
        (charValue(chars.charAt(4)) * 10) +
        (charValue(chars.charAt(5)) * 1);
    } else if (generation == 2) {
      number = (charValue(chars.charAt(4)) * 23 * 10000) +
        (charValue(chars.charAt(5)) * 10000) +
        (charValue(chars.charAt(0)) * 1000) +
        (charValue(chars.charAt(1)) * 100) + 
        (charValue(chars.charAt(2)) * 10) +
        (charValue(chars.charAt(3)) * 1);
    } else if (generation == 3) {
      number = (charValue(chars.charAt(2)) * 23 * 10000) +
        (charValue(chars.charAt(3)) * 10000) +
        (charValue(chars.charAt(0)) * 1000) +
        (charValue(chars.charAt(1)) * 100) + 
        (charValue(chars.charAt(4)) * 10) +
        (charValue(chars.charAt(5)) * 1);
    } else if (generation == 4) {
      number = (charValue(chars.charAt(0)) * 23 * 23 * 23 * 100) +
        (charValue(chars.charAt(1)) * 23 * 23 * 100) +
        (charValue(chars.charAt(4)) * 23 * 100) +
        (charValue(chars.charAt(5)) * 100) + 
        (charValue(chars.charAt(2)) * 10) +
        (charValue(chars.charAt(3)) * 1);
    }

    // Add plate count offset
    for (int i = 1; i < generation; i++) {
      number += getGenerationMaxPlates(i);
    }

    return number;
  }

  public static long plateDifference(String plate1, String plate2) {
    long p1Num = getPlateNumber(plate1);
    long p2Num = getPlateNumber(plate2);

    return Math.abs(p1Num - p2Num);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int tests = in.nextInt();
    for (int i = 0; i < tests; i++) {
      String plate1 = in.next();
      String plate2 = in.next();

      System.out.println(plateDifference(plate1, plate2));
    }

    in.close();
  }
}