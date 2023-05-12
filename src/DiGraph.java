import java.util.ArrayList;

public class DiGraph {
    protected int numberOfNodes;
    protected ArrayList<Integer>[] adjacencyList;

    /**
     * Constructor for a directed graphs with a number of nodes but no edges.
     * @param nodes the number of nodes in the graph
     */
    public DiGraph(int nodes) {
        //initialise the number of nodes
        numberOfNodes = nodes;
        //make the array of ArrayLists
        adjacencyList = new ArrayList [nodes];
        //go through each node and make a new ArrayList for that node
        for (int i = 0; i < nodes; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
    }

    /**
     * Add an edge between the two nodes given
     * @param fromNode the node the edge starts from
     * @param toNode the node that the edge goes to
     */
    public void addEdge(int fromNode, int toNode){
        adjacencyList[fromNode].add(toNode);
    }

    /**
     * Return the number of nodes in the graph
     * @return the number of nodes in the graph
     */
    public int getNumberOfNodes() {return numberOfNodes; }

    /**
     * Determine whether there is an edge between the two nodes given
     * @param fromNode the node the edge starts from
     * @param toNode the node that the edge goes to
     * @return true if there is an edge between fromNode and toNode, false otherwise
     */
    public boolean hasEdge(int fromNode, int toNode) {return adjacencyList[fromNode].contains(toNode); }

    /**
     * Print the adjacency list representation of the graph
     */
    public void printAdjacencyList(){
        System.out.println("Number of nodes = "+ numberOfNodes);
        for (int i = 0; i< adjacencyList.length; i++){
            System.out.print("Neighbours of " + i + " : ");
            for (Integer neighbour: adjacencyList[i]) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }

}
