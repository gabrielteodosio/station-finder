package br.com.data.application;

import java.util.ArrayList;
import java.util.List;

import br.com.data.entities.Line;
import br.com.data.entities.State;
import br.com.data.entities.Station;
import br.com.data.utils.Heuristics;

public class Application {

  private static final int STATION_QUANTITY = 14;
  private static final float TRAIN_VELOCITY = 30 / 60; // unit: km/minute
  private static final int TIME_TO_CHANGE_LINE = 4; // unit: minutes
  
  private static final float[][] DIRECT_DISTANCES = Heuristics.getDirectDistances();
  private static final float[][] REAL_DISTANCES = Heuristics.getRealDistances();
  
  /**
   * initial state represents the initial station, and line,
   * where the user is going to start its travel.
   */
  private static final String[] INITIAL_STATE_DATA = { "E1", "BLUE" };
  private static final State INITIAL_STATE = new State(
      Station.getStation(INITIAL_STATE_DATA[0]),
      new Line(INITIAL_STATE_DATA[1])
  );
  
  /**
   * initial state represents the initial station, and line,
   * where the user is going to start its travel.
   */
  private static final String[] FINAL_STATE_DATA = { "E2", "YELLOW" };
  private static final State FINAL_STATE = new State(
      Station.getStation(FINAL_STATE_DATA[0]),
      new Line(INITIAL_STATE_DATA[1])
  );
  
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
