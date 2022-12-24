package org.example;

import static java.lang.System.out;

import java.util.Scanner;
import lombok.AllArgsConstructor;
import org.example.handlers.Cart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022 Class that controls aplication
 */
@AllArgsConstructor
public class ApplicationController {

  Cart cart;


  /**
   * Method prints all the products and menu
   */
  private void menuPrinter() {
    out.println("Product list");
    cart.getRepository().getProductList().forEach(product ->
        out.println(product.getId() + " " + product.getName() + " " + product.getPrice()));

    out.println("-".repeat(20));
    out.println("0.Exit");
    out.println("1.Add product to cart");
    out.println("2.Delete product from cart");
    out.println("3.Clear cart");
    out.println("4.Show products in cart");
    out.println("-".repeat(20));
    out.println("Choose option");
  }

  /**
   * Method gives user ability to work with cart
   */
  public void work(Cart cart) {
    int option = 1;
    int id;
    Scanner scanner = new Scanner(System.in);

    while (option != 0) {
      menuPrinter();
      option = scanner.nextInt();

      switch (option) {
        case 0:
          out.println("Have a good day! Bye");
          break;

        case 1:
          out.println("Enter id");
          id = scanner.nextInt();
          cart.addById(id);
          break;

        case 2:
          out.println("Enter id");
          id = scanner.nextInt();
          cart.deleteById(id);
          break;

        case 3:
          String configuration = "src/main/resources/ApplicationContext.xml";
          ApplicationContext context = new FileSystemXmlApplicationContext(configuration);

          cart = context.getBean("cart", Cart.class);
          break;

        case 4:
          out.println("-".repeat(20));
          cart.getProductList().forEach(a -> out.println(a.getName() + " " + a.getPrice()));
          out.println("-".repeat(20));
          break;

        default:
          out.println("Wrong option -_-");
          break;
      }
    }
  }
}
