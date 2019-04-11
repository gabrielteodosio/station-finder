package br.com.data.entities;

public class Line {

	public enum Colors {
		RED("RED"),
		YELLOW("YELLOW"),
		GREEN("GREEN"),
		BLUE("BLUE");

		private String color;

		Colors(String color) {
			this.color = color;
		}

		public String getColor() {
			return color;
		}
	}

	private final String color;

	public Line(final String color) {
		this.color = color;
	}

	public Line(final Line.Colors color) {
		this.color = color.getColor();
	}

	public String getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Line other = (Line) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
}
