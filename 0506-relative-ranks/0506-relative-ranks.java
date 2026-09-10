class Solution {
    public String[] findRelativeRanks(int[] arr) {
        String[] res = new String[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> arr[b] - arr[a]);        
        for(int i=0;i<arr.length;i++)
        {
            pq.add(i);
        }
        int place=1;
        while(!pq.isEmpty())
        {
            int ele = pq.poll();
            if(place==1) {
                res[ele] = "Gold Medal"; 
            }
            else if(place==2) {
                res[ele] = "Silver Medal"; 
            }
            else if(place==3) {
                res[ele] = "Bronze Medal"; 
            }
            else{
                res[ele]= String.valueOf(place);
            }
            place++;
        }
        return res;
    }
}