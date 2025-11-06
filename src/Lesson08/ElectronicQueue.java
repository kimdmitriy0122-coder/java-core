package Lesson08;

import java.util.PriorityQueue;
import java.util.Queue;

public class ElectronicQueue {
    private Queue<Integer> clientsQueue = new PriorityQueue();
    private static Integer rowNumber = 0;

    public String register(){
        int nextRowNumber = rowNumber++;
        if(clientsQueue.offer(nextRowNumber))
            return "your number in a queue is " + nextRowNumber;
        else
            return "invalid operation. queue is overloaded";
    }

    public void processed() {
        if (clientsQueue.poll() == null)
            throw new ArrayIndexOutOfBoundsException("queue is empty");
    }
}
