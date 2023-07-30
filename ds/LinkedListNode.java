public class LinkedListNode<T> {
  private int size = 0;
  private Node head = null;
  private Node tail = null;

  public LinkedListNode(T[] arr) {
    for (T t : arr) {
      add(t);
    }
    size = arr.length;
  }

  public LinkedListNode() {
  }

  public Node head() {
    return head;
  }

  public Node tail() {
    return tail;
  }

  public void add(T t) {
    if (head == null) {
      head = new Node(null, tail, t);
    } else if (tail == null) {
      tail = new Node(head, null, t);
      head.next = tail;
    } else {
      Node n = new Node(tail, null, t);
      tail.next = n;
      n.prev = tail;
      tail = n;
    }
    size++;
  }

  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("[");
    Node elm = head;
    if (elm == null) {
      output.append("]");
      return output.toString();
    }
    output.append(head);
    elm = elm.next;
    while (elm != null) {
      output.append(", " + elm.val);
      elm = elm.next;
    }
    output.append("]");
    return output.toString();
  }

  public int size() {
    return size;
  }

  public class Node {
    Node prev = null;
    Node next = null;
    T val;

    Node(Node prev, Node next, T val) {
      this.prev = prev;
      this.next = next;
      this.val = val;
    }

    Node(Node next, T val) {
      this.next = next;
      this.val = val;
    }

    Node(T val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return val.toString();
    }

  }

  public static void main(String[] args) {
    String[] arr = { "a", "b", "c" };
    LinkedListNode<String> list = new LinkedListNode<>(arr);
    list.add("Bruh");
    list.add("Yessir");
    System.out.println(list.toString() + " " + list.size());
  }

}
