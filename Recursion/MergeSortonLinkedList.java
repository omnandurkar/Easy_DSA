/* Problem: Merge Sort on Linked List */


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class MergeSortLinkedList {

    public ListNode mergeSort(ListNode head) {
        // Base case: If the list is empty or has only one element, it's already sorted.
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the linked list using the slow and fast pointer technique.
        ListNode middle = findMiddle(head);

        // Split the linked list into two halves.
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        // Recursively merge sort both halves.
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves back together.
        return merge(left, right);
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode merged = new ListNode(-1);
        ListNode current = merged;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return merged.next;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 3 -> 1 -> 4 -> 2 -> 5
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);

        MergeSortLinkedList sorter = new MergeSortLinkedList();
        ListNode sortedList = sorter.mergeSort(head);

        // Print the sorted linked list: 1 -> 2 -> 3 -> 4 -> 5
        while (sortedList != null) {
            System.out.print(sortedList.val + " -> ");
            sortedList = sortedList.next;
        }
        System.out.print("null");
    }
}
