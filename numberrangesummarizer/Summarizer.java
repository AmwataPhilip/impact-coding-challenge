package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Summarizer implements NumberRangeSummarizer {

	// collect the input
	public Collection<Integer> collect(String input) {
		List<Integer> intCollection = new ArrayList<Integer>(); // using List for specialised functionality and order
		String[] inputArray = input.split(","); // adding numbers to array using comma as delimeter
		// convert each array element from string to int and add it to the collection
		Arrays.stream(inputArray).forEach(str -> intCollection.add(Integer.parseInt(str)));
		// sort the collection based on natural order
		Collections.sort(intCollection);
		return intCollection;
	}

	// get the summarized string
	public String summarizeCollection(Collection<Integer> input) {
		StringBuilder summarisedResult = new StringBuilder();
		Integer start = 0, end = 0, count = 0, other = 0, duplicateCounter = 0;
		List<Integer> inputList = new ArrayList<Integer>(input);
		// loop through collection
		for (int i = 0; i < inputList.size(); i++) {
			if (i == inputList.size() - 1) {
				other = inputList.get(i);
				summarisedResult.append(other + "");
				break;
			} else if (inputList.get(i + 1) - 1 == inputList.get(i)) {
				if (count == 0) {
					start = inputList.get(i);
				}
				count += 1;
			} else {
				end = inputList.get(i);
				count = 0;
			}

			if (count == 0) {
				summarisedResult.append(end + ",");
				duplicateCounter = 0;
			} else if (count != 0 && duplicateCounter == 0) {
				summarisedResult.append(start + "-");
				duplicateCounter += 1;
			}
		}

		String stringResult = summarisedResult.toString();

		return stringResult;
	}

	public static void main(String[] args) {
		String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31", result = "";
		Summarizer summarizer = new Summarizer();
		Collection<Integer> intCollection = summarizer.collect(input);
		result = summarizer.summarizeCollection(intCollection);

		String outputMessage = "Input: %s\nResult: %s";
		System.out.println(String.format(outputMessage, input, result));
	}

}
