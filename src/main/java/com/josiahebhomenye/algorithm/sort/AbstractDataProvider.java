package com.josiahebhomenye.algorithm.sort;

import java.io.File;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractDataProvider implements DataProvider<String> {
	
	private File dataFile;
	
	public AbstractDataProvider(String pathname){
		dataFile = new File(pathname);
	}
	
	@Override
	public List<String> provide() throws Exception{
		Scanner scanner = new Scanner(dataFile);
		List<String> data = new LinkedList<String>();
		
		while(scanner.hasNextLine()){
			data.add(scanner.nextLine());
		}
		
		scanner.close();
		return data;
	}

}
