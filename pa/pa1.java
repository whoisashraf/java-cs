
// Import scanner from Java to allow reading user input
import java.util.Scanner;

/**
 * hello
 */
public class pa1 {

    public static void main(String[] args) {
        // initiate scanner class to be able to read user input
        Scanner scanner = new Scanner(System.in);
        // Get players name
        System.out.println("What is your name? ");
        // Read name from user input and store in a variable
        String name = scanner.nextLine();
        // Display welcome message
        System.out.println(String.format("Welcome to the quiz games %s! ", name));
        System.out.println("Let's begin our game");
        // Store 1st question in a variable
        String question1 = """
                Question 1:
                What is the capital city of Australia?
                A. Sydney
                B. Melbourne
                C. Canberra
                D. Brisbane""";
        // Store correct answer in a variable
        String correctAnswer1 = "C";
        // Print question to user
        System.out.println(question1);
        // Read user input, convert to uppercase and store in a variable
        String answer1 = scanner.nextLine().toUpperCase();
        // Add an empty newline for readability
        System.out.println("");

        // Store 2nd question in a variable
        String question2 = """
                Question 2:
                Which planet is known as the "Red Planet"?
                A. Venus
                B. Mars
                C. Jupiter
                D. Saturn""";
        // Store correct answer in a variable
        String correctAnswer2 = "B";
        // Print question to user
        System.out.println(question2);
        // Read user input, convert to uppercase and store in a variable
        String answer2 = scanner.nextLine().toUpperCase();
        // Add an empty newline for readability
        System.out.println("");

        // Store 3rd question in a variable
        String question3 = """
                Question 3:
                Who wrote the play "Romeo and Juliet"?
                A. Charles Dickens
                B. William Shakespeare
                C. Jane Austen
                D. Mark Twain""";
        // Store correct answer in a variable
        String correctAnswer3 = "B";
        // Print question to user
        System.out.println(question3);
        // Read user input, convert to uppercase and store in a variable
        String answer3 = scanner.nextLine().toUpperCase();
        // Add an empty newline for readability
        System.out.println("");

        // Store 4th question in a variable
        String question4 = """
                Question 4:
                What is the powerhouse of the cell?
                A. Nucleus
                B. Mitochondria
                C. Endoplasmic reticulum
                D. Golgi apparatus""";
        // Store correct answer in a variable
        String correctAnswer4 = "B";
        // Print question to user
        System.out.println(question4);
        // Read user input, convert to uppercase and store in a variable
        String answer4 = scanner.nextLine().toUpperCase();
        // Add an empty newline for readability
        System.out.println("");

        // Store 5th question in a variable
        String question5 = """
                Question 5:
                Which programming language is often used for web development?
                A. Java
                B. Python
                C. HTML
                D. Swift""";
        // Store correct answer in a variable
        String correctAnswer5 = "C";
        // Print question to user
        System.out.println(question5);
        // Read user input, convert to uppercase and store in a variable
        String answer5 = scanner.nextLine().toUpperCase();
        // Add an empty newline for readability
        System.out.println("");
        // Close scanner to free up memory
        scanner.close();

        // Initialize variable score to keep count of correct answers
        int score = 0;

        // If user's answer to question 1 equals the correct answer, increase the score
        // count by 1
        if (answer1.matches(correctAnswer1)) {
            ++score;
        }
        // If user's answer to question 2 equals the correct answer, increase the score
        // count by 1
        if (answer2.matches(correctAnswer2)) {
            ++score;
        }
        // If user's answer to question 3 equals the correct answer, increase the score
        // count by 1
        if (answer3.matches(correctAnswer3)) {
            ++score;
        }
        // If user's answer to question 4 equals the correct answer, increase the score
        // count by 1
        if (answer4.matches(correctAnswer4)) {
            ++score;
        }
        // If user's answer to question 5 equals the correct answer, increase the score
        // count by 1
        if (answer5.matches(correctAnswer5)) {
            ++score;
        }

        // Calculate the user's score in percentage
        int percentage = score * 20;
        // Print score to the user
        System.out.println(String.format("Your score is a %d%% out of 100%%", percentage));

        // Output:
        // What is your name?
        // Ashraf
        // Welcome to the quiz games Ashraf!
        // Let's begin our game
        // Question 1:
        // What is the capital city of Australia?
        // A. Sydney
        // B. Melbourne
        // C. Canberra
        // D. Brisbane
        // c

        // Question 2:
        // Which planet is known as the "Red Planet"?
        // A. Venus
        // B. Mars
        // C. Jupiter
        // D. Saturn
        // d

        // Question 3:
        // Who wrote the play "Romeo and Juliet"?
        // A. Charles Dickens
        // B. William Shakespeare
        // C. Jane Austen
        // D. Mark Twain
        // d

        // Question 4:
        // What is the powerhouse of the cell?
        // A. Nucleus
        // B. Mitochondria
        // C. Endoplasmic reticulum
        // D. Golgi apparatus
        // d

        // Question 5:
        // Which programming language is often used for web development?
        // A. Java
        // B. Python
        // C. HTML
        // D. Swift
        // d

        // Your score is a 20% out of 100%

    }
}