//STUDENT: Rose Lin
//TEACHER: Mr. Radulovic
//DATE: May 7th, 2019
//DESCRIPTION: Mini ADT Assignment | Main Class

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("src/miniAdtAssignment/DATA.txt")); // read file

		// establish variables (length, size)
		int l = file.nextInt();
		int s = file.nextInt();

		file.nextLine(); // space

		// make the adjList
		AdjacencyList d = new AdjacencyList(s); // empty list
		String[] genes = new String[s];

		for (int i = 0; i < s; i++) {
			genes[i] = file.nextLine(); // fill string array with values
		}

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				d.addEdge(i, genes[i], genes[j]); // add the nodes
			}
		}

		// establish variables (maximum changes, number of genes, before mutation, after
		// mutation)
		int m = file.nextInt();
		int g = file.nextInt();
		String[] p;

		file.nextLine(); // space

		while (file.hasNextLine()) {
			p = file.nextLine().split(" ");
			BFS bfs = new BFS(p[0], p[1], s, genes, d);
			
			//three cases
			if (bfs.compute() != -1 && bfs.compute() <= m) { //if fulfills mutation requirements
				System.out.println("YES");
				System.out.println(bfs.compute());
			}
			if (bfs.compute() == -1 ) { //if path does not exist
				System.out.println("NO");
				System.out.println(bfs.compute());
			}
			if (bfs.compute() != -1 && bfs.compute() >m) { //if path exceeds maximum number of mutations
				System.out.println("NO");
				System.out.println(bfs.compute());
			}


		}
	}

}

