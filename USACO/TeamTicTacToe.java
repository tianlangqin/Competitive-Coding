import java.io.*;
import java.util.*;

public class TeamTicTacToe {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("tttt");
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            board[i] = io.next().toCharArray();
        }
        io.println(singleWin(board));
        io.println(teamWin(board));
        io.close();
    }
    public static int singleWin(char[][] board) {
        HashSet<Character> cows = new HashSet<>();
        int result = 0;
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && !cows.contains(board[0][0])) {
            result++;
            cows.add(board[0][0]);
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && !cows.contains(board[2][0])) {
            result++;
            cows.add(board[0][2]);
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && !cows.contains(board[i][0])) {
                result++;
                cows.add(board[i][0]);
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && !cows.contains(board[i][0])) {
                result++;
                cows.add(board[0][i]);
            }
        }
        return result;
    }

    public static int teamWin(char[][] board) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<String> teams = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            //check rows
            set.add(board[i][0]);
            set.add(board[i][1]);
            set.add(board[i][2]);
            if (set.size() == 2) {
                result++;
                String str = "";
                String str2 = "";
                StringBuilder sb = new StringBuilder();
                for (char j : set) {
                    str += j;
                }
                sb.append(str);
                sb.reverse();
                str2 = sb.toString();
                if (teams.contains(str) || teams.contains(str2))
                    result--;
                else {
                    teams.add(str);
                    teams.add(str2);
                }
            }
            set.clear();

            //check columns
            set2.add(board[0][i]);
            set2.add(board[1][i]);
            set2.add(board[2][i]);
            if (set.size() == 2) {
                result++;
                String str = "";
                String str2 = "";
                StringBuilder sb = new StringBuilder();
                for (char j : set) {
                    str += j;
                }
                sb.append(str);
                sb.reverse();
                str2 = sb.toString();
                if (teams.contains(str) || teams.contains(str2))
                    result--;
                else {
                    teams.add(str);
                    teams.add(str2);
                }
            }
            set2.clear();
        }

        //check diagonals
        set.clear();
        set.add(board[0][0]);
        set.add(board[1][1]);
        set.add(board[2][2]);
        if (set.size() == 2) {
            result++;
            String str = "";
            String str2 = "";
            StringBuilder sb = new StringBuilder();
            for (char j : set) {
                str += j;
            }
            sb.append(str);
            sb.reverse();
            str2 = sb.toString();
            if (teams.contains(str) || teams.contains(str2))
                result--;
            else {
                teams.add(str);
                teams.add(str2);
            }
        }

        set.clear();
        set.add(board[2][0]);
        set.add(board[1][1]);
        set.add(board[0][2]);
        if (set.size() == 2) {
            result++;
            String str = "";
            String str2 = "";
            StringBuilder sb = new StringBuilder();
            for (char j : set) {
                str += j;
            }
            sb.append(str);
            sb.reverse();
            str2 = sb.toString();
            if (teams.contains(str) || teams.contains(str2))
                result--;
            else {
                teams.add(str);
                teams.add(str2);
            }
        }

        return result;
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
