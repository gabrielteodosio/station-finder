package br.com.data.entities;

public class Line {

  private final String color;
  
  public Line(final String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }
  
  public static Line[] generateLinesByColor(String colors[]) {
    Line[] lines = new Line[colors.length];
    
    for (int i = 0; i < lines.length; i++) {
      lines[i] = new Line(colors[i]);
    }
    
    return lines;
  }
}
