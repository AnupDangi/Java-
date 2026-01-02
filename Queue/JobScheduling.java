 import java.util.*;

import javax.print.attribute.standard.JobSheets;
public class JobScheduling {
    
    static class Job{
        public char job_id;
        public int deadline;
        public int profit;

    public Job(char job_id,int deadline,int profit){
        this.job_id=job_id;
        this.deadline=deadline;
        this.profit=profit;
    }
    public static int maxProfit(Job array[]){
        int profit=0;
        int max_deadline=0;
        for(int i=0;i<array.length;i++){
            max_deadline=Math.max(max_deadline,array[i].deadline);
        }
        char timeline[]=new char[max_deadline];
        for(int i=0;i<timeline.length;i++){
            timeline[i]='*';
        }
        // 0 1 2 3 4 
        //Sort based on maximum profit
        //5-4 =1 so b is maximum assign it based on maximum
        //c,d,a,b the output of the Arrays.sort seems this
        Arrays.sort(array,(job_a,job_b)->(job_b.profit -job_a.profit)); 
        // +ve sort ie ascending order -ve descending 0 means no sort for that instance 
        //we want greater so we want in descending order so used b.profit-a.profit
        //Nlog(N) time complexity for inbuilt sort

        //Job c --added
        //Job d--drop break
        //Job a--added
        //Job b --drop break
        //N jobs
        //K deadline
        //O(NK)->  k is constant so O(N) is time complexity
        for(int i=0;i<array.length;i++){
            for(int j=array[i].deadline-1;j>=0;j--){
                if(timeline[j]=='*'){
                    //free slot found
                    profit=profit+array[i].profit;
                    timeline[j]=array[i].job_id;
                    break;
                }
            }
        }

        for(int i=0;i<timeline.length;i++){
            if(timeline[i]!='*'){
                System.out.print(timeline[i]+" ");
            }
        }
        System.out.println();
        return profit;
    }
}
    public static void main(String[]args){
        Job jobs[]=new Job[4];
        jobs[0]=new Job('a', 4, 20);
        jobs[1]=new Job('b',1,10);
        jobs[2]=new Job('c', 1, 40);
        jobs[3]=new Job('d', 1, 30);

        int ans=JobScheduling.Job.maxProfit(jobs);
        System.out.println(ans);
    }
}

