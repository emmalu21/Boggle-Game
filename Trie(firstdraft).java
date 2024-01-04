import java.util.ArrayList;
import java.util.List;

public class Trie {
    char data;
    List<Trie> children;
    Trie prev; // pointer to the previous node
    static Trie root;

    /*
    Trie method takes in a given char and creates an array list(children) 
    */
    public Trie(char data) {
        prev = null; 
        this.data = data;
        children = new ArrayList<>(); // each Trie is a new array list
           
    }
    
    /*
    Add child method connects the created array list for the child to the existing arraylist and
    updates the previous variable to hold the node of the parent
    */
   
    public void addWord(String word, Trie start) {

        //List<Character> childs = getChildren(root);
        Trie node;
        node = start;
        for (int i = 0; i < word.length(); i++) {
            
            char letter = word.charAt(i);
            if (children.contains(letter)) {
                node = children.get(children.indexOf(findNode(node, letter))); // might need to change to children.get(childs.indexOf(letter))
            } else {
                //node = new Trie(letter);
                node.addChild(letter);
                node = findNode(node, letter);
                //childs.add(letter); // idk about this line               

            }
            //System.out.println(children);
            //if (!getChildren(node).isEmpty()) {
              //  children = getChildren(node);
            //}
           // childs.add(getChildren(node));

        }



        //children.add(child); // add a child list to the parent list
        //child.prev = this; // keep track of parent to the child
    }
    public void addChild(char letter) {
        Trie node;
        node = new Trie(letter);
        children.add(node);

    }

    /*
    Get children method creates a new list and after checking to make sure the 
    given node exists, it iterates through the list of children Tries, grabs the data, adds the data to the copy children list
    and returns it 
    */
    
    public static List<Character> getChildren(Trie node) { // change to return list of trees
        List<Character> copychildren = new ArrayList<>();
        if (node != null) {
            for (int i = 0; i < node.children.size(); i++) {
                copychildren.add(node.children.get(i).data);
            }
        }
        return copychildren;
    }

    public static boolean test(String word, Trie start) {
        List<Character> childs = getChildren(start);


        Trie node = null;
        for (int i = 0; i < word.length(); i++) {
            
            char letter = word.charAt(i);
            if (childs.contains(letter)) {
                System.out.println(childs);
                System.out.println("found " + letter);
                node = findNode(start, letter); //children.get(childs.indexOf(letter)); // might need to change to children.get(childs.indexOf(letter))
                childs = getChildren(node);
            } else {
                node = null;
                break; 
            }
        }
        if (node == null) {
            return false;
        } else {
            return true;
        }
    }
    public static Trie findNode(Trie node, char info) {
        if (node == null) {
            return null; // tree does not exist
        }
        if (node.data == info) { // case where info is the root node
            return node; 
        }
        for (int i = 0; i < node.children.size(); i++) {
            Trie result = findNode(node.children.get(i), info); // search through every node
            if (result != null) { // making sure the found node exists
                return result; // returning the node 
            }
        }
        return null; // info not found on the tree
    }

    /*
    main method does nothing
    */  
    public static void main(String[] args) {
    }
}
