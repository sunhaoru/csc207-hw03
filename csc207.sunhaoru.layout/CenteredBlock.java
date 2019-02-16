package csc207.sunhaoru.layout;

/**
 * A textblock with the text center-justified
 */
public class CenteredBlock implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box The width of the textbox
   */
  TextBlock tb;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with contents _contents and given widht
   */
  public CenteredBlock(TextBlock tb, int width) {
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
    String centered = null;
    int h = this.tb.height();
    if ((i >= 0) && (i < h)) {
      int space = (this.width - this.tb.row(i).length()) / 2;
      centered = TBUtils.spaces(space) + this.tb.row(i) + TBUtils.spaces(space);
      return centered;
    } else {
      throw new Exception("Invalid row " + i);
    }
  }

  public int height() {
    return this.tb.height();
  }

  @Override
  public int width() {
    return this.width;
  }

}
