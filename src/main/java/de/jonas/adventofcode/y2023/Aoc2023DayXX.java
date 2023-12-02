package main.java.de.jonas.adventofcode.y2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Aoc2023DayXX {
	public String getInputDataPath() {
		return "src/main/java/resource/AOC2023/" + this.getClass().getSimpleName() + ".txt";
	}
	
	public List<String> getInputData(){
		List<String> InputData = null;
		try {
			InputData = Files.readAllLines(Paths.get(getInputDataPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return InputData;
	}
}
