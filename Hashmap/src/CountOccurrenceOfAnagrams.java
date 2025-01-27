//sliding window and hashmap

import java.util.*;

// given an array of length n, and sliding window 
// total sub-arrays possible are n - k + 1


//FIND SUBARRAY WITH THE GIVEN SUM and return their index

//import java.util.HashMap;

// public class SumEqualK {
//     void subArraySum(int a[], int sum){
//         int start=0;
//         int currSum=0;
//         int end=-1;
//         HashMap<Integer, Integer> hm=new HashMap<>();

//         for(int i=0;i<a.length;i++){
//             currSum+=a[i];
//             if((currSum-sum)==0){
//                  start=0;
//                  end=i;
//                  break;
//             }
//             if(hm.containsKey(currSum-sum)){
//                 start=hm.get(currSum-sum)+1;
//                 end=i;
//                 break;
//             }
//             hm.put(currSum,i);
//         }
//         if(end==-1){
//            System.out.println("Not found");
//         }else{
//             System.out.println(start+" "+end);
//         }       
        
//     }
// }


//IMPORTANT QESTION=================================================================================
// Find First Negative element of each sub-array of size k. (return answer in form of an array or list and in case there is no negative element in the sub-array of size k, then put a 0 for that sub-array)
//SLIDING WINDOW(FIXED)

// public class FirstNegativeInWindowSizeK {

//     public static void main(String[] args) {
//         int[] arr = {12, -1, -2, 8, -16, 30, 16, 28};
//         int k = 3;
        
//         int[] ans = solve(arr, k);

//         System.out.println(Arrays.toString(ans));
//     }

//     private static int[] solve(int[] arr, int k) {
//         // given an array of length n, and sliding window 
//         // total sub-arrays possible are n - k + 1
//         int[] ans = new int[arr.length - k + 1];

//         // we are maintaining a list of negatives (FIFO) structure to hold the negatives that are encountered in the original array
//         Queue<Integer> negatives = new LinkedList<>();

//         // left and right ptrs to move in the array
//         int left = 0, right = 0;

//         // ptr to keep track of index in ans
//         int ptr = 0;

//         // iterate till right is less than overall length
//         while (right < arr.length) {

//             // find right most element
//             int ele = arr[right];
//             // if negative add it to the queue
//             if (ele < 0) {
//                 negatives.add(ele);
//             }

//             // if window size is not reached, increase the window size by moving right ptr
//             if (right - left + 1 < k) {
//                 right++;
//             } else if (right - left + 1 == k) {
//                 // if window size is reached, we need additional logic as demanded in the question
//                 // if the negatives queue is empty that means no negative element encountered so far
//                 // so simple add a 0 to the answer/result array
//                 if (negatives.isEmpty()) {
//                     ans[ptr++] = 0;
//                 } else {
//                     // in case the negatives queue is not empty that means we have seen some negative elements in the current sliding window
//                     // peek the queue to find the element and store it in answer array
//                     ans[ptr++] = negatives.peek();
//                     // if the top most element is same as the left most element
//                     // then also remove it from the queue
//                     if (arr[left] == negatives.peek()) {
//                         negatives.remove();
//                     }
//                 }
//                 // finally increase both left and right pointers
//                 // to slide the window
//                 left++;
//                 right++;
//             }
//         }
//         return ans;
//     }
// }


//=================================================================================
//maximum sum of subarray of size k
//sliding window
//important question

// public class SumEqualK {

//     static int maxSumSubArray(int[] a, int k){
//         int wSum=0;
//         int mSun=Integer.MIN_VALUE;

//         for(int i=0;i<k;i++){
//             wSum+=a[i];
//         }
//         mSun=wSum;
//         for(int i=k;i<a.length;i++){

//         //subtracting the element going out and adding the next element
//             wSum=wSum-a[i-k]+a[i];
//             mSun=Math.max(mSun, wSum);
//         }
//         return mSun;
//     }
//      public static void main(String[] args) {
//         int[] a={2,9,31,-4,21,7};
//         int k=3;
//         System.out.println(maxSumSubArray(a, k));
//     }
// }

//---------------- OR -----------------------------

// public class FindMaxSumOfAllSubArraysOfSizeK {

