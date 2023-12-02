package main.java.de.jonas.adventofcode.y2023;

public class Aoc2023Day02 extends Aoc2023DayXX implements DailySolution {
	/*
	 * AOC2023
	 * Day 2: Cube Conundrum
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {
		int index = 1;
		int ans = 0;
		int ans_p2 = 0;

		for (String line : getInputData()) {
			int maxRed = 0;
			int maxGreen = 0;
			int maxBlue = 0;
			
			String[] eachHandfull = line.split(":");
			String[] eachHand = eachHandfull[1].split(";");
			
			for(String s : eachHand) {
				String[] eachHandColorNumber = s.split(",");

				for(String s2 : eachHandColorNumber) {
					String[] eachHandColorNumberSingle = s2.split(" ");
					//System.out.println("index: " + index + " color: " + eachHandColorNumberSingle[2] + " : " + eachHandColorNumberSingle[1]);
					if(eachHandColorNumberSingle[2].equals("green")) {
						if(Integer.parseInt(eachHandColorNumberSingle[1]) > maxGreen) {
							maxGreen = Integer.parseInt(eachHandColorNumberSingle[1]);
						}
					}else if(eachHandColorNumberSingle[2].equals("blue")) {
						if(Integer.parseInt(eachHandColorNumberSingle[1]) > maxBlue) {
							maxBlue = Integer.parseInt(eachHandColorNumberSingle[1]);
						}
					}else if(eachHandColorNumberSingle[2].equals("red")) {
						if(Integer.parseInt(eachHandColorNumberSingle[1]) > maxRed) {
							maxRed = Integer.parseInt(eachHandColorNumberSingle[1]);
						}
					}					
				}
			}
			//System.out.println("maxGreen: " + maxGreen + " maxRed: " + maxRed + " maxBlue: " + maxBlue);
			if(maxRed <= 12 && maxGreen <= 13 && maxBlue <= 14) {
				ans += index;			
			}	
			ans_p2 += maxGreen*maxRed*maxBlue;
			index++;
		}
		
		System.out.println(ans);
		System.out.println(ans_p2);
	}

	public void calculateSolutionPart2() {
	
	}	
	

}

