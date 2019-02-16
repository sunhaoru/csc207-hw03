package csc207.sunhaoru.layout;

/**
 * A specified character repeated to form a rectangle of specified height and width
 */
public class Grid implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int width;
  int height;
  char ch;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new grid with width, height, and ch.
   */
  public Grid(int width, int height, char ch) {
    this.width = width;
    this.height = height;
    this.ch = ch;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {

    String result = Character.toString(ch);
    int h = this.height;
    int w = this.width;

    // Stuff within the box
    if ((i >= 0) && (i < h)) {
      for (int j = 1; j < w; j++) {
        result += ch;
      }
      return result;
    }
    // Everything else
    else {
      throw new Exception("Invalid row " + i);
    }
  } // row(int)

  public int height() {
    return this.height;
  }

  public int width() {
    return this.width;
  }

}
