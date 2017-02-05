package razor.handle;

import java.util.List;

import razor.edge.Edge;

public class Handle {

	private List<Edge> edges;
	
	public List<Edge> getEdges(){
		return edges;
	}
	
	public boolean addEdge(Edge edge){
		return edges.add(edge);
	}
	
}
