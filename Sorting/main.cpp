#include <iostream>
#include <chrono>
#include <fstream>
#include <iomanip>
#include <algorithm>

using namespace std;

void merge(int *arra, int left, int mid, int right) {
    int leftSize = mid - left + 1;
    int rightSize = right - mid;
    int *leftArray = new int[leftSize];
    int *rightArray = new int[rightSize];

    for (int i = 0; i < leftSize; i++)
        leftArray[i] = arra[left + i];
    for (int j = 0; j < rightSize; j++)
        rightArray[j] = arra[mid + 1 + j];
    int l = 0, r = 0, mergedIndex = left;
    while (l < leftSize && r < rightSize) {
        if (leftArray[l] <= rightArray[r]) {
            arra[mergedIndex] = leftArray[l];
            l++;
        } else {
            arra[mergedIndex] = rightArray[r];
            r++;
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
    delete[] leftArray;
    delete[] rightArray;
}

void mergeSort(int *arra, int left, int right){
    if(left>=right)
        return;
    int mid=left+(right-left)/2;
    mergeSort(arra,left,mid);
    mergeSort(arra,mid+1, right);
    merge(arra,left,mid,right);
}
int partition(int *arra, int left, int right){
    int pivot = arra[right];
    int i = (left - 1);
    for (int j = left; j < right; j++) {
        if (arra[j] <= pivot) {
            i++;
            int temp=arra[i];
            arra[i]=arra[j];
            arra[j]=temp;
        }
    }
    i++;
    int temp=arra[i];
    arra[i]=arra[right];
    arra[right]=temp;
    return i;
}

void quickSort(int *arra, int left, int right) {
    if(left>=right)
        return;
    int mid = partition(arra, left, right);
    quickSort(arra, left, mid - 1);
    quickSort(arra, mid + 1, right);
}
int Randompartition(int *arra, int left, int right){
    int x= rand();
    x=x%(right-left);
    x+=left;
    int pivot = arra[x];
    int i = (left - 1);
    for (int j = left; j < right; j++) {
        if (arra[j] <= pivot) {
            i++;
            int temp=arra[i];
            arra[i]=arra[j];
            arra[j]=temp;
        }
    }
    i++;
    int temp=arra[i];
    arra[i]=arra[right];
    arra[right]=temp;
    return i;
}
void RandomizedQuickSort(int *arra, int left, int right) {
    if(left>=right)
        return;
    int mid = Randompartition(arra, left, right);
    quickSort(arra, left, mid - 1);
    quickSort(arra, mid + 1, right);

}

void insertionSort(int *arra, int n) {
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = arra[i];
        j = i - 1;
        while (j >= 0 && arra[j] > key)
        {
            arra[j + 1] = arra[j];
            j = j - 1;
        }
        arra[j + 1] = key;
    }
}

int main() {
    int Arr[] = {5,10,100,1000,10000,100000};
    int n,Size=6;
    float times[Size][7];
    for(int i=0; i<Size; i++)
        for(int j=0; j<7; j++)
            times[i][j] = 0;

    for(int i=0; i<Size; i++)
    {
        n = Arr[i];
        int *Input = new int[n];
        for(int j=0; j<7; j++)
        {
            for(int k=1; k<=20; k++)
            {
                srand(1);
                if(j==0)
                {
                    for(int l=0; l<n; l++)
                        Input[l] = rand();

                    auto start = chrono::high_resolution_clock::now();
                    mergeSort(Input,0,n-1);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
                else if(j==1)
                {
                    for(int l=0; l<n; l++)
                        Input[l] = rand();

                    auto start = chrono::high_resolution_clock::now();
                    quickSort(Input,0,n-1);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
                else if(j==2)
                {
                    for(int l=0; l<n; l++)
                        Input[l] = rand();

                    auto start = chrono::high_resolution_clock::now();
                    RandomizedQuickSort(Input,0,n-1);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
                else if(j==3)
                {
                    for(int it=0; it<n; it++)
                        Input[it] = rand();

                    auto start = chrono::high_resolution_clock::now();
                    insertionSort(Input,n);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
                else if(j==4)
                {
                    auto start = chrono::high_resolution_clock::now();
                    quickSort(Input,0,n-1);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
                else if(j==5)
                {
                    auto start = chrono::high_resolution_clock::now();
                    RandomizedQuickSort(Input,0,n-1);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
                else
                {
                    for(int l=0; l<n; l++)
                        Input[l] = rand();

                    auto start = chrono::high_resolution_clock::now();
                    sort(Input,Input+n);
                    auto stop = chrono::high_resolution_clock::now();
                    auto duration = chrono::duration_cast<chrono::nanoseconds>(stop - start);
                    times[i][j]+= duration.count();
                }
            }
            times[i][j] = (float)times[i][j]/(20.0*1000000.00);
        }
        delete []Input;
 //       cout<<" next level \n";
    }

    ofstream output;
    output.open("out.csv");

    output<<fixed<<setprecision(6)<<endl;
    output<<"n,Merge Sort,Quicksort,Randomized Quicksort,Insertion Sort,Quicksort with Sorted Input,Randomized Quicksort with Sorted Imput,STL sort() function\n";


    for(int i=0; i<Size; i++)
    {
        output<<Arr[i]<<",";
        for(int j=0; j<7; j++)
            output<<times[i][j]<<",";
        output<<endl;
    }
    output.close();
  //  cout<<"Complete\n";

    return 0;
}
