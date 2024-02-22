import java.util.Scanner;

public class TestPostfixConverter {
	
	// algorithm that converts infix to postfix
	public static String convertToPostFix(String infix) {
		// initialize operator stack
	    StackInterface<String> operatorStack = new OperatorStack<String>();
	    
	    // use string builder to make an empty empty string that will be added to as the algorithm runs
	    StringBuilder postfix = new StringBuilder();
	    // create reference to the top operator
	    String topOperator;
	    
	    // get the length of the inputed string infix
	    int characterCount = infix.length();
	    int index = 0;
	    char nextCharacter = ' ';

	    // loop through the entire infix
	    while (index < characterCount) {
	        nextCharacter = infix.charAt(index);

	        switch (nextCharacter) {
	        // used the 4 characters from the text book as characters that will just add to the postfix and not result in re-ordering
	            case 'a': case 'b': case 'c': case 'e' :
	                postfix.append(nextCharacter);
	                break;
	            case '^':
	                operatorStack.push(String.valueOf(nextCharacter));
	                break;
	                // for these operators, check their precedence and determine if they have equal or higher precedence
	            case '+': case '-': case '*': case '/':
	                while (!operatorStack.isEmpty() && checkPrecedence(nextCharacter) <= checkPrecedence(operatorStack.peek().charAt(0))) {
	                    postfix.append(String.valueOf(operatorStack.pop()));
	                }
	                operatorStack.push(String.valueOf(nextCharacter));
	                break;
	            case '(':
	                operatorStack.push(String.valueOf(nextCharacter));
	                break;
	            case ')':
	                topOperator = operatorStack.pop();
	                while (!topOperator.equals("(")) {
	                    postfix.append(topOperator);
	                    topOperator = operatorStack.pop();
	                }
	                break;
	            default:
	                break;
	        }
	        index++;
	    }

	    while (!operatorStack.isEmpty()) {
	        postfix.append(operatorStack.pop());
	    }

	    return postfix.toString();
	}

	// method that returns an int based on the operator in order to determine precedence in algorithm
    public static int checkPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
        
    }

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an infix value: ");
		String infix = scanner.nextLine();
		scanner.close();
		String postfix = convertToPostFix(infix);
		System.out.println(postfix);
		
	}
}