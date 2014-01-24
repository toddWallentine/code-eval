import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * The Main class provides a main entry point to the Morse Code challenge on CodeEval.
 *
 * @author Todd Wallentine todd AT wallentine com
 */
public class Main {
    private static final Map<String, Character> morseCodeMap = new HashMap<String, Character>();
    static {
        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');
        morseCodeMap.put("-----", '0');
    }


    public static void main(String[] args) throws Exception {
        String filename = args[0];
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {
            String message = decodeMessage(line.trim());
            System.out.println(message);
        }

        br.close();
    }

    /**
     * Decode the morse code message.
     *
     * @param codedMessage The morse code to decode.
     * @return The decoded message; this might be empty but never null.
     */
    public static String decodeMessage(final String codedMessage) {
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for(int i = 0; i < codedMessage.length(); i++) {
            if(codedMessage.charAt(i) == ' ') {
                String codedCharacter = codedMessage.substring(start, i);
                sb.append(decodeCharacter(codedCharacter));

                if(codedMessage.charAt(i + 1) == ' ') {
                    sb.append(' ');
                    i++;
                }

                start = i + 1;
            }
        }
        String codedCharacter = codedMessage.substring(start);
        sb.append(decodeCharacter(codedCharacter));

        return sb.toString().trim();
    }

    /**
     * Decode the given morse code String into a character.
     *
     * @param codedCharacter The morse code representation of the character.
     * @return The decoded character.
     */
    public static char decodeCharacter(final String codedCharacter) {
        return morseCodeMap.get(codedCharacter);
    }
}