package com.mcfarevee.groceries;

public class Weight {

  public Unit unit;
  public int amount;

  // Constructor
  public Weight(Unit unit, int amount) {
    this.unit = unit;
    this.amount = amount;
  }

  // Check if the fields form two Weight objects are same
  public boolean equal(Weight other) {
    if (this.unit.equals(other.unit) && this.amount == other.amount)
      return true;
    else
      return false;
  }
}
