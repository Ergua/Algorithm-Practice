package ymj;

/**
 * Created by FYG on 17/8/17.
 */
public class IntegertoEnglishWords {
    private  String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousand = {"", "Thousand", "Million", "Billion"};

    public String numberToWord(int num) {
        if (num == 0) {
            return "Zero";
        }

        String word = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + thousand[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 10) {
            return belowTen[num] + " ";
        } else if (num < 20) {
            return belowTwenty[num - 10] + " ";
        } else if (num < 100) {
            return belowHundred[num / 10] + " " + helper(num % 10);
        } else {
            return belowTen[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        IntegertoEnglishWords test = new IntegertoEnglishWords();
        System.out.println(test.numberToWord(101329));
    }
}
