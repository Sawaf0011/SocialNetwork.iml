import java.util.ArrayList;

public class Traversal {
    /**
     * REFACTOR THIS METHOD
     * Perform a BFS traversal of the graph, printing the nodes in the order visited
     * this method was refractored to be used in the method recieversOf in the SocialNetwork class
     * so it was changed to return an arrayList of strings
     */
    public static ArrayList<String> BFS(ArrayList<Integer>[] adjList, Integer startNode) {
        //create the list of visited nodes and the queue
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        Queue theQueue = new ArrayQueue();

        //mark the start as visited and put it in the Queue
        visitedNodes.add(startNode);
        theQueue.enqueue(startNode);

        while(!theQueue.isEmpty()){
            Integer item = (Integer) theQueue.dequeue();
            //mark all the neighbours of the item which have not been visited as visited and add them to the queue
            for (Integer neighbour:adjList[item]){
                if (!visitedNodes.contains(neighbour)){
                    visitedNodes.add(neighbour);
                    theQueue.enqueue(neighbour);
                }
            }
        }
        //a new arrayList of string is initialised
        ArrayList<String> seenNames = new ArrayList<>();
        //a for loop created
        for(Integer nodes : visitedNodes){
            //if the node does not match the node that we are searching for
            if(nodes!=startNode){
                //the name will be added to the arrayList we initialised
                seenNames.add(Names.networkMembers[nodes]);
            }
        }
        return seenNames;
    }

    /**
     * REFACTOR THIS METHOD
     * Perform a DFS traversal of the graph
     * The refactored method will return true if the destinationNode is encountered in the subgraph descending from
     * startNode
     * This method was refactored to be used in the SocialNetwork class in the method called canReach
     * to return a boolean
     */
    public static boolean DFS(ArrayList<Integer>[] adjList, Integer startNode, Integer endNode){

        //create the list of visited nodes and the stack
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        Stack theStack = new ArrayStack();

        //mark the start as visited and put it in the stack
        visitedNodes.add(startNode);
        theStack.push(startNode);

        while(!theStack.isEmpty()) {
            Integer item = (Integer) theStack.pop();

            //mark all the neighbours of the item which have not been visited as visited and add them to the stack
            for (Integer neighbours : adjList[item]) {
                if (!visitedNodes.contains(neighbours)) {
                    visitedNodes.add(neighbours);
                    theStack.push(neighbours);
                }
            }
        }
        return visitedNodes.contains(endNode);
    }
}
