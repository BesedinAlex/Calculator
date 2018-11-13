/*
 *  Created by BesedinAlex (c) 2018
 *  You can find other projects on github.com/BesedinAlex
 */

package calculator_2;

public class Compf extends Stack {
    protected final static int SYM_LEFT = 0, SYM_RIGHT = 1, SYM_OPER = 2, SYM_OTHER = 3;
    protected char lastC = '+';
    public void compile(char[] str) {
        processSymbol('(');
        for (int i = 0; i < str.length; i++) 
        {
            if (i > 0) lastC = str[i - 1];
            processSymbol(str[i]);
        }
        processSymbol(')');
        System.out.print("\n");
    }
    protected int symType(char c) {
        switch(c) {
            case '(':
                return SYM_LEFT;
            case ')':
                return SYM_RIGHT;
            case '+':
            case '-': 
            case '*': 
            case '/':
                return SYM_OPER;
            default:
                return symOther(c);
        }
    }
    protected int symOther(char c) {
        if (c < 'a' || c > 'z') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    private void processSymbol(char c) {
        switch(symType(c)) {
            case SYM_LEFT:
                push(c);
                break;
            case SYM_RIGHT:
                processSuspendedSymbols(c);
                pull();
                break;
            case SYM_OPER:
                processSuspendedSymbols(c);
                push(c);
                break;
            case SYM_OTHER:
                nextOther(c);
                break;
        }
    }
    private void processSuspendedSymbols(char c) {
        while (precedes(top(), c)) nextOper(pull());
    }
    private boolean precedes(char a, char b) {
        if (symType(a) == SYM_LEFT) return false;
        if (symType(b) == SYM_RIGHT) return true;
        return priority(a) >= priority(b);
    }
    private int priority(char c) {
        return c == '+' || c == '-' ? 1 : 2; // if (c == '+' || c == '-') return 1; else return 2;
    }
    protected void nextOther(char c) {
        if (symType(lastC) == 3) System.out.print(c);
        else System.out.print(" " + c);
    }
    protected void nextOper(char c) {
        System.out.print(" " + c);
    }
}