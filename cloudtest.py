



M,N = map(int, input().split())
m = []
for i in range(M):
    row = list(map(int, input().split()))
    m.append(row)


from union_size import DisjointSet

djs = DisjointSet(M*N)

def idx(r, c):
    return r*N + c

def valid(r, c):
    if r >= 0 and r < M and c >= 0 and c < N:
        return True
    else:
        return False

adj = ((-1,0),(1,0),(0,-1),(0,1))
for r in range(M):
    for c in range(N):
        if m[r][c] == 1:
            for d in adj:
                rr = r+d[0]
                cc = c+d[1]
                if valid(rr,cc) and m[rr][cc] == 1:
                    djs.union(idx(r,c), idx(rr,cc))

# ...existing code...
from collections import defaultdict

counter = defaultdict(int)
maxCount = 0
for r in range(M):
    for c in range(N):
        if m[r][c] != 1:
            continue
        s = djs.find(idx(r,c))
        counter[s] += 1
        if counter[s] > maxCount:
            maxCount = counter[s]

print("ex1: ",maxCount)
        
