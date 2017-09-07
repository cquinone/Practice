class Node:
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None 
        
    def __repr__(self):
        return str(self.val)

def treemin_r(root):
    #recursively finds min element of binary tree
    if (root == None):
        return None
    
    if (root.left == None): return root
    return treemin_r(root.left)

def treemax_r(root):
    #recursively finds max element of binary tree
    if (root == None):
        return None 

    if (root.right == None): return root
    return treemax_r(root.right)

def treemin_i(root):
    #iteratively finds min element of binary tree 
    if (root == None): return root
    
    while (root.left != None):
        root = root.left
    return root

def treemax_i(root):
    #iteratively finds max element of binary tree 
    if (root == None): return root
    
    while (root.right != None):
        root = root.right
    return root

def successor(node):
    if (node == None):
        return None
    
    #right tree nonempty => return the min element in the right tree 
    if (node.right != None):
        return treemin_i(root.right)
    
    #right tree empty => check if successor is an ancestor
    #not an ancestor <=> sucessor does not exist
    p = node.parent
    while (p!= None and p.right == node):
        node = p
        p = p.parent
    return p

def predecessor(node):
    if (node == None):
        return None
    
    #left tree nonempty => return the max element in the left tree
    if (node.left != None):
        return treemax_i(root.left)

    #left tree empty => check if predecessor is an ancestor
    #not an ancestor <=> predecessor does not exist
    p = node.parent
    while (p != None and p.left == node):
        node = p
        p = p.parent
    return p 

def search_r(root,val):
    #recursive tree search
    if (root == None or root.val == val):
        return root
    elif (root.val > val):
        return search_r(root.left,val)
    else:
        return search_r(root.right,val)

def search_i(root,val):
    #iterative tree search
    curr = root

    while(curr != None):
        if (curr == None or curr.val == val):
            return curr
        if (curr.val > val):
            curr = curr.left
        else:
            curr = curr.right
    
def minimumDepth(root):
    #Minimum Depth 
    if (root == None):
        return 0
    
    if (root.left == None and root.right == None):
        return 1
    
    if (root.left == None):
        return 1 + minimumDepth(root.right)

    if (root.right == None):
        return 1 + minimumDepth(root.left)
    
    return 1 + min(minimumDepth(root.left),minimumDepth(root.right))

def mps(root):
    #Maximum Path Sum
    if (root == None):
        return 0
    return root.val + max(mps(root.left),mps(root.right))
    
def nodeBalanced(root):
    if (root == None):
        return True
    else:
        diff = abs(height(root.left) - height(root.right))
        if (diff > 1):
            return False
        else:
            return nodeBalanced(root.left) and nodeBalanced(root.right)
    
def height(root):
    if (root == None):
        return 0
    else:
        return 1 + max(height(root.left),height(root.right))
    
    
def inordertraversal(root):
    if root == None:
        return
    inordertraversal(root.left)
    print root.val
    inordertraversal(root.right)

def preordertraversal(root):
    #preorder is DFS
    if root == None:
        return
    print root.val
    preordertraversal(root.left)
    preordertraversal(root.right)

def postordertraversal(root):
    if root == None:
        return
    postordertraversal(root.left)
    postordertraversal(root.right)
    print root.val
    
def insertu(root,val):
    newnode = Node(val)
    if (root == None):
        root = newnode
        return
    else:
        if (root.val == val):
            return root
        elif (val < root.val):
            if (root.left == None):
                root.left = newnode
                return
            else:
                insert(root.left,val)
        else:
            if (root.right == None):
                root.right = newnode
                return
            else:
                insert(root.right,val)

def insert(root,val):
    newnode = Node(val)
    if (root == None):
        root = newnode
        return
    cnode = root

    while(True):
        if (val == cnode.val):
            return
        elif (val < cnode.val):
            if (cnode.left == None):
                cnode.left = newnode
                return 
            else:
                cnode = cnode.left
                continue
        else:
            if (cnode.right == None):
                cnode.right = newnode
                return
            else:
                cnode = cnode.right
                continue

### TEST CASES ###
root = Node(0)
root.left = Node(1)
root.left.left = Node(3)
root.left.right = Node(4)
root.right = Node(2)
root.right.left = Node(5)
root.right.right = Node(6)

k = Node(5)
k.left = Node(2)
k.right = Node(9)
k.left.left = Node(1)
k.left.right = Node(3)
k.right.left = Node(7)
k.right.right = Node(10)

f = Node(3)
f.right = Node(1)


i = Node(5)
i.left = Node(2)
i.right = Node(7)
i.left.left = Node(1)
i.left.left.left = Node(9)
i.right.right = Node(10)
i.right.right.right = Node(11)
i.left.right = Node(3)


#Tree from Wikipedia
r = Node("F")
r.left = Node("B")
r.left.left = Node("A")
r.left.right = Node("D")
r.left.right.left = Node("C")
r.left.right.right = Node("E")
r.right = Node("G")
r.right.right = Node("I")
r.right.right.left = Node("H")

#Tree should output same inorder traversal as the one above 
u = Node("F")
u.left = Node("B")
u.left.left = Node("A")
u.left.right = Node("D")
u.left.right.left = Node("C")
u.left.right.right = Node("E")
u.right = Node("H")
u.right.left = Node("G")
u.right.right = Node("I")
        
