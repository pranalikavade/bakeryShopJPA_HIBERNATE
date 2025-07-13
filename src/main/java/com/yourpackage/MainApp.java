package com.yourpackage;
import config.JPAUtil;

import model.*;
import service.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Service.CustomerService;
import Service.OrderService;
import Service.ProductService;

public class MainApp {
  private static ProductService ps = new ProductService();
  private static CustomerService cs = new CustomerService();
  private static OrderService os = new OrderService();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
      System.out.println("\n=== Bakery Shop Menu ===");
      System.out.println("1. Add Product");
      System.out.println("2. List Products");
      System.out.println("3. Add Customer");
      System.out.println("4. List Customers");
      System.out.println("5. Place Order");
      System.out.println("6. List Orders");
      System.out.println("0. Exit");
      System.out.print("Choice: ");
      choice = sc.nextInt();

      switch (choice) {
        case 1: addProduct(sc); break;
        case 2: listProducts(); break;
        case 3: addCustomer(sc); break;
        case 4: listCustomers(); break;
        case 5: placeOrder(sc); break;
        case 6: listOrders(); break;
        case 0: break;
        default: System.out.println("Invalid");
      }
    } while (choice != 0);

    JPAUtil.shutdown();
    sc.close();
    System.out.println("Bye!");
  }

  static void addProduct(Scanner sc) {
    System.out.print("Name: "); String name = sc.next();
    System.out.print("Price: "); Double price = sc.nextDouble();
    ps.addProduct(new Product(name, price));
  }

  static void listProducts() {
    List<Product> list = ps.listAll();
    list.forEach(System.out::println);
  }

  static void addCustomer(Scanner sc) {
    System.out.print("Name: ");
    String n = sc.next();
    System.out.print("Email: ");
    String e = sc.next();
    cs.addCustomer(new Customer(n, e));
  }

  static void listCustomers() {
    cs.listAll().forEach(System.out::println);
  }

  static void placeOrder(Scanner sc) {
    System.out.print("Customer ID: ");
    Long cid = sc.nextLong();
    System.out.print("Product ID: ");
    Long pid = sc.nextLong();
    System.out.print("Quantity: ");
    Integer qty = sc.nextInt();
    os.placeOrder(cid, pid, qty, LocalDate.now());
  }

  static void listOrders() {
    os.listAll().forEach(System.out::println);
  }
}
