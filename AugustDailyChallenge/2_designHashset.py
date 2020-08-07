class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.list = []
        

    def add(self, key: int) -> None:
        self.list.append(key)

    def remove(self, key: int) -> None:
        if key in self.list:
            self.list = list(set(self.list))
            del self.list[self.list.index(key)]

    def contains(self, key: int) -> bool:
        """
        Returns true if this set contains the specified element
        """
        if key in self.list:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
