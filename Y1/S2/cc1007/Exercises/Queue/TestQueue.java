public class TestQueue {
  public static void main(String[] args) {

    // Criacao da fila
    MyQueue<String> q = new LinkedListQueue<String>();
    MyQueue<String> a = new LinkedListQueue<String>();
    MyQueue<String> b = new LinkedListQueue<String>();
    
    // Input 1
    // q.enqueue("Luis");
    // q.enqueue("B");
    // q.enqueue("Pedro");
    // q.enqueue("A");
    // q.enqueue("Luisa");
    // q.enqueue("A");
    // q.enqueue("Joao");
    // q.enqueue("X");
    // q.enqueue("Jose");
    // q.enqueue("X");
    // q.enqueue("Miguel");
    // q.enqueue("B");

    // Input 2
    q.enqueue("Luis");
    q.enqueue("B");
    q.enqueue("Pedro");
    q.enqueue("B");
    q.enqueue("Luisa");
    q.enqueue("X");
    q.enqueue("Joao");
    q.enqueue("X");

    System.out.println("Before:");
    System.out.println(q);
    System.out.println(a);
    System.out.println(b);
    
    ED196.process(q, a, b);

    System.out.println("After:");
    System.out.println(q);
    System.out.println(a);
    System.out.println(b);
  }
}