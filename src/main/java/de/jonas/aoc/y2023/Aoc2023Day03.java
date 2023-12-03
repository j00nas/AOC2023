package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;
import java.util.HashMap;

public class Aoc2023Day03 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 2: Cube Conundrum
	 */
	
	public void printSolution(){
		//calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {
		ArrayList<ArrayList<Character>> engineMap = new ArrayList<ArrayList<Character>>();

		for (String line : getInputData()) {
			ArrayList<Character> tempArrayList = new ArrayList<Character>();			
			for(int i = 0; i < line.length(); i++){
				tempArrayList.add(line.charAt(i));
			}			
			engineMap.add(tempArrayList);
		}
		
		engineMap.forEach((x) -> System.out.println(x));
		
		ArrayList<Character> numbers = new ArrayList<Character>();		
		for(int k = 0; k <= 9; k++) {
			numbers.add(Integer.toString(k).charAt(0));
		}

		String possNumber = "";
		boolean numberCounts = false;
		int ans = 0;
		
		for(int i = 0; i < engineMap.size(); i++) {
			for(int j = 0; j < engineMap.get(0).size(); j++) {
				if(numbers.contains(engineMap.get(i).get(j))){
					possNumber += engineMap.get(i).get(j);						
					//check left
					if(j > 0) {
						if(engineMap.get(i).get(j-1) != '.' && !numbers.contains(engineMap.get(i).get(j-1))) numberCounts = true;
					}
					//check right
					if(j < engineMap.get(0).size()-1) {
						if(engineMap.get(i).get(j+1) != '.' && !numbers.contains(engineMap.get(i).get(j+1))) numberCounts = true;
					}
					//check top
					if(i > 0) {
						if(engineMap.get(i-1).get(j) != '.' && !numbers.contains(engineMap.get(i-1).get(j))) numberCounts = true;
					}
					//check bottom
					if(i < engineMap.size()-1) {
						if(engineMap.get(i+1).get(j) != '.' && !numbers.contains(engineMap.get(i+1).get(j))) numberCounts = true;
					}
					//check upper left
					if(i > 0 && j > 0) {
						if(engineMap.get(i-1).get(j-1) != '.' && !numbers.contains(engineMap.get(i-1).get(j-1))) numberCounts = true;
					}
					//check bottom left
					if(i < engineMap.size()-1 && j > 0) {
						if(engineMap.get(i+1).get(j-1) != '.' && !numbers.contains(engineMap.get(i+1).get(j-1))) numberCounts = true;
					}
					//check upper right
					if(i > 0 && j < engineMap.get(0).size()-1) {
						if(engineMap.get(i-1).get(j+1) != '.' && !numbers.contains(engineMap.get(i-1).get(j+1))) numberCounts = true;
					}
					//check bottom right
					if(i < engineMap.size()-1 && j < engineMap.get(0).size()-1) {
						if(engineMap.get(i+1).get(j+1) != '.' && !numbers.contains(engineMap.get(i+1).get(j+1))) numberCounts = true;
					}					
				}else {
					if(numberCounts) {
						ans += Integer.parseInt(possNumber);
					}
					possNumber = "";
					numberCounts = false;
				}
			}
		}
		System.out.println(ans);
	}
	

	public void calculateSolutionPart2() {
		ArrayList<ArrayList<Character>> engineMap = new ArrayList<ArrayList<Character>>();

		for (String line : getInputData()) {
			ArrayList<Character> tempArrayList = new ArrayList<Character>();			
			for(int i = 0; i < line.length(); i++){
				tempArrayList.add(line.charAt(i));
			}			
			engineMap.add(tempArrayList);
		}
		
		engineMap.forEach((x) -> System.out.println(x));
		
		ArrayList<Character> numbers = new ArrayList<Character>();		
		for(int k = 0; k <= 9; k++) {
			numbers.add(Integer.toString(k).charAt(0));
		}

		String possNumber = "";
		boolean numberCounts = false;
		int ans = 0;
		
		HashMap<Integer[], Integer[]> starHashmap = new HashMap<Integer[], Integer[]>();
		
		for(int i = 0; i < engineMap.size(); i++) {
			for(int j = 0; j < engineMap.get(0).size(); j++) {
				if(numbers.contains(engineMap.get(i).get(j))){
					possNumber += engineMap.get(i).get(j);						
					//check left
					if(j > 0) {
						if(engineMap.get(i).get(j-1) == '*' && !numbers.contains(engineMap.get(i).get(j-1))) {
							numberCounts = true;
							Integer[] starCoordinate = {i,j-1};
							if(!starHashmap.containsKey(starCoordinate)) {
								starHashmap.put(starCoordinate, null);
							}
						}
					}
					//check right
					if(j < engineMap.get(0).size()-1) {
						if(engineMap.get(i).get(j+1) == '*' && !numbers.contains(engineMap.get(i).get(j+1))) numberCounts = true;
					}
					//check top
					if(i > 0) {
						if(engineMap.get(i-1).get(j) == '*' && !numbers.contains(engineMap.get(i-1).get(j))) numberCounts = true;
					}
					//check bottom
					if(i < engineMap.size()-1) {
						if(engineMap.get(i+1).get(j) == '*' && !numbers.contains(engineMap.get(i+1).get(j))) numberCounts = true;
					}
					//check upper left
					if(i > 0 && j > 0) {
						if(engineMap.get(i-1).get(j-1) == '*' && !numbers.contains(engineMap.get(i-1).get(j-1))) numberCounts = true;
					}
					//check bottom left
					if(i < engineMap.size()-1 && j > 0) {
						if(engineMap.get(i+1).get(j-1) == '*' && !numbers.contains(engineMap.get(i+1).get(j-1))) numberCounts = true;
					}
					//check upper right
					if(i > 0 && j < engineMap.get(0).size()-1) {
						if(engineMap.get(i-1).get(j+1) == '*' && !numbers.contains(engineMap.get(i-1).get(j+1))) numberCounts = true;
					}
					//check bottom right
					if(i < engineMap.size()-1 && j < engineMap.get(0).size()-1) {
						if(engineMap.get(i+1).get(j+1) == '*' && !numbers.contains(engineMap.get(i+1).get(j+1))) numberCounts = true;
					}					
				}else {
					if(numberCounts) {
						ans += Integer.parseInt(possNumber);
					}
					possNumber = "";
					numberCounts = false;
				}
			}
		}
		System.out.println(ans);
	}	
	

}

