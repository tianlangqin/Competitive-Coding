import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class YearOfTheCow {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        HashMap<String, Integer> zodiacs = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.nextInt();
        String useless = "";
        map.put("Bessie", 0);
        String[] arr = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
        for (int i = 0; i < 12; i++) {
            zodiacs.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            String name = s.next();
            useless += s.next();
            useless += s.next();
            Boolean next = false;
            if (s.next().charAt(0) == 'n') {
                next = true;
            }
            String zodiac = s.next();
            useless += s.next();
            useless += s.next();
            String from = s.next();
            useless = "";


            int fromYear = map.get(from);
            int diff = zodiacs.get(zodiac);
            int yearMod12 = (12 + fromYear) % 12;
            if(fromYear % 12 == diff) {
                if (next)
                    map.put(name, fromYear + 12);
                else
                    map.put(name, fromYear - 12);
            }
            else {
                if (diff > yearMod12) {
                    if (next)
                        map.put(name, fromYear + diff - yearMod12);
                    else
                        map.put(name, fromYear + diff - yearMod12 - 12);
                }
                else{
                    if (next)
                        map.put(name, fromYear + diff - yearMod12 + 12);
                    else
                        map.put(name, fromYear + diff  - yearMod12);
                }
            }
        }
        System.out.println(Math.abs(map.get("Elsie")));
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
