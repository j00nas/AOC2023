package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aoc2023Day07 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 7: Camel Cards
	 */
	
	public void printSolution(){
		//calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		List<List<String>> drawnCards = new ArrayList<List<String>>();
		
		for (String line : getInputData()) {
			List<String> curCard = new ArrayList<String>();
			curCard.add(line.split(" ")[0]);
			curCard.add(line.split(" ")[1]);
			drawnCards.add(curCard);			
		}
		
		//BubbleSort
		int i = 0;
		while(i < drawnCards.size()-1) {
			String card1 = drawnCards.get(i).get(0);
			String card2 = drawnCards.get(i+1).get(0);
			
			//System.out.println("card1: " + card1 + "  card2:" + card2);
			if(compareCards(card1, card2)) {
				List<String> tempCard = drawnCards.get(i);
				drawnCards.set(i,  drawnCards.get(i+1));
				drawnCards.set(i+1, tempCard);
				if(i > 0) i--;
			}else {
				i++;
			}

		}
		
		System.out.println("drawnCards: " + drawnCards);
		double ans = 0;
		int rank = 1;
		for(List<String> card : drawnCards) {
			ans += (rank * Double.parseDouble(card.get(1)));
			rank++;
		}
		System.out.println(ans);
	}

	public boolean compareCards(String card1, String card2){
		Integer card1Hand = calculateHand(card1);
		Integer card2Hand = calculateHand(card2);
		//System.out.println("card1: " + card1 + "  card1Hand: " + card1Hand);
		//System.out.println("card2: " + card2 + "  card2Hand: " + card2Hand);
		
		if(card1Hand > card2Hand) return true;
		if(card1Hand == card2Hand) {
			HashMap<Character, Integer> cardValues = new HashMap<Character, Integer>();
			cardValues.put('A', 13);
			cardValues.put('K', 12);
			cardValues.put('Q', 11);
			cardValues.put('J', 10);
			cardValues.put('T', 9);
			cardValues.put('9', 8);
			cardValues.put('8', 7);
			cardValues.put('7', 6);
			cardValues.put('6', 5);
			cardValues.put('5', 4);
			cardValues.put('4', 3);
			cardValues.put('3', 2);
			cardValues.put('2', 1);
			for(int i = 0; i < card1.length(); i++) {
				if(cardValues.get(card1.charAt(i)) > cardValues.get(card2.charAt(i))) {
					return true;
				}else if(cardValues.get(card1.charAt(i)) < cardValues.get(card2.charAt(i))){
					return false;
				}
			}
		}
		return false;
	}
	
	public Integer calculateHand(String card) {		
		Integer hand = 1;
		
		HashMap<Character, Integer> existingChars = new HashMap<Character, Integer>();
		for(int i = 0; i < card.length(); i++) {
			if(existingChars.containsKey(card.charAt(i))){
				existingChars.put(card.charAt(i), existingChars.get(card.charAt(i)) + 1);
			}else {
				existingChars.put(card.charAt(i), 1);
			}
		}
		
		if(existingChars.size() == 1) return 7; //FIVE
		if(existingChars.size() == 2) {
			for(Integer value : existingChars.values()) {
				if(value == 4) return 6; //FOUR
			}
			return 5; //FULL HOUSE
		}		
		if(existingChars.size() == 3) { 
			for(Integer value : existingChars.values()) {
				if(value == 3) return 4; //THREE	
			}		
			return 3; //TWO PAIRS
		}
		
		if(existingChars.size() == 4) {
			return 2; //PAIR
		}
		
		return hand;
	}
	
	

	
	
	
	
	public void calculateSolutionPart2() {	
		List<List<String>> drawnCards = new ArrayList<List<String>>();
		
		for (String line : getInputData()) {
			List<String> curCard = new ArrayList<String>();
			curCard.add(line.split(" ")[0]);
			curCard.add(line.split(" ")[1]);
			drawnCards.add(curCard);			
		}
		
		//BubbleSort
		int i = 0;
		while(i < drawnCards.size()-1) {
			String card1 = drawnCards.get(i).get(0);
			String card2 = drawnCards.get(i+1).get(0);
			
			//System.out.println("card1: " + card1 + "  card2:" + card2);
			if(compareCards2(card1, card2)) {
				List<String> tempCard = drawnCards.get(i);
				drawnCards.set(i,  drawnCards.get(i+1));
				drawnCards.set(i+1, tempCard);
				if(i > 0) i--;
			}else {
				i++;
			}

		}
		
		System.out.println("drawnCards: " + drawnCards);
		double ans = 0;
		int rank = 1;
		for(List<String> card : drawnCards) {
			ans += (rank * Double.parseDouble(card.get(1)));
			rank++;
		}
		System.out.println(ans);
	}

	public boolean compareCards2(String card1, String card2){
		Integer card1Hand = calculateHand2(card1);
		Integer card2Hand = calculateHand2(card2);
		//System.out.println("card1: " + card1 + "  card1Hand: " + card1Hand);
		//System.out.println("card2: " + card2 + "  card2Hand: " + card2Hand);
		
		if(card1Hand > card2Hand) return true;
		if(card1Hand == card2Hand) {
			HashMap<Character, Integer> cardValues = new HashMap<Character, Integer>();
			cardValues.put('A', 13);
			cardValues.put('K', 12);
			cardValues.put('Q', 11);			
			cardValues.put('T', 10);
			cardValues.put('9', 9);
			cardValues.put('8', 8);
			cardValues.put('7', 7);
			cardValues.put('6', 6);
			cardValues.put('5', 5);
			cardValues.put('4', 4);
			cardValues.put('3', 3);
			cardValues.put('2', 2);
			cardValues.put('J', 1);
			for(int i = 0; i < card1.length(); i++) {
				if(cardValues.get(card1.charAt(i)) > cardValues.get(card2.charAt(i))) {
					return true;
				}else if(cardValues.get(card1.charAt(i)) < cardValues.get(card2.charAt(i))){
					return false;
				}
			}
		}
		return false;
	}
	
	public Integer calculateHand2(String card) {		
		Integer hand = 1;
		int joker = 0;
		
		HashMap<Character, Integer> existingChars = new HashMap<Character, Integer>();
		for(int i = 0; i < card.length(); i++) {
			if(card.charAt(i) != 'J') {
				if(existingChars.containsKey(card.charAt(i))){
					existingChars.put(card.charAt(i), existingChars.get(card.charAt(i)) + 1);
				}else {
					existingChars.put(card.charAt(i), 1);
				}
			}else {
				joker++;
			}
		}
		
		HashMap<Character, Integer> cardValues = new HashMap<Character, Integer>();
		cardValues.put('A', 13);
		cardValues.put('K', 12);
		cardValues.put('Q', 11);			
		cardValues.put('T', 10);
		cardValues.put('9', 9);
		cardValues.put('8', 8);
		cardValues.put('7', 7);
		cardValues.put('6', 6);
		cardValues.put('5', 5);
		cardValues.put('4', 4);
		cardValues.put('3', 3);
		cardValues.put('2', 2);
		cardValues.put('J', 1);
		
		if(joker == 5) {
			return 7;
		}else if(joker > 0) {
			int highestNumber = 0;
			Character highestCorrespondingCard = 0;
			for(Character key : existingChars.keySet()) {
				if(existingChars.get(key) > highestNumber) {
					highestNumber = existingChars.get(key);
					highestCorrespondingCard = key;
				}else if(existingChars.get(key) == highestNumber) {
					if(cardValues.get(key) > cardValues.get(highestCorrespondingCard)) {
						highestCorrespondingCard = key;
					}
				}
			}
			existingChars.put(highestCorrespondingCard, existingChars.get(highestCorrespondingCard) + joker);
		}

		if(existingChars.size() == 1) return 7; //FIVE
		if(existingChars.size() == 2) {
			for(Integer value : existingChars.values()) {
				if(value == 4) return 6; //FOUR
			}
			return 5; //FULL HOUSE
		}		
		if(existingChars.size() == 3) { 
			for(Integer value : existingChars.values()) {
				if(value == 3) return 4; //THREE	
			}		
			return 3; //TWO PAIRS
		}
		
		if(existingChars.size() == 4) {
			return 2; //PAIR
		}
		
		return hand;
	}
	
}

