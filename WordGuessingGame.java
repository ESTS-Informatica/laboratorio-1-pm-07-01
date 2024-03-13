
/**
 * Write a description of class WordGuessingGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordGuessingGame
{
    private String hiddenWord;
    private String guessedWord;
    private int numberOfTries;
    private InputReader reader;
    private WordGenerator word;

    public WordGuessingGame()
    {
        word = new WordGenerator();
        this.hiddenWord = word.generateWord();
        this.guessedWord = "___";
        this.numberOfTries = 0;
        this.reader = new InputReader();
    }

    public String getHiddenWord() 
    {
        return hiddenWord;
    }

    public String getGuessedWord() 
    {
        return guessedWord;
    }

    public int getNumberOfTries() 
    {
        return numberOfTries;
    }
    
    private void showGuessedWord() //
    {
        System.out.println("Guessed Word: " + guessedWord);
    }
    
    public void play(InputReader reader)
    {
        showWelcome();
        do
        {
            guess(reader.getChar("Adivinha a letra!"));
        }
        while(!guessedWord.equals(hiddenWord));
        showResult();
    }
    
    private void showWelcome()
    {
        System.out.println("Bem-vindo ao jogo da forca");
        System.out.println("Tenta adivinhar a palavra oculta.");
        System.out.println("Tentaste " + numberOfTries + " vezes.");
        System.out.println("Vamos começar!");
    }
    
    private void guess(char letter)
    {
        boolean correctGuess = false;
        for(int i = 0; i < hiddenWord.length();i++)
        {
            if(hiddenWord.charAt(i) == letter && guessedWord.charAt(i) == '_')
            {
               guessedWord = guessedWord.substring(0,i) + letter + guessedWord.substring(i,hiddenWord.length() -1);
               correctGuess = true;
            }
        }
        if(correctGuess)
        {
                System.out.println("Acertou a letra!");
                System.out.println(getGuessedWord());
        }
            else
        {
                System.out.println("Letra errada!");
         }
        numberOfTries++;
    }
    
    private void showResult()
    {
        if(guessedWord.equals(hiddenWord))
        {
            System.out.println("A palavra era: " + getHiddenWord());
            System.out.println("Acertou a palavra em " + numberOfTries + " tentativas");
        }
    }
}
