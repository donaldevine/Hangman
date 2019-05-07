import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int ALLOWEDINGUESSES = 6;
        final char[] correctWord = {'O', 'R', 'A', 'N', 'G', 'E'};
        final int SIZE = correctWord.length;
        boolean finished = false;
        boolean alreadyGuessed = false;
        int noOfGuesses = 0;
        int noOfLettersGuessed = 0;
        int noOfWrongGuesses = 0;
        char guessChar = ' ';
        int number = 0;

        char[] guessWord = new char[SIZE];

        for (int index = 0; index < SIZE; index++) {
            guessWord[index] = '_';
        }

        do {

            System.out.println(" ");
            System.out.println(" ");

            for (int index2 = 0; index2 < SIZE; index2++) {
                System.out.print(guessWord[index2] + " ");
            }

            System.out.println(" ");
            System.out.println("Guess a character? ");
            guessChar = keyboard.next().charAt(0);

            //Check if letter has already been guessed correctly
            alreadyGuessed = false;

            number = 0;

            for (int i = 0; i < SIZE; i++) {

                if (guessWord[i] == guessChar) {
                    alreadyGuessed = true;
                }
            }

            if (alreadyGuessed) System.out.println(guessChar + " has already been guessed.");

            if (!alreadyGuessed) {
                noOfGuesses++;
                //Check if letter is in the word
                for (int x = 0; x < SIZE; x++) {
                    if (correctWord[x] == guessChar) {
                        guessWord[x] = guessChar;
                        number++;
                    }
                }

                if (number > 0) {

                    noOfLettersGuessed++;

                    if (noOfLettersGuessed == SIZE) {
                        System.out.println("Congratulations");
                        System.out.println("Number of guesses: " + noOfGuesses);

                        System.out.print("Word is: ");
                        for (int index2 = 0; index2 < SIZE; index2++) {
                            System.out.print(guessWord[index2]);
                        }

                        System.out.println(" ");
                        finished = true;
                    } else {
                        System.out.println(guessChar + " appears " + number + " time(s) in the word.");
                    }
                } else {
                    noOfWrongGuesses++;
                }

                if (!finished) printMan(noOfWrongGuesses);

                if (noOfWrongGuesses >= ALLOWEDINGUESSES) {
                    System.out.println("Word not guessed correctly in time!");
                    finished = true;
                }
            }

        } while (!finished);

    }

    protected static void printMan(int noOfParts) {
        System.out.println("________");
        System.out.println("|\t |");
        switch (noOfParts) {
            case 1:
                System.out.println("|\t o");
                break;
            case 2:
                System.out.println("|\t o");
                System.out.println("|\t O");
                break;
            case 3:
                System.out.println("|\t o");
                System.out.println("|\t/O");
                break;
            case 4:
                System.out.println("|\t o");
                System.out.println("|\t/O\\");
                break;
            case 5:
                System.out.println("|\t o");
                System.out.println("|\t/O\\");
                System.out.println("|\t/");
                break;
            case 6:
                System.out.println("|\t o");
                System.out.println("|\t/O\\");
                System.out.println("|\t/ \\");
                break;
        }//switch
    }//printMan
}
