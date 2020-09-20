
"""
class MovingAverage:
    def __init__(self, capacity):
        self._capacity = capacity
        self._list = []
        self._front = 0
        self._sum = 0
        self._cnt = 0
    
    def next(self, el):
        if self._cnt == self._capacity:
            self._sum -= self._list[self._front]
            self._front += 1
            self._sum += el
            self._list.append(el)
            return self._sum // self._capacity
        
        self._sum += el
        self._list.append(el)
        self._cnt += 1
        return self._sum // self._cnt

if __name__ == '__main__':
    m = MovingAverage(3)
    print(m.next(3))
    print(m.next(5))
    print(m.next(7))
    print(m.next(6))
    print(m.next(6))
    print(m.next(0))

"""

class MovingAverage:
	def __init__(self, capacity):
		self.capacity = capacity
		self.data =[0] * self.capacity
		self.length = 0
	def next(self, val):
		self.data.pop(0)
		self.data.append(val)
		if  self.length < self.capacity:
			self.length += 1
		return sum(self.data) // self.length

if __name__ == '__main__':
    m = MovingAverage(3)
    print(m.next(3))
    print(m.next(5))
    print(m.next(7))
    print(m.next(6))
    print(m.next(6))
    print(m.next(6))
