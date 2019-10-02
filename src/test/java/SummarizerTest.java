import numberrangesummarizer.Summarizer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummarizerTest {

	@Test
	public void collectStringShouldReturnSortedList() {
		Summarizer testClass = new Summarizer();
		String input = "5,0,2,1";
		List<Integer> result = new ArrayList<>();
		result.add(0);result.add(1);result.add(2);result.add(5);

		assertEquals(result, testClass.collect(input));

	}

	@Test
	public void summarizingSortedListWithRangesShouldReturnSummarizedString() {
		Summarizer testClass = new Summarizer();
		List<Integer> input = new ArrayList<>();
		input.add(0);input.add(1);input.add(2);input.add(3);
		String result = "0-3";

		assertEquals(result, testClass.summarizeCollection(input));

	}

	@Test
	public void summarizingSortedListNoRangesShouldReturnSummarizedString() {
		Summarizer testClass = new Summarizer();
		List<Integer> input = new ArrayList<>();
		input.add(5);input.add(8);input.add(13);input.add(21);
		String result = "5,8,13,21";

		assertEquals(result, testClass.summarizeCollection(input));

	}

	@Test
	public void summarizingEmptyListNoRangesShouldReturnEmptyString() {
		Summarizer testClass = new Summarizer();
		List<Integer> input = new ArrayList<>();
		String result = "";

		assertEquals(result, testClass.summarizeCollection(input));

	}
}
