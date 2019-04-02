package br.com.data.entities;

public class Station {
  private int number;
  
  public static Station getStation(int number) {
    return new Station(number);
  }
  
  public static Station getStation(final String name) {
    String[] string = name.split("E");
    return new Station(Integer.parseInt(string[1]));
  }
  
  public Station(int number) {
    this.number = number;
  }
  
  public int getNumber() {
    return number;
  }
  
  public String getName() {
    return "E" + number;
  }
}
