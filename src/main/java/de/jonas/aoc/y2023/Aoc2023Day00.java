package main.java.de.jonas.aoc.y2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Aoc2023Day00 {
	public String getInputDataPath() {
		return "src/main/java/resources/AOC2023/" + this.getClass().getSimpleName() + ".txt";
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