//     public static void main(String[] args) {
//         int[] arr = {2, 3, 5, 2, 9, 7, 1};
//         int k = 3;

//         int max = solve(arr, k);
//         // ans should be 18 for sub-array {2, 9, 7} as this is the maximum sum for any sub-array for given size k
//         System.out.println(max);
//     }

//     private static int solve(int[] arr, int k) {

//         // pointers to maintain start and end of the sliding window
//         int left = 0, right = 0;
//         // variable to hold the answer
//         int ans = Integer.MIN_VALUE;
//         // sum to hold the sum of current on-going window
//         int sum = 0;

//         // while we have not reached till the end
//         while (right < arr.length) {
//             // add current right value to sum
//             sum += arr[right];
//             // if not reached the size of sliding window
//             // just increase the right side
//             if (right - left + 1 < k) {
//                 right++;
//             } else if (right - left + 1 == k) { // once we have reached the size of sliding window, we need to increase both the variables, but need addition logic
//                 // first find the answer till now to hold the maxSum so far for the sub-arrays
//                 ans = Math.max(ans, sum);
//                 // as we are going to slide, so we reduce the sum of the left most element from sum variable
//                 sum -= arr[left];
//                 // finally increase both the pointers to slide the window
//                 left++;
//                 right++;
//             }
//         }

//         // here, we finally return the sum
//         return ans;
//     }
// }


//Important Question=======================================================================================
//Find maximum element of all sub-arrays of size k. (return answer in form of an array or list with size same as total number of sub-arrays in it of size k and each element of the ans will represent the maximum element of that sub-array)
//SLIDING WINDOW

// public class MaximumOfAllSubArraySizeK {


//     public static void main(String[] args) {
//         int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
//         int k = 3;
//         // here we need to find the max element for each sub-array of given size k
//         // so the answer would be 3, 3, 5, 5, 6, 7
//         int[] ans = solve(arr, k);
//         System.out.println(Arrays.toString(ans));
//     }

//     private static int[] solve(int[] arr, int k) {

//         // maintain left and right to iterate over the window
//         int left = 0, right = 0;
//         // maintain a result/ans array to store the ans
//         int[] ans = new int[arr.length - k + 1];
//         // here we take a doubly linked list to build the additional logic as we need to insert and remove from both ends
//         Deque<Integer> temp = new LinkedList<>();
//         // ptr to maintain the index of elements in ans array
//         int ptr = 0;
//         // iterate till right is less than array length
//         while (right < arr.length) {
//             // find the right most element and it has to be appended to the temp list based on logic
//             int ele = arr[right];

//             // if the temp list is not empty and element on right most side is the largest element
//             // then we can simply discard all elements on the left which got added to the deque
//             while (!temp.isEmpty() && temp.peekLast() < ele) {
//                 temp.removeLast();
//             }
//             // add the right most element to the last
//             temp.addLast(ele);

//             // if the window size is not reached, increase the right pointer
//             if (right - left + 1 < k) {
//                 right++;
//             } else if (right - left + 1 == k) {
//                 // if the window size is reached, we need additional logic before sliding the window

//                 // now, we peek the first element from the deque and maintain it in the ans array
//                 ans[ptr++] = temp.peekFirst();
//                 // if the first element is same as the left most element of the array which we need to slide,
//                 // then we remove it from the deque
//                 if (arr[left] == temp.peekFirst()) {
//                     temp.removeFirst();
//                 }
//                 // finally slide the window
//                 left++;
//                 right++;
//             }
//         }
//         return ans;
//     }
// }

//IMPORTANT QUESTION=======================================================================================
//SLIDING WINDOW
//Count the number of occurrences of anagrams of a given pattern in a given string
//Important Question (Here the size of the sliding window is not given in the input and we need to formulate it)

// public class CountOccurrenceOfAnagrams {

//     public static void main(String[] args) {
//         String str = "aabaabaa";
//         String pattern = "aaba";
//         // basically in this problem, we need to prepare all the anagrams
//         // for given pattern and find in original string
//         // the size of window is not given to us,
//         // but logically it is same as the size of pattern (because all anagrams of pattern will be same as the length of pattern)
//         // finally we need to see all windows/sub-arrays in str of size pattern length to see if it is a possible anagram of given pattern
//         // if yes, we need to increase our answer by 1.
//         System.out.println(solve(str, pattern, pattern.length()));
//     }

