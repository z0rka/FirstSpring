package org.example;

import org.example.handlers.ConfigurationHandler;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 */
public class Main {

  public static void main(String[] args) {
    ConfigurationHandler handler = new ConfigurationHandler();
    handler.configure();
  }
}
