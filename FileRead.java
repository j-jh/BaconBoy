import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.lang.String;
import java.util.Scanner;
import java.io.IOException;

public class FileRead {
	private BufferedReader reader;
	public static Graph graph; 
	public static FileRead read;
	static Scanner input = new Scanner(System.in);

	public FileRead(String csvfile) throws IOException { 
	//function takes in args[0] from main function (.csv file) as the string 'csvfile'
		graph = new Graph();
		reader = new BufferedReader(new FileReader(csvfile));
		read(); //graph function called
	}

/*
	note: i got help for this read() function, especially the token 
	and cvs data extraction parts
*/	
	public Graph read() throws IOException {
		//throws ioexception. kept getting errors for all funct without.
		
		String line = null;
		while ((line = reader.readLine()) != null) 
		{
			String[] tokenize = line.split(","); 
			//splits lines from .csv document along comma and tokenizes 
			boolean flag = true;
			ArrayList<String> actors = new ArrayList<String>(); 
			//new array list to store

			for (String token: tokenize) 
			{
				if (flag) 
				{
					if (token.contains("department")) 
					{
						flag = false;
					}
			//got help for below sections
					if (token.contains("name")) {
						actors.add(token.substring(13, token.charAt(token.length() - 1) 
								== '}' ? token.length() - 3: token.length() - 2));
					}
				}
			}
			for (int i = 0; i < actors.size() - 1; i++) {
				for (int j = i + 1; j < actors.size(); j++) {
					graph.addEdge(actors.get(i), actors.get(j));
				}
			}
		}
		return graph;
	}
}
