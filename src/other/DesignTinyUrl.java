package other;

import java.util.HashMap;

/**
 * Created by FYG on 17/7/20.
 */
public class DesignTinyUrl {
    private int counter = 0;
    private HashMap<String, Integer> longToShort = new HashMap<>();
    private HashMap<Integer, String> shortToLong = new HashMap<>();
    private final String elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = base10ToBase62(counter);
        longToShort.put(longUrl, counter);
        shortToLong.put(counter, longUrl);
        counter++;
        return "http://tinyurl.com/" + shortUrl;
    }

    private String base10ToBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, elements.charAt(n % 62));
            n /= 62;
        }
        while (sb.length() < 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String url = shortUrl.substring("http://tinyurl.com/".length());
        int n = base62ToBase10(url);
        return shortToLong.get(n);
    }

    private int base62ToBase10(String url) {
        int n = 0;
        for (int i = 0; i < url.length(); i++) {
            n = n * 62 + convert(url.charAt(i));
        }
        return n;
    }


    private int convert(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A';
        }
    }

    ///////////////////////////////////////////////////
    private int counter2 = 0;
    private HashMap<String, String> longToShort2 = new HashMap<>();
    private HashMap<String, String> shortToLong2 = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode2(String longUrl) {
        String shortUrl = base10ToBase62(counter2);
        longToShort2.put(longUrl, shortUrl);
        shortToLong2.put(shortUrl, longUrl);
        counter2++;
        return "http://tinyurl.com/" + shortUrl;
    }

    public String decode2(String shortUrl) {
        String url = shortUrl.substring("http://tinyurl.com/".length());
        return shortToLong2.get(url);
    }

    public static void main(String[] args) {
        DesignTinyUrl test = new DesignTinyUrl();
        String s1 = "https://leetcode.com/problems/encode-and-decode-tinyurl/#/description";
        String s2 = "https://zhuanlan.zhihu.com/p/27800261?group_id=867800594176430080";
        String short1 = test.encode(s1);
        String short2 = test.encode(s2);
        System.out.println(short1);
        System.out.println(short2);
        System.out.println(test.decode(short1));
        System.out.println(test.decode(short2));
        String short11 = test.encode2(s1);
        String short22 = test.encode2(s2);
        System.out.println(short11);
        System.out.println(short22);
        System.out.println(test.decode2(short11));
        System.out.println(test.decode2(short22));
    }
}
