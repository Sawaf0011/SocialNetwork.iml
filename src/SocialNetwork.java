import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SocialNetwork extends DiGraph {
    //Declaring a variable to store in the length of the array of the
    //network members in the Names class
    int num = Names.networkMembers.length;
    /**
     * Constructor for a directed graphs with a number of nodes but no edges.
     *
     * @param nodes the number of nodes in the graph
     */
    //the super constructor for the inherited class from
    public SocialNetwork(int nodes) {
        super(Names.networkMembers.length);
    }


    /**
     * COMPLETE THIS METHOD
     * takes the name of a person and should return an ArrayList of String objects, which contains
     * the names all the followers of person.
     * @param person - the name of the Person to check
     * @return
     */
    public ArrayList<String> broadcastsTo(String person){
        //Declaring ana arrayList of string called names
        ArrayList<String> names = new ArrayList<>();
        //Declaring a variable to store in the result of the
        //method called returnTheIndex
        int index = returnTheIndex(person);
        //setting up a boolean
        boolean condition = true;
        //Setting up a for loop
        for (int i = 0; i <num ; i++) {
            //this is to check if the index in the for loop is equal to the index that
            //we are testing it
            if(i == index)
                //if it is then it going to the second step
                continue;
            //this is to check if the edge is the one that we are trying to retrive from the system
            //if it was then we are going to add it
                if(hasEdge(i, index)){
                    names.add(Names.networkMembers[i]);
                }//if the edge does not exist the boolean is going to be set up to false
                else{
                    condition = false;
                }
        }//this indicates that the edge has not been found then it will return
        //a message indicating g that
        if(condition){
            System.out.println("Edge does not exist");
        }
        //it will return the arrayList of names that edges has been added to
        return names;
    }

    /**
     * COMPLETE THIS METHOD
     * Method takes the name of a person starting a broadcasting a story (source) and the name of the person that the
     * story is broadcast to (target).
     * It uses the refactored depth first search to see if the story will get from the source to the target and
     * should return true if the story will get from the source to the target
     * and false if there is no path from the source to the target.
     * @param source - the name of the Person to check
     * @param target - the name of the target to check
     * @return true if the story will get from the source to the target and false if there is no path from the
     * source to the target.
     * The method uses the Depth First Search
     */
    public boolean canReach(String source, String target) {
        //Declaring an integer variables one to store the fromIndex and other to store the toIndex to store in the index
        // from the method returnTheIndex
        int fromIndex = returnTheIndex(source);
        int toIndex = returnTheIndex(target);
        //returning the boolean value of the DFS method created in the Traversal class
        return Traversal.DFS(adjacencyList, fromIndex, toIndex);
    }

    /**
     * COMPLETE THIS METHOD
     * Method takes the name of a person who has started a story and uses a breadth first search to return an
     * ArrayList of String objects that contains the names of all the person who will receive the story
     * broadcast by that person.
     * @param person name of the person to check
     * @return an ArrayList of String objects that contains the names of all the person who will receive the story
     * This method Breadth First Search
     */
    public ArrayList<String> receiversOf(String person){
        //declaring a variable to store the toIndex value of the person going to
        int toIndex = Arrays.asList(Names.networkMembers).indexOf(person);
        //the if condition, if the index return -1 which is impossible will return null
        if(toIndex == -1){
            return null;
        }
        //Creating an arrayList of String to store in result of the BFS method in the Traversal class
        ArrayList<String> result = Traversal.BFS(adjacencyList, toIndex);
        return result;
    }

    //this method i created is to check if the index of the person matches the name
    //we are trying to find
    public static int returnTheIndex(String person){
        //creating a variable to store in the lenght of the array of strings networkMembers
        int num = Names.networkMembers.length;
        //creating a for loop
        for (int i = 0; i < num; i++) {
            //if the index matches with the index of the name we are trying to find
            //will return the index
            if(Names.networkMembers[i].equals(person)){
                return i;
            }
        }
        //will return the parseInt value of null
        return Integer.parseInt(null);
    }

}