package br.com.data.entities;

public class Station {
  private int number;
  
  public static Station getStation(int number) {
    return new Station(number);
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
