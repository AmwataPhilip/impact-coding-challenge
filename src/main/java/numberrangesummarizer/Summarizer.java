package numberrangesummarizer;

import java.util.Collection;
import java.util.Collections;

public class Summarizer implements NumberRangeSummarizer {

	// collect the input
	public Collection<Integer> collect(String input) {
		Collection<Integer> result = Collections.emptyList(); // Using subinterface method
		String[] inputArray = input.split(","); // adding numbers to array using comma as delimeter
		for (String var : inputArray) {
			result.add(Integer.parseInt(var));
		}
		return result;
	}

	// get the summarized string
	public String summarizeCollection(Collection<Integer> input) {
		String result = "";

		// loop through collection
		for (Integer var : input) {

		}
		// TODO: Check using suitable algorithm
		// TODO: Use toArray() on collection
		// TODO: Use join() on array

		return result;
	}

}
