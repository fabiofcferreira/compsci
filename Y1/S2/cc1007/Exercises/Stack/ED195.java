public class ED195 {
  public static void reverse(MyStack<Character> s, int n) {
    // if the number of reversed elements is 1
    // there's nothing to do
    if (s.size() == 1) return;

    char[] elements = new char[n];

    // remove the first n elements of the stack
    for (int i = 0; i < n; i++) {
      elements[i] = s.pop();
    }

    // re-add the elements in reverse order
    for (int i = 0; i < n; i++) {
      s.push(elements[i]);
    }
  }

  public static boolean balanced(String s) {
    // in order for the expression to be valid
    // it's length must be even (because each symbol
    // must appear in pairs for it to be valid)
    if ((s.length() % 2) != 0) return false;

    MyStack<Character> stack = new LinkedListStack<Character>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '[' || s.charAt(i) == '(') stack.push(s.charAt(i));
      else if (s.charAt(i) == ']' || s.charAt(i) == ')') {
        if (stack.top() == null) return false;
        else if (s.charAt(i) == ']' && stack.top() == '[' ||
          s.charAt(i) == ')' && stack.top() == '(') stack.pop();
        else return false;
      }
    }

    if (stack.size() > 0) return false;

    return true;
  }
}