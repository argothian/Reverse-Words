package NewProducerConsumerPattern;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

public class ReverseWordsProcessQueue implements Runnable {
	protected BlockingQueue<String> queue1 = null;
	protected BlockingQueue<Stack<String>> queue2 = null;

	public ReverseWordsProcessQueue(BlockingQueue<String> queue1,
			BlockingQueue<Stack<String>> queue2) {
		super();
		this.queue1 = queue1;
		this.queue2 = queue2;
	}

	@Override
	public void run() {
		Stack<String> stack = new Stack<String>();
		Scanner sc;
		try {
		int count = Integer.parseInt(queue1.take());
		for (int i = 0; i < count; i++) {
				sc = new Scanner(queue1.take());
			while (sc.hasNext()) {
				String string = sc.next();
				stack.push(string);
			}
		}
			queue2.put(stack);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stack = new Stack<String>();
	}

}
