package de.ppasler.sorting.obj;

public class Fruit implements Comparable<Fruit> {

	private final String name;
	private final Color color;

	public Fruit(final String name, final Color color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	// sort by color
	@Override
	public int compareTo(final Fruit otherFruit) {
		return color.name().compareTo(otherFruit.getColor().name());
	}

	@Override
	public boolean equals(final Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof Fruit) {
			final Fruit otherFruit = (Fruit)anObject;
			return name.equals(otherFruit.getName()) &&
					color == otherFruit.getColor();
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getName() +  ":" + color.name().toLowerCase() + " " + name;
	}

	public enum Color {
		YELLOW,
		ORANGE,
		GREEN,
		RED
	}
}
