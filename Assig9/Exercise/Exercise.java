/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import comp102.*;
import java.awt.Color;
import java.util.*;
import java.io.*;


/** Exercise   */

public class Exercise{




    public static void main(String[] arguments){
	String ans = javax.swing.JOptionPane.showInputDialog("Which exercise:\n 1 for Skipgo,\n 2 for NumberTable, \n 3 for WordGrid:");
	if ("1".equals(ans)) new Skipgo();
	if ("2".equals(ans)) new NumberTable();
	if ("3".equals(ans)) new WordGrid();
    }	


}
