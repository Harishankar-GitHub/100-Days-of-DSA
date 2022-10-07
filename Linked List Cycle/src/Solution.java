import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem statement: https://leetcode.com/problems/linked-list-cycle/

    public static void main(String[] args) {
        ListNode head = buildLinkedList_Example_1();
        System.out.println("Solution 1 - Has Cycle: " + hasCycle_solution_1(head));  // returns true

        head = buildLinkedList_Example_2();
        System.out.println("Solution 1 - Has Cycle: " + hasCycle_solution_1(head));  // returns true

        head = buildLinkedList_Example_3();
        System.out.println("Solution 1 - Has Cycle: " + hasCycle_solution_1(head));  // returns false

        head = buildLinkedList_Example_1();
        System.out.println("Solution 2 - Has Cycle: " + hasCycle_solution_2(head));  // returns true

        head = buildLinkedList_Example_2();
        System.out.println("Solution 2 - Has Cycle: " + hasCycle_solution_2(head));  // returns true

        head = buildLinkedList_Example_3();
        System.out.println("Solution 2 - Has Cycle: " + hasCycle_solution_2(head));  // returns false
    }

    public static boolean hasCycle_solution_1(ListNode head) {
        // O(n) time | O(n) space

        Set<ListNode> visitedNodes = new HashSet<>();

        ListNode currentNode = head;

        while (currentNode != null) {
            visitedNodes.add(currentNode);
            ListNode nextNode = currentNode.next;

            if (nextNode != null) {
                if (visitedNodes.contains(nextNode)) {
                    return true;
                } else {
                    visitedNodes.add(nextNode);
                }
                currentNode = nextNode;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean hasCycle_solution_2(ListNode head) {
        // O(n) time | O(1) space
        // Floyd's Cycle Detection Algorithm (Hare and Tortoise Algorithm)

        if (head == null || head.next == null) return false;

        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (firstPointer != null && secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;

            if (firstPointer == secondPointer) return true;
        }

        return false;
    }

    private static ListNode buildLinkedList_Example_1() {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode minusFour = new ListNode(-4);

        three.next = two;
        two.next = zero;
        zero.next = minusFour;
        minusFour.next = two;

        return three;
    }

    private static ListNode buildLinkedList_Example_2() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);

        one.next = two;
        two.next = one;

        return one;
    }

    private static ListNode buildLinkedList_Example_3() {
        return new ListNode(1);
    }

     // Definition for singly-linked list.
     static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}