package other;

/**
 * Created by FYG on 17/7/17.
 */
import java.util.Random;

public class ReservoirSampling {
    public int Reservoir(int[] input) {
        Random random = new Random();
        //int result = input[0];
        for (int i = 1; i < input.length; i++) {
            int k = random.nextInt(i + 1);
            if (k == 0) {
                int temp = input[0];
                input[0] = input[i];
                input[i] = temp;
            }
        }
        return input[0];
    }

    public static void main(String[] args) {
        ReservoirSampling test = new ReservoirSampling();
        System.out.println(test.Reservoir(new int[]{1, 2, 3, 4}));
    }
}

