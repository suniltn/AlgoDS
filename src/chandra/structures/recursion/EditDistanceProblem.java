package com.chandra.structures.recursion;

/**
Edit Distance Problem
Objec­tive: Given two strings, s1 and s2 and edit oper­a­tions (given below). Write an algo­rithm to find min­i­mum num­ber oper­a­tions required to con­vert string s1 into s2.

Allowed Oper­a­tions:

Inser­tion — Insert a new character.
Dele­tion — Delete a character.
Replace — Replace one char­ac­ter by another.
Exam­ple:

String s1 = "horizon"
String  s2 = "horzon"
Output: 1  {remove 'i' from string s1}

String s1 = "horizon"
String  s2 = "horizontal"
Output: 3  {insert 't', 'a', 'l' characters in string s1}

Approach:

Start com­par­ing one char­ac­ter at a time in both strings. Here we are com­par­ing string from right to left (backwards).

Now for every string we there are two options:

If last char­ac­ters in both the strings are same then just ignore the char­ac­ter and solve the rest of the string recursively.
Else if last char­ac­ters in both the strings are not same then we will try all the pos­si­ble oper­a­tions ( insert, replace, delete) and get the solu­tion for rest of the string recur­sively for each pos­si­bil­ity and pick the min­i­mum out of them.
Let’s say given strings are s1 and s2 with lengths m and n respectively.

case 1: last char­ac­ters are same , ignore the last character.
Recur­sively solve for m-1, n-1
case 2: last char­ac­ters are not same then try all the pos­si­ble oper­a­tions recursively.
Insert a char­ac­ter into s1 (same as last char­ac­ter in string s2 so that last char­ac­ter in both the strings are same): now s1 length will be m+1, s2 length : n, ignore the last char­ac­ter and Recur­sively solve for m, n-1.
Remove the last char­ac­ter from string s1. now s1 length will be m-1, s2 length : n, Recur­sively solve for m-1, n.
Replace last char­ac­ter into s1 (same as last char­ac­ter in string s2 so that last char­ac­ter in both the strings are same): s1 length will be m, s2 length : n, ignore the last char­ac­ter and Recur­sively solve for m-1, n-1.

http://algorithms.tutorialhorizon.com/dynamic-programming-edit-distance-problem/

So in worst case we need to per­form the oper­a­tion on every char­ac­ter of the string, since we have 3 oper­a­tions, Time Com­plex­ity will be O(3^n).

Dynamic programming can solve this in O(n^2)
*/
public class EditDistanceProblem {

	public int editDistanceRecursion(String s1, String s2, int m, int n){
        //If any of the string if empty then number of operations
        //needed would be equal to the length of other string
        //(Either all characters will be removed or inserted)

        if(m==0)
            return n; //all elements will be inserted.
        if(n==0)
            return m; // all elements will be removed.

        //If last characters are matching, ignore the last character
        // and make a recursive call with last character removed.
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return editDistanceRecursion(s1, s2, m-1, n-1);

        //If nothing above worked then we need to try all 3 operations
        //and choose the minimum among them
        return 1 + Math.min(editDistanceRecursion(s1, s2, m, n-1), //Insert
                Math.min(editDistanceRecursion(s1, s2, m-1, n), // Remove
                        editDistanceRecursion(s1, s2, m-1, n-1))); //Replace
    }
}
