 /* File: IntStack.java
  * Classes: IntStack, Stack (interface)
  * Date: 2/19/2014
  * Class: Boston University CS 112, Spring 2013
  * Author: Wayne Snyder (snyder@bu.edu)
  * Editor: Calvin Yung, cyung20@bu.edu
  * Purpose: Example of simple array-based stack for Lab 04
  */

public class IntStack implements Stack {
  
  private int [] A = new int[5]; 
  
  private int next = 0;                        // location of next available unused slot  
  
  // interface methods
  
  public void push(int key) {         // push the key onto the top of the stack 
    A[next++] = key; 
  }
  
  // remove the top integer and return it -- will cause error if empty!
  public int pop() {  
      if (next == 0) {
          throw new IndexOutOfBoundsException("Stack Underflow!");
      } else {
          return A[--next];   
      }
  }
  
  public boolean isEmpty() {
    return (next == 0); 
  }
  
  public int size() {                 // how many integers in the stack 
    return next; 
  }
  
  // unit test
 
  public static void main(String [] args) {
    
    Stack S = new IntStack();        
 
    System.out.println("Pushing 5, 9, 9, -3, 31 then popping and printing it out:"); 
    S.push(5); S.push(9); S.push(9); S.push(-3); S.push(31);
    
    while(!S.isEmpty()) {
       System.out.println(S.pop()); 
    }
    
    
    
    // this one will cause an error!
    //System.out.println(S.pop());
    
    // So will this one!
    System.out.println("Pushing 5, 9, 9, -3, 31, and 99 then popping and printing it out:");
    int x = 5;
    S.push(x);
    x = 9;
    S.push(x);
    x = 9;
    S.push(x);
    x = -3;
    S.push(x);
    x = 31;
    S.push(x);
    x = 99;
    S.push(x);
    
    try { 
        push(x);
    }
    
    catch (Exception e) {
        System.out.println("Stack Overflow! Cannot push " + x);
        
    }  
    
    
  }
  
  
}


// Stack Interface

interface Stack { 
  public void push(int key);          // push the key onto the top of the stack 
  public int pop();                   // remove the top integer and return it 
  public boolean isEmpty(); 
  public int size();                  // how many integers in the stack 
}

class StackOverflowException extends Exception {
    public int num;
    public StackOverflowException(String msg, int n) {
        super(msg);
        num = n;
    }
}