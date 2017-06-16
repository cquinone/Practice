"""
Imagine a robot sitting on the upper left corner of an X by Y grid. The robot
can only move in two directions: right and down.  How many possible paths are
there for the robot to go from (0,0) to (X,Y)?
"""

def directions(grid):
    return dirhelper(grid,0,0)

def dirhelper(grid,x,y):
    if ((x>len(grid)-1) or (y>len(grid[0])-1)):
        return 0
    if ((x==len(grid)-1) and (y==len(grid[0])-1)):
        return 1
    return dirhelper(grid,x+1,y) + dirhelper(grid,x,y+1)
#Follow Up algorithm is pretty much ismazesolveable 

### TEST CODE ###
grid = [["","","","",""],
        ["","","","",""],
        ["","","","",""],
        ["","","","",""],
        ["","","","",""]]

print directions(grid)
    

