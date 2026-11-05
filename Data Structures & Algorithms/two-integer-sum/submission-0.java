class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] arr={0,0};
        for(int i=0;i<nums.length;i++){
            int complement= target - nums[i];
            if(map.containsKey(complement)){
                arr[0]=map.get(complement);
                arr[1]=i;
                break;
            }
            map.put(nums[i], i);
            

        } 
        return arr;       
    }
}
