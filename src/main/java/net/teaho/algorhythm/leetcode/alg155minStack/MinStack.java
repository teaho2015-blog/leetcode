package net.teaho.algorhythm.leetcode.alg155minStack;

class MinStack {

    ListNode stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int val) {
        if (stack == null) {
            stack = new ListNode(val, val);
        } else {
            ListNode tmp = new ListNode(val, Math.min(stack.min, val));
            tmp.next = stack;
            stack = tmp;
        }
    }

    public void pop() {
        if (stack != null) {

            stack = stack.next;
        }
    }

    public int top() {
        if (stack == null) {
            return Integer.MIN_VALUE;
        }
        return stack.val;

    }

    public int getMin() {
        if (stack == null) {
            return Integer.MIN_VALUE;
        }
        return stack.min;

    }

    private class ListNode {
        int val;
        int min;
        ListNode next;

        public ListNode(int val, int min) {
            this.val = val;
            this.min = min;
        }

    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */