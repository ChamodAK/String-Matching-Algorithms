//
//  main.c
//  Test
//
//  Created by Chamod AK on 3/11/18.
//  Copyright © 2018 Chamod AK. All rights reserved.
//

#include <stdio.h>
#include <string.h>

int main(){
    
    char pattern[10], text[30];
    
    printf("Enter a text: ");
    scanf("%s",&text);
    printf("Enter a pattern: ");
    scanf("%s", &pattern);
    
    printf("Your Text is: %s\nYour Pattern is: %s\n", text, pattern);
    
    int tLen, pLen;
    
    tLen = strlen(text);
    pLen = strlen(pattern);
    printf("Length of the text is: %d\n", tLen);
    printf("Length of the pattern is: %d\n", pLen);
    
    //------ from using for loops --------//
    
    /*for(int i=0; i<tLen-pLen; i++){
        int matchCount=0;
        for(int j=0; j<pLen; j++){
            if(pattern[j]==text[i+j]){
                matchCount ++;
            }
        }
        if (matchCount==pLen){
            printf("Pattern found at Index %d\n", i);
        }
    }*/
    
    
    //----------- from using while loop --------- //
    
    for(int i=0; i<tLen-pLen; i++){
        int j = 0;
        while(j<pLen && pattern[j]==text[i+j]){
            j = j+1;
            if (j==pLen){
                printf("Pattern found at Index %d\n", i);
            }
        }
    }
    
    
    return 0;
    
}
