import java.util.Scanner;

public class LIS {
    
    public void longestIncreasingSubsequence(int inputArr[]) {

        int maxLengthArr[] = new int[inputArr.length];
        int trackingArr[] = new int[inputArr.length];
        
        for(int i=0; i < inputArr.length; i++){
            maxLengthArr[i] = 1;
            trackingArr[i] = i;
        }
        
        for(int i=1; i<inputArr.length; i++) {
            for(int j=0; j<i; j++) {
                if(inputArr[i]>inputArr[j]) {
                    if(maxLengthArr[j]+1 > maxLengthArr[i]) {
                        maxLengthArr[i] = maxLengthArr[j]+1;
                        trackingArr[i] = j;
                    }
                }
            }
        }
        
        int maxIndex = 0;
        for(int i=0; i < maxLengthArr.length; i++){
            if(maxLengthArr[i] > maxLengthArr[maxIndex]){
                maxIndex = i;
            }
        }
        
        int lisLength = maxLengthArr[maxIndex];
        int solutionArr[] = new int[lisLength];
        int k = lisLength-1;
        
        int track = maxIndex;
        int newTrack = maxIndex;
        
        do{
            track = newTrack;
            solutionArr[k] = inputArr[track];
            k = k - 1;
            newTrack = trackingArr[track];
        }while(track != newTrack);
        
        System.out.println("Input Number Sequence: ");
        
        for(int num : inputArr) {
            System.out.print(num+", ");
        }
        System.out.println("\n");
        
        System.out.println("Longest Increasing Subsequence: ");
        
        for(int num : solutionArr) {
            System.out.print(num+", ");
        }
        System.out.println("\n");
        
        System.out.println("Length of Longest Increasing Subsequence: \n" + maxLengthArr[maxIndex]);
        System.out.println();
        
    }

    public static void main(String[] args) {
        
        System.out.println("Enter the Number of Guests: ");
        Scanner sc = new Scanner(System.in);
        int guests = sc.nextInt();
        System.out.println();
        
        //auto generating numbers for each guest
        int arr[] = new int [guests];
        for(int i=0; i<guests; i++) {
            arr[i] = (int) Math.round(Math.random()*guests);
        }
        
        
        LIS lis = new LIS();
        lis.longestIncreasingSubsequence(arr);

    }

}
