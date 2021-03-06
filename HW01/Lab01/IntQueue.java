/* File: IntQueue.java
 * Date: 1/27/14
 * Author:  Wayne Snyder (snyder@bu.edu)
 * Edited by: Calvin Yung (cyung20@bu.edu)
 * Class: CS 112, Lab01
 * Purpose: Contains methods that allow the user to add and remove items from a queue.
 */

public class IntQueue implements IntQueueable {
    private int[] array = new int[10];         
    private int next = 0;
    
    // Adds a value at the end of an array
    public void enqueue(int enqueueNum) {
        array[next] = enqueueNum;
        ++next;
    }
    
    // Removes a value from the front of the array and then shifts everything
    public int dequeue() {
        int dequeueNum = array[0];
        for(int i = 0; i < next; ++i)
            array[i] = array[i + 1];
        --next;
        return dequeueNum;
    }
    
    // Prints the entire array
    public void list() {
        for(int i = next - 1; i >= 0; --i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    
    // Checks if the array is empty.
    public boolean isEmptyarray() {
        return(next == 0);
    }
}

interface IntQueueable {
    public void enqueue(int enqueueNum);
    public int dequeue();
    public void list();
    public boolean isEmptyarray();
}