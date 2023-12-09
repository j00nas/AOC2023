package main.java.de.jonas.aoc.y2023;

import java.util.ArrayList;

public class Aoc2023Day08 extends Aoc2023Day00 implements DailySolution {
	/*
	 * AOC2023
	 * Day 8: Haunted Wasteland
	 */
	
	public void printSolution(){
		//calculateSolutionPart1();
		calculateSolutionPart2();
	}

	public void calculateSolutionPart1() {	
		String myRL = "";
		ArrayList<myNode> myNodes = new ArrayList<myNode>();
		
		for (String line : getInputData()) {
			if(!line.contains("=") && line.length() > 0) {
				myRL = line;
			}else if(line.contains("=")) {
				String name = line.split("=")[0].trim();
				myNode newNode = null;
				
				String nameLeft = line.split("=")[1].split(",")[0].replace('(', ' ').trim();
				String nameRight = line.split("=")[1].split(",")[1].replace(')', ' ').trim();
				
				for(myNode node : myNodes) {
					if(node.name.equals(name)) {
						newNode = node;
					}
				}
				
				if(newNode == null) {
					newNode = new myNode(name);
					myNodes.add(newNode);
				}

				for(myNode node : myNodes) {
					if(node.name.equals(nameLeft)) {
						newNode.left = node;
					}
					if(node.name.equals(nameRight)) {
						newNode.right = node;
					}
				}
								
				if(newNode.left == null && newNode.right == null && nameLeft.equals(nameRight)) {
					newNode.left = new myNode(nameLeft);
					newNode.right = newNode.left;
					myNodes.add(newNode.left);
				}else if(newNode.left == null || newNode.right == null) {						
					if(newNode.left == null) {
						newNode.left = new myNode(nameLeft);
						myNodes.add(newNode.left);
					}
					if(newNode.right == null) {
						newNode.right = new myNode(nameRight);
						myNodes.add(newNode.right);
					}
				}
				//System.out.println("newNode: " + newNode.name + " newNode.name.left: " + newNode.left.name + " newNode.name.right: " + newNode.right.name);
			}
			
		}
		
		System.out.println(myRL);
		//myNodes.forEach(x -> System.out.println("nodes: " + x.name + " ( " + x.left.name + " , " + x.right.name + " )"));
		
		
		
		myNode curNode = null;
		
		for(myNode myNode : myNodes) {
			if(myNode.name.equals("AAA")) {
				curNode = myNode;
				break;
			}
		}
		
		int i = 0;
		int ans = 0;
		while (true) {
			//System.out.println("[vorher] i: " + i + " myRL.charAt(i): " + myRL.charAt(i) + " curNode.name: " + curNode.name);
			ans++;

			switch(myRL.charAt(i)) {
			case 'R':
				curNode = curNode.right;
				break;
			case 'L':
				curNode = curNode.left;
				break;
			}
			
			if(curNode.name.equals("ZZZ")) {
				break;
			}
			
			i++;
			if(i == myRL.length()) i = 0;
			//System.out.println("[nachher] i: " + i + " myRL.charAt(i): " + myRL.charAt(i) + " curNode.name: " + curNode.name);
		}
		
		System.out.println("ans Part1: " + ans);
	}
	

	public void calculateSolutionPart2() {	
		String myRL = "";
		ArrayList<myNode> myNodes = new ArrayList<myNode>();
		
		for (String line : getInputData()) {
			if(!line.contains("=") && line.length() > 0) {
				myRL = line;
			}else if(line.contains("=")) {
				String name = line.split("=")[0].trim();
				myNode newNode = null;
				
				String nameLeft = line.split("=")[1].split(",")[0].replace('(', ' ').trim();
				String nameRight = line.split("=")[1].split(",")[1].replace(')', ' ').trim();
				
				for(myNode node : myNodes) {
					if(node.name.equals(name)) {
						newNode = node;
					}
				}
				
				if(newNode == null) {
					newNode = new myNode(name);
					myNodes.add(newNode);
				}

				for(myNode node : myNodes) {
					if(node.name.equals(nameLeft)) {
						newNode.left = node;
					}
					if(node.name.equals(nameRight)) {
						newNode.right = node;
					}
				}
								
				if(newNode.left == null && newNode.right == null && nameLeft.equals(nameRight)) {
					newNode.left = new myNode(nameLeft);
					newNode.right = newNode.left;
					myNodes.add(newNode.left);
				}else if(newNode.left == null || newNode.right == null) {						
					if(newNode.left == null) {
						newNode.left = new myNode(nameLeft);
						myNodes.add(newNode.left);
					}
					if(newNode.right == null) {
						newNode.right = new myNode(nameRight);
						myNodes.add(newNode.right);
					}
				}
				//System.out.println("newNode: " + newNode.name + " newNode.name.left: " + newNode.left.name + " newNode.name.right: " + newNode.right.name);
			}
			
		}
		
		ArrayList<myNode> nodesToWatch = new ArrayList<myNode>();
		
		for(myNode myNode : myNodes) {
			if(myNode.name.charAt(2) == 'A') {
				nodesToWatch.add(myNode);
			}
		}
		
		//nodesToWatch.forEach(x -> System.out.println("nodes: " + x.name + " ( " + x.left.name + " , " + x.right.name + " )"));

		int i = 0;
		long  ans = 0;
		
		ArrayList<Long> runsToReach = new ArrayList<Long>();

		for(int k = 0; k < nodesToWatch.size(); k++) {
			ans = 0;
			i = 0;
			while (true) {			
				ans++;
				
					switch(myRL.charAt(i)) {
					case 'R':
						nodesToWatch.set(k, nodesToWatch.get(k).right);
						break;
					case 'L':
						nodesToWatch.set(k, nodesToWatch.get(k).left);
						break;
					}
				
					if(nodesToWatch.get(k).name.charAt(2) == 'Z') {					
						runsToReach.add(ans);
						//System.out.println("Node: " + k + " ans: " + ans + " i: " + i + " nodesToWatch.get(k).name: " + nodesToWatch.get(k).name);			
						break;
					}
				i++;
				if(i == myRL.length()) i = 0;
			}
		}
		
		System.out.println("runsToReach: " + runsToReach);
		long finalAns = 0;
		finalAns = lcm(runsToReach);
		System.out.println("finalAns: " + finalAns);
	}	
	
	private static long lcm(ArrayList<Long> input)
	{
		long  result = input.get(0);
	    for(int i = 1; i < input.size(); i++) result = lcm(result, input.get(i));
	    return result;
	}
	
	private static long lcm(long  a, long  b)
	{
	    return a * (b / gcd(a, b));
	}
	
	private static long gcd(long  a, long  b)
	{
	    while (b > 0)
	    {
	    	long  temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
}


