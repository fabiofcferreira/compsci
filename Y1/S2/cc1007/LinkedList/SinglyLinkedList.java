public class SinglyLinkedList<T> {
  private Node<T> first;    // Primeiro no da lista
  private int size;         // Tamanho da lista

  // Construtor (cria lista vazia)
  SinglyLinkedList() {
    first = null;
    size = 0;
  }

  // Retorna o tamanho da lista
  public int size() {
    return size;
  }

  // Devolve true se a lista estiver vazia ou falso caso contrario
  public boolean isEmpty() {
    return (size == 0);
  }
  
  // Adiciona v ao inicio da lista
  public void addFirst(T v) {
    Node<T> newNode = new Node<T>(v, first); 
    first = newNode;
    size++;
  }

  // Adiciona v ao final da lista
  public void addLast(T v) {
    Node<T> newNode = new Node<T>(v, null); 
    if (isEmpty()) {
      first = newNode;
    } else {
      Node<T> cur = first;

      while (cur.getNext() != null) cur = cur.getNext();

      cur.setNext(newNode);         
    }
    size++;
  }

  // Retorna o primeiro valor da lista (ou null se a lista for vazia)
  public T getFirst() {
    if (isEmpty()) return null;
    return first.getValue();
  }

  // Retorna o ultimo valor da lista (ou null se a lista for vazia)
  public T getLast() {
    if (isEmpty()) return null;
    Node<T> cur = first;
    while (cur.getNext() != null)
      cur = cur.getNext();
    return cur.getValue();      
  }

  // Remove o primeiro elemento da lista (se for vazia nao faz nada)
  public void removeFirst() {
    if (isEmpty()) return;
    first = first.getNext();
    size--;
  }

  // Remove o ultimo elemento da lista (se for vazia nao faz nada)
  public void removeLast() {
    if (isEmpty()) return;
    if (size == 1) {
      first = null;
    } else {
      // Ciclo com for e uso de de size para mostrar alternativa ao while
      Node<T> cur = first;
      for (int i=0; i<size-2; i++)
          cur = cur.getNext();
      cur.setNext(cur.getNext().getNext());
    }
    size--;
  }

  // Counts number of entries with value of target
  public int count(T target) {
    Node<T> node = first;
    int counter = 0;

    while(node.getNext() != null) {
      if (node.getValue().equals(target)) counter++;
      
      // next node
      node = node.getNext();
    }
    if (node.getValue().equals(target)) counter++;

    return counter;
  }

  // Get value stored in the given position
  public T get(int pos) {
    Node<T> node = first;
    int i = 0;

    // index must be positive
    if (pos < 0 || pos >= size) return null;

    while (i++ < pos) node = node.getNext();
    return node.getValue();
  }

  // Remove node given its position
  public T remove(int pos) {
    Node<T> curr = first;
    Node<T> toRemove = null;
    T value = null;
    int i = 0;

    // index must be positive
    if (pos < 0 || pos >= size) return null;

    // remove first
    if (pos == 0) {
      // get first node value and remove
      value = getFirst();
      removeFirst();
    } else if (pos == size - 1) {
      value = getLast();
      removeLast();
    } else {
      // navigate to the node before the selected node
      while (i < pos - 1) {
        curr = curr.getNext();
        i++;
      }

      // get node which is going to be deleted
      toRemove = curr.getNext();
      value = toRemove.getValue();

      curr.setNext(toRemove.getNext());

      // update size
      size--;
    }

    return value;
  }

  // Remove all nodes with given value
  public void removeAll(T value) {
    Node<T> curr = first;

    // check for empty list
    if (first == null) return;

    // check if first node matches
    while (first != null && first.getValue().equals(value)) {
      removeFirst();

      curr = first;
    }

    // check for empty list
    if (first == null) return;

    // check remaining nodes
    while (curr.getNext() != null) {
      if (curr.getNext().getValue().equals(value)) {
        curr.setNext(curr.getNext().getNext());
        size--;
      } else {
        curr = curr.getNext();
      }
    }
  }

  // Duplicate each node
  public void duplicate() {
    Node<T> curr = first;

    while (curr != null) {
      Node<T> newNode = new Node<T>(curr.getValue(), curr.getNext());

      // point current node to the duplicate node
      curr.setNext(newNode);

      curr = curr.getNext().getNext();
    }

    size *= 2;
  }

  // Copy list
  public SinglyLinkedList<T> copy() {
    SinglyLinkedList<T> list = new SinglyLinkedList<T>();

    // point the new list start to the current list first node
    list.first = first;
    list.size = size;
    
    // delete current list
    first = null;
    size = 0;

    return list;
  }

  // Converte a lista para uma String
  public String toString() {
     String str = "{";      
     Node<T> cur = first;
     while (cur != null) {
        str += cur.getValue();
        cur = cur.getNext();
        if (cur != null) str += ",";                     
     }      
     str += "}";
     return str;
  }
}