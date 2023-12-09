package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;

public class Aoc2023Day09 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 9: Mirage Maintenance
	 */
	
	public void printSolution(){
		//calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		int ans = 0;
		
		for (String line : getInputData()) {
			ArrayList<Integer> curNumbers = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> fullPyramid = new ArrayList<ArrayList<Integer>>();
			
			for(String s : line.split(" ")) {
				curNumbers.add(Integer.parseInt(s));
			}
			fullPyramid.add(curNumbers);
			
			while(!calcSum(fullPyramid.get(fullPyramid.size()-1))) {
				fullPyramid.add(calcNextLine(fullPyramid.get(fullPyramid.size()-1)));
			}
			
			ans += calcPrediction(fullPyramid);
			//fullPyramid.forEach(x -> System.out.println(x));
		}
		
		System.out.println("ans: " + ans);
	}
	
	public void calculateSolutionPart2() {	
		int ans = 0;
		
		for (String line : getInputData()) {
			ArrayList<Integer> curNumbers = new ArrayList<Integer>();
			ArrayList<ArrayList<Integer>> fullPyramid = new ArrayList<ArrayList<Integer>>();
			
			for(String s : line.split(" ")) {
				curNumbers.add(Integer.parseInt(s));
			}
			fullPyramid.add(curNumbers);

			while(!calcSum(fullPyramid.get(fullPyramid.size()-1))) {
				fullPyramid.add(calcNextLine(fullPyramid.get(fullPyramid.size()-1)));
			}

			ans += calcPrediction2(fullPyramid);
			//fullPyramid.forEach(x -> System.out.println(x));
		}
		
		System.out.println("ans: " + ans);
	}
	
	
	public ArrayList<Integer> calcNextLine(ArrayList<Integer> curList){
		ArrayList<Integer> newLine = new ArrayList<Integer>();
		for(int i = 1; i < curList.size(); i++) {
			newLine.add(curList.get(i) - curList.get(i-1));
		}
		return newLine;
	}
	
	
	public boolean calcSum(ArrayList<Integer> curList) {
		Integer sum = 0;
		for(Integer i : curList) {
			sum += i;
		}
		return (sum == 0) ? true : false;	
	}
	
	
	public Integer calcPrediction(ArrayList<ArrayList<Integer>> fullPyramid) {		
		fullPyramid.get(fullPyramid.size()-1).add(0);
		
		for(int i = fullPyramid.size()-1; i > 0; i--) {
			fullPyramid.get(i-1).add(fullPyramid.get(i).get(fullPyramid.get(i).size()-1) + fullPyramid.get(i-1).get(fullPyramid.get(i-1).size()-1));
		}
		
		fullPyramid.get(fullPyramid.size()-1).add(0);
		
		return fullPyramid.get(0).get(fullPyramid.get(0).size()-1);
	}
	
	
	public Integer calcPrediction2(ArrayList<ArrayList<Integer>> fullPyramid) {		
		fullPyramid.get(fullPyramid.size()-1).add(0);
		
		for(int i = fullPyramid.size()-1; i > 0; i--) {
			fullPyramid.get(i-1).set(0, (fullPyramid.get(i-1).get(0) - fullPyramid.get(i).get(0)));
		}
		
		fullPyramid.get(fullPyramid.size()-1).add(0);
		
		return fullPyramid.get(0).get(0);
	}
}


