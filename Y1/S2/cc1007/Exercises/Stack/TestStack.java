public class TestStack {
  public static void main(String[] args) {
    // Criacao da pilha
    MyStack<Integer> s = new LinkedListStack<Integer>();
    //MyStack<Integer> s = new ArrayStack<Integer>();

    // Exemplo de insercao de elementos na pilha
    for (int i=1; i<=8; i++)
       s.push(i); // insere i no topo da pilha
    System.out.println(s);

    // Exemplo de utilizacao dos outros metodos
    System.out.println("s.size() = " + s.size());
    System.out.println("s.isEmpty() = " + s.isEmpty());
    System.out.println("s.top() = " + s.top());

    ED194.reverse(s, 4);

    System.out.println(s);
  }
}