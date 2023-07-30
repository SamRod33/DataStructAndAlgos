import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<E> {
  private int loadFactor = 10;
  private E[] stack;
  private Class<E> clazz;

  public Stack(Class<E> clazz) {
    this.clazz = clazz;
    stack = (E[]) Array.newInstance(clazz, loadFactor * 3);
  }

  public Stack(Class<E> clazz, int load) {
    loadFactor = load;
    this.clazz = clazz;
    stack = (E[]) Array.newInstance(clazz, loadFactor * 3);
  }

  public void capacity() {
    E[] newArr = (E[]) Array.newInstance(clazz, loadFactor * 3);
    int i = 0;
    for (E e : stack) {
      newArr[i / loadFactor * loadFactor + i] = e;
    }
    stack = newArr;
  }

  public void push1(E val) {
    int i = 0;
    if (stack[i] != null)
      capacity();
    int limit = stack.length / 3;
    while (i < limit) {
      if (stack[i] == null) {
        stack[i] = val;
        return;
      }
      i++;
    }
    stack[limit - 1] = val;
  }

  public void push2(E val) {
    int i = stack.length / 3;
    if (stack[i] != null)
      capacity();
    int limit = 2 * stack.length / 3;
    while (i < limit) {
      if (stack[i] == null) {
        stack[i] = val;
        return;
      }
      i++;
    }
    stack[limit - 1] = val;
  }

  public void push3(E val) {
    int i = 2 * stack.length / 3;
    if (stack[i] != null)
      capacity();
    int limit = stack.length;
    while (i < limit) {
      if (stack[i] == null) {
        stack[i] = val;
        return;
      }
      i++;
    }
    stack[limit - 1] = val;
  }

  public E pop(int i, int limit) {
    while (i < limit) {
      if (stack[i] != null) {
        E val = stack[i];
        stack[i] = null;
        return val;
      }
      i++;
    }
    return null;
  }

  public E peek(int i, int limit) {
    while (i < limit) {
      if (stack[i] != null) {
        return stack[i];
      }
      i++;
    }
    return null;
  }

  public E pop1() {
    return pop(0, stack.length / 3);
  }

  public E pop2() {
    return pop(stack.length / 3, 2 * stack.length / 3);
  }

  public E pop3() {
    return pop(2 * stack.length / 3, stack.length);
  }

  public E peek1() {
    return peek(0, stack.length / 3);
  }

  public E peek2() {
    return peek(stack.length / 3, 2 * stack.length / 3);
  }

  public E peek3() {
    return peek(2 * stack.length / 3, stack.length);
  }

  public String toString() {
    return Arrays.toString(stack);
  }

  public static void main(String[] args) {
    Stack<Integer> s = new Stack<>(Integer.class);
    System.out.println(s);
    s.push1(1);
    System.out.println(s);
    s.push1(2);
    System.out.println(s);
    s.push1(3);
    System.out.println(s);
    s.push2(2);
    System.out.println(s);
    s.push3(4);
    System.out.println(s);
    s.push2(10);
    System.out.println(s);

  }

}
