package collections;

import java.util.Enumeration;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList  aLinkedList = new LinkedList();

        Enumeration e = aLinkedList.enumerate();

        while(e.hasMoreElements()) {
            Object obj = e.nextElement();
            System.out.println(obj.toString());
        }
    }
}