import java.util.Date;

/**
 * MainTest provides a test to see which method works better.
 *
 * @author Todd Wallentine todd AT wallentine com
 */
public class MainTest {
    public static void main(String[] args) {
        int MAX = 10000;
        String line = "This a test line to see which reverse algorithm works better.";

        long startTime = new Date().getTime();
        for(int i = 0; i < MAX; i++) {
            String rLine = Main.reverseLine2(line);
        }
        long runTime = (new Date().getTime()) - startTime;
        System.out.println("Runtime for " + MAX + " loops is " + runTime);
    }
}
