public class ED194 {
  public static void reverse(MyStack<Integer> s, int n) {
    // if the number of reversed elements is 1
    // there's nothing to do
    if (s.size() == 1) return;

    int[] elements = new int[n];

    // remove the first n elements of the stack
    for (int i = 0; i < n; i++) {
      elements[i] = s.pop();
    }

    // re-add the elements in reverse order
    for (int i = 0; i < n; i++) {
      s.push(elements[i]);
    }
  }
}