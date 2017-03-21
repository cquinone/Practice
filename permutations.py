"""
Permutations of a String: Print all permutations of a string
"""

def tolist(string):
    return list(string)

def tostring(List):
    return "".join(List)

def permutations(string,low,upp):
    #implementation assumes we are given a string instead of a list
    arr = tolist(string)
    if (low == upp):
        print string
    else:
        for i in range(low,upp+1):
            arr[low], arr[i] = arr[i], arr[low]
            permutations(tostring(arr),low+1,upp)
            arr[low], arr[i] = arr[i], arr[low]

### Test Code ###
def testPermutations():
    permutations("abcd",0,3)

testPermutations()
