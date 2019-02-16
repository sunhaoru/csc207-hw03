package com.mcfarevee.shopping;

import com.mcfarevee.groceries.BulkItem;
// https://stackoverflow.com/questions/541749/how-to-determine-an-objects-class
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.Unit;
import java.io.PrintWriter;
import java.util.*;


public class Cart {

  // Field
  Vector<Item> cart;

  // Constructor
  public Cart() {
    this.cart = new Vector<Item>();
  }

  /**
   * addItem adds a grocery item to the cart which is a vector
   * 
   * @param item An Item
   * @post the grocery item resides at the end of the array
   */
  public void addItem(Item item) {
    this.cart.add(item);
  }

  /**
   * numThings counts how many items are in the cart
   * 
   * @return count The number of items in the cart
   */
  public int numThings() {
    int count = 0;
    for (int i = 0; i < this.cart.size(); i++) {
      if (this.cart.get(i) instanceof ManyPackages) {
        count += ((ManyPackages) this.cart.get(i)).count;
      } else
        count++;
    }
    return count;
  }

  /**
   * numEntries counts how many entries are in the cart
   * 
   * @return the size of the vector cart
   */
  public int numEntries() {
    return this.cart.size();
  }// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html


  /**
   * printContents prints a list of the cart's contents
   */
  public void printContents(PrintWriter pen) {
    pen.println(this.cart.toString());
  }

  /**
   * getPrice computes the price of total items in cart
   * 
   * @return price The total price
   */
  public int getPrice() {
    int price = 0;
    for (int i = 0; i < this.cart.size(); i++) {
      price += this.cart.get(i).getPrice();
    }
    return price;
  }

  /**
   * getWeight stores the unconverted weights of the grocery Items in Cart
   * 
   * @return weight If the cart is empty, getWeight returns four 0's if the cart is not empty,
   */
  public double[] getWeight() {
    double[] weight = {0, 0, 0, 0};// stored as POUND, OUNCE, KILOGRAM, and GRAM

    for (int i = 0; i < this.cart.size(); i++) {
      if (this.cart.get(i).getWeight().unit == Unit.POUNDS) {
        weight[0] += this.cart.get(i).getWeight().amount;
      } else if (this.cart.get(i).getWeight().unit == Unit.OUNCES) {
        weight[1] += this.cart.get(i).getWeight().amount;
      } else if (this.cart.get(i).getWeight().unit == Unit.KILOGRAMS) {
        weight[2] += this.cart.get(i).getWeight().amount;
      } else
        weight[3] += this.cart.get(i).getWeight().amount;
    }
    return weight;
  }

  /**
   * remove removes an item from the cart
   * 
   * @param name A String
   * @pre the cart cannot be empty
   * @post the number of entries is reduced by 1
   */
  public void remove(String name) {
    for (int i = 0; i < this.cart.size(); i++) {
      if (this.cart.get(i).getName().equals(name)) {
        this.cart.remove(i);
        i--;
      }
    }
  }

  /**
   * merge combines identical entries into a single ManyPackages entry
   * 
   * @pre conditions: the cart cannot be empty
   * @post Identical Packages become a single ManyPackages entry. Identical BulkItem and BulkFood
   *       entries become single BulkItem/Food entries. If a Packages matches a ManyPackages entry,
   *       it will be added to the ManyPackages entry and removed from itsown entry
   */
  public void merge() {
    for (int i = 0; i < this.cart.size() - 1; i++) {
      switch (this.cart.get(i).getClass().toString().substring(30)) {

        case "BulkItem":
          if (((BulkItem) this.cart.get(i)).equal(this.cart.get(i + 1))) {
            ((BulkItem) this.cart.get(i)).amount += ((BulkItem) this.cart.get(i + 1)).amount;
            this.cart.remove(i + 1);
            i--;
          }
          break;

        case "Package":
          if (((Package) this.cart.get(i)).equal(this.cart.get(i + 1))) {
            this.cart.remove(i);
            this.cart.add(i, new ManyPackages((Package) this.cart.get(i), 2));
            this.cart.remove(i + 1);
            i--;
          }
          break;

        case "ManyPackages":
          if (((ManyPackages) this.cart.get(i)).equal(this.cart.get(i + 1))) {
            ((ManyPackages) this.cart.get(i)).count += ((ManyPackages) this.cart.get(i + 1)).count;
            this.cart.remove(i + 1);
            i--;
          } else if (((ManyPackages) this.cart.get(i)).type.equal(this.cart.get(i + 1))) {
            ((ManyPackages) this.cart.get(i)).count++;
            this.cart.remove(i + 1);
            i--;
          }
          break;

        default:
          break;
      }
    }
  }

}
