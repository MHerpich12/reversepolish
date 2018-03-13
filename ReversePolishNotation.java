import java.util.Scanner;
import java.math.BigInteger;
/**
 * Reverse Polish Notation class uses Stacks and RedBlackTrees to iteratively receive and compute
 * Reverse Polish expressions from user.  Supports standard operations, unary minus, modulo division,
 * and variable assignment.  Program keeps iterating until it throws and Exception or the user inputs
 * Enter.
 */

public class ReversePolishNotation {
    public static void main(String[] args) {

        /**
         * Initialize Stack and RedBlackTree and read input from user as String.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************************************");
        System.out.println("Welcome to Reverse Polish Notation evaluator.  Please enter expressions or return to terminate");
        String string1 = " ";
        Stack RParray = new Stack();
        RedBlackTree RPtree = new RedBlackTree();

        /**
         * Process String input, pushing/popping from Stack and adding to RedBlackTree as necessary.
         * All non-operator characters and numbers are pushed to the Stack.  Operator characters pop
         * integers or characters off Stack in LIFO format.  Characters are dereferenced to their
         * BigInteger assignments using RedBlackTree.  If a character is unassigned, order of operations is mixed,
         * or an invalid name is assigned to a character, the program throws an Exception.
         * Pre-Condition: requires valid RPN syntax with each number/character/operator separated by a space.
         * Post-Condition: evaluates expression and displays result.
         */
        while(!string1.isEmpty()){
            string1 = scanner.nextLine();
            if(string1.isEmpty()){
                System.out.println("Terminating.");
                break;
            } else {
                String[] expression = string1.split(" "); //parse String by spaces
                for(int i = 0; i < expression.length; i++){
                    if(expression[i].equals("+")){
                        BigInteger anum;
                        BigInteger bnum;

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger c = anum.add(bnum);
                        //System.out.println(c);
                        RParray.push(String.valueOf(c));
                    } else if(expression[i].equals("-")){
                        BigInteger anum;
                        BigInteger bnum;

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger c = anum.subtract(bnum);
                        //System.out.println(c);
                        RParray.push(String.valueOf(c));
                    } else if(expression[i].equals("*")){
                        BigInteger anum;
                        BigInteger bnum;

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger c = anum.multiply(bnum);
                        //System.out.println(c);
                        RParray.push(String.valueOf(c));
                    } else if(expression[i].equals("/")){
                        BigInteger anum;
                        BigInteger bnum;

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger c = anum.divide(bnum);
                        //System.out.println(c);
                        RParray.push(String.valueOf(c));
                    } else if(expression[i].equals("%")){
                        BigInteger anum;
                        BigInteger bnum;

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger c = anum.mod(bnum);
                        //System.out.println(c);
                        RParray.push(String.valueOf(c));
                    } else if(expression[i].equals("#")){
                        BigInteger anum;
                        BigInteger bnum;
                        BigInteger cnum;

                        String c = (String) RParray.pop();
                        char co = c.charAt(0);
                        if(Character.isDigit(co) || co == '-'){
                            cnum = new BigInteger(c);
                        } else {
                            cnum = new BigInteger(RPtree.queryNode(c));
                        }

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger d = anum.modPow(bnum, cnum);
                        //System.out.println(d);
                        RParray.push(String.valueOf(d));
                    } else if(expression[i].equals("~")){
                        BigInteger anum;

                        String a = (String) RParray.pop();
                        char ao = a.charAt(0);
                        if(Character.isDigit(ao) || ao == '-'){
                            anum = new BigInteger(a);
                        } else {
                            anum = new BigInteger(RPtree.queryNode(a));
                        }

                        BigInteger b = anum.multiply(BigInteger.valueOf(-1));

                        //System.out.println(b);
                        RParray.push(String.valueOf(b));
                    } else if(expression[i].equals("=")){
                        String key;
                        BigInteger bnum;

                        String b = (String) RParray.pop();
                        char bo = b.charAt(0);
                        if(Character.isDigit(bo) || bo == '-'){
                            bnum = new BigInteger(b);
                        } else {
                            bnum = new BigInteger(RPtree.queryNode(b));
                        }

                        key = (String) RParray.pop();
                        char ko = key.charAt(0);
                        if(Character.isDigit(ko) || ko == '-'){
                            try{
                                throw new CustomException("Error: " + key + " is not a valid variable name.");
                            } catch(CustomException e){
                                e.printStackTrace();
                                System.exit(0);
                            }
                        }

                        RPtree.insert(key, bnum);
                        //System.out.println(RPtree.queryNode(key));
                        RParray.push(RPtree.queryNode(key));
                    } else {
                        RParray.push(expression[i]);
                    }
                }
            }
            String output = (String) RParray.pop();
            char outo = output.charAt(0);
            if(Character.isDigit(outo) || outo == '-'){
                System.out.println(output);
            } else {
                System.out.println(RPtree.queryNode(output));
            }
        }
    }
}
