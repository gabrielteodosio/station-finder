package br.com.data.entities;

public class Station implements Comparable<Station> {
	private int number;

	public Station(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number - 1;
	}

	public String getName() {
		return "E" + number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (number != other.number)
			return false;
		return true;
	}

	@Override
	public int compareTo(Station station) {
		return this.getNumber() < station.getNumber() ? -1 : (this.getNumber() > station.getNumber() ? 1 : 0);
	}
}
