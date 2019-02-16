package com.mcfarevee.shopping;

import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.NonFood;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Weight;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.ManyPackages;
import java.io.PrintWriter;


public class Drive {

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Unit.POUNDS, 50, 20);
    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Unit.GRAMS, 1000, 200);

    Cart cart = new Cart();
    // The customer adds three pounds of bananas to the cart
    cart.addItem(new BulkItem(bananas, Unit.POUNDS, 3));
    cart.addItem(new BulkItem(bananas, Unit.POUNDS, 3));
    // The customer adds a bag of 1 gram of saffron to the cart
    cart.addItem(new BulkItem(saffron, Unit.GRAMS, 1));

    // The customer adds a can opener to the cart, priced $3.489.
    cart.addItem(new NonFood("can opener", new Weight(Unit.OUNCES, 2), 349));

    // The customer adds a box of oreos to the cart
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCES, 12), 399));

    /**
     * The following codes are used for merge testing. All situations are considered.
     */
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCES, 12), 399));
    cart.addItem(new ManyPackages(new Package("macncheez", new Weight(Unit.OUNCES, 6), 77), 5));
    cart.addItem(new ManyPackages(new Package("macncheez", new Weight(Unit.OUNCES, 6), 77), 5));
    cart.addItem(new Package("macncheez", new Weight(Unit.OUNCES, 6), 77));

    // Print the original cart
    cart.printContents(pen);
    cart.merge();
    cart.printContents(pen);
  }
}
