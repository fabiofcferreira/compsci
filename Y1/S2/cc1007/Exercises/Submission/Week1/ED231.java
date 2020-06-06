/*
Nome: Fábio Ferreira
Número mecanográfico: 201906173
Sobre ajudas: A única pesquisa que fiz foi se haveria alguma forma de
arredondar os valores percentuais de crescimento do número de casos
no entanto, é inútil e só perco performance. De resto, fiz tudo
sozinho sem ajuda do StackOverflow eheh :)
Explicação da solução: Tenho 3 funções - 1 para cada 1 das flags.
absoluteGrowth (flag 1) é fundamentalmente um loop que começa na segunda
posição do array onde guardo todos os casos por dias e que compara cada
indíce com o anterior, calcula a diferença e compara com os valores
mínimos e máximos substituindo-os se o valor da diferença for menor
ou maior, respetivamente.

No caso da função relativeGrowth (flag 2) começo por guardar todas as
diferenças sob a forma de percentagens numa array de variáveis double.
Após essa tarefa, é executado um loop que mediante um boolean que
indica se existe atualmente um periodo de baixa propagação em curso,
verifica se o valor da percentagem do dia i -1 para o dia i é
igual ou inferior a 0.05 (5%):

- Se o valor percentual <= 0.05 e existir um período em curso,
este continua e o comprimento do periodo é incrementado.

- Se o valor percentual > 0.05 e existir um período, este é acabado,
isto é, o valor boolean que serve de sentinela é mudado para false e
é calculado o comprimento máximo dos períodos comparando o máximo atual e o
comprimento do período acabado.

- Se o valor percentual <= 0.05 e não existir um período, começa um
novo período (valor boolean é mudado para verdade) e é incrementado
o comprimento do período.

A função drawChart (flag3) começa com o cálculo do valor máximo de
casos registados da epidemia e consequentemente do número de linhas
do gráfico, através da divisão ( número máximo de casos / 100 ).

Sendo que cada # corresponde a 100 casos, p.ex. um dia com 532 casos
teria 5 # em coluna.

Ora, com um loop por cada uma das linhas linha e calculando o valor
mínimo de casos nesse dia para que tenha representação no gráfico
na linha atual do loop através da expressão: 
    ( número de linhas * 100 ) - ( nº da linha atual * 100).

Por fim, executando um loop agora por cada um dos dias do dataset,
e comparando o número de casos nesse dia com o número mínimo de casos
para este dia ter representação no gráfico na linha corrente,
podemos imprimir "#" no caso do dia ter mais casos que o mínimo de
casos para essa linha ou "." no caso contrário.

*/

import java.util.Scanner;

public class ED231 {
  static int days;
  static int[] cases = new int[100];
  static int totalCases = 0;
  static int flag;

  public static void absoluteGrowth() {
    int min = 100000;
    int max = 0;
    
    for (int i = 1; i < days; i++) {
      int diff = cases[i] - cases[i - 1];
      // check if the new cases in i-th day is less than the minimum ever recorded
      if (diff < min) min = diff;
      // check if the new cases in i-th day is greater than the maximum ever recorded
      if (diff > max) max = diff;
    }

    System.out.printf("%d %d\n", min, max);
  }
  
  public static void relativeGrowth() {
    // calculate the relative growth (percentage)
    double[] percentage = new double[days];
    
    for (int i = 1; i < days; i++) {
      // the percentage growth from day i-1th to ith is the difference
      // between them dividing by the i-1th day number of cases
      // double percentageDiff = (cases[i] - cases[i - 1]) / (double) cases[i - 1];
      percentage[i - 1] = (cases[i] - cases[i - 1]) / (double) cases[i - 1];
    }

    // count number of low propagation periods and the maximum length
    // of a recorded low-propagation period
    boolean belowMark = false;
    boolean insidePeriod = false;
    int periodLength = 0;
    int numPeriods = 0;
    int maxPeriodLength = 0;
    for (int i = 0; i < days - 1; i++) {
      belowMark = percentage[i] <= 0.05;
      // pointer is not inside a period but the percentage
      // is less than 0.05)
      if (!insidePeriod && belowMark) {
        // star period
        insidePeriod = true;
        periodLength++;
        
        // there's a new period
        numPeriods++;
        continue;
      }

      // period continues (pointer is in a period and the percentage is
      // less than 0.05)
      if (insidePeriod && belowMark) periodLength++;

      // period ends (pointer is in a period but the percenge is greater
      // than 0.05)
      if (insidePeriod && !belowMark || i == days - 2) {
        maxPeriodLength = maxPeriodLength > periodLength ? maxPeriodLength : periodLength;

        // end period
        periodLength = 0;
        insidePeriod = false;
      }
    }

    System.out.printf("%d %d\n", numPeriods, maxPeriodLength);
  }

  public static void drawChart() {
    int rows = 0;

    // calculate maximum of daily recorded cases
    int totalCases = 0;
    for (int i = 0; i < days; i++)
      totalCases = cases[i] > totalCases ? cases[i] : totalCases;
    rows = totalCases / 100;

    // loop for every row
    for (int row = 0; row < rows; row++) {
      // minimum number of cases in the ith day for it to have
      // a chart bar
      int minCases = (rows * 100) - (row * 100);

      // loop for every day and only print hashtag if the number of cases
      // in that day is greater than the minimum number
      for (int day = 0; day < days; day++) {
        if (cases[day] >= minCases) System.out.printf("#");
        else System.out.printf(".");
      }

      System.out.printf("\n");
    }
  }

  public static void main(String[] args) {
    // IO scanner
    Scanner in = new Scanner(System.in);
    
    // read number of days
    days = in.nextInt();

    // read each day's total recorded cases
    for (int i = 0; i < days; i++) {
      cases[i] = in.nextInt();
    }

    // read flag
    flag = in.nextInt();

    // execute
    switch (flag) {
      case 1:
        absoluteGrowth();
        break;
      case 2:
        relativeGrowth();
        break;
      case 3:
        drawChart();
        break;
    }

    in.close();
  }
}