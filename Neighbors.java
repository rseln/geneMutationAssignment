//STUDENT: Rose Lin
//TEACHER: Mr. Radulovic
//DATE: May 7th, 2019
//DESCRIPTION: Mini ADT Assignment | Neighbors Class

public class Neighbors {

	boolean isNeighborSwap(String w, String v) { // checks if input is a neighbor of any given node on the graph

		int count = 0;
		// swapping two bases
		int previous = -1, current = -1;
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) != v.charAt(i)) {
				count++;
				if (count > 2)
					return false;

				// store index
				previous = current;
				current = i;
			}
		}
		// compare values and set conditions
		return (count == 2 && w.charAt(previous) == v.charAt(current) && v.charAt(previous) == w.charAt(current)&& current-previous == 1 );
		// if inputs fulfill conditions; neighbor is confirmed
	}

	boolean isNeighborChange(String w, String v) { // checks if input is a neighbor of any given node on the graph
		int count = 0;
		// changing one base (check if the two genes differ by a single letter)
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) != v.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return count == 1; // if inputs fulfill conditions; neighbor is confirmed
	}
	
	boolean isNeighbor(String w, String v) { //combines two rules
		return (isNeighborSwap(w, v) || isNeighborChange(w, v));
	}
	
	
}
