package main.java.de.jonas.adventofcode.y2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Aoc2023Day01 extends Aoc2023DayXX implements DailySolution {
	/*
	 * AOC2023
	 * Day 1: Trebuchet?!
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {
		List<String> InputData = getInputData();

		String numbers = "0123456789";
		int ans = 0;
		
		for (String line : InputData) {
			char firstNumber = ' ';
			char lastNumber = ' ';
			String tempAns = "";
			for(int i = 0; i < line.length(); i++) {
				if(new String(numbers).indexOf(line.charAt(i)) != -1) {
					if(firstNumber == ' ') {
						firstNumber = line.charAt(i);
					}
					lastNumber = line.charAt(i);
				}
			}	
			tempAns = String.valueOf(firstNumber) + String.valueOf(lastNumber);
			ans += Integer.parseInt(tempAns);		
		}
		System.out.println(ans);	
	}

	public void calculateSolutionPart2() {
		List<String> InputData = getInputData();
		List<String> possNumbers =  Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");		
		HashMap<String, String> translateStringToInt = new HashMap<String, String>();
		int ans = 0;
		int translatedNumber = 1;
		for(String s: possNumbers) {
			translateStringToInt.put(s, Integer.toString(translatedNumber));
			translatedNumber++;
			if(translatedNumber > 9) {
				translatedNumber = 1;
			}
		}
		
		for (String line : InputData) {
			int smallestIndex = line.length()+1;
			int highestIndex = -1;
			String smallestNumber = "";
			String highestNumber = "";
			String tempAns = "";
			for(String possNumber : possNumbers) {
				int curFirstIndex = line.indexOf(possNumber);
				if(curFirstIndex != -1) {
					if(curFirstIndex < smallestIndex) {
						smallestIndex = curFirstIndex;
						smallestNumber = possNumber;
					}
				}
				int curLastIndex = line.lastIndexOf(possNumber);
				if(curLastIndex != -1) {
					if(curLastIndex > highestIndex) {
						highestIndex = curLastIndex;
						highestNumber = possNumber;
					}
				}
			}
			if(smallestNumber  == "") highestNumber = smallestNumber;
			if(highestNumber == "") smallestNumber = highestNumber;
			tempAns = translateStringToInt.get(smallestNumber) + translateStringToInt.get(highestNumber);	
			ans += Integer.parseInt(tempAns);	
		}
		System.out.println(ans);		
	}	
}

