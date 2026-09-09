# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = [] #create an array for the result

        if root:
            q = collections.deque()#create a queue called q
            q.append(root)#add the root to the queue

            while q: #while q isnt empty
                qLen = len(q) #length of q
                level = []#create level array

                for i in range(qLen):#while i is less than current q
                    node = q.popleft() #dequeue the node
                    if node: #if this node isnt null
                        level.append(node.val) #add it to the level list
                        if node.left: q.append(node.left) #add its left and right child to the queue
                        if node.right: q.append(node.right)
                    
                
                res.append(level) #add the level to the result

        return res #return result






        