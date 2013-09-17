package ReverseWords_ver1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class ReverseWord1 {

	private Stack<String>[] stack;
	private int num, temp = 0;
	private File inputFile;
	private File outputFile;
	private PrintWriter write;
	private Scanner sc1;
	private Scanner sc2;

	@SuppressWarnings("unchecked")
	public ReverseWord1(String name) throws FileNotFoundException {
		super();
		this.inputFile = new File(name);
		this.outputFile = new File(name.substring(0, name.indexOf('.') + 1)
				+ "out");
		this.write = new PrintWriter(outputFile);
		this.temp = 0;
		this.sc1 = new Scanner(this.inputFile);
		this.num = sc1.nextInt();
		this.stack = new Stack[num];
		for (int i = 0; i < this.stack.length; i++) {
			this.stack[i] = new Stack<String>();
		}
		sc1.nextLine();
	}

	public void readFile() {
		while (sc1.hasNextLine()) {
			String s = sc1.nextLine();
			sc2 = new Scanner(s);

			while (sc2.hasNext()) {
				String string = sc2.next();
				stack[temp].push(string);
			}
			temp++;
		}
		sc1.close();
	}

	public void writeFile() throws FileNotFoundException {
		for (int i = 0; i < stack.length; i++) {
			write.print("Case #" + (i + 1) + ": ");
			while (stack[i].size() > 1) {
				write.print(stack[i].pop() + " ");
			}
			write.println(stack[i].pop());
		}
		write.close();
	}

	public static void main(String... args) throws IOException {

		long startTime = System.currentTimeMillis();

		ReverseWord1 sinput = new ReverseWord1(args[0]);
		sinput.readFile();
		sinput.writeFile();
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println(duration);
	}
}
