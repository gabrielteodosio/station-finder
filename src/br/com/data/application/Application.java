package br.com.data.application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import br.com.data.entities.Line;
import br.com.data.entities.Route;
import br.com.data.entities.State;
import br.com.data.entities.Station;
import br.com.data.entities.User;
import br.com.data.utils.CSVReader;
import br.com.data.utils.Heuristics;

public class Application {

	private static final float TRAIN_VELOCITY = 30000 / 60; // unit: m/minute
	private static final int TIME_TO_CHANGE_LINE = 4; // unit: minutes

	private static final double[][] DIRECT_DISTANCES = Heuristics.getDirectDistances();
	private static final double[][] REAL_DISTANCES = Heuristics.getRealDistances();

	public static void main(String[] args) {
		CSVReader reader = new CSVReader("routes.csv");

		HashMap<Station, ArrayList<Route>> stations = reader.readStations();

		State initialState = new State(new Station(11), new Line("BLUE"));
		State desiredState = new State(new Station(6), new Line("BLUE"));

		User user = new User(initialState, desiredState);

		while (true) {
			ArrayList<Route> routes = stations.get(user.getCurrentState().getStation());
			ArrayList<Double> costs = new ArrayList<>();

			Route bestRoute = null;
			double lowestCost = Double.MAX_VALUE;

			for (int i = 0; i < routes.size(); i++) {
				Route route = routes.get(i);

				Station departure = route.getStations()[0];
				Station destination = route.getStations()[1];
				Line currentLine = route.getLine();

				if (departure.getNumber() != destination.getNumber()) {
					double realDistance = getRealDistance(departure, destination);
					double directDistance = getDirectDistance(destination, user.getDesiredState().getStation());

					Double cost = directDistance + realDistance;
					if (!currentLine.getColor().equals(user.getCurrentState().getLine().getColor())) {
						cost += 4;
					}

					costs.add(cost);

					if (cost < lowestCost && cost != 0d) {
						lowestCost = costs.get(i);
						bestRoute = routes.get(i);
					}
				} else {
					costs.add(0d);
				}
			}

			if (!user.getPath().contains(bestRoute.getStations()[1])) {
				user.getPath().push(bestRoute.getStations()[1]);
				user.setCurrentState(new State(bestRoute.getStations()[1], bestRoute.getLine()));
			} else {
				break;
			}

			if (user.getCurrentState().getLine().getColor().equals(user.getDesiredState().getLine().getColor()) &&
					user.getCurrentState().getStation().getNumber() == user.getDesiredState().getStation().getNumber()) {
				System.out.println("Here follows the best path: ");
				user.printPath();
				break;
			}
		}
	}

	private static double getRealDistance(Station departure, Station destination) {
		int i = departure.getNumber();
		int j = destination.getNumber();

		double distance = REAL_DISTANCES[i][j];
		if (distance == 0.0) {
			distance = REAL_DISTANCES[j][i];
		}
		return distance;
	}

	private static double getDirectDistance(Station departure, Station destination) {
		int i = departure.getNumber();
		int j = destination.getNumber();

		double distance = DIRECT_DISTANCES[i][j];
		if (distance == 0.0) {
			distance = DIRECT_DISTANCES[j][i];
		}
		return distance;
	}

	// 30km/h = 500m/min
	// 500 - 1 [m - min]
	// distance - x [m - min]
	private static double calculateCost(double distance) {
		return distance / TRAIN_VELOCITY;
	}

	static class RouteComparator implements Comparator<Route> {
		@Override
		public int compare(Route route1, Route route2) {
			// ddr1 = direct distance route 1
			Double ddr1 = getDirectDistance(route1.getStations()[0], route1.getStations()[1]);
			Double ddr2 = getDirectDistance(route2.getStations()[0], route2.getStations()[1]);

			Double cost1 = calculateCost(ddr1);
			Double cost2 = calculateCost(ddr2);

			if (cost1 == 0.0 || cost2 == 0.0) {
				return -1;
			}

			return Double.compare(ddr1, ddr2);
		}
	}
}
