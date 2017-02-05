package razor.main;

import razor.edge.Edge;
import razor.handle.Handle;

public class Main {
	public static void main(String [] args){
		Handle handle = new Handle();
		Edge edge = new Edge();
		Edge edge1 = new Edge();
		handle.addEdge(edge);
		
		
		System.out.println("Getting a Edge");
		System.out.println("Got an Edge!");
	}
}
