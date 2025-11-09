class Node:
    def __init__(self,data,next):
        self.data = data
        self.next = next

class LinkedList:
    
    def printList(self,head):
        temp = head
        
        result = []
        while temp:
            result.append(str(temp.data))
            print(temp.data)
            temp = temp.next 
        print(" -> ".join(result) if result else "EmptyList")
            
    def insertAtHead(self,head,data):
        newnode = Node(data=data,next=head)
        return newnode
    
    def insertAtPos(self,head,data,n):
        
        if n == 0:
            self.insertAtHead(self,head,data)
        
        temp = head
        i=0
        while temp and  i<n-1:
            temp = temp.next 
            i+=1
        
        if temp is None:
            return head
        
        newNode = Node(data,temp.next)
        temp.next = newNode
        
        return head
    
    def insertAtTail(self,head,data):
        
        newnode = Node(data,None)
        
        if head is None:
            return newnode
        
        temp = head
        
        while temp.next :
            temp = temp.next
        
        
        temp.next = newnode
        
        return head
    
    def deleteAtHead(self,head):
        
        if head is None:
            return None
        head = head.next

        return head
    
    def deleteAtPos(self,head,n):
        
        if n == 0:
            return head.next
        temp = head
        
        i = 0
        
        while temp and i<n-1:
            temp = temp.next
            i+=1
        
        if temp is None or temp.next is None:
            return head
        
        temp.next = temp.next.next 
        
        return head
    
    def deletebyvalue(self,head,value):
        if head is None:
            return None
        
        if head.data == value:
            return head.next 
        
        temp = head
        
        while temp and temp.next :
            if temp.next.data == value:
                break
            
            temp = temp.next
        
        if temp is None or temp.next is None:
            return head 
         
        temp.next = temp.next.next 
        
        return head
    
    def search(self,head,value):
        
        if head is None:
            return -1
        
        i = 0
        index = -1
        temp = head
        while temp:
            if temp.data == value:
                index = i
                break
            temp = temp.next
        
        if temp is None and index == -1:
            return -1 
        
        return index
    
    def getlength(self,head):
        if head is None:
            return 0
        
        i = 0
        
        temp = head
        
        while temp :
            i+=1
            temp = temp.next 
        
        return i
    
    def reverse(self,head):
        
        if head is None:
            return None
        
        prev = None
        
        current = head
        
        while current:
            next_node = current.next #saving the next node
            current.next = prev #reversing the link
            prev = current 
            current = next_node
        
        return prev
    
    def getMiddle(self,head):
        ''' finding middle of the node using slow-fast pointer technique'''
        
        if head is None:
            return None
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next 
            fast =fast.next.next 
        
        return slow.data
    
    def getNthFromEnd(self,head,n):
        ''' 
        let suppose k is length and n from end is k-n from start first pointer makes n moves
        second pointer at strt only
        now first pointer and second pointe makes k-n moves to gert the value
        '''
        
        if head is None:
            return -1
        
        first = head
        second = head
        
        #firt pointer makes n steps
        
        for i in range(n):
            if first is None :
                return -1
            
            first = first.next 
        
        if first is None:
            return head.data
        
        while first.next:
            first = first.next 
            second =second.next 
        
        return second.next.data
    
    def detectloop(self,head):
        if head is None :
            return False
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next 
            fast = fast.next.next 
            
            if slow == fast:
                return True
        
        return False
    
    def removeDuplicates(self,head):
        '''from sorted list'''
        
        if head is None:
            return None
        
        temp = head
        
        while temp:
            if temp.data == temp.next.data:
                temp.next = temp.next.next 
            else :
                temp = temp.next
        
        return head
            

def main():
    ll = LinkedList()
    head = None
    
    print("=== Testing LinkedList Operations ===\n")
    
    # Test insertAtHead
    print("1. Insert at head: 10, 20, 30")
    head = ll.insertAtHead(head, 10)
    head = ll.insertAtHead(head, 20)
    head = ll.insertAtHead(head, 30)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    # Test insertAtTail
    print("2. Insert at tail: 5")
    head = ll.insertAtTail(head, 5)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    # Test insertAtPos
    print("3. Insert 25 at position 2")
    head = ll.insertAtPos(head, 25, 2)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    # Test search
    print("4. Search for value 25")
    index = ll.search(head, 25)
    print(f"Found at index: {index}\n")
    
    # Test deleteAtHead
    print("5. Delete at head")
    head = ll.deleteAtHead(head)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    # Test deleteAtPos
    print("6. Delete at position 1")
    head = ll.deleteAtPos(head, 1)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    # Test deletebyvalue
    print("7. Delete node with value 5")
    head = ll.deletebyvalue(head, 5)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    print("*. Reverse th list")
    
    print("8. Reverse the list")
    head = ll.reverse(head)
    ll.printList(head)
    print(f"Length: {ll.getlength(head)}\n")
    
    print("9. Get middle element")
    middle = ll.getMiddle(head)
    print(f"Middle element: {middle}\n")
    
    # Test getNthFromEnd
    print("10. Get 2nd node from end")
    nthFromEnd = ll.getNthFromEnd(head, 2)
    print(f"2nd from end: {nthFromEnd}\n")
    print("=== All tests completed! ===")

if __name__ == "__main__":
    main()
    
    

        
    
        
        
        
        
        
        
    