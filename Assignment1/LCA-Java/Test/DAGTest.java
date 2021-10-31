import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DAGTest {

    @Test
    public void testLCA()  {
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

        ArrayList<Integer> comparisonValues = new ArrayList<Integer>(Arrays.asList(1,2));
        ArrayList<Integer> testValues = g.LCA(4,7);
        assertEquals(comparisonValues,testValues);
    }

    @Test
    public void testEmptyGraph()  {
        DAG g = new DAG(0);
        g.BFS(0);//BFS used to initliase depth values

        ArrayList<Integer> comparisonValues = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> testValues = g.LCA(4,7);
        assertEquals(comparisonValues,testValues);
    }

    @Test
    public void testNodeIsLca()  {
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

        ArrayList<Integer> comparisonValues = new ArrayList<Integer>(Arrays.asList(6));
        ArrayList<Integer> testValues = g.LCA(6,7);
        assertEquals(comparisonValues,testValues);
    }

    @Test
    public void testNoLCA()  {
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

        ArrayList<Integer> comparisonValues = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Integer> testValues = g.LCA(3,9);
        assertEquals(comparisonValues,testValues);
    }




}