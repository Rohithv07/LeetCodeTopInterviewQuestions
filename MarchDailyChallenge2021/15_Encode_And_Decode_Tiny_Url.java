Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.


public class Codec {

    private Map<Integer, String> map = new HashMap<>();
    private int counter = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(counter, longUrl);
        return "http://tinyurl.com/" + counter++;
        /* The following is also possible answer
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
        */
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        // thiss method is the same for both approaches.
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
