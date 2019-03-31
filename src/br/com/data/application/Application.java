package br.com.data.application;

import java.util.ArrayList;
import java.util.List;

import br.com.data.entities.Heuristics;
import br.com.data.entities.Station;

public class Application {

  private static final int STATION_QUANTITY = 14;
  
  private static final float[][] DIRECT_DISTANCES = Heuristics.getDirectDistances();
  private static final float[][] REAL_DISTANCES = Heuristics.getRealDistances();
  
  public static void main(String[] args) {
    List<Station> stations = new ArrayList<>();

    for (int i = 1; i <= STATION_QUANTITY; i++) {
      stations.add(Station.getStation(i));
    }

    float realDistance = getRealDistanceBetween(stations.get(12), stations.get(2));
    float directDistance = getDirectDistanceBetween(stations.get(12), stations.get(2));
    
    System.out.println("real distance: " + realDistance);
    System.out.println("direct distance: " + directDistance);
  }
  
  private static float getRealDistanceBetween(Station one, Station two) {
    float distance = REAL_DISTANCES[one.getNumber() - 1][two.getNumber() - 1];
    
    if(distance == 0.0f) {
      distance = REAL_DISTANCES[two.getNumber() - 1][one.getNumber() - 1];
    }
    
    return distance;
  }
  
  private static float getDirectDistanceBetween(Station one, Station two) {
    float distance = DIRECT_DISTANCES[one.getNumber() - 1][two.getNumber() - 1];
    
    if(distance == 0.0f) {
      distance = DIRECT_DISTANCES[two.getNumber() - 1][one.getNumber() - 1];
    }
    
    return distance;
  }
}
