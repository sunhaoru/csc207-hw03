package csc207.sunhaoru.layout;

import java.io.PrintWriter;

public class Driver {

  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    TBUtils.print(pen, new BoxedBlock(new Grid(7, 3, '*')));

    /*
     * TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye")); TextBlock
     * block2 = new TruncatedBlock(block, 3); TBUtils.print(pen, block); TBUtils.print(pen, block2);
     */

    /*
     * TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye")); TextBlock
     * block2 = new BoxedBlock(new CenteredBlock(block, 11)); TBUtils.print(pen, block2);
     */

    /*
     * TextBlock top = new CenteredBlock(new TextLine("Hello"), 11); TextBlock bottom = new
     * CenteredBlock(new TextLine("Goodbye"), 11); TextBlock block = new BoxedBlock(new
     * VComposition(top,bottom));
     */

    /*
     * TextBlock block = new VComposition(new TextLine("Hello"), new TextLine("Goodbye")); TextBlock
     * block2 = new BoxedBlock(new RightJustified(block, 11));
     */


    TextBlock block3 = new BoxedBlock(new BlockPair(new TextLine("Hello")));

    TBUtils.print(pen, block3);


    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(
        new CenteredBlock(new BoxedBlock(new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);

    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);

  }

}
