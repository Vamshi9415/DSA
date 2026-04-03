class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, key):
        def _insert(root, key):
            if root is None:
                return Node(key)

            if key < root.key:
                root.left = _insert(root.left, key)
            else:
                root.right = _insert(root.right, key)

            return root

        self.root = _insert(self.root, key)

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(root.key, end=" ")
            self.inorder(root.right)

    def search(self, root, target):
        while root and root.key != target:
            if target < root.key:
                root = root.left
            else:
                root = root.right

        return root


if __name__ == "__main__":
    bst = BinaryTree()

    elements = [8, 5, 12, 4, 7, 10, 14, 6, 13]
    for el in elements:
        bst.insert(el)

    print("Inorder traversal:")
    bst.inorder(bst.root)
    print()

    target = 13
    result = bst.search(bst.root, target)
    if result:
        print(f"Found {target} in BST")
    else:
        print(f"{target} not found in BST")
            

            

        