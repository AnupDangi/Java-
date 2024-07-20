import java.util.*;
public class ActivitySelection{

    public static void main(String[]args){
        int start[]={1,4,0,5,8,5};
        int end[]={2,4,6,7,9,9};


        //sorting process when the end array is not sorted
        int activites[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activites[i][0]=i;
            activites[i][1]=start[i];
            activites[i][2]=end[i];
        }

        //lambda function ->shortform
        Arrays.sort(activites,Comparator.comparingDouble(o->o[2]));

        //end time basis sorted
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();

        //1stActivity
        maxAct=1;
        ans.add(activites[0][0]);
        int LastEnd=activites[0][2];
        for(int i=1;i<end.length;i++){
            if(activites[i][1]>=LastEnd){
                maxAct++;
                ans.add(activites[i][0]);
                LastEnd=activites[i][2];
            }
        }
        // ans.add(0);
        // int LastEnd=end[0];
        // for(int i=1;i<end.length;i++){
        //     //ACtivity Select
        //     maxAct++;
        //     ans.add(i);
        //     LastEnd=end[i];
        // }
        System.out.println("Max activites="+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}