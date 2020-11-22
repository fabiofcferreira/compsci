import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

public class DAA021 {
  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int a;
    int r;

    String action;
    int energy;
    int counter;
    TreeMap<Integer, Integer> energies = new TreeMap<Integer, Integer>();

    // Read additions and removals
    a = in.nextInt();
    r = in.nextInt();

    for (int i = 0; i < a+r; i++) {
      action = in.next();

      // Add a new bakugan
      if (action.compareTo("BAK") == 0) {
        energy = in.nextInt();

        // Add one more bakugan with an existing energy
        if (energies.containsKey(energy)) {
          energies.put(energy, energies.get(energy) + 1);
        } else {
          energies.put(energy, 1);
        }
      }

      // Remove a minimum value bakugan
      if (action.compareTo("MIN") == 0) {
        FastPrint.out.println(energies.firstKey());

        counter = energies.get(energies.firstKey());
        if (counter-1 == 0) {
          energies.remove(energies.firstKey());
        } else {
          energies.put(energies.firstKey(), counter-1);
        }
      }

      // Remove a maximum value bakugan
      if (action.compareTo("MAX") == 0) {
        FastPrint.out.println(energies.lastKey());

        counter = energies.get(energies.lastKey());
        if (counter-1 == 0) {
          energies.remove(energies.lastKey());
        } else {
          energies.put(energies.lastKey(), counter-1);
        }
      }
    }

    FastPrint.out.close();
  }
}