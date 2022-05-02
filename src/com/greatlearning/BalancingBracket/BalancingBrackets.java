package com.greatlearning.BalancingBracket;

import java.util.Stack;

public class BalancingBrackets {
	
	public static void main(String[] args) {
		
		String bracketExp = "([[{}]]))";
		
		Boolean result = checkBracketBalanced(bracketExp);
		
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
	}
	
	private static Boolean checkBracketBalanced(String bracketExp) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<bracketExp.length();i++) {
			
			char character = bracketExp.charAt(i);
			
			if(character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;				
			}
			
			if(stack.isEmpty()) {
				return false;
			}
			char temp;
			switch (character) {

			case '}': 
				temp = stack.pop();
				if(temp == '(' || temp == '[')
					return false;
				break;
				
			case ')': 
				temp = stack.pop();
				if(temp == '{' || temp == '[')
					return false;
				break;
				
			case ']': 
				temp = stack.pop();
				if(temp == '(' || temp == '{')
					return false;
				break;				
			}
		}		
		return stack.isEmpty();			
	}

}
