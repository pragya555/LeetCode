class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int l = 0, h = 0, n = arr.length, sum = 0, minlen = Integer.MAX_VALUE;
        int[] prefixMin = new int[n];
        int[] suffixMin = new int[n];
        Arrays.fill(prefixMin, Integer.MAX_VALUE);
        Arrays.fill(suffixMin, Integer.MAX_VALUE);
        
        // Left to Right Pass
        while(h < n){
            sum += arr[h];
            while(sum > target){
                sum -= arr[l++];
            }
            if(sum == target){
                minlen = Math.min(minlen, h - l + 1);
            }
            prefixMin[h] = minlen;
            h++;
        }
        
        // Right to Left Pass
        l = n - 1; h = n - 1; sum = 0; minlen = Integer.MAX_VALUE;
        while(l >= 0){
            sum += arr[l];
            while(sum > target){
                sum -= arr[h--];
            }
            if(sum == target){
                minlen = Math.min(minlen, h - l + 1);
            }
            suffixMin[l] = minlen;
            l--;
        }
        
        // Find optimal division point
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            if(prefixMin[i] != Integer.MAX_VALUE && suffixMin[i + 1] != Integer.MAX_VALUE){
                res = Math.min(res, prefixMin[i] + suffixMin[i + 1]);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}