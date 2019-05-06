import java.util.Scanner;

public class LZS {
    
    public void longestZigZagSubsequence(int inputArr[], int n) {
    
        int table[][] = new int[n][2];
        
        for(int i=0; i<n; i++) {
            table[i][0] = 1;
            table[i][1] = 1;
        }
        
        int finalLength = 1;
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                
                if(inputArr[i] > inputArr[j] && table[i][0] < table[j][1] + 1) {
                    table[i][0] = table[j][1]+1;
                }
                if(inputArr[i] < inputArr[j] && table[i][1] < table[j][0] + 1) {
                    table[i][1] = table[j][0]+1;
                }
                
            }
            
            if(finalLength < table[i][0]) {
                finalLength = table[i][0];
            }
            else if(finalLength < table[i][1]) {
                finalLength = table[i][1];
            }
            
        }
        
        
        System.out.println("Max zigzag length: "+ finalLength);
        System.out.println();
        
        
    }
    
    public static void main(String[] args) {
      
        System.out.print("Number of elements in the sequence: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println();
        
        int inputArr[] = new int[n];
        
        System.out.println("Enter the numbers one by one: ");
        
        for(int i=0; i<n; i++) {
            inputArr[i] = sc.nextInt();
        }
        System.out.println();
        
        System.out.println("Input Array: ");
        for(int a : inputArr) {
            System.out.print(a+", ");
        }
        System.out.println("\n");
        
        LZS lzs = new LZS();
        lzs.longestZigZagSubsequence(inputArr, n);
        System.out.println();
        
        
    }

}
