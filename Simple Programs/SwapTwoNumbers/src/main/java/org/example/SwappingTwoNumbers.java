package org.example;

public class SwappingTwoNumbers {
    public static void main(String[] args) {
        int a = 10, b = 20;

        System.out.println("Logic 1");
        System.out.println("Before swapping values are..." + a + " " + b);

        //Logic1 - Third varialbe

        int t = a;
        a = b;
        b = t;

        System.out.println("After swapping values are... "  + a + " " + b);

        //Logic2 - use + & - without using third variable

        a = 10; b = 20;
        System.out.println("Logic 2");
        System.out.println("Before swapping values are..." + a + " " + b);
        a = a + b; //10+20=30
        b = a - b; //30-20=10
        a = a - b; //30-10=20

        System.out.println("After swapping values are... "  + a + " " + b);

        //Logic 3 - use * and / without third variable only if a & b are not equal 0
        a = 10; b = 20;
        System.out.println("Logic 3");
        System.out.println("Before swapping values are..." + a + " " + b);

        a = a * b; // 10*20=200
        b = a / b; // 200/20=10
        a = a / b; // 200/10=20

        System.out.println("After swapping values are... "  + a + " " + b);

        //Logic 4 - bitwise XOR (^)
        a = 10; b = 20;
        System.out.println("Logic 4");
        System.out.println("Before swapping values are..." + a + " " + b);
        /*
        a = 10 in binary  1010
        b = 20 in binary 10100
        */
        a = a ^ b; // 1010 ^ 10100 = 11110  (in decimal 10 ^ 20 = 30)
        b = a ^ b; // 11110 ^ 10100 =  1010  (in decimal 30 ^ 20 = 10)
        a = a ^ b; // 11110  ^ 1010 = 10100  (in decimal 30 ^ 10 = 20)


        System.out.println("After swapping values are... "  + a + " " + b);

        //Logic 5 - single statement
        a = 10; b = 20;
        System.out.println("Logic 5");
        System.out.println("Before swapping values are..." + a + " " + b);

        b = a + b - (a = b);

        /*Execution will be from right to left
        (a=b) <- a = 20
        a + b <- 10 + 20 = 30
        b = 30-20 <- b = 10
        */
        System.out.println("After swapping values are... "  + a + " " + b);
    }
}