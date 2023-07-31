import util

################################################################################
#####################################Stack######################################
################################################################################
class Stack:
    def __init__(self):
        self.top = ListNode(None) # init to dummy
        self.size = 0
        
    def pop(self):
        out = self.peek() # check stack is not empty
        self.top.next = self.top.next.next
        self.size -= 1
        return out
    
    def push(self, elem):
        node = ListNode(elem, self.top.next)
        self.top.next = node
        self.size += 1
    
    def peek(self):
        if self.size < 1:
            raise util.InvalidOperationException('Stack is empty')
        return self.top.next.val
    
    def __str__(self) -> str:
        out = []
        n = self.top.next
        while n:
            out.append(n.val)
            n = n.next
        return f'[{", ".join(out)}]'
    
    
################################################################################
#####################################Queue######################################
################################################################################
class Queue(Stack):
    def __init__(self):
        super(Queue, self).__init__()
        self.bottom = self.top

    def pop(self):
        out = self.peek() # check queue is not empty
        self.top.next = self.top.next.next
        if self.size == 1:
            self.bottom = self.top
        self.size -= 1
        return out
        
    
    def push(self, elem):
        node = ListNode(elem)
        self.bottom.next = node
        self.bottom = node
        self.size += 1

################################################################################
######################################Tree######################################
################################################################################
class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

################################################################################
###################################LinkedList###################################
################################################################################
class ListNode:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

################################################################################
#####################################Graph######################################
################################################################################

class Node:
    def __init__(self, val):
        self.val = val
        self.neighbors = set()
        self.outdegree = 0
    
    def add_neighbors(self, neighbors):
        for neighbor in neighbors:
            self.add_neighbor(neighbor)
    
    def add_neighbor(self, neighbor):
        if neighbor in self.neighbors:
            return
        self.neighbors.add(neighbor)
        self.outdegree += 1
    
    def __str__(self):
        return f'({self.val}->{self.neighbors})'

class Graph:
    def __init__(self, edges=[]):
        self.__label = dict() # node -> node id
        self.__size = 0
        self.nodes = [] # node[i] is a Node, and i is its node id
        self.add_edges(edges)
        
    def add_edge(self, u, v):
        # u, v are nodes
        self.add_nodes((u, v))
        self.nodes[self.__label[u]].add_neighbor(self.__label[v])

    def add_edges(self, edges):
        for edge in edges:
            u, v = edge
            self.add_edge(u, v)
            
    def add_node(self, node):
        # assign id to every node, use id in implementation
        if node in self.__label:
            return
        self.__label[node] = self.__size
        self.__size += 1
        self.nodes.append(Node(self.__label[node]))
        
    def add_nodes(self, nodes):
        for node in nodes:
            self.add_node(node)
            
    def __str__(self) -> str:
        node_strs = []
        id_to___label = {v:k for k, v in self.__label.items()}
        for node in self.nodes:
            neighbors = {id_to___label[neighbor] for neighbor in node.neighbors}
            node_str = f'({id_to___label[node.val]}->{neighbors})'
            node_strs.append(node_str)
        return f'[{", ".join(node_strs)}]'
    

def test_graph():
    util.pp_header("Graph Tests")
    edges = [['cat', 'dog'], ['dog', 'cat'], ['bird', 'dog'], ['cat', 'bird']]
    g = Graph(edges)
    print(g)
    util.pp_header("Finished Graph Tests")
    
    


if __name__ == '__main__':
    print('Running Tests')
    test_graph()
    print('Finished All Tests')
    