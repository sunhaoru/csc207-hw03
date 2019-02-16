package csc207.sunhaoru.layout;

public class CComposition implements TextBlock{

 TextBlock block;
 int width;
 
 public CComposition (TextBlock block, int width) {
   this.block = block;
   this.width = width;
 }
 
  public String row(int i) throws Exception {
    return null;
  }

 
  public int height() {
    return this.block.height();
  }

 
  public int width() {
    return this.block.width();
  }

  
}
