package com.mcfarevee.groceries;

public class Package implements Item {

  // Fields
  String name;
  Weight weight;
  int price;

  // Constructor
  public Package(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  // Accessors
  public String toString() {
    String rt = null;
    rt = Integer.toString(this.weight.amount) + " " + this.weight.unit.toString() + " package of "
        + this.name;
    return rt;

  }

  public Weight getWeight() {
    return this.weight;
  }

  public int getPrice() {
    return this.price;
  }

  // Compare if all the fields of two objects
  public boolean equal(Item other) {
    if (other instanceof Package) {
      if (this.name.equals(((Package) other).name) && this.weight.equal(((Package) other).weight)
          && this.price == ((Package) other).price)
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
