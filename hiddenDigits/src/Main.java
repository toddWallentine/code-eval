import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * The Main class provides the main entry point for the Hidden Digits CodeEval challenge (122).
 *
 * @author Todd Wallentine todd AT wallentine com
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String hiddenDigits = decode(line.trim());
            if(hiddenDigits.length() < 1) {
                System.out.println("NONE");
            } else {
                System.out.println(hiddenDigits);
            }
        }

        br.close();
    }

    /**
     * Decode the given String into digits.
     *
     * @param codedString The String that is coded.
     * @return A String containing the visible and hidden digits. Might be empty.
     */
    public static String decode(final String codedString) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < codedString.length(); i++) {
            switch(codedString.charAt(i)) {
                case '0':
                case 'a': sb.append(0); break;
                case '1':
                case 'b': sb.append(1); break;
                case '2':
                case 'c': sb.append(2); break;
                case '3':
                case 'd': sb.append(3); break;
                case '4':
                case 'e': sb.append(4); break;
                case '5':
                case 'f': sb.append(5); break;
                case '6':
                case 'g': sb.append(6); break;
                case '7':
                case 'h': sb.append(7); break;
                case '8':
                case 'i': sb.append(8); break;
                case '9':
                case 'j': sb.append(9); break;
            }
        }

        return sb.toString().trim();
    }
}
