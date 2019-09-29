all: Summarizer.class NumberRangeSummarizer.class

Summarizer.class: NumberRangeSummarizer.class
	javac numberrangesummarizer/Summarizer.java

NumberRangeSummarizer.class:
	javac numberrangesummarizer/NumberRangeSummarizer.java

run:
	java numberrangesummarizer/Summarizer

clean:
	rm numberrangesummarizer/*.class
