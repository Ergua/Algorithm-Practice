package basicDataStructure;

/**
 * Created by FYG on 17/8/3.
 */
public class Intervals {
    public int start;
    public int end;
    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
