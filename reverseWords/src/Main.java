import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * The Main class provides an entry point for the Reverse Words challenge.
 *
 * @author Todd Wallentine todd AT wallentine com
 */
public class Main {
    /**
     * The main method takes a single argument which is a file name for the source
     * of words to reverse. Each line in the file will be reversed and printed to
     * stdout.
     */
    public static void main(String[] args) throws Exception {
        String fileName = args[0];

        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line = br.readLine()) != null) {
            if(line.trim().length() > 0) {
                String reversedLine = reverseLine2(line.trim());
                System.out.println(reversedLine);
            }
        }

        br.close();
    }

    /**
     * Reverse the words in the given line.
     *
     * @param line The line to reverse the words for.
     * @return A String containing the reversed words.
     */
    public static String reverseLine(final String line) {
        StringBuilder sb = new StringBuilder();

        Deque<String> deque = new ArrayDeque<String>();
        StringTokenizer st = new StringTokenizer(line, " ");
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            deque.push(token);
        }
        for(String item : deque) {
            sb.append(item + " ");
        }

        return sb.toString().trim();
    }

    /**
     * Reverse the words in the given line.
     *
     * @param line The line to reverse the words for.
     * @return A String containing the reversed words.
     */
    public static String reverseLine2(final String line) {
        StringBuilder sb = new StringBuilder();

        boolean done = false;
        int i = line.length() - 1;
        int last = line.length();
        while(!done) {
            while((line.charAt(i) != ' ') && (i > 0)) {
                i--;
            }
            if(i == 0) {
                sb.append(line.substring(i, last) + " ");
                done = true;
            } else {
                sb.append(line.substring(i + 1, last) + " ");
                last = i;
                i--;
            }
        }

        return sb.toString().trim();
    }
}