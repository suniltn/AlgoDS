package com.chandra.structures.topcoder;

/**
Problem Statement
    	Computers tend to store dates and times as single numbers which represent the number of seconds or milliseconds since a particular date. Your task in this problem is to write a method whatTime, which takes an int, seconds, representing the number of seconds since midnight on some day, and returns a string formatted as "<H>:<M>:<S>". Here, <H> represents the number of complete hours since midnight, <M> represents the number of complete minutes since the last complete hour ended, and <S> represents the number of seconds since the last complete minute ended. Each of <H>, <M>, and <S> should be an integer, with no extra leading 0's. Thus, if seconds is 0, you should return "0:0:0", while if seconds is 3661, you should return "1:1:1".
Definition
    	
Class:	Time
Method:	whatTime
Parameters:	int
Returns:	string
Method signature:	string whatTime(int seconds)
(be sure your method is public)
    
 
Constraints
-	seconds will be between 0 and 24*60*60 - 1 = 86399, inclusive.
Examples
0)	 
    	
0
Returns: "0:0:0"
 
1)	 
    	
3661
Returns: "1:1:1"
 
2)	 
    	
5436
Returns: "1:30:36"
 
3)	 
    	
86399
Returns: "23:59:59"
 
*/
public class Time {
	public String whatTime(int seconds) {
		int secs = seconds % 60;
		seconds /= 60;
		int mins = seconds % 60;
		seconds /= 60;
		int hours = seconds % 24;
		return String.valueOf(hours) + ":" + String.valueOf(mins) + ":" + String.valueOf(secs); 
	}
	
	public static void main(String[] args) {
		Time t = new Time();
		System.out.println(t.whatTime(0));
		System.out.println(t.whatTime(3661));
		System.out.println(t.whatTime(5436));
		System.out.println(t.whatTime(86399));
	}
}
