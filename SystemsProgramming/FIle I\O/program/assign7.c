#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#define COURSE_FILE "courses.dat"


int main(void)
    {
    typedef struct
    {
        char course_Name[60];
        char course_Sched[4];
        unsigned course_Hours;
        unsigned course_Size;
    } Course;

    Course course; 

    FILE *coursesFile;
    
    char temp;
    char search[60];
    int value;


    char in[1];
    int num = 0;
    int rcFseek,rc;
    while(in){
        printf("Enter one of the following actions or press CTRL-D to exit \n");
        printf("C - create a new course record \n");   
        printf("U - update an existing course \n");
        printf("R - read an existing course record \n");
        printf("D - delete an existing course record \n");
        
        scanf("%s",in);
        if(strcmp(in,"C") == 0 || strcmp(in,"c")==0){
            value = 1;
        }else if(strcmp(in,"u") == 0 || strcmp(in,"U")==0){
            value=2;
        }else if(strcmp(in,"R") == 0 || strcmp(in,"r")==0){
            value=3;
        }else if(strcmp(in,"D") == 0 || strcmp(in,"d")==0){
            value=4;
        }else{
            printf("ERROR: Invalid Option!! \n\n");
            value=0;
        }

        switch(value) {
            case 1:
               
               coursesFile = fopen(COURSE_FILE,"r+b");
               if(coursesFile != NULL){
                    printf("Enter course number:  \n");
                    scanf("%d",&num);
                                  
                    num = num*sizeof(Course);
                    rcFseek = fseek(coursesFile,num,SEEK_SET);
                    rc = fread(&course,sizeof(Course),1L,coursesFile);
                    
                    if(rc = 1 && course.course_Hours != 0){
                        printf("ERROR: Course Already Exists \n");
                        }else{
                        
                            printf("Enter course name:  \n");
                            scanf("%c",&temp);
                            fgets(course.course_Name,sizeof(course.course_Name),stdin);
                            
                            printf("Enter course schedule:  \n");
                            scanf("%s",course.course_Sched);
                            printf("Enter course credit hours: \n");
                            scanf("%d",&course.course_Hours);
                            printf("Enter course enrollment:  \n");
                            scanf("%d",&course.course_Size);                                    
                            fseek(coursesFile,num,SEEK_SET);
                                
                            fwrite(&course,sizeof(Course),1L,coursesFile);
                              } 
                       }else{
                           printf("Error: File not found");
                       }
                        fclose(coursesFile);
                
                break;
            case 2:
                coursesFile = fopen(COURSE_FILE,"r+b");
                if(coursesFile){

                    printf("Enter course number:  \n");
                    scanf("%d",&num);
                
                    num = num*sizeof(Course);
                    rcFseek = fseek(coursesFile,num,SEEK_SET);
                    rc = fread(&course,sizeof(Course),1L,coursesFile);
                    char name[60]=" ";
                    char sched[4]=" ";
                    unsigned hour = 0;
                    unsigned size = -1;

                    if(rc == 1 && course.course_Hours != 0){
                    
                        printf("Enter course name:  \n");;  
                        scanf("%c",&temp);
                        fgets(course.course_Name,sizeof(course.course_Name),stdin);
                        
                        printf("Enter course schedule:  \n");
                        scanf("%s",course.course_Sched);
                        
                        if(strlen(sched)>4){ printf("Error to many characters");}
                        
                         
                        printf("Enter course credit hours: \n");
                        scanf("%d",&hour);
                        if(hour > 0){course.course_Hours = hour;}

                        printf("Enter course enrollment:  \n");
                        scanf("%d",&size);
                        if(size >= 0){course.course_Size = size;} 
                    
                        rcFseek = fseek(coursesFile,num,SEEK_SET);
                        
                        fwrite(&course,sizeof(Course),1L,coursesFile);
                    }else{
                        printf("Error: course not found");
                    }
                }else{
                    printf("File not found");
                }
                    fclose(coursesFile);
                break;

            case 3:
                coursesFile = fopen(COURSE_FILE,"ab+");                
                printf("\nEnter a CS course number:");                                
                scanf("%d", &num);
                
               int num2 = num*sizeof(Course);
                rcFseek = fseek(coursesFile,num2,SEEK_SET);
               // assert(rcFseek == 0);

                rc = fread(&course,sizeof(Course),1L,coursesFile);

                if(rc == 1 && course.course_Hours != 0){
                    printf("\nCourse number: %d \n\nCourse name: %s \nScheduled days: %s \n\nCredit hours: %d \n\nEnrolled Students: %d       \n\n\n"
                    ,num,course.course_Name,course.course_Sched,course.course_Hours,course.course_Size);
                }else{
                    printf("Record number not found \n");
                }
                fclose(coursesFile);
                break;

            case 4:
                printf("Enter course number:  \n");
                scanf("%d",&num);
                 coursesFile = fopen(COURSE_FILE,"r+b");

                 num = num*sizeof(Course);
            
                 rcFseek = fseek(coursesFile,num,SEEK_SET);
                
                 rc = fread(&course,sizeof(Course),1L,coursesFile);
                
            
                unsigned ho = 0;
                if(rc = 1 && course.course_Hours != 0){
                
                    course.course_Hours = 0;
                    
                    
                                     
                    rcFseek = fseek(coursesFile,num,SEEK_SET);
                    fwrite(&course,sizeof(Course),1L,coursesFile);

                    printf("Course number was successfull deleted \n");
                 
                 }else{
                     printf("ERROR: invalid option \n");
                     }
                fclose(coursesFile);
                break;
               
               case 5:

                    printf("\nEnter a search phrase\n");
                    scanf("%s",search);

                    coursesFile = fopen(COURSE_FILE,"r+b");
                  
                  while(fread(&course,sizeof(Course),1L,coursesFile)){
                        if(rc == 1 && course.course_Hours != 0){
                            if(course.course_Sched ==  search){
                             //   printf("%d",
                            }


                            
                            printf("%s",course.course_Name);

                        }
                
                    }
                    fclose(coursesFile);


                    break;
               
               
               }


        
    }














    return 0;

}
