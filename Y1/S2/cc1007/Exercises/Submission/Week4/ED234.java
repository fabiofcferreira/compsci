/*
Nome: Fábio Ferreira
Número mecanográfico: 201906173
Sobre ajudas:
Explicação da solução: Na flag1 foi apenas necessário ciar uma BST, ler os
valores de cada filme embora o rating seja completamente inutil para esta flag.
Aquando da leitura do rating, insiro o nome do filme na BST e como não há valores
repetidos a solução é imprimir o número de nós no final da leitura de todos os
filmes.

Na flag2 já é necessário um dicionário pois para além do nome do filme, é necessário
guardar o número de ratings de cada filme. Durante a leitura, o dicionário é
consultado para incrementar o valor atual (se ele existir) de ratings.

No final é necessário fazer um loop por cada um dos filmes guardados no dicionário
(acessível com recurso ao método keys) e imprimir o nome do filme cujo número 
de ratings é o maior de todos, tal como pedido.

Na flag3 usam-se 2 dicionários: 1 para guardar o número de ratings por filme
e o outro para guardar a soma das notas dadas em cada rating. A leitura
dos ratings e a escrita em cada um destes dicionários acontece simultaneamente.
No caso do numero de ratings o passo necessário é acrescentar 1 ao número de ratings
do filme (se existir) ou definir como 1 (no caso do dicionário ainda não ter um rating
deste filme). No caso da soma é somar à soma atual que começa no 0, claro.

Para concluir é apenas preciso fazer um loop por cada um dos filmes guardados
e imprimir o nome daqueles cuja média de rating é igual ou superior a 5.
É possível calcular esta média através dos valores dos 2 dicionários (pois temos 
o número total de ratings e a soma de todas essas ratings).
*/

import java.util.LinkedList;
import java.util.Scanner;

public class ED234 {
  static Scanner in = new Scanner(System.in);

  public static void moviesRated(int ratings) {
    BSTree<String> t = new BSTree<String>();

    // read all ratings line by line
    for (int i = 0; i < ratings; i++) {
      String name = in.next();
      int grade = in.nextInt();

      t.insert(name);
    }

    System.out.println(t.numberNodes());
  }

  public static void mostRatedMovie(int ratings) {
    BSTMap<String, Integer> map = new BSTMap<String, Integer>();

    // read all ratings
    for (int i = 0; i < ratings; i++) {
      String name = in.next();
      int grade = in.nextInt();

      // get existing number of ratings
      int currentRatings = 0;
      if (map.get(name) != null) currentRatings = map.get(name);

      // count one more rating
      map.put(name, currentRatings + 1);
    }

    // get the most rated movie
    int maxRatings = 0;
    String mostRatedMovie = "";
    LinkedList<String> keysLL = map.keys();

    for (int i = 0; i < keysLL.size(); i++) {
      String movieName = keysLL.get(i);

      if (map.get(movieName) > maxRatings) {
        mostRatedMovie = movieName;
        maxRatings = map.get(movieName);
      }
    }

    System.out.printf("%s %d\n", mostRatedMovie, maxRatings);
  }

  public static void positiveRatedMovie(int ratings) {
    BSTMap<String, Integer> map = new BSTMap<String, Integer>();
    BSTMap<String, Integer> sumMap = new BSTMap<String, Integer>();

    // read all ratings and save ratings and a sum of
    // all ratings of the movie
    for (int i = 0; i < ratings; i++) {
      String name = in.next();
      int grade = in.nextInt();

      // get existing number of ratings
      int currentRatings = 0;
      if (map.get(name) != null) currentRatings = map.get(name);

      // count one more rating
      map.put(name, currentRatings + 1);

      // get existing sum of ratings
      int ratingsSum = 0;
      if (sumMap.get(name) != null) ratingsSum = sumMap.get(name);

      sumMap.put(name, ratingsSum + grade);
    }

    // loop for each movie and print the names of the movies
    // which rating average is equals or above 5 in a scale of 1 to 10
    LinkedList<String> keysLL = map.keys();
    for (int i = 0; i < keysLL.size(); i++) {
      String movieName = keysLL.get(i);

      if (sumMap.get(movieName) / map.get(movieName) >= 5)
        System.out.println(movieName);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int flag;
    int ratings;

    flag = in.nextInt();
    ratings = in.nextInt();

    if (flag == 1) moviesRated(ratings);
    else if (flag == 2) mostRatedMovie(ratings);
    else if (flag == 3) positiveRatedMovie(ratings);

    in.close();
  }
}