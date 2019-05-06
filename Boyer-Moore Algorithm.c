//
//  main.c
//  Test
//
//  Created by Chamod AK on 3/11/18.
//  Copyright © 2018 Chamod AK. All rights reserved.
//

#include <stdio.h>
#include <string.h>

int find (char p[], char ch);
int boyermoorematch(char s[], char p[]);

int main(){
    int index = boyermoorematch("acdcd", "cd");
    if(index==-1){
        printf("Pattern not found\n");
    }
    else{
        printf("Pattern foun at index of %d\n", index);
    }
    return 0;
}

int boyermoorematch(char s[], char p[]){
    
    int n,m,i,j,lastch;
    
    n = strlen(s);
    m = strlen(p);
    i = m-1;                // matching starting from right to left
    j = m-1;                // matching starting from right to left
    
    while (i<n) {           //text index number doesn't go beyond text length
        if (p[j]==s[i]) {
            if (j==0) {     //first character of pattern
                return i;
            }
            else{
                i--;        //going left
                j--;        //going left
            }
        }
        else{                           //not matching with pattern
            lastch = find(p, s[i]);     // check the index of last character
            if (lastch==-1) {           // not found
                i = i+m;                // jump over
            }
            else{
                i = i+j-lastch; // align character(remeber the equation
            }
            j = m-1;            //restart from right
        }
    }
    return -1;                  // not matched
    
    
}

int find (char p[], char ch){   //finding the last index of a given char, in
    int m, i;                   //..in the pattern
    m = strlen(p);
    
    for(i=0; i<m; i++){
        if(p[i]==ch){
            return i;
        }
    }
    return -1;
    
}

