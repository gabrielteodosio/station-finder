package br.com.data.entities;

public class State {

	private Station station;
	private Line line;

	public State(Station station, Line line) {
		this.station = station;
		this.line = line;
	}

	public Station getStation() {
		return station;
	}

	public Line getLine() {
		return line;
	}
}
