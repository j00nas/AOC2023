package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;

public class Aoc2023Day06 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 6: Wait For It
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Double> distances = new ArrayList<Double>();
		
		for (String line : getInputData()) {
			if(line.split(":")[0].equals("Time")) {
				for(String s : line.split(":")[1].split(" ")) {
					if(s != "") times.add(Double.parseDouble(s));
				}				
			}else {
				for(String s : line.split(":")[1].split(" ")) {
					if(s != "") distances.add(Double.parseDouble(s));
				}
			}
		}
		
		int ans = 1;
		
		for(int i = 0; i < times.size(); i++) {
			double n = times.get(i);
			double a = calcA(n);
			double maxDistance = distances.get(i);
			int tempAns = 0;
			for(int j = 0; j < times.get(i); j++) {
				double y = calcY(j, a, n);
				if(y > maxDistance) tempAns++;
			}
			ans *= tempAns;
		}

		System.out.println("ans: " + ans);
		
	}
	
	public void calculateSolutionPart2() {
		
	}	
	
	public double calcA(double n) {
		return Math.pow(n, 2)/4;
	}
	
	public double calcY(double x, double a, double n) {
		return -Math.pow((x-(n/2)),2) + a;
	}
	
}

