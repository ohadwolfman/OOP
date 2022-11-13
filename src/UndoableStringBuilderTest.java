import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoableStringBuilderTest {

    @Test
    void appendStringToNewUsb() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        assertEquals("test", usb.stb.toString());
    }

    @Test
    void appendNullStringToUsb() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append(null);
        System.out.println(usb.stb.toString().equals("null"));
    }

    @Test
    void appendEmptyString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("");
        System.out.println(usb.stb.toString().equals(""));
    }

    @Test
    void appendStringToUsb() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        usb.append(" appended string");
        System.out.println(usb.stb.toString().equals("test appended string"));
    }

    @Test
    void deleteStringFromExisitStringInUsb() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test me please");
        usb.delete(4, 6);
        assertEquals("teste please", usb.stb.toString());
    }

    @Test
    void deleteEndIndexOutOfBounce() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test me");
        usb.delete(4, 10);
        assertEquals("test", usb.stb.toString());

    }

    @Test
    void deleteStartIndexAfterLastIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test me");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            usb.delete(8,15);
        });
    }

    @Test
    void deleteFromNegativeIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test me");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            usb.delete(-2, 3);
        });
    }

    @Test
    void deleteStartIndexAfterEndIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test me");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            usb.delete(4, 3);
        });
    }

    @Test
    void insertStringFromSpecificIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("tt me");
        usb.insert(1,"es");
        assertEquals("test me", usb.stb.toString());
    }

    @Test
    void insertNullString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("tt me");
        usb.insert(1,null);
        assertEquals("tnullt me", usb.stb.toString());
    }

    @Test
    void insertEmptyString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("tt me");
        usb.insert(1,"");
        assertEquals("tt me", usb.stb.toString());
    }

    @Test
    void insertFromNegativeIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        assertThrows(StringIndexOutOfBoundsException.class, ()->{
            usb.insert(-3,"me");
        });
    }
    @Test
    void insertFromIndexAfterLastIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        assertThrows(StringIndexOutOfBoundsException.class, ()->{
            usb.insert(7,"hi!");
        });
    }

    @Test
    void replaceSubStringFromIndextoIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        usb.replace(2,4,"a!");
        assertEquals("tea!",usb.stb.toString());
    }

    @Test
    void replaceLongerSubStringThanThePrevious() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        usb.replace(2,4,"a is good");
        assertEquals("tea is good",usb.stb.toString());
    }

    @Test
    void replaceShorterSubStringThanThePrevious() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        usb.replace(2,4,"a");
        assertEquals("tea",usb.stb.toString());
    }

    @Test
    void replaceEndIndexAfterEndOfString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        usb.replace(2,15,"a is good!");
        assertEquals("tea is good!",usb.stb.toString());
    }

    @Test
    void replaceFromNegativeIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            usb.replace(-3, 4, "hi!");
        });
    }

    @Test
    void replaceEndIndexBeforeStartIndex() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            usb.replace(2, 1, "hi!");
        });
    }

    @Test
    void replaceStartIndexAfterString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            usb.replace(5, 7, "hi!");
        });
    }

    @Test
    public void reverseString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("test me");
        usb.reverse();
        assertEquals("em tset", usb.stb.toString());
    }

    @Test
    public void reverseEmptyString() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.reverse();
        assertEquals("", usb.stb.toString());
    }

    @Test
    public void undoOnce() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("undo this");
        usb.undo();
        assertEquals("", usb.stb.toString());
    }

    @Test
    public void undoThrice() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("undo this");
        usb.delete(0, 2);
        usb.reverse();
        usb.undo();
        usb.undo();
        usb.undo();
        assertEquals("", usb.stb.toString());
    }

    @Test
    public void undoNothingToUndo() {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.undo();
        assertEquals("", usb.stb.toString());
    }
}