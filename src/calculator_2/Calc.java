/*
 *  Created by BesedinAlex (c) 2018
 *  You can find other projects on github.com/BesedinAlex
 */

package calculator_2;

public class Calc extends Compf {
    private final StackInt s;
    public Calc() {
        s = new StackInt();
    }
    private static int char2int(char c) {
        return (int) c - (int) '0';
    }
    @Override public final void compile(char[] str) {
        super.compile(str);
        System.out.println("" + s.top());
    }
    @Override protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    @Override protected void nextOther(char c) {
        if(symType(lastC) == 3) {
            int toIncrease = s.pull() * 10;
            s.push(toIncrease + char2int(c));
        }
        else s.push(char2int(c));
    }
    @Override protected void nextOper(char c) {
        int second = s.pull();
        int first = s.pull();
        switch (c) {
            case '+':
                s.push(first + second);
                break;
            case '-':
                s.push(first - second);
                break;
            case '*':
                s.push(first * second);
                break;
            case '/':
                s.push(first / second);
                break;
        }
    }
}