"""
Combinations of an Array: Print all subsets of a set (Powerset)
"""

def subsets(elements):
  if elements is None: return None

  subsets = [[]]
  next = []

  for elem in elements:
    for s in subsets:
      next.append(s + [elem])
    subsets += next
    next = []
    
  return subsets

def sum(list):
  if (list == []):
    return 0
  return list.pop(0) + sum(list)


