class Solution {
    
    int search(int arr[],int target){
        int peak=findPeakElement(arr);
        int firstTry=OrderAgnosticBS(arr,target,0,peak);
        if(firstTry !=-1){
            return firstTry;
        }
        else{
            return OrderAgnosticBS(arr,target,peak+1,arr.length-1);
        }
    }
    
    
    public int findPeakElement(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=(end+start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
    return start;
    }
    static int OrderAgnosticBS(int arr[],int target,int start,int end){
        boolean isAsc=arr[start]<arr[end];

        while(start<=end){
            int middle=(start+end)/2;
            if(arr[middle]==target){
                return middle;
            }
            if(isAsc){
                if(target<arr[middle])
                    end=middle-1;
                else if(target>arr[middle])
                    start=middle+1;
            }
            else{
                if(target<arr[middle])
                    start=middle+1;
                else if(target>arr[middle])
                    end=middle-1;
            }
           
        }
        return -1;
    }
}
