package LeetCode_Problems;

class ListNode {
        int val;
        ListNode next;

        public ListNode(int x){
            val = x;
            next = null;
        }
    }

public class LL {

    // Linked-list cycle (LC:141)   // Amazon and Microsoft
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next; // move ahead by 2x 
            slow = slow.next;   // move ahead by 1x

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // Find the length of the cycle
    public int cycleLength(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next; // move ahead by 2x 
            slow = slow.next;   // move ahead by 1x

            if(fast == slow){
                // length calculate
                ListNode temp = slow;
                int length = 0; // take a length track
                do{
                    temp = temp.next;
                    length++;
                }while(temp != slow); // track until its meet slow again

                return length;
            }
        }
        return 0;
    }

    // Linked-list cycle II (LC:) 
    // we have to return that node where the cycle is starting
    public ListNode detectCycle(ListNode head){
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next; // move ahead by 2x 
            slow = slow.next;   // move ahead by 1x

            if(fast == slow){
                length = cycleLength(slow);
                break;
            }
        }

        if(length == 0){
            return null;
        }

        // now we have to find the start node
        ListNode f = head;
        ListNode s = head;

        while(length > 0){
            s = s.next;
            length--;
        }
        // keep moving both forward and they will meet at cycle start
        while(s != f){
            s = s.next;
            f = f.next;
        }

        return s;
    }

    // Happy Number (LC:202)   // ask in Google ivw
    public boolean isHappay(int n){
        int fast = n;
        int slow = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow == 1){
            return true;
        }
        return false;
    }
    // function for finding sum of square -->
    private int findSquare(int n){
        int sum = 0;
        while(n > 0){
            sum += ((n%10)*(n%10));
            n /= 10;
        }
        return sum;
    }

    // Middle of the LL (LC:876)
    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Sort List  (LC:148)
    // public ListNode sortList(ListNode head){
    //     ListNode f = head;
    //     ListNode s = head.next;
    //     while(s != null){
    //         if(f.val > s.val){
    //             int temp = f.val;
    //             f.val = s.val;
    //             s.val = temp;
    //         }
    //     }
    //     return head;
    // }
    // private ListNode get(ListNode head){
    //     ListNode temp = head;  
    // }

    // Reverse the linkedlist (LC:206)
    // in place reversal of LL (ask in Google, microsoft, apple, amazon)
    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;

            if(next != null){
                next = next.next;
            }
        }
        head = prev;

        return head;
    }

    // Reverse linkedlist II (LC:92)
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == right){
            return head;
        }

        // Skip the first (left-1) nodes
        ListNode prev = null;
        ListNode current = head;

        for (int i = 0; current != null && i < left-1; i++) { // current!= null bcz of checking nullPointerException
            prev = current;
            current = current.next;
        }
        ListNode prevLeft = prev;
        ListNode newRight = current;

        // Reverse between left and right
        ListNode next = current.next;
        for (int i = 0; i < right - left + 1 && current != null; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(prevLeft != null){
            prevLeft.next = prev; // connecting it to leftPrev node with right
        }
        else{
            head = prev;
        }

        newRight.next = current; // connecting left with rightNext node

        return head;
    }

    // Palindrome LinkedList (LC: 234) 
    // Ask in Google, facebook, microsoft, amazon, apple, linkedin
    public boolean isPalindrome(ListNode head){

        ListNode mid = findMiddle(head); // see above findMiddle() already defined
        ListNode secondHead = reverse(mid);// reverse the 2nd half of the LL
        ListNode reverseHead = secondHead; // storing the secondHead

        while(head != null && secondHead != null){ // comparing both halves
            if(head.val != secondHead.val){
                break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        reverse(reverseHead); // re-reverse the 2nd half

        if(head == null || secondHead == null){
            return true;
        }
        else{
            return false;
        }

    }

    // Reorder Linkedlist (LC: 143)
    public void reOrderList(ListNode head){

        if(head == null || head.next == null){
            return;
        }

        ListNode mid = findMiddle(head);
        reverse(mid);

        ListNode headFirst = head;
        ListNode headSecond = mid;

        while(headFirst != null && headSecond != null){
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }

        if(headFirst != null){
            headFirst.next = null;
        }
    }

    // Reverse Node in K-group (LC:25)
    public ListNode reverseKGroup(ListNode head, int k){

        if(head == null || k <= 1){
            return head;
        }
        
        // Skip the first (left-1) nodes
        ListNode prev = null;
        ListNode current = head;

        int length = getLength(head);
        int count = length/k;

        while(count > 0){
            
            ListNode prevLeft = prev;
            ListNode newRight = current;

            // Reverse between left and right
            ListNode next = current.next;
            for (int i = 0; i < k && current != null; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }

            if(prevLeft != null){
                prevLeft.next = prev; // connecting it to leftPrev node with right
            }
            else{
                head = prev;
            }

            newRight.next = current; // connecting left with rightNext node
            prev = newRight;
            count--;
        }

        return head;
    }
    // for calculating length
    public int getLength(ListNode head){
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    // Reverse Alternative k-nodes in LL

    // Rotate List (LC:61)
    // Ask in Gooogle, Facebook, Twitter
    public ListNode rotateRight(ListNode head, int k){
        if(k <= 0 || head == null || head.next == null){
            return head;
        }

        ListNode last = head;
        int length = 1;

        while(last.next != null){
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;

        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        

        return head;
    }

    // Remove Nth node from end of the list (LC:19)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        int length = 1;
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            length++;
        }

        if(length == n){
            return head.next;
        }
        
        node = head;
        int skip = length - n;
        for(int i = 0; i < skip-1; i++){
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}