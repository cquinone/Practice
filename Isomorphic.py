from collections import defaultdict
"""
http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
"""

def isomorphic(str1,str2):
    visited = [False]*256
    log = defaultdict(str)
    if (len(str1)!=len(str2)):
        return False
    for i in range(0,len(str1)):
        if (visited[ord(str1[i])] == False):
            visited[ord(str1[i])] = True
            log[str1[i]] = str2[i]
            if (log[str2[i]]!="" and log[str2[i]]!=str1[i]):
                return False
        else:
            if (str2[i] != log[str1[i]]):
                return False
    return True

### Test Code ###
def testIsomorphic():
    assert(isomorphic("xzc","hjf")==True)
    assert(isomorphic("aab","ccb")==True)
    assert(isomorphic("ababab","bababa")==True)
    assert(isomorphic("ababad","bababc")==True)
    assert(isomorphic("abcdef","bcdefg")==True)
    assert(isomorphic("aab","bac")==False)
    assert(isomorphic("abcd","abcc")==False)
    assert(isomorphic("abdd","abcc")==True)
    print "All tests passed"

    
    


