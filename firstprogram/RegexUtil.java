/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogram;
import java.util.regex.*;

/**
 *
 * @author avik
 */
public class RegexUtil {
    
    public static void main(String args[])
    {
        //Pattern p= Pattern.compile("abc");
        Pattern p= Pattern.compile("A.+k"); //Numeric Digit
        
        Matcher m=p.matcher("Avikkmullic");
        System.out.println(m.matches()+""+m.lookingAt());
        while(m.find())
            System.out.println(m.start()+" ,");
    }
    
}
