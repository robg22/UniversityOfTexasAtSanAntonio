BEGIN{

totalD = 0;
totalUsers = 0;
totalFiles = 0;
allT = 0;
allH = 0;
totalO = 0;
totalstorage = 0
username = "temp"
oldT2 = 0;
old1 = 0;
}



{
    if(NF != 8){
        next    
    }
    
    username = $3
   
    
    usernames[username] = 1
    usernames2[username] = 1   

    if($1 ~ /^-/){
        allFiles[username]++
        storage[username] += $5
        totalStorage += $5
        totalFiles++

        if($NF ~ /^\./){
            hidden[username]++
            allH++
        }
        if(old1 == 0){
            oldest = $0;
            old1 = $6;
        }

        if(old1 > $6){
            oldest = $0
            old1 = $6
        }

        if(oldT2 < $6){
            newest = $0
            oldT2 = $6;
       }
    }
    else if($1 ~ /^d/){
        directories[username]++
        totalD++;
    }

    else{
        other[username]++
        totalO++
    }
    


}

END {
    
    for(username in usernames){
       if(!allFiles[username]){
            for(username in usernames){
                if(!allFiles[username]){
                    if(!tempU1){
                        tempU1 = username }

                if(tempU1 > username){
                    tempU1 = username
                    }
                }
             }   
        
            print("")
            print("Usermame: ",tempU1,":")
            print("         Directories:",directories[tempU1]);
            if(other[tempU1]){
                print("         Others:",other[tempU1])
            }
            delete usernames[tempU1]
            delete allFiles[tempU1]
            tempU1 = NULL
           # totalUsers++
       }
    }

    for (username in usernames2){
         if(allFiles[username]){
            for(username in usernames2){
               if(allFiles[username]){
                    if(!tempU2){
                    tempU2 = username
                    tempNum = storage[username]
                   }

                    if(tempNum > storage[username])
                        tempU2 = username
                        tempNum = storage[username]
                    }
                }
                
           
           
            
            print("")
            print("Username:",tempU2,":");
            print("  Files:")
            print("     All files:", allFiles[tempU2])
            
            if(hidden[tempU2]){
              print("       Hidden: ",hidden[tempU2]);  
            }else{ print("      Hidden:  0")}
        

        if(directories[tempU2]){
            print("         Directories: ", directories[tempU2])
        }
        
        if(other[tempU2]){
            print("         Other files: ", other[tempU2])
        
        }
        
        if(storage[tempU2]){
            print("         Storage (B) :",storage[tempU2],"bytes");
            }


        delete usernames2[tempU2]
        
        tempU2 = NULL
        
   }
   totalUsers++
    }
    totalUsers++

       print("")
       print("")
       
       print("Oldest file:")
       print(oldest)
       print("Newest file:")
       print(newest)

        print("")
        print("")
       totalUsers--
       print("Total Users:", totalUsers)
        print("Total files:")
        print("     (All / Hidden):     (",totalFiles,",",allH,")")
        print("Total Directoreis: ", totalD)
        print("Total others: ", totalO)
        print("Storage: (B)",totalStorage)
        
        
        

}
