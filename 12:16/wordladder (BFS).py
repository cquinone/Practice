"""
http://www.programcreek.com/2012/12/leetcode-word-ladder/
"""
from collections import defaultdict

def wordladder(start,end,words):
    G = defaultdict(list)
    words.append(start)
    words.append(end)
    #Create Graph 
    for i in range(0,len(words)):
        for j in range(0,len(words)):
            if ((j != i) and (edgeExists(words[i],words[j]))):
                G[words[i]].append(words[j])

    #return pathlength
    return pathlength(G,words,start,end) 

def pathlength(G,words,start,end):
    visited = [False]*len(G)
    visited[words.index(start)] = True
    Q = []
    pathlength = 1
    Q.append((start,pathlength))
    
    while(len(Q) != 0):
        top = Q.pop(0)
        for word in G[top[0]]:
            if visited[words.index(word)] == False:
                Q.append((word,top[1]+1))
                visited[words.index(word)] = True
                if (word == end):
                    return top[1]+1
    return -1

def edgeExists(word1,word2):
    differs = 0
    if (len(word1)!=len(word2)):
        return False
    for i in range(0,len(word1)):
        if (word1[i] != word2[i]):
            differs+=1
    return differs == 1

### TEST CODE ### 
def testWordLadder():
    assert(wordladder("hit","cog",["hot","dot","dog","lot","log"]) == 5)
    assert(wordladder("dad","bad",["had","lad","fad"]) == 2)
    print "All tests passed"

testWordLadder()
