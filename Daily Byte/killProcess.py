You are given two lists of integers and an integer representing a process id to kill. One of the lists represents a list of process ids and the other represents a list of each of the processes’ corresponding (by index) parent ids. When a process is killed, all of its children should also be killed. Return a list of all the process ids that are killed as a result of killing the requested process. Ex: Given the following…

pid =  [2, 4, 3, 7]
ppid = [0, 2, 2, 3]
kill = 7
the tree of processes can be represented as follows:
           2
         /   \
        4     3
             /
            7
return [3, 7] as killing process 3 will also require killing its child (i.e. process 10).


class Solution:
	def killProcess(self, pid: List[int], ppid: List[int], kill : int) -> List[int]:
		dictionary = defaultdict(list)
		for i, pp in enumerate(ppid):
			dictionary[pp].append(pid[i])
		queue = collections.deque([kill])
		result = []
		while queue:
			parent_node = queue.popLeft()
			result.append(parent_node)
			queeu.extend(dictionary[parent_node])
		return result
