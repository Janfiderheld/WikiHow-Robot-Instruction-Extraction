package nlp;

import model.verbs.ISearchableVerb;
import utils.OccurrenceChecker;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SentencePreprocessor {

    private final static String[] sentenceCombiners = new String[]{"and", "where", "if", "before", "while"};

    public static Map<String, String> preprocessDescription(String description, ISearchableVerb verb) {
        String desc = preprocessWholeDescription(description);
        ArrayList<String> sentences = splitAndFilterSentences(desc, verb);
        Map<String, String> processedSentences = new HashMap<>();
        for(String sent : sentences) {
            processedSentences.put(sent, preprocessSentence(sent, verb));
        }
        return processedSentences;
    }

    public static String preprocessWholeDescription(String description) {
        description = convertFractionsToDecimal(description);
        description = removeSpecialCharacters(description);
        return description.toLowerCase();
    }

    private static String removeSpecialCharacters(String description) {
        description = description.replaceAll("(\\d)-(\\d)", "$1 to $2");
        description = description.replaceAll("[(].*?[)]", "");
        description = description.replaceAll("\\?", ".");
        description = description.replaceAll("!", ".");
        description = description.replaceAll(";", "");
        description = description.replaceAll("\"", "");
        description = description.replaceAll("“", "");
        description = description.replaceAll("”", "");
        description = description.replaceAll("\n", " ");
        description = description.replaceAll(":", "");
        description = description.replaceAll("—", " ");
        description = description.replaceAll("-", " ");
        description = description.replaceAll(" {2}", " ");
        description = description.replaceAll("\\.{2,}", ".");

        description = description.replaceAll("`", "'");
        description = description.replaceAll("’", "'");
        description = description.replaceAll("'ve", " have");
        description = description.replaceAll("n't", " not");
        description = description.replaceAll("'re", " are");
        description = description.replaceAll("'", "");
        return description;
    }

    private static String convertFractionsToDecimal(String description) {
        description = Normalizer.normalize(description, Normalizer.Form.NFKD).replaceAll(" \u2044", "/");
        while(description.contains("/")) {
            int location = description.indexOf("/");
            char before = description.charAt(location - 1);
            char after = description.charAt(location + 1);
            if(Character.isDigit(after)) {
                double beforeValue = 1.0;
                int locBefore = location;
                if(Character.isDigit(before)) {
                    beforeValue = Character.digit(before, 10);
                    locBefore = location - 1;
                }
                double fract = beforeValue / ((double) Character.digit(after, 10));
                fract = (Math.round(fract * 100.0) / 100.0);
                description = description.substring(0, locBefore) + " " + fract + description.substring( location + 2);
            } else {
                description = description.substring(0, location) + " or " + description.substring( location + 1);
            }
        }

        return description;
    }

    /**
     * Takes the step description string and returns a list containing all sentences from the description.
     * @param desc step description to split up
     * @return list containing the split up description
     */
    public static ArrayList<String> splitDescriptionIntoSentences(String desc) {
        // split the description at each period (.)
        String[] sentences = desc.split("\\.");
        ArrayList<String> gluedSent = new ArrayList<>();
        try {
            for(int i = 0; i < sentences.length; i++) {
                // since double measurements (like 2.5l) also use a period, we look for
                // substrings that begin with a number (the number after the decimal point)
                // and stitch them together with the last sentences already handled
                if(i > 0 && sentences[i].substring(0, 1).matches("\\d")) {
                    int loc = i - 1;
                    while(loc >= gluedSent.size()) {
                        loc--;
                    }
                    gluedSent.remove(loc);
                    gluedSent.add((sentences[loc] + "." + sentences[i]).trim());
                } else {
                    gluedSent.add(sentences[i].trim());
                }
            }
        } catch (Exception ex) {
            System.out.printf("Error %s while processing description %s\n", ex, desc);
        }
        return gluedSent;
    }

    private static ArrayList<String> splitAndFilterSentences(String desc, ISearchableVerb verb) {
        ArrayList<String> gluedSent = splitDescriptionIntoSentences(desc);
        gluedSent.removeAll(gluedSent.stream().filter(s -> !OccurrenceChecker.checkOccurrence(s, verb)).toList());
        return gluedSent;
    }

    private static String preprocessSentence(String sent, ISearchableVerb verb) {
        sent = cutGivenSentenceAtComma(sent, verb);
        for(var word : sentenceCombiners) {
            sent = cutGivenSentenceAtWord(sent, word, verb);
        }
        return removeSpecialCharacters(sent);
    }

    private static String cutGivenSentenceAtComma(String sent, ISearchableVerb verb) {
        int verbBeginLocation = OccurrenceChecker.getVerbLocationInSentenceChars(sent, verb);
        if(sent.contains(",") && sent.lastIndexOf(",") > verbBeginLocation) {
            for(int i = verbBeginLocation; i < sent.length(); i++) {
                if(sent.charAt(i) == ',') {
                    sent = sent.substring(verbBeginLocation, i);
                    break;
                }
            }
        } else {
            sent = sent.substring(verbBeginLocation);
        }
        return sent;
    }

    private static String cutGivenSentenceAtWord(String toCut, String word, ISearchableVerb verb) {
        if(!OccurrenceChecker.doesWordOccurInSentence(word, toCut)) {
            return toCut;
        }

        int verbBeginLocation = OccurrenceChecker.getVerbLocationInSentenceChars(toCut, verb);
        int wordBeginLocation = toCut.indexOf(word);
        return toCut.substring(verbBeginLocation, wordBeginLocation);
    }

    public static String cleanBeforeAfterString(String toClean) {
        return toClean.replace("the ", "").replace("a ", "").replace("an ", "").replace("your ", "").trim();
    }
}