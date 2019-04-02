package br.com.data.utils;

import br.com.data.entities.Line;

public class Data {

  public static final String[] COLORS = { "RED", "YELLOW", "GREEN", "BLUE" };
  
  public static Line[] getLines() {
    return Line.generateLinesByColor(COLORS);
  }
}
