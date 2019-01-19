package calculator_2;

public class Compf extends Stack {
    protected final static int SYM_LEFT = 0, SYM_RIGHT = 1, SYM_OPER = 2, SYM_LEFT_DOUBLE = 3, SYM_RIGHT_DOUBLE = 4, SYM_OTHER = 5;
    protected char lastC = '+';
    public void compile(char[] str) {
        processSymbol('(');
        for (int i = 0; i < str.length; i++) {
            if (i > 0) lastC = str[i - 1];
            processSymbol(str[i]);
        }
        processSymbol(')');
        lastC = '+';
        System.out.print("\n");
    }
    protected int symType(char c) {
        switch (c) {
            case '(':
                return SYM_LEFT;
            case ')':
                return SYM_RIGHT;
            case '+':
            case '-':
            case '*':
            case '/':
                return SYM_OPER;
            case '[':
                return SYM_LEFT_DOUBLE;
            case ']':
                return SYM_RIGHT_DOUBLE;
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
        switch (symType(c)) {
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
            case SYM_LEFT_DOUBLE:
                push(c);
                break;
            case SYM_RIGHT_DOUBLE:
                processSuspendedSymbols(c);
                pull();
                _double(c);
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
        if (symType(a) == SYM_LEFT || symType(a) == SYM_LEFT_DOUBLE) return false;
        if (symType(b) == SYM_RIGHT || symType(b) == SYM_RIGHT_DOUBLE) return true;
        return priority(a) >= priority(b);
    }
    private int priority(char c) {
        return c == '+' || c == '-' ? 1 : 2;
    }
    protected void nextOther(char c) {
        if (symType(lastC) == SYM_OTHER) System.out.print(c);
        else System.out.print(" " + c);
    }
    protected void nextOper(char c) {
        System.out.print(" " + c);
    }
    protected void _double(char c) {
        System.out.print(" *2");
    }
}