//     private static int solve(String str, String pattern, int patternLength) {

//         Map<Character, Integer> freqMap = new HashMap<>();
//         int left = 0, right = 0;
//         int ans = 0;
//         int count = 0;

//         // prepare frequency map by iterating over pattern
//         for (Character c : pattern.toCharArray()) {
//             freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
//         }
//         // initialize count by size of frequency map to represent number of distinct characters in pattern
//         count = freqMap.size();

//         // run till right pointer is less than length of the string
//         while (right < str.length()) {

//             // get the right most char
//             char ch = str.charAt(right);

//             // see if the char is there in frequency map
//             if (freqMap.containsKey(ch)) {
//                 // decrease the count of frequency by 1
//                 freqMap.put(ch, freqMap.get(ch) - 1);

//                 // check if the frequency count of the char became 0, then reduce the count as well by 1
//                 if (freqMap.get(ch) == 0) {
//                     count--;
//                 }
//             }

//             // see if the window side is still not reached, then increase the right pointer only
//             if (right - left + 1 < patternLength) {
//                 right++;
//             } else if (right - left + 1 == patternLength) { // if window size is same as pattern lenght both ptr will be increased by 1

//                 // verify at this time if count is 0, means we are able to match the freq of all chars in freq map,
//                 // increase the answer by 1
//                 if (count == 0) ans++;
//                 // now since we need to shrink the window, we need add on logic
//                 // find the left char of the window
//                 Character leftChar = str.charAt(left);

//                 // if the left char is present in the freqMap
//                 // we are going to increase the frequency for this char by 1 in freq map
//                 // also if the freq of this char became greater than 0 this time, then we will increase the count variable also by 1
//                 if (freqMap.containsKey(leftChar)) {
//                     freqMap.put(leftChar, freqMap.get(leftChar) + 1);
//                     if (freqMap.get(leftChar) > 0) {
//                         count++;
//                     }
//                 }

//                 // finally shift the window by sliding both pointers
//                 left++;
//                 right++;
//             }
//         }

//         return ans;
//     }
// }


//=======================================================================================

//subarray product less than k
//sliding window

// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         if (k <= 1) return 0;

//         int L = 0, R = 0, product = 1, count = 0;
//         int n = nums.length;

//         while (R < n) {
//             product *= nums[head];
//             while (product >= k){
//                 product /= nums[L];
//                 L++;
//             } 
//             count += (R - L + 1);
//             head++;
//         }

//         return count;
//     }
// }

//===============================================================================
//sliding window
//Minimum size subarray sum (Q-209)

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         //DEFINE POINTERS
//         int L=0, R=0;

//         //MIN & SUM ARRAY LEN
//         int min=Integer.MAX_VALUE, sum=0;
//         int n=nums.length;

//         //min sub array len
//         while(R< n){

//             //add the current element
//             sum+=nums[R];

//             //contract window
//             while(target<=sum){
//                 min = Math.min(min,(R-L+1));
//                 sum-=nums[L];
//                 L++;
//             }
//             R++;
//         }
//         return min==Integer.MAX_VALUE? 0 : min;
//     }
// }


//=========================================================================
//SLIDING WINDOW(Premium question)
//Longest substring with atmost two distinct characters (159)
//given a string s, find the length of the longest substring t that conatins atmost 2 distinct characters

// import java.util.HashMap;

// class Solution{
//     public int lengthOfLongestSubstringTwoDistinct(String s){
//         //base case
//         char[] arr=s.toCharArray();
//         int n=arr.length;
//         if(n<3) return n;

//         //define pointer
//         int L=0,R=0;

//         //define table
//         HashMap<Character, Integer> hm = new HashMap<>();

//         //define maxlen
//         int maxLen=0;

//         //find the max len substring 2 distinct char
//         while(R<n){
//             hm.put(arr[R], hm.getOrDefault(arr[R], 0)+1);

//             //contract our window if we don't meet the condition
//             while(hm.size()>2){

//                 hm.put(arr[L], hm.get(arr[L]) -1);
//                 if(hm.get(arr[L])==0){
//                     hm.remove(arr[L]);
//                 }
//                 L++;
//             }
//             maxLen=Math.max(maxLen, R-L+1);
//             R++;
//         }
//         return maxLen;
//     }
// }


