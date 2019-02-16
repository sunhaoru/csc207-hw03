package com.mcfarevee.groceries;

public class ManyPackages implements Item {

  //Fields
  public Package type;
  public int count;

  //Constructor
  public ManyPackages(Package type, int count) {
    this.type = type;
    this.count = count;
  }

  //Accessors
  public String toString() {
    return Integer.toString(this.count) + " x " + type.toString();
  }

  public Weight getWeight() {
    return new Weight(this.type.getWeight().unit, this.count * this.type.getWeight().amount);
  }

  public int getPrice() {
    return this.count * this.type.getPrice();
  }

  public boolean equal(Item other) {
    if (other instanceof ManyPackages) {
      if (this.type.equal(((ManyPackages) other).type)
          && this.count == ((ManyPackages) other).count)
        return true;
      else
        return false;
    } else
      return false;
  }

  public String getName() {
    return this.type.name;
  }
}
