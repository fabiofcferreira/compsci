/*
Nome: Fábio Ferreira
Número mecanográfico: 201906173
Sobre ajudas: Como criar um Set no StackOverflow

Esta semana a parte do exercício mais complexa foi o
método remove. As restantes duas foram relativamente
straightforward.

O reverse é feito de forma simples adicionado como
último nó o primeiro nó da lista inicial.
De seguida, até chegar ao final da Linked List,
vamos adicionando cada valor como último nó.

Para contar as ocorrências de um valor, uso
uma array temporário com tamanho igual ao da linked
list, pois o número máximo de occorências é
igual ao número de nós da lista.

Através de um loop nó por nó ao longo da lista,
é comparado o valor guardado no nó, com o valor
em questão e se forem iguais, adiciona-se o indíce
onde a occorência existe.

No final, retorna-se um novo array apenas com os
indices usados e com os indices de cada ocorrência.

Por último, o método remove começa com a criação
de um set com todos os elementos a remover a
partir da lista fornecida.

Para poder manter as ligações entre nós é necessário
que o loop a executar verifique sempre o valor do nó
seguinte, caso contrário, o loop não terá acesso ao 
nó anterior.
Caso o próximo nó tenha um valor a remover, apontamos
o nó atual para o 2º nó a contar dele próprio.

Portanto, uso 3 ciclos while:
- Um para apenas verificar constantemente o primeiro
nó (por ser um corner case - não existe nenhum nó
antes do primeiro)
- 1 para navegar até ao final da linked list e outro
para verificar se o nó seguinte a um nó recentemente
eliminado também tem o mesmo valor e se se verificar
deve ser eliminado)
*/

import java.util.*;

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
      while (cur.getNext() != null)
        cur = cur.getNext();
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
  
  // Reverts the nodes position in the linked list from beginning to last
  public SinglyLinkedList<T> reverse() {
    Node<T> node = first;
    SinglyLinkedList<T> reverseList = new SinglyLinkedList<T>();

    // empty list corner case
    if (size == 0) return reverseList;
    
    // loop for each node
    while (node != null) {
      reverseList.addFirst(node.getValue());
      node = node.getNext();
    }

    return reverseList;
  }
  
  // Returns indexes of occurrences of the value given
  public int[] occurrences(T elem) {
    int[] tmp = new int[size];
    int numOccurrences = 0;
    int nodeIndex = 0;
    Node<T> node = first;

    while (node != null) {
      if (node.getValue().equals(elem)) {
        tmp[numOccurrences++] = nodeIndex;
      }

      nodeIndex++;
      node = node.getNext();
    }

    int[] occurrences = new int[numOccurrences];
    for (int i = 0; i < numOccurrences; i++) occurrences[i] = tmp[i];

    return occurrences.length > 0 ? occurrences : null;
  }

  // Removes all nodes from linked list whose values are also stored in
  // nodes of the given linked list
  public void remove(SinglyLinkedList<T> toRemove) {
    Set<T> elems = new HashSet<T>();
    Node<T> node = first;
    Node<T> nextNode = null;

    // get all elements that sould be deleted from
    // the toRemove linked list
    for (int i = 0; i < toRemove.size(); i++) {
      elems.add(toRemove.get(i));
    }


    // check first node
    while (elems.contains(getFirst())) {
      removeFirst();

      node = first;
    }

    // search and remove matches from second node to the end
    while (node != null) {
      nextNode = node.getNext();

      // next pointer doesn't point to the end of the list
      if (nextNode != null) {
        while (nextNode != null && elems.contains(nextNode.getValue())) {
          node.setNext(nextNode.getNext());
          size--;

          nextNode = nextNode.getNext();
        }
      }

      node = node.getNext();
    }
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