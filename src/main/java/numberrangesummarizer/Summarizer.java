package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Summarizer implements NumberRangeSummarizer {

	// collect the input
	public Collection<Integer> collect(String input) {
		List<Integer> intCollection = new ArrayList<>(); // using List for specialised functionality and order
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
		int count = 0;
		List<Integer> inputList = new ArrayList<>(input);
		// loop through collection
		for (int i = 0; i < inputList.size(); i++) {
			if (i == inputList.size() - 1) { // Last element
				summarisedResult.append(inputList.get(i));
				break;
			} else if (inputList.get(i + 1) - 1 == inputList.get(i)) { // Check if can be aggregated into a range
				if (count == 0) { // if the element is the start of the range add to stringBuilder
					summarisedResult.append(inputList.get(i)).append("-");
				}
				count += 1;
			} else { // if can't be aggregated just add to stringBuilder
				summarisedResult.append(inputList.get(i)).append(",");
				count = 0;
			}
		}

		return summarisedResult.toString();
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
