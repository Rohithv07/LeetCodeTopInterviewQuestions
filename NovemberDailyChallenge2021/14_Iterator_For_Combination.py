class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):
        self.characters = characters
        self.combinationLength = combinationLength
        self.i = 0
        self.finalResult = []
        self.combine('', 0)
    
    def combine(self, string, start):
        if len(string) == self.combinationLength:
            self.finalResult.append(string)
            return
        else:
            for i in range(start, len(self.characters)):
                self.combine(string + self.characters[i], i+1)

    def next(self) -> str:
        finalResult = self.finalResult[self.i]
        self.i += 1
        return finalResult

    def hasNext(self) -> bool:
        return self.i < len(self.finalResult)


# Your CombinationIterator object will be instantiated and called as such:
# obj = CombinationIterator(characters, combinationLength)
# param_1 = obj.next()
# param_2 = obj.hasNext()