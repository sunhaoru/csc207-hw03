package csc207.sunhaoru.layout;

/**
 * A text block cut to a specified, non-negative width
 */
public class TruncatedBlock implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock tb;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public TruncatedBlock(TextBlock tb, int width) {
    this.tb = tb;
    this.width = width;
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
    String truncated = null;
    int h = this.tb.height();
    if ((i >= 0) && (i < h)) {
      truncated = this.tb.row(i).substring(0, this.width);
      return truncated;
    } else {
      throw new Exception("Invalid row " + i);
    }
  }

  // Accessors
  public int height() {
    return this.tb.height();
  }


  public int width() {
    return this.width;
  }

}
