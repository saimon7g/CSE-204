#include<iostream>
#include<vector>
using namespace std;

class Heap {
private:
    int* Array;
    int maxSize;
    int n;

    void swap(int a, int b){
        int temp = Array[a];
        Array[a] = Array[b];
        Array[b] = temp;
    }

    int UpShift(int pos){
        if(pos >= n) return -1;
        while((pos != 0) && Array[pos] > Array[parent(pos)]){
            swap(pos, parent(pos));
            pos = parent(pos);
        }
        return pos;
    }

    void DownShift(int pos){
        if(pos >= n) return;
        while(!isLeaf(pos)){
            int maxPos = leftChild(pos);
            if(maxPos < n - 1 && Array[maxPos] < Array[maxPos + 1])
                maxPos++;
            if(Array[pos] >Array[maxPos])
                return;
            swap(pos, maxPos);
            pos = maxPos;
        }
    }

    bool isLeaf(int pos){
        if( (pos >= n/2) && (pos < n))
            return 1;
        return 0;
    }

    int leftChild(int pos){
        return 2*pos + 1;
    }

    int rightChild(int pos){
        return 2*pos + 2;
    }

    int parent(int pos){
        return (pos - 1) / 2;
    }

public:
    Heap(int Size){
        this->maxSize= Size;
        this->Array = new int[maxSize];
        n = 0;
    }

    Heap(vector<int> &elements){
        this->maxSize = elements.size();
        n = maxSize;
        this->Array = new int[maxSize];
        for(int i=0;i<elements.size();i++)
            Array[i] = elements[i];
        buildheap();
    }

    int size(){
        return n;
    }

    int getMax(){
           if(n == 0){
            cout<<"The heap is empty"<<endl;
            return NULL;
        }
        return Array[0];
    }

    void insert(int element){
         if(n>=maxSize){
            cout<<"heap is full"<<endl;
            return;
        }
        Array[n++] = element;
        UpShift(n - 1);
    }

    int deleteKey(){
        if(n == 0){
            cout<<"The heap is empty"<<endl;
            return NULL;
        }
        swap(0, n);
        n--;
        if(n != 0) DownShift(0);
        return Array[n];
    }

    void buildheap(){
        for(int i = n / 2 - 1; i >= 0; i--)
            DownShift(i);
    }

    ~Heap(){
        delete[] Array;
    }
};

void heapsort(vector<int>&v){
    Heap h(v);
    for(int i = 0; i < v.size(); i++){
        v[i] = h.deleteKey();
    }
}
