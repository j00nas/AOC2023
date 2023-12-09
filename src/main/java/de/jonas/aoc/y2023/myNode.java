package main.java.de.jonas.aoc.y2023;

public class myNode {
	public String name;
	public myNode left;
	public myNode right;
	
	public myNode(String name) {
		this.name = name;
	}
	
	public myNode(String name, myNode left, myNode right) {
		this.name = name;
		this.left = left;
		this.right = right;
	}
}
