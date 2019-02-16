package csc207.sunhaoru.layout;

/**
 * A textblock with the text right-justified
 */
public class RightJustified implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  TextBlock tb;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new grid with textblock tb and widht.
   */
  public RightJustified(TextBlock tb, int width) {
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
    String right;
    int h = this.tb.height();
    if ((i >= 0) && (i < h)) {
      int l = this.tb.row(i).length();
      if (l > this.width) {
        throw new Exception("Invalid width" + this.width);
      } else {
        right = TBUtils.spaces(this.width - l) + this.tb.row(i);
        return right;
      }
    } else {
      throw new Exception("Invalid row " + i);
    }
  }

  public int height() {
    return this.tb.height();
  }

  public int width() {
    return this.width;
  }

}
