package academy.devonline.temp;

/**
 * @author devonline
 * @link http://devonline.academy/javamm
 */
public class SourceLine {

    private final String fileName;

    private final int number;

    private final String text;

    public SourceLine(final String fileName, final int number, final String text) {

        this.fileName = fileName;
        this.number = number;
        this.text = text;
    }

    public String getFileName() {
        return fileName;
    }


    public int getNumber() {
        return number;
    }

}
