#include <bits/stdc++.h>
using namespace std;

int merge(int *arra, int left, int mid, int right) {
    int leftSize = mid - left + 1;
    int rightSize = right - mid;
    int *leftArray = new int[leftSize];
    int *rightArray = new int[rightSize];
    long long int  res=0;

    for (int i = 0; i < leftSize; i++)
        leftArray[i] = arra[left + i];
    for (int j = 0; j < rightSize; j++)
        rightArray[j] = arra[mid + 1 + j];
    int l = 0, r = 0, mergedIndex = left;
    while (l < leftSize && r < rightSize) {
        if (leftArray[l] <rightArray[r]) {
            arra[mergedIndex] = leftArray[l];
            l++;
        } else {
            arra[mergedIndex] = rightArray[r];
            r++;
            res+=(leftSize-l);
        }
        mergedIndex++;
    }
    while (l < leftSize) {
        arra[mergedIndex] = leftArray[l];
        l++;
        mergedIndex++;
    }
    while (r < rightSize) {
        arra[mergedIndex] = rightArray[r];
        r++;
        mergedIndex++;
    }
    return res;
}

int mergeSort(int *arra, int left, int right){
    long long int  res=0;
    if(left>=right)
        return res;
    int mid=left+(right-left)/2;
   res+=  mergeSort(arra,left,mid);
    res+= mergeSort(arra,mid+1, right);
    res+=merge(arra,left,mid,right);
    return res;
}
int main()
{
    int tc=1;
    cin>>tc;
    while(tc--)
    {
        int n;
        cin>>n;
        int arr[n] ;
        for(int i=0; i<n; i++)
        {
            cin>>arr[i];
        }
	long long int  ans = mergeSort(arr,0,n-1);
	cout << ans<<endl;
    }
	return 0;
}
