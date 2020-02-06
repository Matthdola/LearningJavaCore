package collections;

import java.util.Enumeration;
public class LinkedList {
    private Node root;

    public Enumeration enumerate() {
        return new LinkedListEnumerator(root);
    }
}


class Node {
    private Object contents;
    private Node next;


    public Object contents() {
        return contents;
    }

    public Node next() {
        return next;
    }
}

class LinkedListEnumerator implements Enumeration {
    private Node currentNode;

    LinkedListEnumerator(Node root) {
        currentNode = root;
    }

    @Override
    public boolean hasMoreElements() {
        return currentNode != null;
    }

    @Override
    public Object nextElement() {
        Object obj = currentNode.contents();

        currentNode = currentNode.next();
        return obj;
    }
}