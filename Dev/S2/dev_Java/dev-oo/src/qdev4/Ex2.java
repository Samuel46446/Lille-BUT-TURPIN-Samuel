package qdev4;

import tpQU.tp04.LocalKeyboard;

public class Ex2
{
    public static int[] tab = {17, 12, 15, 38, 29, 157, 89, -22, 0, 5};
    
    public static int division(int index, int divisor) {
        return tab[index]/divisor;
    }
   
    public static void statement() {
        int x, y;
        x = LocalKeyboard.readInt("Write the index of the integer to divide: ");
        y = LocalKeyboard.readInt("Write the divisor: ");
        System.out.println("The result is: " + division(x,y));
    }
        
}
