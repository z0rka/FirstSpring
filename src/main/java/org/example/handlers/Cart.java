package org.example.handlers;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.objects.Product;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 * Class cart with list of products {@link Product},{@link ProductRepository}
 */

@AllArgsConstructor
@Getter
public class Cart {

  private ProductRepository repository;
  private final List<Product> productList = new ArrayList<>();

  public void addById(int id) {
    productList.add(repository.getProductById(id));
  }

  public void deleteById(int id) {
    productList.remove(repository.getProductById(id));
  }
}
