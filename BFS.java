//STUDENT: Rose Lin
//TEACHER: Mr. Radulovic
//DATE: May 7th, 2019
//DESCRIPTION: Mini ADT Assignment | Breadth First Search Class

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	String st;
	String end;
	int size;
	String[] posGenes;
	AdjacencyList adjList;

	public BFS(String st, String end, int size, String[] posGenes, AdjacencyList adjList) {
		this.st = st;
		this.end = end;
		this.size = size;
		this.posGenes = posGenes;
		this.adjList = adjList;
	}

	public int compute() {
		
		//distance array: provides distance between nodes (operates as a visited array and to count the number of mutations)
		int[] distArray = new int [size];
		Arrays.fill(distArray, -1);
		
		Queue<String> que = new LinkedList<>();
		
		que.add(st);
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			if (posGenes[i].equals(st)) { 
				index = i;
			}
		}
		
		distArray[index] = 0;

		if (st == end) {
			return 0;
		}

		while (!que.isEmpty()) {
			String x = que.poll();
			
			//provides index for the string that is removed from the queue
			int u = 0;
			for (int i = 0; i < size; i++) {
				if (posGenes[i].equals(x)) {
					u = i;
				}
			}

			//traverses through the nodes of the adj list
			for (Edge e : adjList.G[u]) { 
				
				//provides an index for the start gene
				int w = 0;
				for (int i = 0; i < size; i++) {
					if (posGenes[i].equals(e.gene)) {
						w = i;
					}
				}
				if (distArray[w]==-1) { //if false (ie. not visited) 
					distArray[w] = distArray[u]+1;
					
					if (e.gene.equals(end)) {
						return distArray[w] ;
					}

					
					que.add(e.gene);
				}
			}
		}
				return -1;
	}
}
