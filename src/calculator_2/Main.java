/*
 *  Created by BesedinAlex (c) 2018
 *  You can find other projects on github.com/BesedinAlex
 */

package calculator_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Calc c = new Calc();
            while(true){
                Scanner in = new Scanner(System.in);
                System.out.print("\nType equation: ");
                String str = in.nextLine();
                c.compile(str.toCharArray());
            }
    }
}