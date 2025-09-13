class DisjointSet:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0] * n

    
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
            if self.rank[rootX] < self.rank[rootY]:
                self.parent[rootX] = rootY
            elif self.rank[rootX] > self.rank[rootY]:
                self.parent[rootY] = rootX
            else:
                self.parent[rootY] = rootX
                self.rank[rootX] += 1

ds = DisjointSet(10)

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

print("Parent: ", ds.parent)
print("Rank: ", ds.rank)
print("Find 1:", ds.find(1))
print("Find 5:", ds.find(5))
print("Find 8:", ds.find(8))
print("Find 3:", ds.find(3))
print("Find 7:", ds.find(7))