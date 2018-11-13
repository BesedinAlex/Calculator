/*
 *  Created by BesedinAlex (c) 2018
 *  You can find other projects on github.com/BesedinAlex
 */

package calculator_2;

class StackInt {
    private final static int DEFSIZE = 32;
    private final int[] array;
    private int head;
    public StackInt() {
        array = new int[DEFSIZE];
        head = 0;
    }
    public final void push(int digit) {
        array[head++] = digit;
    }
    public final int pull() {
        return array[--head];
    }
    public final int top() {
        return array[head-1];
    }
}