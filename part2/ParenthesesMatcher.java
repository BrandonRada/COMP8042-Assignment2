import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParenthesesMatcher{

    // Function that checks if the opening parenthesis matches the closing parenthesis
    private static boolean matches(char opening, char closing){
        return (opening == '(' && closing == ')') || (opening == '{' && closing == '}') || (opening == '[' && closing == ']'); 
    }
    

    public static boolean checkFile(String filename){
        ArrayListStack<Character> parenthesesStack = new ArrayListStack<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader(filename))){
            String line;
            int lineNumber = 1;

            // While the buffered reader still has something to read
            while((line = bReader.readLine()) != null){
                // Look through the whole line for parenthesis (each character)
                for(char currentCharacter: line.toCharArray()){
                    
                    // Check for opening bracket
                    if(currentCharacter == '(' || currentCharacter == '{' || currentCharacter == '['){
                        parenthesesStack.push(currentCharacter);
                    }

                    //check for closing bracket
                    if (currentCharacter == ')' || currentCharacter == '}' || currentCharacter == ']'){
                        // If the stack is empty, then we there was no opening parentheses.
                        if (parenthesesStack.empty()){
                            System.out.println("Error in " + filename + ": closing'"  + currentCharacter + "' at line " + lineNumber + " with no matching opening bracket");
                            return false;
                        }

                        // No need to hold integrity of the stack, if this character doesnt match the current parenthesis, then there is an error.
                        char openingBracket = parenthesesStack.pop();
                        if(!matches(openingBracket, currentCharacter)){
                            System.out.println("Error in " + filename + ": '" + openingBracket + "' does not match '" + currentCharacter + "' at line " + lineNumber);
                            return false;
                        }
                    }
                }
                lineNumber++;
            }
            if (!parenthesesStack.empty()){
                System.out.println("Error in " + filename + ": file ended but an opening bracket '" + parenthesesStack.peek() + "' was never closed");
                return false;
            }
        } catch (IOException e){
            System.out.println("Error reading file: " + filename);
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Usage: ParenthesesMatcher <file1> <file2> ... <fileN>");
            return;
        }

        // Check each file the user entered
        for (String file: args){
            boolean allParenthesesCorrect = checkFile(file);
            if(allParenthesesCorrect){
                System.out.println(file + ": All parenthesis match!");
            }
        }
    }
}
/**
 * My program runs at O(n) as the while loop runs once per line, and the for loop runs for only each character in a line once.
 *
 * 
 *  StackParenthesesTask4.java: All parenthesis match!                java ParenthesesMatcher StackParenthesesTask1.java StackParenthesesTask2.java StackParenthesesTask3.java StackParenthesesTask4.java
    Error in StackParenthesesTask1.java: file ended but an opening bracket '{' was never closed
    Error in StackParenthesesTask2.java: '{' does not match ')' at line 54
    Error in StackParenthesesTask3.java: '{' does not match ')' at line 380
    StackParenthesesTask4.java: All parenthesis match!
 */