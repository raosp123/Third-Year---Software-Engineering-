import unittest
from LCA import Node as Node
from LCA import findLCA as findLCA


class TestLCA(unittest.TestCase):
    def testMissing(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.right = Node(5)
        root.right.left = Node(6)
        root.right.right = Node(7)

        lca = findLCA(root, 4, 10)

        self.assertEqual(None,lca)

    def testRootLCA(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.right = Node(5)
        root.right.left = Node(6)
        root.right.right = Node(7)

        lca = findLCA(root, 1, 7)

        self.assertEqual(1,lca.key)

    def testNormalIsLca(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.right = Node(5)
        root.right.left = Node(6)
        root.right.right = Node(7)

        lca = findLCA(root, 2, 3)
        self.assertEqual(1,lca.key)

        lca = findLCA(root, 4, 5)
        self.assertEqual(2,lca.key)

        lca = findLCA(root, 4, 7)
        self.assertEqual(1,lca.key)

        lca = findLCA(root, 6, 1)
        self.assertEqual(1,lca.key)

    def testUnbalancedTree(self):
        root = Node(1)
        root.left = Node(2)
        root.left.left = Node(3)
        root.left.left.right = Node(4)
        root.left.right = Node(5)
        root.left.right.right = Node(6)

        lca = findLCA(root, 6, 4)

        self.assertEqual(2,lca.key)