//
// Created by Saimon on 2/1/2022.
//
#include<iostream>

using namespace std;

int main(){
    int arr_b1[20];
    int max=0;
    int maxpos=-1;
     for(int i=0;i<20;i++){
         cin>>arr_b1[i];
         if(maxpos==-1){
             max=arr_b1[i];
             maxpos=i;
         }
         else if( arr_b1[i]>=max){
             max=arr_b1[i];
             maxpos=i;
         }
     }

     int tempPos= 5; //input your desired position here;
    int temp=arr_b1[tempPos];
    arr_b1[tempPos]=max;
    arr_b1[maxpos]=temp;





    return 0;

}