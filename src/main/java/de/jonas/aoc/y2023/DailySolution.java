package main.java.de.jonas.aoc.y2023;

import java.util.List;

public interface DailySolution {
	public void printSolution();	
	public void calculateSolutionPart1();
	public void calculateSolutionPart2();
	public String getInputDataPath();
	public List<String> getInputData();
}