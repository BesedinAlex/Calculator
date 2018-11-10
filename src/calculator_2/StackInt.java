/*
 *  Created by BesedinAlex (c) 2018
 *  You can find other projects on github.com/BesedinAlex
 */

package calculator_2;

class StackInt {
    private static final int DEFSIZE = 16;
    private int[] array;
    private int head;
    public StackInt() {
        array = new int[DEFSIZE];
        head = 0;
    }
    public final void push(int val) {
        array[head++] = val;
    }
    public final int pull() {
        return array[--head];
    }
    public final int top() {
        return array[head-1];
    }
}