import java.io.*;
import java.util.*;

class Char implements Comparable<Char> {
  public int dictionaryIndex;
  public int firstOccurrence;
  public int counter;

  Char () {
    dictionaryIndex = -1;
    firstOccurrence = -1;
    counter = 0;
  }

  @Override
  public int compareTo(Char c) {
    if (counter < c.counter) return +1;
    if (counter > c.counter) return -1;

    if (firstOccurrence < c.firstOccurrence) return -1;
    if (firstOccurrence > c.firstOccurrence) return +1;

    return 0;
  }
}

public class DAA009 {
  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    Char[] frequencies = new Char[26];
    for (int i = 0; i < 26; i++) {
      frequencies[i] = new Char();
    }

    // Read DNA sequence
    String sequence = in.nextLine();
    int dictionaryIndex = -1;

    for (int i = 0; i < sequence.length(); i++) {
      dictionaryIndex = sequence.charAt(i) - 'A';
      
      // Set dictionary index (if not set previously)
      if (frequencies[dictionaryIndex].dictionaryIndex == -1) {
        frequencies[dictionaryIndex].dictionaryIndex = dictionaryIndex;
      }

      // Set first occurrence index (if not set previously)
      if (frequencies[dictionaryIndex].firstOccurrence == -1) {
        frequencies[dictionaryIndex].firstOccurrence = i;
      }

      // Increment character count
      frequencies[dictionaryIndex].counter++;
    }

    // Order by frequency
    Arrays.sort(frequencies);

    for (int i = 0; i < 26; i++) {
      if (frequencies[i].counter > 0) {
        FastPrint.out.printf("%c %d\n", 'A' + frequencies[i].dictionaryIndex, frequencies[i].counter);
      }
    }

    // Close print buffer
    FastPrint.out.close();
  }
}