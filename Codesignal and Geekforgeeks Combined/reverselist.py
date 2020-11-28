def reverse(list):
    current = list
    previous = None
    
    while current is not None:
        previous, current.next, current = current, previous, current.next
        
    return previous
