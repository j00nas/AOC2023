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
		//ArrayList<Integer> TempStarCoordinates = new ArrayList<Integer>();
		HashMap<ArrayList<Integer>, Integer> TempStarCoordinates = new HashMap<ArrayList<Integer>, Integer>();
				
		for(int i = 0; i < engineMap.size(); i++) {
			for(int j = 0; j < engineMap.get(0).size(); j++) {
				if(numbers.contains(engineMap.get(i).get(j))){
					possNumber += engineMap.get(i).get(j);						
					//check left
					if(j > 0) {
						if(engineMap.get(i).get(j-1) == '*' && !numbers.contains(engineMap.get(i).get(j-1))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i, j-1);
						}
					}
					//check right
					if(j < engineMap.get(0).size()-1) {
						if(engineMap.get(i).get(j+1) == '*' && !numbers.contains(engineMap.get(i).get(j+1))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i, j+1);
						}
					}
					//check top
					if(i > 0) {
						if(engineMap.get(i-1).get(j) == '*' && !numbers.contains(engineMap.get(i-1).get(j))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i-1, j);
						}
					}
					//check bottom
					if(i < engineMap.size()-1) {
						if(engineMap.get(i+1).get(j) == '*' && !numbers.contains(engineMap.get(i+1).get(j))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i+1, j);
						}
					}
					//check upper left
					if(i > 0 && j > 0) {
						if(engineMap.get(i-1).get(j-1) == '*' && !numbers.contains(engineMap.get(i-1).get(j-1))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i-1, j-1);
						}
					}
					//check bottom left
					if(i < engineMap.size()-1 && j > 0) {
						if(engineMap.get(i+1).get(j-1) == '*' && !numbers.contains(engineMap.get(i+1).get(j-1))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i+1, j-1);
						}
					}
					//check upper right
					if(i > 0 && j < engineMap.get(0).size()-1) {
						if(engineMap.get(i-1).get(j+1) == '*' && !numbers.contains(engineMap.get(i-1).get(j+1))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i-1, j+1);
						}
					}
					//check bottom right
					if(i < engineMap.size()-1 && j < engineMap.get(0).size()-1) {
						if(engineMap.get(i+1).get(j+1) == '*' && !numbers.contains(engineMap.get(i+1).get(j+1))) {
							numberCounts = true;
							putTempStarCoordinates(TempStarCoordinates, i+1, j+1);
						}
					}					
				}else {		
					if(numberCounts) {							
						for(ArrayList<Integer> coordinates : TempStarCoordinates.keySet()) {							
							Integer[] tempCoordinates = {coordinates.get(0), coordinates.get(1)};
							
							if(starHashmap.isEmpty()) {
								Integer[] newEntry = {Integer.parseInt(possNumber)};
								starHashmap.put(tempCoordinates, newEntry);
							}else{							
								for(Integer[] starHashmapEntries : starHashmap.keySet()) {
									if(starHashmapEntries[0].equals(tempCoordinates[0]) && starHashmapEntries[1].equals(tempCoordinates[1])) {									
										if(starHashmap.get(tempCoordinates) != null) {
											Integer[] newEntry = new Integer[starHashmap.get(tempCoordinates).length + 1];
											for(int k = 0; k < starHashmap.get(tempCoordinates).length; k++) {
												newEntry[k] = starHashmap.get(tempCoordinates)[k];
											}									
											newEntry[starHashmap.get(tempCoordinates).length] = Integer.parseInt(possNumber);
											starHashmap.put(tempCoordinates, newEntry);
										}else {
											Integer[] newEntry = {Integer.parseInt(possNumber)};
											starHashmap.put(tempCoordinates, newEntry);
										}									
									}else {
										Integer[] newEntry = {Integer.parseInt(possNumber)};
										starHashmap.put(tempCoordinates, newEntry);
									}
								}
							}						
						}
					}
					TempStarCoordinates.clear();
					possNumber = "";
					numberCounts = false;
				}
			}
		}
		for(Integer[] test : starHashmap.keySet()) {
			System.out.print("i = " + test[0] + " j = " + test[1] + "   ");
			for(int i : starHashmap.get(test)) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		//starHashmap.forEach((x, y) -> System.out.println(x[0] + " " + y[0]));
		System.out.println(ans);
	}	
	
	public void putTempStarCoordinates(HashMap<ArrayList<Integer>, Integer> tempStar, Integer i, Integer j) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(i);
		temp.add(j);
		if(!tempStar.containsKey(temp)) {
			tempStar.put(temp, null);
		}
	}

}

