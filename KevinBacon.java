import java.util.Scanner;
import java.lang.String;
import java.io.IOException;

public class KevinBacon {
	public static FileRead read;
	public static Graph graph;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//again was getting error without ioexception
			
		if (args.length != 1) //if run argument not added
		{
			System.out.println("Direct run configuration to .csv file");
		}
		else
		{
			read = new FileRead(args[0]); //args[0] contians .csv file
			graph = read.read();
			
			boolean cont = true;
			while (cont) {
				System.out.print("Actor 1 name: ");
				String actor1 = input.nextLine();

				System.out.print("Actor 2 name: ");
				String actor2 = input.nextLine();

				String path = graph.findPath(actor1, actor2);

				if (path.equals("")) 
				{
					System.out.println("No path found");
				} else {
					System.out.println("\n" + path + "\n");
				}

				System.out.print("Continue? \nInput Yes(1) or No(2): ");
				String resume = input.nextLine();

				if (resume.equals("2")) 
				{
					System.out.println("Exiting..\n");
					cont = false;
				} else {
					System.out.println("Continuing..\n");
					cont = true;
				}
			}
		}
	}
}
