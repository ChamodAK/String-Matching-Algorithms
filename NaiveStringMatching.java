public class NaiveStringMatching {

    public static void main(String[] args) {
        
       
        String T[] = {"a", "a", "b", "c", "c", "a", "a", "b", "b"};
        String P[] = {"a", "a", "b"};
        
        int n = T.length;
        int m = P.length;
        
        int count = 0;
        
        for(int i=0; i<n-m; i++) {
            int j=0;
            while(j<m && T[i+j]==P[j]) {
                j++;
            }
            if(j==m) {
                System.out.println("Match found at index: " + i);
                count++;
            }
        }
        
        if(count==0) {
            System.out.println("There is no sub-string of T matching P");
        }
       
        
    }

}