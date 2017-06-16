"""
Find the size of the last word in a string
"""
def sizeoflastword(string):
    nonWhiteSpaceFound = False
    size = 0
    string = reverse(string)

    for i in range(0, len(string)):
        if (nonWhiteSpaceFound == False):
            if (string[i] != " "):
                nonWhiteSpaceFound = True
                size+=1
        else:
            if (string[i] != " "):
                size+=1
            else:
                return size
    return size 
    

def reverse(string):
    slen = len(string)
    sarr = list(string)
    
    for i in range(0, slen/2):
        sarr[i], sarr[slen-1-i] = sarr[slen-1-i], sarr[i]

    return "".join(sarr)

### Test Code ###
def testSize():
    assert(sizeoflastword("Hello") == 5)
    assert(sizeoflastword("Hey dude ") == 4)
    assert(sizeoflastword("") == 0)
    assert(sizeoflastword("  idk") == 3)
    assert(sizeoflastword("idk  ") == 3)
    assert(sizeoflastword("a last") == 4)
    print "All tests passed"

testSize()
    
    
