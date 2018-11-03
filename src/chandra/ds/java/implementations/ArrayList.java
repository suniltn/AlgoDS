package com.chandra.ds.java.implementations;

//http://algoviz.org/OpenDSA/Books/OpenDSA/html/ListArray.html#

public class ArrayList {
	private Object listArray[];             // Array holding list elements
	  private static final int defaultSize = 10; // Default size
	  private int maxSize;                    // Maximum size of list
	  private int listSize;                   // Current # of list items
	  private int curr;                       // Position of current element
	
	
	public ArrayList(int size) {
		maxSize = size;
	    listSize = curr = 0;
	    listArray = new Object[size];         // Create listArray
	}
	
	public void clear()                     // Reinitialize the list
    { listSize = curr = 0; }              // Simply reinitialize values

  // Insert "it" at current position
  public boolean insert(Object it) {
    if (listSize >= maxSize) return false;
    for (int i=listSize; i>curr; i--)  // Shift elements up
      listArray[i] = listArray[i-1];   //   to make room
    listArray[curr] = it;
    listSize++;                        // Increment list size
    return true;
  }
  
//Append "it" to list
 public boolean append(Object it) {
   if (listSize >= maxSize) return false;
   listArray[listSize++] = it;
   return true;
 }

 // Remove and return the current element
 public Object remove() {
   if ((curr<0) || (curr>=listSize))  // No current element
     return null;
   Object it = listArray[curr];       // Copy the element
   for(int i=curr; i<listSize-1; i++) // Shift them down
     listArray[i] = listArray[i+1];
   listSize--;                        // Decrement size
   return it;
 }

 public void moveToStart() { curr = 0; }       // Set to front
 public void moveToEnd() { curr = listSize; }  // Set at end
 public void prev() { if (curr != 0) curr--; } // Move left
 public void next() { if (curr < listSize) curr++; } // Move right
 public int length() { return listSize; }      // Return list size
 public int currPos() { return curr; }         // Return current position
 
 // Set current list position to "pos"
 public boolean moveToPos(int pos) {
   if ((pos < 0) || (pos > listSize)) return false;
   curr = pos;
   return true;
 }

 // Return true if current position is at end of the list
 public boolean isAtEnd() { return curr == listSize; }

 // Return the current element
 public Object getValue() {
   if ((curr < 0) || (curr >= listSize)) // No current element
     return null;
   return listArray[curr];
 }
}
