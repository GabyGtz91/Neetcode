package stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println("Resultado: " + isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> pila = new Stack<>();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case '(', '[', '{' -> {
                    pila.push(c[i]);
                }
                case ')', ']', '}' -> {
                    if (pila.isEmpty()) {
                        return false;
                    } else {
                        if (apertura(c[i]) != pila.pop()) {
                            return false;
                        }
                    }
                }
                default -> {return false;}
            }
        }
        if (pila.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static char apertura(char caracter) {
        if (caracter == '}') return '{';
        else if (caracter == ']') return '[';
        else if (caracter == ')') return '(';
        else return 'x';
    }
}
