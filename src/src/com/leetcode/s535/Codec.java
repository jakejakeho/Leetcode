package src.com.leetcode.s535;

public class Codec {

    private static final String[] database = new String[(int) Math.pow(10, 4)];

    private static final String SITE_BASE_URL = "http://tinyurl.com/";

    private static int DATABASE_AUTO_INCREMENT_INDEX = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int index = getCurrentIndex();
        String encodedUrl = SITE_BASE_URL + index;
        database[index] = longUrl;
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl.substring(SITE_BASE_URL.length()));
        return database[index];
    }

    public int getCurrentIndex() {
        return DATABASE_AUTO_INCREMENT_INDEX++;
    }
}