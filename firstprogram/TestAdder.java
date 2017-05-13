/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogram;

/**
 *
 * @author avik
 */
public class TestAdder {

    public static void main(String args[]) {
        Adder a = new Adder();

        System.out.println("Integer Example " + a.add(12, 13));
        System.out.println("Floating Example " + a.add(12.23f, 13.45f));
        System.out.println("Expected Floating Example " + a.add(12, 13.45f));
        System.out.println("Expected Floating Example " + a.add(12.23f, 13));
    }

}

class Adder {

    public int add(int a, int b) {
        System.out.println("Integer Adder");
        return a + b;
    }

    public float add(float a, float b) {
        System.out.println("Float Adder");
        return a + b;
    }

    public float add(int a, float b) {
        System.out.println("Integer Float Adder");
        return a + b;
    }
}
