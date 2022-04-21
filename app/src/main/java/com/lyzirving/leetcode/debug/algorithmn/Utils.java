package com.lyzirving.leetcode.debug.algorithmn;

import com.lyzirving.leetcode.debug.data.ListNode;

public class Utils {

    /**
     * LeetCode No.25
     * @param head head node of the list
     * @param num  number of node that should be reversed
     * @return reversed list head
     */
    public static ListNode reverseGroup(ListNode head, int num) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode cur = head;
        ListNode result = null;
        ListNode lastTail = null;

        while (cur != null) {
            if (haveEnoughNode(cur, num)) {
                ListNode tmpHead = reverseSubGroup(cur, num);
                if (result == null)
                    result = tmpHead;
                ListNode tmpTail = moveToSeqLast(tmpHead, num);
                if (tmpTail != null)
                    cur = tmpTail.next;
                else
                    cur = null;
                if (lastTail != null)
                    lastTail.next = tmpHead;

                lastTail = tmpTail;
            } else {
                if (lastTail != null)
                    lastTail.next = cur;
                else
                    result = cur;
                break;
            }
        }
        return result;
    }

    private static boolean haveEnoughNode(ListNode head, int num){
        int pos = 0;
        ListNode cur = head;
        while(pos < num - 1) {
            if (cur == null)
                return false;
            cur = cur.next;
            pos++;
        }
        return cur != null;
    }

    private static ListNode moveToSeqLast(ListNode head, int num){
        int pos = 0;
        ListNode cur = head;
        while(pos < num - 1) {
            if (cur == null)
                return null;
            cur = cur.next;
            pos++;
        }
        return cur;
    }

    private static ListNode reverseSubGroup(ListNode head, int num) {
        ListNode dst = head.next;
        int nextInd = 1;
        while (nextInd < num) {
            ListNode oldHead = head;
            ListNode dstNext = dst.next;
            ListNode dstPre = head;

            while(head != dst) {
                dstPre = head;
                head = head.next;
            }

            dst.next = oldHead;
            dstPre.next = dstNext;

            //go next step
            head = dst;
            dst = dstNext;
            nextInd++;
        }
        return head;
    }

}
