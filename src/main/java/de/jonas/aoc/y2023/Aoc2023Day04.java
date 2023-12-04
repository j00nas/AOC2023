package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;
import java.util.HashMap;

public class Aoc2023Day04 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 4: Scratchcards
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {		
		double ans = 0;
		double matches = 0;
		
		for (String line : getInputData()) {
			ArrayList<String> winning_numbers = new ArrayList<String>();
			ArrayList<String> my_numbers = new ArrayList<String>();
			
			for(String s : line.split(":")[1].split("\\|")[0].trim().split(" ")) {
				if(s != "") winning_numbers.add(s);
			}
			for(String s : line.split(":")[1].split("\\|")[1].trim().split(" ")) {
				if(s != "") my_numbers.add(s);
			}
			
			matches = 0;
			
			for(String winningNumber : winning_numbers) {	
				for(String myNumber : my_numbers) {
					if(myNumber.equals(winningNumber)) {
						matches++;
					}
				}				
			}
			if(matches > 0) ans += Math.pow(2, matches-1);			
		}
		System.out.println((int) ans);
	}
	

	public void calculateSolutionPart2() {
		int cardnumber = 0;
		int matches = 0;
		
		HashMap<Integer, Integer[]> cardsAndWins = new HashMap<Integer, Integer[]>();
		
		for (String line : getInputData()) {
			ArrayList<String> winning_numbers = new ArrayList<String>();
			ArrayList<String> my_numbers = new ArrayList<String>();
			
			for(String s : line.split(":")[1].split("\\|")[0].trim().split(" ")) {
				if(s != "") winning_numbers.add(s);
			}
			for(String s : line.split(":")[1].split("\\|")[1].trim().split(" ")) {
				if(s != "") my_numbers.add(s);
			}
			
			matches = 0;
			
			for(String winningNumber : winning_numbers) {	
				for(String myNumber : my_numbers) {
					if(myNumber.equals(winningNumber)) {
						matches++;
					}
				}				
			}	
			
			Integer[] tempEntry = new Integer[2];
			tempEntry[0] = matches; //Number of matches
			tempEntry[1] = 1; //Number of cards
			cardsAndWins.put(cardnumber, tempEntry);		
			cardnumber++;			
		}

		int ans = 0;
		
		for(int i = 0; i < cardsAndWins.size(); i++) {
			for(int j = i + 1; j < Math.min(cardsAndWins.size(), i + cardsAndWins.get(i)[0] + 1); j++) {
				Integer[] tempEntry = new Integer[2];
				tempEntry[0] = cardsAndWins.get(j)[0];	//Number of matches keeps the same	
				tempEntry[1] = cardsAndWins.get(j)[1] + cardsAndWins.get(i)[1];	//new Number of cards		
				cardsAndWins.put(j, tempEntry);
			}
			ans += cardsAndWins.get(i)[1];
		}

		System.out.println(ans); 
	}	
}

