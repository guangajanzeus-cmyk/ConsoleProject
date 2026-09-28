import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class JavaHangmanGame {

    public static void main(String[] args) {

        String path = "src\\words.txt";

        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
            words.add(line.trim());
            }
        }
        catch (NullPointerException e) {
            System.out.println("Null Pointer Error");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Please check there is an Error");
        }
        catch (FileNotFoundException e) {
            System.out.println("Something wrong with the file");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));

        Scanner sc = new Scanner(System.in);

        ArrayList<Character> wordState = new ArrayList<>();
        int wrongGuess = 0;

        for (char i = 0 ; i < word.length(); i++){
            wordState.add('_');
        }

        System.out.println("*****************");
        System.out.println("JAVA HANGMAN GAME");
        System.out.println("*****************");

        while (wrongGuess < 6){
            System.out.println(getHangmanArt(wrongGuess));
            System.out.print("Word: ");

            for (char c: wordState){
                System.out.print(c + " ");
            }

            System.out.println();


            System.out.print("Guess the Letter: ");

            char guess = sc.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("CORRECT GUESS");

                for (int i = 0 ; i < word.length(); i++){
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')){
                    System.out.println(getHangmanArt(wrongGuess));
                    System.out.println("You WON!");
                    System.out.println("The word is: " + word);
                    break;
                }
            }


            else{
                wrongGuess++;
                System.out.println("TRY AGAIN!");
            }
        }
        if (wrongGuess >= 6) {
            System.out.println(getHangmanArt(wrongGuess));
            System.out.println("YOU LOSE");
            System.out.println("GAME OVER");
            System.out.println("THE WORD YOU DIDN't GOT: " + word );
        }




        sc.close();

    }

    static String getHangmanArt(int wrongGuess){
        return switch (wrongGuess) {
            case 0 -> """
                      
                      
                      
                      """;
            case 1 -> """
                       o
                     
                     
                     """;
            case 2 -> """
                       o
                      /
                      
                      """;
            case 3 -> """
                       o
                      /|
                      
                      """;
            case 4 -> """
                       o
                      /|\\
                      
                      """;
            case 5-> """
                       o
                      /|\\
                      /
                      """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;
            default -> " ";
        };
    }
}
