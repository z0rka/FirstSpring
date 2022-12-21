package org.example.handlers;

import lombok.NoArgsConstructor;
import org.example.ApplicationController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 */
@NoArgsConstructor
public class ConfigurationHandler {

  private ApplicationController controller;

  public void configure() {
    String configuration = "src/main/resources/ApplicationContext.xml";
    ApplicationContext context = new FileSystemXmlApplicationContext(configuration);

    ProductRepository repository = context.getBean("productRep", ProductRepository.class);
    Cart cart = context.getBean("cart", Cart.class);
    controller = context.getBean("controller", ApplicationController.class);

    controller.work(cart);
  }
}
