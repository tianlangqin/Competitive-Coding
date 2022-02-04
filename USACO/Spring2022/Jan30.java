
public class Jan30 {
    public static void main(String[] args) {
        System.out.println(ransomNote("low goal","hello how are you doing"));
    }
    static boolean ransomNote(String ransom, String magazine) {
        int n = ransom.length();
        int m = magazine.length();
        int[] countRansom = new int[256];
        int[] countMagazine = new int[256];
        for (int i = 0; i < n; i++) {
            countRansom[ransom.charAt(i)]++;
        }
        for (int i = 0; i < m; i++) {
            countMagazine[magazine.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++){
            if (countMagazine[i] < countRansom[i] && countMagazine[i] != 0){
                return false;
            }
        }
        return true;
    }
}
