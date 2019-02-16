package com.mcfarevee.groceries;

public class NonFood implements Item {

  // Fields
  String name;
  Weight weight;
  int price;

  // Constructor
  public NonFood(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  // Accessor
  public String toString() {
    return this.name;
  }

  public Weight getWeight() {
    return this.weight;
  }

  public int getPrice() {
    return this.price;
  }

  public boolean equals(Item other) {
    if (other instanceof NonFood) {
      if (this.name.equals(((NonFood) other).name) && this.weight.equals(((NonFood) other).weight)
          && this.price == ((NonFood) other).price)
        return true;
      else
        return false;
    } else
      return false;
  }

  public String getName() {
    return this.name;
  }
}

