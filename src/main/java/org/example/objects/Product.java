package org.example.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Kostiantyn Kvartyrmeister on 19.12.2022
 */
@AllArgsConstructor
@Getter

public class Product {

  private int id;
  private String name;
  private float price;
}
