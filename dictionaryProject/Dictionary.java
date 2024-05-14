package dictionaryProject;

import java.io.*;

public class Dictionary {

    private File dictionary;
    private HashMap<String, String> map = new HashMap(1);
    BufferedReader r;

    public Dictionary(File dictionary) throws FileNotFoundException, IOException {
        this.dictionary = dictionary;
        this.r = new BufferedReader(new FileReader(dictionary));
        String word;
        while ((word = r.readLine()) != null) {
            word = word.trim(); word = word.toLowerCase();
            map.put(word, word);
        }
    }

    public void insertWord(String word) throws IOException{
        map.put(word, word);
    }

    public void removeWord(String word) {
        map.remove(word);
    }

    public String searchWord(String word) {
        HashMap.map<String, String> result = map.search(word);
        if (result == null) {
            return null;
        }
        return (String) result.getValue();
    }

    public void checkSpelling(File file) throws FileNotFoundException, IOException {
        r = new BufferedReader(new FileReader(file));
        String line;
        while ((line = r.readLine()) != null) {
            String[] words = line.split("[\\s\\p{Punct}]+");
            for (String word : words) {
                word = word.trim();
                word = word.toLowerCase();
                if (searchWord(word) == null) {
                    System.out.println(word + ": is spelled incorrectly");
                }

            }
        }
    }

}
