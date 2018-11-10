/*
 *  Created by BesedinAlex (c) 2018
 *  You can find other projects on github.com/BesedinAlex
 */

package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Compf c = new Compf();
            while(true){
                Scanner in = new Scanner(System.in);
                System.out.print("\nType equation: ");
                String str = in.nextLine();
                c.compile(str.toCharArray());
            }
    }
}
