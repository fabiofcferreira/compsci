public class ED196 {
  public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
    while (true) {
      if (q.isEmpty()) return;

      String nome = q.dequeue();
      String list = q.dequeue();

      if (list.equals("A")) a.enqueue(nome);
      else if (list.equals("B")) b.enqueue(nome);
      else if (list.equals("X") && a.size() != b.size()) {
        if (a.size() > b.size()) b.enqueue(nome);
        else if (a.size() < b.size()) a.enqueue(nome);
      }
    }
  }
}