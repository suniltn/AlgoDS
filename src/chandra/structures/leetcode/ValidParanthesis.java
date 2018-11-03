package com.chandra.structures.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidParanthesis {
	
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) return false;
		Stack<Character> stack = new Stack<>();
		
		
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
		//	if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
			if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
			//if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
			//if (c == '(' || c == '{' || c == '[') stack.push(c);
			if (c == '{') stack.push(c);
		}
		
		
		/*for (int i=0;i<s.length();i++) {
			char c= s.charAt(i);
			switch(c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty()) return false;
				char p = stack.pop();
				if (p != '(') return false;
				break;
			case '}':
				if (stack.isEmpty()) return false;
				char p1 = stack.pop();
				if (p1 != '{') return false;
				break;
			case ']':
				if (stack.isEmpty()) return false;
				char p2 = stack.pop();
				if (p2 != '[') return false;
				break;
			default:
				return false;
			}
		}*/
		return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		System.out.println(isValid("{{{{{{{{}}}}}}}}"));
	}
}
