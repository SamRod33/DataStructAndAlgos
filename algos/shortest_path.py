"""
Returns the shortest path from node u to node v in a graph
"""
from heapq import heappush, heappop

def shortest_path(grid, source, target):
    """Returns shortest path from source to target in grid.

    Args:
        grid (list[list[int]]): grid[y1][x1] is cost to reach node (y1, x1) in grid
        source (tuple[int, int]): source node location
        target (tuple[int, int]): target node location

    Returns:
        list[tuple[int, int]]: shortest path from source to target
    """
    # Dijstrka's Algorithm Implementation
    # Time: O(|E|log|V|), Space: O(|V|)
    m = len(grid)
    n = len(grid[0])
    NEIGHBORS = [(1, 0), (-1, 0), (0, -1), (0, 1)]
    F = [] # minHeap
    S = set()
    SandF = dict() # node -> (distance, backpointer)
    heappush(F, (grid[source[0]][source[1]], source))
    SandF[source] = (grid[source[0]][source[1]], None)
    while len(F) > 0:
        d, (r, c) = heappop(F)
        if (r, c) in S:
            continue
        S.add((r, c))
        if target in S:
            return path(SandF, target)
        for u, v in NEIGHBORS:
            x, y = r + u, c + v
            if 0 <= x < m and 0 <= y < n:
                w = d + grid[x][y]
                if (x, y) not in SandF or w < SandF[(x, y)][0]:
                    SandF[(x, y)] = (w, (r, c))
                    heappush(F, (w, (x, y)))
    return [] # case: no path from top left to bottom right

def path(SandF, n):
    """Returns path from source node to n. Helper for shortest_path

    Args:
        SandF (dict[tuple[int, int]->tuple[int, tuple[int, int]]]): map of nodes to (min distance, backpointer)
        n (tuple[int, int]): target node

    Returns:
        list[tuple[int, int]]: shortest path from source to n
    """
    out = []
    while n:
        out.append(n)
        _, n = SandF[n]
    return list(reversed(out))

def main():
    grid = [[1,3,1],[1,5,1],[4,2,1]]
    print(shortest_path(grid, (0, 0), (2, 2)))
          
if __name__ == '__main__':
    main()
        