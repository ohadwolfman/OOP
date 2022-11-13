import java.util.Stack;
import java.lang.StringBuilder;
/**
 * This class creates an object of the type UndoableStringBuilder
 * the class allows to add strings, delete, insert and replace substrings,
 * so that it is able to apply an undo operation and get the previous string received
 *
 * @author Ohad Wolfman and Benji Kehat
 * @version 2
 */

public class UndoableStringBuilder {
     StringBuilder stb = new StringBuilder();
    Stack<String> stack=new Stack<String>();

    public UndoableStringBuilder (){
        StringBuilder stb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
    }

    /**
     * This function appends a string to another string
     * and pushes it into Stack so that the previous operation can be returned by the undo function
     */
    public UndoableStringBuilder append(String str){
        stb.append(str);
        stack.addElement(stb.toString());
        return this;
    }
    /**
     * This function delete a slice of string from one index to another,
     * and pushes it into Stack so that the previous operation can be returned by the undo function
     */
    public UndoableStringBuilder delete(int start, int end){
        stb.delete(start, end);
        stack.addElement(stb.toString());
        return this;
    }
    /**
     * This function insert a string into accepted index
     * and pushes it into Stack so that the previous operation can be returned by the undo function
     */
    public UndoableStringBuilder insert(int offset, String str){
        stb.insert(offset, str);
        stack.addElement(stb.toString());
        return this;

    }
    /**
     * This function takes subString from one index to another and replace it with another String
     * and pushes it into Stack so that the previous operation can be returned by the undo function
     */
    public UndoableStringBuilder replace(int start,int end, String str){
        stb.replace(start, end, str);
        stack.addElement(stb.toString());
        return this;

    }
    /**
     * This function is reversing the accepted StringBuilder Object
     * and pushes it into Stack so that the previous operation can be returned by the undo function
     */
    public UndoableStringBuilder reverse(){
        stb.reverse();
        stack.addElement(stb.toString());
        return this;
    }
    public void undo() {
        stack.pop();
        if (!stack.isEmpty()) {
            stb.replace(0, stb.length(), stack.peek());
        } else {
            stb.replace(0, stb.length(), "");
        }
    }
    public String toString() {
        return stb.toString();
        }

    public static void main(String[] args){
		StringBuilder stb = new StringBuilder();
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not");
        System.out.println(usb.stb.toString());
        usb.reverse();
        System.out.println(usb.stb.toString());
        usb.append(" to be");
        System.out.println(usb.stb.toString());
        usb.replace(0,6,"reversed");
        System.out.println(usb.stb.toString());
        usb.insert(7,"hhhh");
        System.out.println(usb.stb.toString());
        usb.delete(0,10);

        System.out.println(usb.stb.toString());
        //System.out.println(usb.stack.pop());
        usb.undo();
        System.out.println(usb.stb.toString());
        usb.undo();
        System.out.println(usb.stb.toString());
        usb.undo();
        System.out.println(usb.stb.toString());
        usb.undo();
        System.out.println(usb.stb.toString());
        usb.undo();
        System.out.println(usb.stb.toString());


    }
}
