/*
 * File: driver1.c
 * Robert Gonzalez... YOU NEED TO IMPLEMENT THE main() + additional functions if needed
 *
 * ....
 */

#include <stdio.h>
#include <stdlib.h>
#include "mylinkedlist.h"
#include <stdbool.h>

/* 
 * Function: ReadLine
 * Usage: s = ReadLine();
 * ---------------------
 * ReadLine reads a line of text from standard input and returns
 * the line as a string.  The newline '\n' character that terminates
 * the input is not stored as part of the string.
 */
char *ReadLine(void);



 
int main(int argc, char *arvg[])
{
  // YOU NEED TO IMPLEMENT THIS driver1.c USING FUNCTIONS FROM mylinkedlist.h
  // But before that, implement your ReadLine() function, and test it as shown below. 
  // IF NEEDED,    linked_list_T* list;
   linked_list_T *list;
   list = NewLinkedList();
    bool  end = true;   
 while(end){  
   int opt = 0;

   printf("\n\n1. Create new student cell (id,gpa, & name) \n2. Remove first student from linked list and print his/her id, gpa, and name \n3. Print the number of students in the linked list\n4. Print (id,gpa,name) of a student at a specific index \n5. Print (id, gpa, name) of every student in the linked list \n6. Print the min, average, max gpa in the linked list \n7. Remove the student with the highest gpa and print his/her info \n8. Exit \n");
printf("\nInput your choice: \n");
   
   char *optS = ReadLine();
   opt = atoi(optS);
  switch(opt){
    case 1:
       // student_cell_T *element;
        printf("Enter ID: \n");    
        char *stringId = ReadLine();
        printf("Enter gpa: \n");
        char *stringGpa = ReadLine();
        printf("Enter Name: \n");
        char *name = ReadLine();

        int id = atoi(stringId);
        int gpa = atoi(stringGpa);
        student_cell_T* element = NewStudentCell(id,gpa,name);
    
        Enlist(list,element); 
        break;
    case 2:
        Delist(list);
      
        
        break;
    case 3:
       printf("Num Students:  %d", LinkedListLength(list));        
        break;
    case 4:
        printf("Enter Index: \n");
        char *getIn = ReadLine();
        int index = atoi(getIn);
        student_cell_T *temp = GetLinkedListElement(list,index);
        
        if(temp){
            printf("Name: %s   ID: %d  GPA: %f", temp->name, temp->id, temp->gpa);
        }else{
            printf("Invalid index");
            }
        break;
    case 5:
        printAll(list);
        break;
   case 6:
        print6(list);
        break;
    case 7:
        removeHigh(list);        
        break;
    case 8:
        end = false;
        break;
   }
}

  return 0;
}

/* 
 * IMPLEMENTATION of ReadLine();
 * Function: ReadLine
 * Usage: s = ReadLine();
 * ---------------------
 * ReadLine reads a line of text from standard input and returns
 * the line as a string.  The newline '\n' character that terminates
 * the input is not stored as part of the string.
 *
 * In contrast to standard I/O functions (e.g., scanf with "%s", fgets) 
 * that can read strings into a given static size buffer, ReadLine function 
 * should read the given input line of characters terminated by a newline 
 * character ('\n') into a dynamically allocated and resized buffer based on 
 * the length of the given input line. 
 *
 * When implementing this function you can use standard I/O functions. 
 * We just want you to make sure you allocate enough space for the entered data. 
 * So don't simply allocate 100 or 1000 bytes every time. 
 * If the given input has 5 characters, you need to allocate space for 6 characters.
 *
 * Hint: initially dynamically allocate an array of char with size 10. 
 * Then, read data into that array character by charecter (e.g, you can use getchar()). 
 * If you see '\n' char before reading 10th character, you are done. And you know the 
 * exact length of the input string. So, accordingly allocate enough space and copy the 
 * data into new char array, insert '\0' instead of '\n' and free the original array. 
 * Then return the new string. However, if you DO NOT see '\n' char after 10th character, 
 * then you need larger space. Accordingly, resize your original array and double its size 
 * and continue reading data character by character as in the first step... 
 * Hope you got the idea! 
 *
 * Also please check for possible errors (e.g., no memory etc.) and appropriately handle 
 * them. For example, if malloc returns NULL, free partially allocated space and return 
 * NULL from this function. The program calling this function may take other actions, 
 * e.g., stop the program!
 */
char *ReadLine()
{
  int i = 0;
  // A SIMPLE WAY TO IMPLEMENT JUST TO TEST FOR NOW, BUT THIS IS NOT WHAT WE WANT!!!
  long size = 10;
  
  char *buff = malloc(size);
  char c;
//  scanf("%s", buff);
  while((c=getchar()) != '\n'){
    *(buff + i)=c;
    i++;
    if(i%10==0){
    size = size *2;
    buff = realloc(buff,size);
    }
  }

 *(buff + i) = '\0';




  return buff;


  // YOU NEED TO DELETE ABOVE 3 LINES, and IMPLEMENT THSI as described above
  

  return(NULL);   // if there is any error!
}


   
