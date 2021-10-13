import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void testMissing()  {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(4, 10);
        assertEquals(null,lca);
    }

    @Test
    public void testRootLca()  {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(1, 7);
        assertEquals(1,lca.data);
    }

    @Test
    public void testNormalIsLca()  {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCA(2, 3);
        assertEquals(1,lca.data);

        lca = tree.findLCA(4, 5);
        assertEquals(2,lca.data);

        lca = tree.findLCA(4, 7);
        assertEquals(1,lca.data);

        lca = tree.findLCA(6, 1);
        assertEquals(1,lca.data);

    }

    @Test
    public void testUnbalancedTree()  {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.left.right = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);


        Node lca = tree.findLCA(6, 4);
        assertEquals(2,lca.data);
    }


}