import java.util.Scanner;

class Customer {
  String name;
  int products;
  int arrivalSecond;
  int orderEnd; 

  Customer(String n, int sa, int p) {
    name = n;
    arrivalSecond = sa;
    products = p;
    orderEnd = 0;
  }
}

class Cashier {
  int timePerProduct;

  // queue information
  MyQueue<Customer> queue;
  int nextReadyTime;

  // cashier stats
  int totalCustomers;
  int totalProductsHandled;
  int lastCustomerProductsNumber;

  Cashier(int time) {
    timePerProduct = time;

    nextReadyTime = 0;
    totalCustomers = 0;
    totalProductsHandled = 0;
    lastCustomerProductsNumber = 0;
    queue = new LinkedListQueue<Customer>();
  }

  public void enqueue(Customer c) {
    if (nextReadyTime > c.arrivalSecond) nextReadyTime += 10 + (timePerProduct * c.products);
    else nextReadyTime += (c.arrivalSecond - nextReadyTime) + 10 + (timePerProduct * c.products);

    c.orderEnd = nextReadyTime;

    // update total number of products and the last customer's
    // number of products
    totalCustomers++;
    totalProductsHandled += c.products;
    lastCustomerProductsNumber = c.products;

    // add to queue
    queue.enqueue(c);
  }

  public void dequeue(Customer c) {
    Customer removedCustomer = queue.dequeue();
  }

  public String toString() {
    String str = "{\n";
    str += "Time: " + timePerProduct + "\n";
    str += "Queue size: " + queue.size() + "\n";
    str += "Last customer's products number: " + lastCustomerProductsNumber + "\n";
    str += "Total number of products: " + totalProductsHandled + "\n";
    str += "}";

    return str;
  }
}

public class ED115 {
  public static void customerOrder(Cashier[] cashiers, Customer[] customers) {
    int availableSecond = 0;
    int timePerProduct = cashiers[0].timePerProduct;

    for (int i = 0; i < customers.length; i++) {
      System.out.printf("%s ", customers[i].name);
      System.out.printf("%d ", customers[i].arrivalSecond);

      int end = 0;
      if (availableSecond > customers[i].arrivalSecond) end += availableSecond;
      else end += customers[i].arrivalSecond;

      // add time of adding products
      end += timePerProduct * customers[i].products + 10;

      // set the next second when the cashier is available
      availableSecond = end;

      System.out.printf("%d", end);
      System.out.println();
    }
  }

  public static int nextAvailableCashier(Cashier[] cashiers, Customer customer) {
    int chosenCashier = 0;
    int chosenQueueSize = 0;
    MyQueue<Customer> currQueue;

    // first of all, update the queues by removing ended orders
    for (int i = 0; i < cashiers.length; i++) {
      // remove customers whose order has ended already by the time the current
      // customer arrives at the cashier spot 
      while(cashiers[i].queue.size() > 0 && cashiers[i].queue.first().orderEnd < customer.arrivalSecond)
        cashiers[i].queue.dequeue();
    }

    // update chosen queue's size
    chosenQueueSize = cashiers[chosenCashier].queue.size();

    // check whose cashier is the best pick
    for (int i = 0; i < cashiers.length; i++) {
      if (i == chosenCashier) continue;
      currQueue = cashiers[i].queue;

      if (currQueue.size() < chosenQueueSize) {
        // chose by queue size
        chosenCashier = i;
        chosenQueueSize = cashiers[chosenCashier].queue.size();
      } else if (currQueue.size() == chosenQueueSize) {
        // chose by last customer's products number
        if (currQueue.size() > 0) {
          int currQueueLastCustomerProductsNumber = cashiers[i].lastCustomerProductsNumber;
          int chosenQueueLastCustomerProductsNumber = cashiers[chosenCashier].lastCustomerProductsNumber;

          if (currQueueLastCustomerProductsNumber < chosenQueueLastCustomerProductsNumber) {
            chosenCashier = i;
            chosenQueueSize = cashiers[chosenCashier].queue.size();
          } else if (currQueueLastCustomerProductsNumber == chosenQueueLastCustomerProductsNumber) {
            // chose by cashier index
            if (i < chosenCashier) {
              chosenCashier = i;
              chosenQueueSize = cashiers[chosenCashier].queue.size();
              break;
            }
          }
        }
      }
    }

    return chosenCashier;
  }

  public static void cashierReport(Cashier[] cashiers, Customer[] customers) {
    Cashier cashier;

    for (int i = 0; i < customers.length; i++) {
      int chosenCashierIndex = nextAvailableCashier(cashiers, customers[i]);

      cashier = cashiers[chosenCashierIndex];
      cashier.enqueue(customers[i]);
    }

    for (int i = 0; i < cashiers.length; i++) {
      System.out.printf("Caixa #%d: %d %d\n", i + 1, cashiers[i].totalCustomers, cashiers[i].totalProductsHandled);
    }
  }

  public static void main(String[] args) {
    int flag = 0;
    int cashiersNum = 0;
    int customersNum = 0;

    Cashier[] cashiers;
    Customer[] customers;

    // open stream reader
    Scanner in = new Scanner(System.in);

    flag = in.nextInt();
    cashiersNum = in.nextInt();

    // create array of cashiers and read each
    // one time for every single product
    cashiers = new Cashier[cashiersNum];
    for (int i = 0; i < cashiersNum; i++) {
      cashiers[i] = new Cashier(in.nextInt());
    }

    // read customers info
    customersNum = in.nextInt();
    customers = new Customer[customersNum];

    String line = "";
    String customerName;
    int arrivalSecond;
    int productsNum;
    for (int i = 0; i < customersNum; i++) {
      // only read variables from non-empty lines
      while(line.length() == 0) {
        line = in.nextLine();
      }
      
      // use space delimiter to find variables
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(" ");

      // read variables
      customerName = lineScanner.next();
      arrivalSecond = lineScanner.nextInt();
      productsNum = lineScanner.nextInt();

      // create customers
      customers[i] = new Customer(customerName, arrivalSecond, productsNum);

      // reset variables number
      line = "";
      customerName = "";
      arrivalSecond = 0;
      productsNum = 0;
    }

    if (flag == 1) {
      customerOrder(cashiers, customers);
    } else if (flag == 2) {
      cashierReport(cashiers, customers);
    }

    // close stream reader
    in.close();
  }
}