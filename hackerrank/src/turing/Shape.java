package turing;

import java.util.ArrayList;
import java.util.List;

public class Shape {

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getDiameter() {
		return diameter;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	private String name;
	private double diameter;
	
	@Override
	public String toString() {
		return String.format("%s [%.2f]", getName(), getDiameter());
	}

	public Shape(String name, double diameter) {
		super();
		this.name = name;
		this.diameter = diameter;
	}
	
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Shape("S1", 286));
		shapes.add(new Shape("S2", 512));
		shapes.add(new Shape("S3", 268));
		shapes.add(new Shape("S4", 258));
		shapes.add(new Shape("S5", 431));
		shapes.add(new Shape("S6", 289));
		
		Shape result = shapes.stream().reduce(shapes.get(0), (a, b) -> a.getDiameter() > b.getDiameter() ? a : b);
		System.out.println(result);
		
	}
	
}


