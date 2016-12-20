package se.hallis.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBas {
    protected final String INPUT_DIR = "input_data/";

    public String[] hamtaTestdata(String filnamn) {
	List<String> result = new ArrayList<String>();
	try (BufferedReader br = new BufferedReader(new FileReader(INPUT_DIR + filnamn))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		result.add(line);
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return (String[]) result.toArray(new String[0]);
    }

    public List<String> ReadInput(String filnamn) {
	List<String> result = new ArrayList<String>();

	try (Stream<String> stream = Files.lines(Paths.get(INPUT_DIR + filnamn))) {

	    result = stream.collect(Collectors.toList());

	} catch (IOException e) {
	    e.printStackTrace();
	}

	return result;
    }

}