//=======================================================================
//sliding window
//Longest substring without repeating character

//import java.util.HashMap;

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         //base case
//         char[] arr=s.toCharArray();
//         int n = arr.length;
//         if(n<2)return n;

//         //define pointers
//         int L=0,R=0;

//         //define tables
//         HashMap<Character, Integer> hm= new HashMap<>();

//         //define max length
//         int maxLen=0;

//         //find longest substring
//         while(R<n){
//             //add current element
//             hm.put(arr[R], hm.getOrDefault(arr[R], 0)+1);

//             //check if meet the condition
//             while(hm.size() !=R-L+1){
//                 hm.put(arr[L], hm.get(arr[L])-1);
//                 if(hm.get(arr[L])==0){
//                     hm.remove(arr[L]);
//                 }
//                 L++;
//             }
//             //UPDATE THE MAXLEN
//             maxLen=Math.max(maxLen, R-L+1);

//             //MOVE THE R ONE TO THE RIGHT
//             R++;
//         }

//         //return max length
//         return maxLen;
//     }
// }

//======================================================================================
//LENGTH OF LONGEST SUBARRAY WITH AT MOST K frequency-----------------------------------

// class Solution {
//     public int maxSubarrayLength(int[] nums, int k) {
//         int R=0,L=0;
//         int maxLen=0;
//         int n=nums.length;

//         HashMap<Integer, Integer> hm = new HashMap<>();

//         while(R<n){
//             hm.put(nums[R], hm.getOrDefault(nums[R],0)+1);
//                 while(hm.get(nums[R])>k){
//                 hm.put(nums[L], hm.get(nums[L]) -1); 
//                     if(hm.get(nums[L])==0){
//                     hm.remove(nums[L]);
//                 }          
//                 L++;
//             }
//              maxLen=Math.max(maxLen, R-L+1);
//              R++;
//         }
//         return maxLen;
//     }
// }


//=========================================================================
//sliding window
//Longest substring with at most K distinct Characters
///LEETCODE 340 =>PREMIUM QUESTION

// import java.util.HashMap;

// class Solution{
//     public int lengthOfLongestSubstringKDistinct(String s, int k){
//         //base case
//         if(k==0)return 0;

//         char[] arr=s.toCharArray();

//         //define pointers
//         int L=0,R=0;

//         //define table
//         HashMap<Character, Integer> hm= new HashMap<>();

//         //define maxLen
//         int maxLen=0;
//         int n=arr.length;

//         //find longest substring with k distinct char
//         while(R<n){
//             hm.put(arr[R], hm.getOrDefault(arr[R],0)+1);

//             //contract window if we dont meet the condition
//             while(hm.size()>k){
//                 hm.put(arr[L], hm.get(arr[L])-1);

//                 if(hm.get(arr[L])==0){
//                     hm.remove(arr[L]);
//                 }
//                 L++;
//             }
//             //UPDATE THE MAX
//             maxLen = Math.max(maxLen,R-L+1);
//             //MOVE THE RIGHT POINTER
//             R++;
//         }
//         return maxLen;


//     }
// }

//=======================================================================================
//SLiding window premium question
//487 leetcode Max consecutive ones II
//Given a binary array , find the max num of consecutive 1s in this array if you can flip atmost one 0


// class Solution{
//     public int findMaxConsecutiveOnes(int[] nums){
//         //base case
//         int n=nums.length;
//         if(n<2)return n;

//         //define pointers
//         int L=0,R=0;

//         //define maxLen,counter
//         int maxLen=0,counter=0;

//         //find max cons ones
//         while(R<n){
 //       // expand the window
//             if(nums[R]==0){
//                 counter++;
//             }
//             //contract window if we dont meet the condition
//             while(counter>1){
//                 if(nums[L]==0){
//                     counter--;
//                 }
//                 L++;
//             }
//             //update the maxlen
//             maxLen=Math.max(maxLen,R-L+1);
//             //move the R one to the right
//             R++;
//         }

//         //return maxLen
//         return maxLen;

//     }
// }


//=======================================================================================
//SLiding window 
//485 leetcode Max consecutive ones 
//Given a binary array , find the max num of consecutive 1s in this array .

