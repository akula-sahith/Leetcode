class Solution {
    public int maxEvents(int[][] events) {
        return greedy(events);
    }

    //We can follow the greedy approach for this question 
    //Where we will first select the fast completed event
    public int greedy(int[][] events){
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0;
        int i = 0;
        int day = 0;
        int n = events.length;

        while(i<n || !pq.isEmpty()){
        

        if(pq.isEmpty()){
           day = events[i][0];
        }

        //Find out all the events starting on the same day and add that end to the pq
        while(i<n && events[i][0] <= day){
            pq.add(events[i][1]);
            i++;
        }

        //Remove the expired events 
         while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
                day++;
            }



        }


        return count;

      
    }
}