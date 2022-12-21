package org.example;

import static java.lang.System.out;

import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.handlers.Cart;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 */
@AllArgsConstructor
public class ApplicationController {

  Cart cart;

  private void menuPrinter() {
    out.println("Product list");
    cart.getRepository().getProductList().forEach(product ->
        out.println(product.getId() + " " + product.getName() + " " + product.getPrice()));

    out.println("-".repeat(20));
    out.println("0.Exit");
    out.println("1.Add product to cart");
    out.println("2.Delete product from cart");
    out.println("-".repeat(20));
    out.println("Choose option");
  }

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

        default:
          out.println("Wrong option -_-");
          break;
      }
    }
  }
}
