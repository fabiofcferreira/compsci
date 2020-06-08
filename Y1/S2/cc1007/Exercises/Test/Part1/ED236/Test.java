public class Test {
  public static void main(String[] args) {
    SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

    list.addFirst('a');
    list.addLast('b');
    list.addLast('c');
    list.addLast('d');
    list.addLast('e');

    list.shift(2);

    System.out.println(list);
  }
}