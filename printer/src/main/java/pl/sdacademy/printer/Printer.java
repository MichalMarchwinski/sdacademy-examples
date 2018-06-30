package pl.sdacademy.printer;

import java.util.Stack;

public class Printer {

	private final int documentThreshold;
	private Stack<Document> printQueue;

	public Printer(int documentsThreshold) {
		this.documentThreshold = documentsThreshold;
		this.printQueue = new Stack<>();
		}

	void print(Document document) {
		printQueue.push(document);
		if (printQueue.size() >= documentThreshold) {
			while(!printQueue.isEmpty())
			printQueue.pop().setPrinted(true);

		}
	}
}
