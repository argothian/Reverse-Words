package ProdecerConsumerPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;

class ReverseWordsConsumer implements Runnable {
	protected BlockingQueue<Stack<String>> queue = null;
	private File outputFile;
	private PrintWriter write;
	private int count;

	public ReverseWordsConsumer(BlockingQueue<Stack<String>> queue, String name)
			throws FileNotFoundException {
		super();
		this.queue = queue;
		this.outputFile = new File(name.substring(0, name.indexOf('.') + 1)
				+ "out");
		this.write = new PrintWriter(outputFile);
	}

	@Override
	public void run() {
		Stack<String> stack = new Stack<String>();
		try {
			count = Integer.parseInt(queue.take().pop());
			for (int i = 0; i < count; i++) {
				stack = (Stack<String>) queue.take();
				write.print("Case #" + (i + 1) + ": ");
				while (stack.size() > 1) {
					write.print(stack.pop() + " ");
				}
				write.println(stack.pop());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			write.close();
		}
	}
}