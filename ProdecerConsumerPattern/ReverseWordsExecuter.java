package ProdecerConsumerPattern;


import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReverseWordsExecuter {

	private static final ExecutorService exec = Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws FileNotFoundException,
			InterruptedException {
		BlockingQueue<Stack<String>> queue = new ArrayBlockingQueue<Stack<String>>(
				1024);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 1000; i++) {
			ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(new ReverseWordsProducer(queue, args[0]));
		exec.submit(new ReverseWordsConsumer(queue, args[0]));
		exec.shutdown();

		exec.awaitTermination(1, TimeUnit.MINUTES);
		}
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println(duration);
	}
}
