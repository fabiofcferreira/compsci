public class TestSinglyLinkedList {
  public static void main(String[] args) {

    // Criacao de lista de inteiros
    // SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
    SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    // Integers
    // list.addFirst(1);
    // list.addLast(2);
    // list.addLast(2);
    // list.addLast(2);
    // list.addLast(1);
    // list.addLast(3);
    // list.addLast(4);
    // list.addLast(2);
    // list.addLast(1);

    // Strings
    list.addLast("a");
    list.addLast("b");
    list.addLast("c");
    list.addLast("d");
    list.addLast("e");
    list.addLast("a");
    list.addLast("e");
    list.addLast("d");
    list.addLast("c");
    list.addLast("b");
    list.addLast("a");

    // System.out.println();
    System.out.println(list);
    System.out.println(list.size());
    list.removeAll("e");
    System.out.println(list);
    System.out.println(list.size());
  }
}