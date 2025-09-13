
class DisjointSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.size = [1] * n

    
    def find(self, x):
        root = x
        while self.parent[root] != root:
            root = self.parent[root]
        while self.parent[x] != root:
            nxt = self.parent[x]
            self.parent[x] = root
            x = nxt
        return root
    

    def union(self,x,y):
        rootX = self.find(x)
        rootY = self.find(y)

        if rootX != rootY:
            if self.size[rootX] < self.size[rootY]:
                self.parent[rootX] = rootY
                self.size[rootY] += self.size[rootX]
            else:
                self.parent[rootY] = rootX
                self.size[rootX] += self.size[rootY]

ds = DisjointSet(12)

ds.union(1, 2)
ds.union(2, 3)    
ds.union(4, 5)
ds.union(6, 7)
ds.union(5, 6)    
ds.union(3, 7)  

ds.find(1)
ds.find(3)
ds.find(7)
ds.find(5)
ds.find(8)

# print("Find 1:", ds.find(1))
# print("Find 5:", ds.find(5))
# print("Find 8:", ds.find(8))
# print("Find 3:", ds.find(3))
# print("Find 7:", ds.find(7))
# */

ds.union(1, 7)

# call find on nodes to trigger path compression
print("Find 1:", ds.find(1))
print("Find 5:", ds.find(3))
print("Find 8:", ds.find(7))
print("Find 3:", ds.find(5))
print("Find 7:", ds.find(8))

print("Parent:", ds.parent)
print("Size:  ", ds.size)