//STUDENT: Rose Lin
//TEACHER: Mr. Radulovic
//DATE: May 7th, 2019
//DESCRIPTION: Mini ADT Assignment | Adjacency List/Graph Class

import java.util.*;

public class AdjacencyList { // create an adjacency list to store edges

	List<Edge> G[]; // initialize list (type: Edge Class)
	Neighbors c = new Neighbors();
	int size;
	
	public AdjacencyList(int size) { // constructor; creates an empty list
		G = new LinkedList[size]; // linked list
		for (int i = 0; i < G.length; i++) {
			G[i] = new LinkedList<Edge>();
		}
	}

	void addEdge(int u, String head, String v) { // adds edges into AdjList (checks for neighbors)
		if (c.isNeighbor(head, v))
			G[u].add(0, new Edge(v)); // adds neighbors to the list
	}
	
	
}
