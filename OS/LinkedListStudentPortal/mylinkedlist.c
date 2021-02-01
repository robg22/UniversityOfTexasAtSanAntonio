/*
 * File: mylinkedlist.c
 * YOUR NAME ... 
 * YOU NEED TO IMPLEMENT THE FUNCTIONS  here
 * ....
 */

#include <stdio.h>
#include <stdlib.h>
#include "mylinkedlist.h"
int numS = 0; 
/*
 * Function: NewStudentCell
 * Usage: student_cell_T *element;
 *        element = NewStudentCell(int id, double gpa, char *name);
 * --------------------------
 * This function allocates space for a student cell and intilize its fileds
 */
student_cell_T *NewStudentCell(int id, double gpa, char *name)
{
   student_cell_T *element;
  
   element = (student_cell_T *) malloc( sizeof(student_cell_T) );
   if( !element){
     fprintf(stderr,"NewStudentCell cannot allocate memory\n");
     return NULL;
   }
   element->id = id;
   element->gpa = gpa;
   element->name = name;

  return element;
}


/*
 * Function: NewLinkedList
 * Usage: linked_list_T *list;
 *        list = NewLinkedList();
 * --------------------------
 * This function allocates and returns an empty linked list.
 */
linked_list_T *NewLinkedList(void)
{
   linked_list_T *list;
  
   list = (linked_list_T *) malloc( sizeof(linked_list_T) );
   if( !list){
     fprintf(stderr,"NewLinkedList cannot allocate memory\n");
     return NULL;
   }

   list->head = NULL;
   list->tail = NULL;

  return list;
}


/*
 * Function: FreeLinkedList
 * Usage: FreeLinkedList(list);
 * ------------------------
 * This function frees the storage associated with list.
 */
void FreeLinkedList(linked_list_T *list)
{
    free(list);

}

/*
 * Function: Enlist
 * Usage: Enlist(list, element);
 * -------------------------------
 * This function adds a student cell pointed by element to the end of the list.
 */
void Enlist(linked_list_T *list, student_cell_T *element)
{
    if(list->head  == NULL){
        list->head = element;
        list->tail = element;
    
    }else{
        element->next = NULL;
        list->tail->next = element;
        list->tail = element;
    
    }

}
void printAll(linked_list_T *list){
    student_cell_T *printA  = list->head;
    
    while(printA != NULL)
    {
        printf("Name: %s    ID: %d    GPA: %f  \n",printA->name,printA->id, printA->gpa);
        printA = printA->next;
    }

    free(printA);

}

/*
 * Function: Delist
 * Usage: element = Delist(list);
 * --------------------------------
 * This function removes the student cell at the head of the list
 * and returns its address to the caller (client).  If the list is empty, Delist
 * prints an Error with an appropriate message and returns NULL.
 */
void Delist(linked_list_T *list)
{
    if(list->head !=NULL){
        student_cell_T *temp= list->head;
        list->head = list->head->next;
        printf("Student Removed: Name: %s   ID %d   GPA: %f\n",temp->name,temp->id,temp->gpa);
        free(temp);
    }else{
        printf("List is empty!");
        
    }
    
}


int LinkedListIsFull(linked_list_T *list)
{
  return 0; // because we have linked list
}

/*
 * Function: LinkedListLength
 * Usage: n = LinkedListLength(list);
 * ------------------------------
 * This function returns the number of elements in the list.
 */
int LinkedListLength(linked_list_T  *list)
{
    int count = 0;
    student_cell_T *temp = list->head;
    while(temp != NULL){
        count++;
        temp = temp->next;
    }
    free(temp);
    return count;
}

/*
 * Function: GetLinkedListElement
 * Usage: element = GetLinkedListElement(list, index);
 * -----------------------------------------------
 * This function returns the element at the specified index in the
 * list, where the head of the list is defined as index 0. For
 * example, calling GetLinkedListElement(list, 0) returns the initial
 * element from the list without removing it.  If the caller tries
 * to select an element that is out of range, GetLinkedListElement prints
 * Error and returns NULL.  Note: This function is not a fundamental list operation
 * and is instead provided mainly to facilitate debugging.
 */
student_cell_T *GetLinkedListElement(linked_list_T *list, int index)
{
    student_cell_T *temp = list->head;
    int count = 0;
    while(temp != NULL){
        if(count == index){
            return temp;
        }
        temp = temp->next;
        count++;
    }
    return NULL;
}

void print6(linked_list_T *list){
    double max = 0;
    double tot = 0;
    double total = 0;
    student_cell_T *temp = list-> head;
    double min = temp->gpa;

    while(temp != NULL){
        tot++;

        if(min > temp->gpa)
            min = temp->gpa;

        if(max < temp->gpa)
            max = temp->gpa;
        
        total = total + temp->gpa;
        
        temp = temp->next;
    
    }
    double average = total/tot;

    printf("Min GPA: %f     Max GPA: %f     Average: %f",min,max,average);
    free(temp);
}

void removeHigh(linked_list_T *list){
   if(list->head != NULL){
   double max = 0;
    int count = 0;
    int index = 0;
    student_cell_T *temp = list->head;

    while(temp != NULL){
        if(max < temp->gpa){
            max = temp->gpa;
            index = count;
        }
        temp = temp->next;
        count++;
    }
    free(temp);
    if(index ==0){
        list->head = list->head->next;
    }

    student_cell_T *t2 = list->head;
    int i;
    for(i = 0; t2 != NULL && i<index-1;i++){
        t2 = t2->next;
    }

    printf("Name: %s    ID: %d  GPA: %f \n", t2->next->name, t2->next->id,t2->next->gpa);

    student_cell_T *next = t2->next->next;

    free(t2->next);
    
    t2->next = next;
   }else{
        printf("List is empty! \n");
   }
}

/* OTHER FUNCTIONS YOU WOULD NEED....
 * EXPORT THEM HERE, BUT IMPLMENT THEM in mylinkedlist.c 
 */

  