// class Solution{
//     public int findMaxConsecutiveOnes(int[] nums){
//         int maxLen=0,counter=0;

//         //iterate all the elements
//         for(int num:nums){
//             if(num==0){
//                 counter=0;
//             }else{
//                 counter++;
//                 maxLen=Math.max(counter,maxLen);
//             }
//         }
//         return maxLen;


//     }
// }


//=======================================================================================
//SLiding window 
//1004 leetcode Max consecutive ones 111 
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.


// class Solution {
//     public int longestOnes(int[] A, int k) {
//         //base case
//         int n=A.length;
//         if(n<2 && 0<k)return n;

//         //define pointers
//         int L=0,R=0;

//         //define maxLen,counter
//         int maxLen=0,counter=0;

//         //find max cons ones
//         while(R<n){
//             //expand the window
//             if(A[R]==0){
//                 counter++;
//             }
//             //contract window if we dont meet the condition
//             while(counter>k){
//                 if(A[L]==0){
//                     counter--;
//                 }
//                 L++;
//             }
//             //update the maxlen
//             maxLen=Math.max(maxLen,R-L+1);
//             //move the R one to the right
//             R++;
//         }

//         //return maxLen
//         return maxLen;
//     }
// }


//=======================================================================================
//SLiding window 
//424 leetcode Max consecutive ones 111 
//Longest repeatinng character replacement.
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

// import java.util.HashMap;

// class Solution {
//     public int characterReplacement(String s, int k) {
//         char[] arr=s.toCharArray();
//         int L=0, R=0,n=arr.length;

//         //define table
//         HashMap<Character, Integer> hm = new HashMap<>();

//         //DEFINE maxLen and  most freq
//         int maxLen=0, mostFreq=0;

//         //find longest repeating character replacement
//         while(R<n){
//             //expand the window
//             hm.put(arr[R], hm.getOrDefault(arr[R], 0)+1);
//             mostFreq=Math.max(mostFreq,hm.get(arr[R]));

//             //SHRRINK the window if we need to replace more than k char
//             while((R-L+1)-mostFreq>k){
//                 hm.put(arr[L], hm.get(arr[L])-1);
//                 L++;
//             }
//             maxLen=Math.max(maxLen,R-L+1);
//             R++;
//         }
//         return maxLen;
//     }
// }


//================================================================================================================
//int max = Arrays.stream(nums).max().getAsInt();=>shortcut to find maximum number in an array
//sliding window(2962)=>Count number of subarrays
//You are given an integer array nums and a positive integer k.
//Return the number of subarrays where the maximum element of nums appears at least k times in that subarray

// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//        int n=nums.length;      
//        int R=0,L=0;
//        long count=0;

//        HashMap<Integer, Integer> hm=new HashMap<>();        
//         int max=Integer.MIN_VALUE;
//         for(int i=0; i<n;i++){
//             if(nums[i]>max){
//                 max=nums[i];
//             }
//         }
//         while(R<n){          
//             hm.put(nums[R], hm.getOrDefault(nums[R], 0)+1);

//             while (hm.getOrDefault(max, 0) >= k){
//                 count+=n-R;
//                 hm.put(nums[L], hm.get(nums[L])-1);
//                 L++;
//             }
//             R++;
//         }
//         return count;
//     }
// }


//================================================================================================================
//int max = Arrays.stream(nums).max().getAsInt();=>shortcut to find maximum number in an array
//sliding window(992)=>Count number of subarrays with k different integer
//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//A good array is an array where the number of different integers in that array is exactly k

// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k){
//        return countSubarray(nums,k)-countSubarray(nums,k-1);
//    }
//    public int countSubarray(int[] nums, int k) {
//       int n=nums.length;      
//       int R=0,L=0;
//       int count=0;

//       HashMap<Integer, Integer> hm=new HashMap<>();        
//        while(R<n){          
//            hm.put(nums[R], hm.getOrDefault(nums[R], 0)+1);

//            while (hm.size()> k){
               
//                hm.put(nums[L], hm.get(nums[L])-1);
//                if (hm.get(nums[L]) == 0) 
//                hm.remove(nums[L]);
//                L++;
//            }
//            count+=R-L+1;
//            R++;
//        }
//        return count;
//    }
// }