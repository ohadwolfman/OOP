import java.util.Stack;
import java.lang.StringBuilder;
/**
 * This class does something useful
 * @author Ohad Wolfman and Benji Kehat
 * @version 2
 */

public class UndoableStringBuilder {
    /**Initial size*/
     StringBuilder stb = new StringBuilder();
    Stack<String> stack=new Stack<String>();

    public UndoableStringBuilder (){
        StringBuilder stb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
    }

    /**
     * This function calculates something
     * param num 1 The first number
     * param num 2 The second number
     * @return What we get from those two numbers
     */
    public UndoableStringBuilder append(String str){
        stb.append(str);
        stack.addElement(stb.toString());
        return this;
    }
    /**
     * This function calculates something
     * param num 1 The first number
     * param num 2 The second number
     * @return What we get from those two numbers
     */
    public UndoableStringBuilder delete(int start, int end){
        return this;
    }
    /**
     * This function calculates something
     * param num 1 The first number
     * param num 2 The second number
     * @return What we get from those two numbers
     */
    public UndoableStringBuilder insert(int offset, String str){
        return this;

    }
    /**
     * This function calculates something
     * param num 1 The first number
     * param num 2 The second number
     * @return What we get from those two numbers
     */
    public UndoableStringBuilder replace(int start,int end, String str){
        return this;

    }
    /**
     * This function calculates something
     * param num 1 The first number
     * param num 2 The second number
     * @return What we get from those two numbers
     */
    public UndoableStringBuilder reverse(){
        return this;

    }

    public static void main(String[] args){
		StringBuilder stb = new StringBuilder();
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not");
        System.out.println(usb.stb.toString());
        usb.append(" to be");
        System.out.println(usb.stb.toString());
        System.out.println(usb.stack.pop());
        System.out.println(usb.stack.pop());
        System.out.println(usb.stack.toString());
    }
}
