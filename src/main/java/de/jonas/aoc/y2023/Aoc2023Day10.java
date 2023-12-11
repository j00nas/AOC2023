package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;

public class Aoc2023Day10 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 10: Pipe Maze
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		
		ArrayList<ArrayList<Character>> myMap = new ArrayList<ArrayList<Character>>();

		//create map
		for (String line : getInputData()) {
			ArrayList<Character> tempList = new ArrayList<Character>();
			for(String s : line.split("")) {
				tempList.add(s.charAt(0));
			}
			myMap.add(tempList);
		}
		
		//printMap(myMap);
		
		//find start
		ArrayList<Integer> startCoord = new ArrayList<Integer>();
		for(int row = 0; row < myMap.size(); row++) {
			for(int col = 0; col < myMap.get(0).size(); col++) {
				if(myMap.get(row).get(col) == 'S') {
					System.out.println("start found: " + " row: " + row + " col: " + col);
					startCoord.add(row);
					startCoord.add(col);
					break;
				}
			}
		}
		
		double longestPath = traversTroughMap(myMap, startCoord) + 1;
		
		System.out.println("longestPath: " + longestPath);
		System.out.println("maxDistance: " + Math.ceil(longestPath/2));		
	}
	
	public void calculateSolutionPart2() {	
		
	}
	
	
	@SuppressWarnings("unchecked")
	public double traversTroughMap(ArrayList<ArrayList<Character>> myMap, ArrayList<Integer> startCoord) {
		ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> myPath = new ArrayList<ArrayList<Integer>>();
		
		Object myMaxPath = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> myTempMaxPath = new ArrayList<ArrayList<Integer>>();
		
		myPath.add(startCoord);
		
		double longestPath = 0;
		double tempLongestPath = 0;
		
		while(myPath.size() > 0) {
			
			ArrayList<Integer> curPoint = myPath.get(myPath.size()-1);
			int curRow = curPoint.get(0);
			int curCol = curPoint.get(1);			
			char curChar = myMap.get(curRow).get(curCol);
			myTempMaxPath.add(curPoint);
			myPath.remove(myPath.size()-1);

			//System.out.println("curChar: " + curChar + " curRow: " + curRow + " curCol: " + curCol + " tempLongestPath: " + tempLongestPath);

			//check up
			if(curRow > 0 && (curChar == 'S' || curChar == '|' || curChar == 'L' || curChar == 'J')) {
				char upperChar = myMap.get(curRow-1).get(curCol);
				if(upperChar == '|' || upperChar == '7' || upperChar == 'F' || upperChar == 'S') {
					if(upperChar == 'S' && tempLongestPath != 1) {
						longestPath = (tempLongestPath > longestPath) ? tempLongestPath : longestPath;
						tempLongestPath = 0;
						if(myTempMaxPath.size() > ((ArrayList<ArrayList<Character>>) myMaxPath).size()) {
							myMaxPath = myTempMaxPath.clone();
							myTempMaxPath.clear();
						}
					}

					visited.add(curPoint);
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add((curRow -1 ));
					newPoint.add(curCol);
					if(!checkIfVisited(visited, newPoint)) myPath.add(newPoint);
				}
			}
			
			//check right
			if(curCol < myMap.get(0).size()-1 && (curChar == 'S' || curChar == '-' || curChar == 'F' || curChar == 'L')) {
				char rightChar = myMap.get(curRow).get(curCol + 1);
				if(rightChar == '-' || rightChar == 'J' || rightChar == '7' || rightChar == 'S') {
					if(rightChar == 'S' && tempLongestPath != 1) {
						longestPath = (tempLongestPath > longestPath) ? tempLongestPath : longestPath;
						tempLongestPath = 0;
						if(myTempMaxPath.size() > ((ArrayList<ArrayList<Character>>) myMaxPath).size()) {
							myMaxPath = myTempMaxPath.clone();
							myTempMaxPath.clear();
						}
					}
					visited.add(curPoint);
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add((curRow));
					newPoint.add(curCol + 1);
					if(!checkIfVisited(visited, newPoint)) myPath.add(newPoint);
				}
			}
			
			//check bottom
			if(curRow < myMap.size()-1 && (curChar == 'S' || curChar == '|' || curChar == 'F' || curChar == '7')) {
				char bottomChar = myMap.get(curRow + 1).get(curCol);
				if(bottomChar == '|' || bottomChar == 'J' || bottomChar == 'L' || bottomChar == 'S') {
					if(bottomChar == 'S' && tempLongestPath != 1) {					
						longestPath = (tempLongestPath > longestPath) ? tempLongestPath : longestPath;
						tempLongestPath = 0;
						if(myTempMaxPath.size() > ((ArrayList<ArrayList<Character>>) myMaxPath).size()) {
							myMaxPath = myTempMaxPath.clone();
							myTempMaxPath.clear();
						}
					}
					visited.add(curPoint);
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add((curRow + 1));
					newPoint.add(curCol);
					if(!checkIfVisited(visited, newPoint)) myPath.add(newPoint);
				}
			}
			
			//check left
			if(curCol > 0 && (curChar == 'S' || curChar == '-' || curChar == '7' || curChar == 'J')) {
				char leftChar = myMap.get(curRow).get(curCol - 1);
				if(leftChar == '-' || leftChar == 'L' || leftChar == 'F' || leftChar == 'S') {
					if(leftChar == 'S' && tempLongestPath != 1) {
						longestPath = (tempLongestPath > longestPath) ? tempLongestPath : longestPath;
						tempLongestPath = 0;
						if(myTempMaxPath.size() > ((ArrayList<ArrayList<Character>>) myMaxPath).size()) {
							myMaxPath = myTempMaxPath.clone();
							myTempMaxPath.clear();
						}
					}
					visited.add(curPoint);
					ArrayList<Integer> newPoint = new ArrayList<Integer>();
					newPoint.add((curRow));
					newPoint.add(curCol - 1);
					if(!checkIfVisited(visited, newPoint)) myPath.add(newPoint);
				}
			}
			
			tempLongestPath++;	
		}
		
		
		((ArrayList<ArrayList<Integer>>) myMaxPath).add(startCoord);
		ArrayList<ArrayList<Character>> longestMap = printMap2(myMaxPath, myMap);
		
		//printMap(longestMap);
		
		calcInner(longestMap);
		
		//printMap(longestMap);
		
		return longestPath;
	}
	
	public boolean checkIfVisited(ArrayList<ArrayList<Integer>> visited, ArrayList<Integer> curPoint) {
		int curRow = curPoint.get(0);
		int curCol = curPoint.get(1);
		
		for(ArrayList<Integer> visit : visited) {
			int visRow = visit.get(0);
			int visCol = visit.get(1);
			if(visRow == curRow && visCol == curCol) {
				return true;
			}
		}
		return false;		
	}
	
	
	public void calcInner(ArrayList<ArrayList<Character>> longestMap) {
		int ans = 0;
		
		for(int row = 0; row < longestMap.size(); row++) {
			for(int col = 0; col < longestMap.get(0).size(); col++) {
				if(longestMap.get(row).get(col) == '.') {
					double up = 0; double right = 0; double down = 0; double left = 0;

					//count up
					int upRow = row-1;
					if(upRow >= 0) {
						while(upRow >= 0) {
							if(longestMap.get(upRow).get(col) == '-') up += 1;							
							if(longestMap.get(upRow).get(col) == '7' || longestMap.get(upRow).get(col) == 'L') up += 0.5;
							if(longestMap.get(upRow).get(col) == 'J' || longestMap.get(upRow).get(col) == 'F') up -= 0.5;
							upRow--;
						}						
					}
					//count right
					int rightCol = col+1;
					if(rightCol < longestMap.get(0).size()) {						
						while(rightCol < longestMap.get(0).size()) {
							if(longestMap.get(row).get(rightCol) == '|') right += 1;
							if(longestMap.get(row).get(rightCol) == '7' || longestMap.get(row).get(rightCol) == 'L') right += 0.5;
							if(longestMap.get(row).get(rightCol) == 'J' || longestMap.get(row).get(rightCol) == 'F') right -= 0.5;
							rightCol++;
						}
					}
					//count down
					int downRow = row+1;
					if(downRow < longestMap.size()) {						
						while(downRow < longestMap.size()) {
							if(longestMap.get(downRow).get(col) == '-') down += 1;
							if(longestMap.get(downRow).get(col) == '7' || longestMap.get(downRow).get(col) == 'L') down += 0.5;
							if(longestMap.get(downRow).get(col) == 'J' || longestMap.get(downRow).get(col) == 'F') down -= 0.5;
							downRow++;
						}
					}
					//count left
					int leftCol = col-1;
					if(leftCol >= 0) {						
						while(leftCol >= 0) {
							if(longestMap.get(row).get(leftCol) == '|') left += 1;
							if(longestMap.get(row).get(leftCol) == '7' || longestMap.get(row).get(leftCol) == 'L') left += 0.5;
							if(longestMap.get(row).get(leftCol) == 'J' || longestMap.get(row).get(leftCol) == 'F') left -= 0.5;
							leftCol--;
						}
					}
					
				
					
					if(up%2 != 0 || right%2 != 0 || down%2 != 0 || left%2 != 0) {
						//System.out.println("row: " + row + "\tcol: " + col + "\tup: " + up + "\tright: " + right + "\tdown: " + down + "\tleft: "+ left);
						ans++;
						longestMap.get(row).set(col, '®');
						//longestMap.set(longestMap.get(row), longestMap.get(row).)
					}
				}
			}
		}
		
		System.out.println("ans: " + ans);
	}
	
	
	public ArrayList<ArrayList<Character>> printMap2(Object myMaxPath, ArrayList<ArrayList<Character>> myMap) {
		@SuppressWarnings("unchecked")
		ArrayList<ArrayList<Integer>> myMaxPath2 = (ArrayList<ArrayList<Integer>>) myMaxPath;
		
		ArrayList<ArrayList<Character>> longestMap = new ArrayList<ArrayList<Character>>();
		
		boolean found = false;
		//System.out.print("   ");
		for(int i = 0; i < myMap.get(0).size(); i++) {
			//System.out.print(i + " ");
		}
		//System.out.println();
		for(int row = 0; row < myMap.size(); row++) {
			//System.out.print(row + "  ");
			ArrayList<Character> tempLongestRow = new ArrayList<Character>();
			for(int col = 0; col < myMap.get(0).size(); col++) {
				
				if(myMap.get(row).get(col) == 'S') {
					if(row > 0 && (myMap.get(row-1).get(col) == '7' || myMap.get(row-1).get(col) == 'F' || myMap.get(row-1).get(col) == '|')) {
						if(col > 0 && (myMap.get(row).get(col-1) == '-' || myMap.get(row-1).get(col) == 'L' || myMap.get(row).get(col-1) == 'F')) {
							myMap.get(row).set(col, 'J');
						}else{
							myMap.get(row).set(col, 'L');
						}
					}	
					if(row < myMap.size()-1 && (myMap.get(row+1).get(col) == 'L' || myMap.get(row+1).get(col) == '|' || myMap.get(row+1).get(col) == 'J')) {
						if(col > 0 && (myMap.get(row).get(col-1) == '-' || myMap.get(row).get(col-1) == 'L' || myMap.get(row).get(col-1) == 'F')) {
							myMap.get(row).set(col, '7');
						}else{
							myMap.get(row).set(col, 'F');
						}
					}	
				}

				found = false;
				for(ArrayList<Integer> myPath : myMaxPath2) {
					if(myPath.get(0) == row && myPath.get(1) == col) {
						//tempLongestRow.add('o');
						tempLongestRow.add(myMap.get(row).get(col));
						//System.out.print("x" + " ");
						//System.out.print(myMap.get(row).get(col) + " ");
						
						found = true;
						break;
					}
				}
				if(!found) {
					tempLongestRow.add('.');
					//System.out.print(". ");
				}
			}
			longestMap.add(tempLongestRow);
			//System.out.println();
		}
		System.out.println();
		
		return longestMap;
	}	
	
	public void printMap(ArrayList<ArrayList<Character>> myMap) {
		System.out.print("   ");
		for(int i = 0; i < myMap.get(0).size(); i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int row = 0; row < myMap.size(); row++) {
			System.out.print(row + "  ");
			for(int col = 0; col < myMap.get(0).size(); col++) {
				System.out.print(myMap.get(row).get(col) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
		
}


