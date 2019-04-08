package br.com.data.entities;

public class Route {

	private Station[] stations = new Station[2];
	private Line line;

	public Route(Station departure, Station destination, Line line) {
		this.stations[0] = departure;
		this.stations[1] = destination;
		this.line = line;
	}

	public Station[] getStations() {
		return stations;
	}

	public Line getLine() {
		return line;
	}
}
