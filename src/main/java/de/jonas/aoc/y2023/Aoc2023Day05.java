package main.java.de.jonas.aoc.y2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Aoc2023Day05 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 6: Wait For It 
	 */
	
	public void printSolution(){
		calculateSolutionPart1();
		//calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		List<List<Double>> seedToSoilMap = new ArrayList<List<Double>>();
		List<List<Double>> soilToFertilizerMap = new ArrayList<List<Double>>();
		List<List<Double>> fertilizerToWaterMap = new ArrayList<List<Double>>();
		List<List<Double>> waterToLightMap = new ArrayList<List<Double>>();
		List<List<Double>> lightToTemperatureMap = new ArrayList<List<Double>>();
		List<List<Double>> temperatureToHumidityMap = new ArrayList<List<Double>>();
		List<List<Double>> humidityToLocationMap = new ArrayList<List<Double>>();
		
		List<Double> seeds = new ArrayList<Double>();
		
		List<List<List<Double>>> allDicts = new ArrayList<List<List<Double>>>();
		allDicts.add(seedToSoilMap);
		allDicts.add(soilToFertilizerMap);
		allDicts.add(fertilizerToWaterMap);
		allDicts.add(waterToLightMap);
		allDicts.add(lightToTemperatureMap);
		allDicts.add(temperatureToHumidityMap);
		allDicts.add(humidityToLocationMap);		
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resources/AOC2023/Aoc2023Day05.txt"))) {
			String line;
			String nextLine;
			while ((line = br.readLine()) != null) {				
				String firstPart = line.split(":")[0];
				if(firstPart.equals("seeds")) {				
					for(String s : line.split(":")[1].split(" ")) {
						if(s != "") {
							seeds.add(Double.parseDouble(s));
						}
					}				
				}
				
				if(firstPart.equals("seed-to-soil map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						seedToSoilMap.add(tempList);
					}
				}

				if(firstPart.equals("soil-to-fertilizer map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						soilToFertilizerMap.add(tempList);			
					}
				}

				if(firstPart.equals("fertilizer-to-water map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						fertilizerToWaterMap.add(tempList);				
					}
				}

				if(firstPart.equals("water-to-light map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						waterToLightMap.add(tempList);		
					}
				}
				
				if(firstPart.equals("light-to-temperature map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						lightToTemperatureMap.add(tempList);			
					}
				}

				if(firstPart.equals("temperature-to-humidity map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						temperatureToHumidityMap.add(tempList);						
					}
				}
				
				if(firstPart.equals("humidity-to-location map")) {
					while ((nextLine = br.readLine()) != null) {
						List<Double> tempList = new ArrayList<Double>();
						tempList.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempList.add(Double.parseDouble(nextLine.split(" ")[2]));
						humidityToLocationMap.add(tempList);				
					}
				}	
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		Double min = Double.MAX_VALUE;

		// Part1	
		/*for(Double seed : seeds) {
			Double currentValue = seed;
			
			for(List<List<Double>> dic : allDicts) {
				for(List<Double> entries : dic) {
					Double src = entries.get(1), dest = entries.get(0), range = entries.get(2);
					//System.out.println("seed: " + seed + " currentValue: " + currentValue + " src: " + src + " dest: " + dest + " range: " + range);
					//currentValue = (currentValue >= src && currentValue <= (src+range)) ? dest + currentValue - src : currentValue;
					if(currentValue >= src && currentValue < (src+range)) {
						currentValue = dest + currentValue - src;
						break;
					}
				}
			}
			min = (currentValue < min) ? currentValue : min;
		}*/
		
		
		//Part2
		for(int i = 0; i < seeds.size()-1; i += 2) {  //Double seed : seeds) {
			System.out.println("Run: " + i + " current seed: " + seeds.get(i));
			for(Double x = seeds.get(i); x < (seeds.get(i) + seeds.get(i+1)); x++) {
				Double currentValue = x;	
				//System.out.println("currentValue: " + currentValue);
				for(List<List<Double>> dic : allDicts) {
					for(List<Double> entries : dic) {
						Double src = entries.get(1), dest = entries.get(0), range = entries.get(2);
						//System.out.println("seed: " + seed + " currentValue: " + currentValue + " src: " + src + " dest: " + dest + " range: " + range);
						//currentValue = (currentValue >= src && currentValue <= (src+range)) ? dest + currentValue - src : currentValue;
						if(currentValue >= src && currentValue < (src+range)) {
							currentValue = dest + currentValue - src;
							break;
						}
					}
				}
				min = (currentValue < min) ? currentValue : min;
			}
		}	
		
		System.out.println(min);
	}
	
	public void calculateSolutionPart2() {
		/*List<List<List<Double>>> seedToSoilMap = new ArrayList<List<List<Double>>>();
		List<List<List<Double>>> soilToFertilizerMap = new ArrayList<List<List<Double>>>();
		List<List<List<Double>>> fertilizerToWaterMap = new ArrayList<List<List<Double>>>();
		List<List<List<Double>>> waterToLightMap = new ArrayList<List<List<Double>>>();
		List<List<List<Double>>> lightToTemperatureMap = new ArrayList<List<List<Double>>>();
		List<List<List<Double>>> temperatureToHumidityMap = new ArrayList<List<List<Double>>>();
		List<List<List<Double>>> humidityToLocationMap = new ArrayList<List<List<Double>>>();
		
		List<Double> seeds = new ArrayList<Double>();
		
		List<List<List<List<Double>>>> allDicts = new ArrayList<List<List<List<Double>>>>();
		allDicts.add(seedToSoilMap);
		allDicts.add(soilToFertilizerMap);
		allDicts.add(fertilizerToWaterMap);
		allDicts.add(waterToLightMap);
		allDicts.add(lightToTemperatureMap);
		allDicts.add(temperatureToHumidityMap);
		allDicts.add(humidityToLocationMap);		
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/resources/AOC2023/Aoc2023Day05.txt"))) {
			String line;
			String nextLine;
			while ((line = br.readLine()) != null) {				
				String firstPart = line.split(":")[0];
				if(firstPart.equals("seeds")) {				
					for(String s : line.split(":")[1].split(" ")) {
						if(s != "") {
							seeds.add(Double.parseDouble(s));
						}
					}				
				}
				
				if(firstPart.equals("seed-to-soil map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);						
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListTarget);
						seedToSoilMap.add(tempListSrcTarget);
					}
					
				}

				if(firstPart.equals("soil-to-fertilizer map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();					
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);						
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListTarget);
						soilToFertilizerMap.add(tempListSrcTarget);
					}
				}
				
				if(firstPart.equals("fertilizer-to-water map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();				
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);						
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListTarget);
						fertilizerToWaterMap.add(tempListSrcTarget);
					}
				}

				if(firstPart.equals("water-to-light map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();					
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);							
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListTarget);
						waterToLightMap.add(tempListSrcTarget);
					}
				}
				
				if(firstPart.equals("light-to-temperature map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();					
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);							
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListSrc);	
						lightToTemperatureMap.add(tempListSrcTarget);
					}
				}

				if(firstPart.equals("temperature-to-humidity map")) {
					while (!(nextLine = br.readLine()).equals("")) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();					
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);						
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListSrc);	
						temperatureToHumidityMap.add(tempListSrcTarget);
					}
				}
				
				if(firstPart.equals("humidity-to-location map")) {
					while ((nextLine = br.readLine()) != null) {
						List<Double> tempListSrc = new ArrayList<Double>();		
						List<List<Double>> tempListSrcTarget = new ArrayList<List<Double>>();						
						//src						
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]));
						tempListSrc.add(Double.parseDouble(nextLine.split(" ")[1]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);	
						tempListSrcTarget.add(tempListSrc);						
						//target
						List<Double> tempListTarget = new ArrayList<Double>();
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]));
						tempListTarget.add(Double.parseDouble(nextLine.split(" ")[0]) + Double.parseDouble(nextLine.split(" ")[2]) - 1);
						tempListSrcTarget.add(tempListSrc);	
						humidityToLocationMap.add(tempListSrcTarget);
					}
				}	
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		Double min = Double.MAX_VALUE;

		List<List<Double>> currentRanges = new ArrayList<List<Double>>();
		
		for(int j = 0; j < seeds.size()-1; j += 2) {
			List<Double> firstRange = new ArrayList<Double>();
			firstRange.add(seeds.get(j));
			firstRange.add(seeds.get(j) + seeds.get(j+1));
			currentRanges.add(firstRange);	
		}		
		
		
		for(List<List<List<Double>>> dic : allDicts) {
			Collections.sort(dic, new Comparator<List<List<Double>>> () {
			    @Override
			    public int compare(List<List<Double>> a, List<List<Double>> b) {
			        return a.get(0).get(0).compareTo(b.get(1).get(1));
			    }
			});
		}
		
		System.out.println("seedToSoilMap: " + seedToSoilMap);
		
		
		List<Double> currentRange = currentRanges.get(0);
		List<List<Double>> newCurrentRanges = new ArrayList<List<Double>>();		

		
		for(List<List<List<Double>>> dic : allDicts) {
			for(int n = 0; n < dic.size()-1; n += 2) {
				List<Double> src = dic.get(n).get(0);
				List<Double> target = dic.get(n).get(1);
				System.out.println("currentRange: " + currentRange);
				System.out.println("src: " + src + " target " + target);
				
				if(currentRange.get(1) > src.get(0) && currentRange.get(0) < src.get(0)) {
					List<Double> newRange = new ArrayList<Double>();
					newRange.add(currentRange.get(0));
					newRange.add(src.get(0) - 1);
					newCurrentRanges.add(newRange);				
				}
				System.out.println("newCurrentRanges: " + newCurrentRanges);
				break;
			}
			break;
		}
		
		/*
		
		
		
		for(List<Double> currentRange : currentRanges) {			
			
			
			
			for(List<List<List<Double>>> dic : allDicts) {
				
				for(int n = 0; n < dic.size()-1; n += 2) {
					List<Double> src = dic.get(n).get(0);
					List<Double> target = dic.get(n).get(1);
					System.out.println("currentRange: " + currentRange);
					System.out.println("src: " + src + " target " + target);
					
					List<Double> newRange = new ArrayList<Double>();
					
					if((currentRange.get(0) >= src.get(0)) && currentRange.get(0) < src.get(1)) {
						Double newMin = target.get(0) + (currentRange.get(0) - src.get(0));
						Double newMax = target.get(1) - Math.max(0, (src.get(1) - currentRange.get(1)));
						newRange.add(newMin);
						newRange.add(newMax);
						newCurrentRanges.add(newRange);						
					}
				}	
				System.out.println("newCurrentRanges: " + newCurrentRanges);
				break;
			}
			break;
		}
			*/

		

		//System.out.println("ans: " + min);*/
	}	
}

