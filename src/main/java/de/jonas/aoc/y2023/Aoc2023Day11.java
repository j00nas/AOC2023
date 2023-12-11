package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;

public class Aoc2023Day11 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 10: Pipe Maze
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		ArrayList<ArrayList<Character>> galaxy = new ArrayList<ArrayList<Character>>();
		
		for (String line : getInputData()) {
			ArrayList<Character> curCol = new ArrayList<Character>();
			for(String s : line.split("")) {
				curCol.add(s.charAt(0));
			}
			galaxy.add(curCol);			
		}
		
		//expandGalaxy(galaxy);	
		ArrayList<ArrayList<Integer>> galaxyIndices = findAllGalaxies(galaxy);
		
		ArrayList<ArrayList<Integer>> CoordinatesWhichExpand = findCoordinatesWhichExpand(galaxy);
		
		System.out.println(CoordinatesWhichExpand);
		//printGalaxy(galaxy);
		//System.out.println("galaxyIndices: " + galaxyIndices);
		
		//int ans = calcDistances(galaxyIndices);
		
		long ans = calcDistances2(galaxyIndices, CoordinatesWhichExpand, 1000000);
		System.out.println("ans: " + ans);
	}
	
	public void calculateSolutionPart2() {	
		
	}
	
	public long calcDistances2(ArrayList<ArrayList<Integer>> galaxyIndices, ArrayList<ArrayList<Integer>> CoordinatesWhichExpand, long extandFactor) {
		long ans = 0;
		
		for(int i = 0; i < galaxyIndices.size()-1; i++) {
			for(int j = i+1; j < galaxyIndices.size(); j++) {
				long x1 = galaxyIndices.get(i).get(0);
				long y1 = galaxyIndices.get(i).get(1);
				long x2 = galaxyIndices.get(j).get(0);
				long y2 = galaxyIndices.get(j).get(1);				
				long Mindistance = Math.abs((x1-x2)) + Math.abs((y1-y2));
				
				//rows
				for(Integer row : CoordinatesWhichExpand.get(0)) {
					if(row > Math.min(x1, x2) && row < Math.max(x1, x2)) {
						ans += extandFactor-1;
					}
				}
				
				//cols
				for(Integer col : CoordinatesWhichExpand.get(1)) {
					if(col > Math.min(y1, y2) && col < Math.max(y1, y2)) {
						ans += extandFactor-1;
					}					
				}

				ans += Mindistance;
				//System.out.println("pair: " + pair + " " + galaxyIndices.get(i) + " " + galaxyIndices.get(j) + " distance: " + Mindistance);
				//pair++;
			}
		}
		return ans;	
	}
	
	
	
	
	public Integer calcDistances(ArrayList<ArrayList<Integer>> galaxyIndices) {
		//int pair = 1;
		int ans = 0;
		for(int i = 0; i < galaxyIndices.size()-1; i++) {
			for(int j = i+1; j < galaxyIndices.size(); j++) {
				int x1 = galaxyIndices.get(i).get(0);
				int y1 = galaxyIndices.get(i).get(1);
				int x2 = galaxyIndices.get(j).get(0);
				int y2 = galaxyIndices.get(j).get(1);
				
				int Mindistance = Math.abs((x1-x2)) + Math.abs((y1-y2));
				
				ans += Mindistance;
				//System.out.println("pair: " + pair + " " + galaxyIndices.get(i) + " " + galaxyIndices.get(j) + " distance: " + Mindistance);
				//pair++;
			}
		}
		return ans;
	}
	
	
	
	public ArrayList<ArrayList<Integer>> findAllGalaxies(ArrayList<ArrayList<Character>> galaxy) {
		ArrayList<ArrayList<Integer>> galaxyIndices = new ArrayList<ArrayList<Integer>>();
		
		for(int row = 0; row < galaxy.size(); row++) {
			for(int col = 0; col < galaxy.get(0).size(); col++) {
				if(galaxy.get(row).get(col) == '#'){
					ArrayList<Integer> indices = new ArrayList<Integer>();
					indices.add(row);
					indices.add(col);
					galaxyIndices.add(indices);
				}
			}
		}

		return galaxyIndices;
	}
	
	
	
	public ArrayList<ArrayList<Integer>> findCoordinatesWhichExpand(ArrayList<ArrayList<Character>> galaxy){
		ArrayList<ArrayList<Integer>> coordinatesThatExpand = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> coordRows = new ArrayList<Integer>();
		ArrayList<Integer> coordColumns = new ArrayList<Integer>();
		
		for(int row = 0; row < galaxy.size(); row++) {		
			if(!galaxy.get(row).contains('#')) {
				coordRows.add(row);
			}
		}
		
		for(int col = 0; col < galaxy.get(0).size(); col++) {
			boolean findHashTag = false;
			for(int row = 0; row < galaxy.size(); row++) {
				if(galaxy.get(row).get(col) == '#') {
					findHashTag = true;
				}
			}			
			if(!findHashTag) {
				coordColumns.add(col);
			}
		}	
		
		coordinatesThatExpand.add(coordRows);
		coordinatesThatExpand.add(coordColumns);
		return coordinatesThatExpand;
	}
	
	
	public void expandGalaxy(ArrayList<ArrayList<Character>> galaxy) {
		ArrayList<Character> newCol = new ArrayList<Character>();
		for(int row = 0; row < galaxy.size(); row++) {
			newCol.add('.');
		}
		
		//insert new columns
		for(int row = 0; row < galaxy.size(); row++) {		
			if(!galaxy.get(row).contains('#')) {
				galaxy.add(row, newCol);
				row++;
				if(row == galaxy.size()) break;
			}
		}

		//insert new rows
		for(int col = 0; col < galaxy.get(0).size(); col++) {
			boolean findHashTag = false;
			for(int row = 0; row < galaxy.size(); row++) {
				if(galaxy.get(row).get(col) == '#') {
					findHashTag = true;
				}
			}			
			if(!findHashTag) {
				for(int row = 0; row < galaxy.size(); row++) {
					galaxy.get(row).add(col, '.');
				}
				col++;	
				if(col == galaxy.get(0).size()) break;
			}
		}	
	}
	
	
	
	
	
	public void printGalaxy(ArrayList<ArrayList<Character>> galaxy) {		
		for(int row = 0; row < galaxy.size(); row++) {
			for(int col = 0; col < galaxy.get(0).size(); col++) {
				System.out.print(galaxy.get(row).get(col));
			}
			System.out.println();
		}		
	}
		
}


