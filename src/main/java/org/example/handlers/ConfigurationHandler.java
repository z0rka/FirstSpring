package org.example.handlers;

import lombok.NoArgsConstructor;
import org.example.ApplicationController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 * Class configures application
 */
@NoArgsConstructor
public class ConfigurationHandler {

  /**
   * Method configures cart and starts controller
   */

  public void configure() {
    String configuration = "src/main/resources/ApplicationContext.xml";
    ApplicationContext context = new FileSystemXmlApplicationContext(configuration);

    Cart cart = context.getBean("cart", Cart.class);
    ApplicationController controller = context.getBean("controller", ApplicationController.class);

    controller.work(cart);
  }
}
