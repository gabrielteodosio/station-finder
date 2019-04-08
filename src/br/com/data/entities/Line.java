package br.com.data.entities;

public class Line {

	private final String color;
	public static final String[] COLORS = { "RED", "YELLOW", "GREEN", "BLUE" };

	public Line(final String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public static Line[] generateLinesByColor(String colors[]) {
		Line[] lines = new Line[colors.length];

		for (int i = 0; i < lines.length; i++) {
			lines[i] = new Line(colors[i]);
		}

		return lines;
	}

	public static Line[] getLines() {
		return Line.generateLinesByColor(COLORS);
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
