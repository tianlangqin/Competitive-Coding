package Templates;

public class RabinKarp {
    public static void main(String[] args) {
        System.out.println(search("abc", "abdajf"));
        System.out.println(search("abc", "abdabcf"));
                                                    // 012345678901234
        System.out.println(search("abc", "abdafwefabc"));
    }

    // d is the number of characters in the input alphabet
    public final static int d = 256;
 
    /* 
        q -> A prime number
    */
    public static int search(String seek, String within) {
        int q = 101;
        int M = seek.length();
        int N = within.length();
        
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
 
        // The value of h would be "pow(d, M-1)%q"
        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;
 
        // Calculate the hash value of pattern and first
        // window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + seek.charAt(i)) % q;
            t = (d * t + within.charAt(i)) % q;
        }
 
        // Slide the pattern over text one by one
        for (int i = 0; i <= N - M; i++) {
 
            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                int j;
                for (j = 0; j < M; j++) {
                    if (within.charAt(i + j) != seek.charAt(j))
                        break;
                }
 
                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    return i;
            }
 
            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - within.charAt(i) * h)
                     + within.charAt(i + M))
                    % q;
 
                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
            
        }
        return -1;
    }
}
