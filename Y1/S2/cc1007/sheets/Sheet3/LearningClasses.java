class Student {
   String name;
   int number;

   // Construtor "padrão"
   Student() {
      name   = "undefined";
      number = -1;
   }

  public String toString() {
    return "(" + name + "," + number + ")";
  }
}

// Classe principal contendo o main para testar a classe Aluno
public class LearningClasses {
   public static void main(String[] args) {
      Student a = new Student();
      
      System.out.println("a.name = " + a.name);
      System.out.println("a.number = " + a.number);
      System.out.println("a = " + a);

      Student b = new Student();
      Student c = b;
      b.name = "modificado";
      System.out.println("b = " + b);
      System.out.println("c = " + c);
   }
}