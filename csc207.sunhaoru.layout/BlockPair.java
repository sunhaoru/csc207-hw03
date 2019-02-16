package csc207.sunhaoru.layout;

public class BlockPair implements TextBlock {

  TextBlock tb;
  
  public BlockPair(TextBlock tb) {
    this.tb = tb;
  }

  public String row(int i) throws Exception {
    String pair;
    int h = this.tb.height();
    if ((i >= 0) && (i < h)) {
        pair = this.tb.row(i) + this.tb.row(i);
        return pair;
      }
     else {
      throw new Exception("Invalid row " + i);
    }
  }

  public int height() {
    return this.tb.height();
  }

  public int width() {
    return this.tb.width()*2;
  }

}


