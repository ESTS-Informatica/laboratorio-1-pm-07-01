import java.util.ArrayList;

public class WordGenerator {
    private ArrayList<String> words; 

    public WordGenerator() 
    {
        this.words = new ArrayList<>();
    }

     public String generateWord() {
        if (words.isEmpty()) 
        {
            return null;
        }
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }
    
    private void  fillArrayList()
    {
        String[] aux = {"boolean", "break", "byte", "case", "char", "class", 
            "continue", "do", "double", "else", "enum", "for", 
            "if", "import", "int"};
        for (String string : aux) 
        {
            words.add(string);
        }
    }
    
    public void addWord(String word) 
    {
        words.add(word);
    }
    
    private String initializeGuessedWord(String hiddenWord) 
    {
        String guessedWord = "";
        for(int i = 0; i < hiddenWord.length();i++)
        {
            guessedWord = guessedWord.substring(0,i) + "_";
        }
        return guessedWord;
    }
}