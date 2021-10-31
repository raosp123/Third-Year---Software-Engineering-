import java.lang.reflect.Array;
import java.util.*;

class DAG
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    public int depth[];

    // Constructor
    DAG(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
        depth = new int[V];
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    //setup function for recursive, gets all ancestors of node a
    public ArrayList<Integer> getAllAncestors(int a){
        Set<Integer> allAncestors = new LinkedHashSet<Integer>();
        Set<Integer> ancestorsSet = getAllAncestors(a,allAncestors);
        ancestorsSet.add(a);//add itself to set

        ArrayList<Integer> finalAncestors = new ArrayList<>(ancestorsSet);
        return finalAncestors;
    }

    //recursive function that gets all ancestors of a node, i.e parents of parents, and puts it into an ArrayList set
    public Set<Integer> getAllAncestors(int node, Set<Integer> ancestorAccumulator) {

        ArrayList<Integer> immediateParents = parentsOf(node); //immediate parents of current node
        ancestorAccumulator.addAll(immediateParents);

        if(immediateParents.size()>0) {
            for (int i = 0; i < immediateParents.size(); i++) {
                ancestorAccumulator.addAll(getAllAncestors(immediateParents.get(i), ancestorAccumulator));
            }
        }
        return ancestorAccumulator;
    }

    //function to get an arraylist of parents of a node
    public ArrayList<Integer> parentsOf(int node){
        ArrayList<Integer> parents = new ArrayList<Integer>();
        Iterator<Integer> iterator;

        //loops through all nodes in graph
        for(int i=0; i< adj.length; i++) {

            //iterator for linkedlist
            iterator = adj[i].listIterator();

            //loop to check if i is a parent of node
            while(iterator.hasNext()) {
                if (iterator.next()==node){
                     parents.add(i);
                }
            }
        }
        return parents;

    }

    // BFS algorithm
    public void BFS(int s) {
        if(adj.length!=0) {
            boolean visited[] = new boolean[V];

            LinkedList<Integer> queue = new LinkedList();

            visited[s] = true;
            queue.add(s);

            int count = 1;

            while (queue.size() != 0) {
                s = queue.poll();
                //System.out.print(s + " ");

                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    //System.out.println(n);
                    depth[n] = count;
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
                count++;
            }
        }else{
            System.out.println("Graph does not exist");
        }
    }

    public int depth(int v){
        return depth[v];
    }

    //returns the maximum depth of values in graph
    public int getMaxDepth(ArrayList<Integer> values){
        int maxDepth = 0;
        for(int i=0; i<values.size();i++){
            if (depth[values.get(i)]>maxDepth){
                maxDepth = depth[values.get(i)];
            }
        }
        return maxDepth;
    }

    //returns the LCAs of two nodes
    public ArrayList<Integer> LCA(int p, int q){
        ArrayList<Integer> lca = new ArrayList<>();
        ArrayList<Integer> temp1 = getAllAncestors(p);
        ArrayList<Integer> temp2 = getAllAncestors(q);

        temp1.retainAll(temp2);
        int maxDepth = getMaxDepth(temp1);

        //loop to check which nodes share the same max depth, since they are all LCAs of the original nodes p and q
        for(int i=0; i<temp1.size();i++){
            if(depth(temp1.get(i))==maxDepth){
                lca.add(temp1.get(i));
            }
        }
        return lca;
    }

    // Driver method to
    public static void main(String args[])
    {
        DAG g = new DAG(9);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 4);
        g.addEdge(1, 6);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 6);
        g.addEdge(3, 6);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(7, 8);

        g.BFS(0);//BFS used to initliase depth values

        System.out.println(g.LCA(6,7));

    }
}
