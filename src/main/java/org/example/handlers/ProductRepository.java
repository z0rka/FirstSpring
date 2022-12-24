package org.example.handlers;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.objects.Product;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 * Class with list of products in shop
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRepository {

  private List<Product> productList;

  public Product getProductById(int id) {
    return productList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
  }
}
