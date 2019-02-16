package com.mcfarevee.groceries;
// https://stackoverflow.com/questions/6149677/comparing-class-types-in-java

public class BulkItem implements Item {

  // Fields
  BulkFood food;
  Unit unit;
  public int amount;

  // Constructor
  public BulkItem(BulkFood food, Unit unit, int amount) {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  }

  // Accessors
  public String toString() {
    String rt = null;
    rt = Integer.toString(this.amount) + " " + this.food.unit.toString() + " of " + this.food.name;
    return rt;
  }

  public Weight getWeight() {
    return (new Weight(this.unit, this.amount));
  }


  public int getPrice() {
    return this.amount * this.food.pricePerUnit;
  }

  public boolean equal(Item other) {
    if (other instanceof BulkItem) {
      if (this.food.equals(((BulkItem) other).food) && this.unit.equals(((BulkItem) other).unit)
          && this.amount == ((BulkItem) other).amount)
        return true;
      else
        return false;
    } else
      return false;
  }

  public String getName() {
    return this.food.name;
  }
}
