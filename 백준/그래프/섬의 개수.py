# 리트 코드 200번 - 섬의 개수

from pip import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(i,j):
            if(grid[i][j] == "1"):
                grid[i][j] = 0
                if(j != len(grid[i])-1):
                    dfs(i, j+1)
                if(i != len(grid) - 1):
                    dfs(i+1, j)
                if(i != 0):
                    dfs(i-1, j)
                if(j != 0):
                    dfs(i, j-1)

        count = 0

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if(grid[i][j] == "1"):
                    dfs(i, j)
                    count += 1     
        return count

