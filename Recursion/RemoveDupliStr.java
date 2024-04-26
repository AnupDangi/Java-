public class RemoveDupliStr {
    
    public static void removeduplicates(String str,int index,StringBuilder newStr,boolean map[]){

        //print when the index traverse all the characters in the str and the new string is stored in stringbuilder newStr
        if(index==str.length()){
            System.out.println(newStr);
            return;
        }
        //check whether it exist in the map 
        char currChar=str.charAt(index);
        if(map[currChar-'a']==true){//this checks wherther the current character is already stored inside the map if so increment 
            //duplicate
            //if the map of array consist of the current char before then increment the index
            removeduplicates(str,index+1,newStr,map);
        }
        else{
            //assign the current character in the array map as true and append the index character to stringbuilder that is newStr and call the function
            map[currChar-'a']=true;
            removeduplicates(str,index+1,newStr.append(currChar),map);
        }

    }

    public static void main(String[] args){
        String str="appnacollege";
       removeduplicates(str,0,new StringBuilder(""),new boolean[26]);
    }
}
