class Node:
    def __init__(self, data, left_node, right_node):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node

def pre_order(node: Node):
    print(node.data, end = " ")
    if node.left_node != None:
        pre_order(tree[node.left_node])
    if node.right_node != None:
        pre_order(tree[node.right_node])

def in_order(node: Node):
    if node.left_node != None:
        in_order(tree[node.left_node])
    print(node.data, end=' ')
    if node.right_node != None:
        in_order(tree[node.right_node])

def post_order(node: Node):
    if node.left_node != None:
        post_order(tree[node.left_node])
    if node.right_node != None:
        post_order(tree[node.right_node])
    print(node.data, end=' ')

tree = {
    'A' : Node('A', 'B', 'C'),
    'B' : Node('B', 'D', 'E'),
    'C' : Node('C', 'F', 'G'),
    'D' : Node('D', None, None),
    'E' : Node('E', None, None),
    'F' : Node('F', None, None),
    'G' : Node('G', None, None),
}

pre_order(tree['A'])
print()
in_order(tree['A'])
print()
post_order(tree['A'])