package ymj;

/**
 * Created by FYG on 17/8/3.
 */
public class BusinessInfo{
    int rating;
    int id;
    BusinessInfo(int rating, int id) {
        this.rating = rating;
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + id + ", " + rating + "]";
    }
}
