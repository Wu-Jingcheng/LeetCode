// the time complexity is supposed to be O(1)
import java.util.*;

public class MaxQueue {
  private Queue<Integer> core = new LinkedList<Integer>();
  private ArrayDeque<Integer> maxHelper = new ArrayDeque<Integer>();

  public MaxQueue() {

  }

  public int max_value() {
    return maxHelper.isEmpty() ? -1 : maxHelper.peekFirst();
  }

  public void push_back(int value) {
    core.add(value);
    while (!maxHelper.isEmpty() && value > maxHelper.peekLast())
      maxHelper.pollLast();
    maxHelper.add(value);
  }

  public int pop_front() {
    if (core.isEmpty())
      return -1;
    if (maxHelper.peekFirst().equals(core.peek()))
      maxHelper.pollFirst();
    return core.poll();
  }

  public static void main(String[] args) {
    MaxQueue q1 = new MaxQueue();
    System.out.println("Checking case1: ");
    q1.push_back(1);
    q1.push_back(2);
    System.out.println("Checkpoint1: " + (q1.max_value() == 2));
    q1.pop_front();
    System.out.println("Checkpoint2: " + (q1.max_value() == 2));
    System.out.println();

    MaxQueue q2 = new MaxQueue();
    System.out.println("Checking case2: ");
    System.out.println("Checkpoint1: " + (q2.pop_front() == -1));
    System.out.println("Checkpoint2: " + (q2.pop_front() == -1));
    System.out.println();

    MaxQueue q3 = new MaxQueue();
    q3.push_back(47);
    System.out.println(q3.pop_front() + "," + q3.max_value() + "," + q3.maxHelper.isEmpty());
    q3.push_back(800);
    System.out.println(q3.pop_front() + "," + q3.max_value());
    q3.push_back(500);
    q3.pop_front();
    System.out.println("Checking case3: " + q3.max_value());

  }

}
