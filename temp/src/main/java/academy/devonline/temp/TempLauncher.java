package academy.devonline.temp;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public class TempLauncher {

    public static void main(String[] args) {

        final SourceLine sourceLine = new SourceLine("file1.txt", 5, "hello");

        System.out.println(sourceLine.getFileName());

        System.out.println(sourceLine.getNumber());


    }

}
