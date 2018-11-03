package com.chandra.structures.dynamic;

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

http://algorithms.tutorialhorizon.com/dynamic-programming-edit-distance-problem/
	
*/


/* Applications:
 * In com­puter sci­ence, edit dis­tance is a way of quan­ti­fy­ing how dis­sim­i­lar two strings (e.g., words) 
 * are to one another by count­ing the min­i­mum num­ber of oper­a­tions required to trans­form one string into the other. 
 * Edit dis­tances find appli­ca­tions in nat­ural lan­guage pro­cess­ing, where auto­matic spelling cor­rec­tion can deter­mine 
 * can­di­date cor­rec­tions for a mis­spelled word by select­ing words from a dic­tio­nary that have a low dis­tance to the word in ques­tion. 
 * In bioin­for­mat­ics, it can be used to quan­tify the sim­i­lar­ity of DNA sequences, which can be viewed as strings of 
 * the let­ters A, C, G and T. Source wiki: https://en.wikipedia.org/wiki/Edit_distance
 * https://web.stanford.edu/class/cs124/lec/med.pdf
 */
public class EditDistanceProblem_21 {

	private int getMin(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	
    public int editDistanceDP(String s1, String s2) {
        int [][] solution = new int[s1.length()+1][s2.length()+1];
        
        //base case
        //If any of the string if empty then number of operations
        //needed would be equal to the length of other string
        //(Either all characters will be removed or inserted)
        for (int i = 0; i <=s2.length(); i++) {//all elements will be inserted
            solution[0][i] =i;
        }

        for (int i = 0; i <=s1.length(); i++) {//all elements will be removed
            solution[i][0] =i;
        }

        //solving it bottom-up manner
        int m = s1.length();
        int n = s2.length();
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                //If last characters are matching, ignore the last character
                // then the solution will be same as without the last character.
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    solution[i][j] = solution[i-1][j-1]; // diagonal value
                else
                    solution[i][j] = 1 + getMin(solution[i][j-1], //Insert - left
                                         solution[i-1][j], // Remove - above
                                         solution[i-1][j-1]); //Replace - diagonal
            }
        }
        return solution[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "horizon";
        String s2 = "horizontal";
        EditDistanceProblem_21 ed = new EditDistanceProblem_21();
        System.out.println("Minimum Edit Distance -(DP): " + ed.editDistanceDP(s1, s2));
    }
}