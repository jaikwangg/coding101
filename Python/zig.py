class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def zigzagTraversal(root):
    if not root:
        return []

    result = []
    queue = [root]
    level = 0

    while queue:
        level_values = []
        next_level = []

        for node in queue:
            level_values.append(node.val)
            if node.left:
                next_level.append(node.left)
            if node.right:
                next_level.append(node.right)

        if level % 2 == 1:
            level_values = level_values[::-1]  # Reverse the list for odd levels

        result.extend(level_values)
        queue = next_level
        level += 1

    return result

# Create a binary tree
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)

# Perform zigzag traversal
result = zigzagTraversal(root)
print(result)  # Output: [1, 3, 2, 4, 5, 6, 7]
