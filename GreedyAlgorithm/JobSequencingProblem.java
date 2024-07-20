import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class JobSequencingProblem {

    static class Job{
        int deadline;
        int profit;
        int id;
        
        public Job(int i,int d, int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void main(String[]args){
        //Job Sequencing Problem
        int jobarr[][]={{4,20},{1,10},{1,40},{1,30}};
        
        ArrayList<Job> jobs=new ArrayList<>();

        for(int i=0;i<jobarr.length;i++){
            jobs.add(new Job(i, jobarr[i][0], jobarr[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);
        //Descending order
        int time=0;
        ArrayList<Integer> seq= new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        //print seq
        System.out.println("Max jobs="+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
    