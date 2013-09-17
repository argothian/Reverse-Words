package ProdecerConsumerPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

public class ReverseWordsProducer implements Runnable {

	protected BlockingQueue<Stack<String>> queue = null;
	private File inputFile;
	private Scanner sc1;

	public ReverseWordsProducer(BlockingQueue<Stack<String>> queue, String name)
			throws FileNotFoundException, InterruptedException {
		super();
		this.queue = queue;
		this.inputFile = new File(name);
		this.sc1 = new Scanner(this.inputFile);
	}

	@Override
	public void run() {
		Stack<String> stack = new Stack<String>();
		Scanner sc2;
		while (sc1.hasNextLine()) {
			String s = sc1.nextLine();
			sc2 = new Scanner(s);

			while (sc2.hasNext()) {
				String string = sc2.next();
				stack.push(string);
			}
			try {
				queue.put(stack);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stack = new Stack<String>();
		}
		sc1.close();
	}
}