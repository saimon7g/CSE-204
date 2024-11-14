//
// Created by Saimon on 2/4/2022.
//
#include<iostream>
#include<algorithm>

using namespace std;

int main(){
    int NumOfPlants,NumOfFriends;
    cin>>NumOfPlants>>NumOfFriends;
    int arr[NumOfPlants];
    for(int i=0;i<NumOfPlants;i++){
        cin>>arr[i];
    }
    sort(arr,arr+NumOfPlants);
    int i=NumOfPlants-1,j=0;
    int cost=0;
    while(i>=0){
        for(int k=0;k<NumOfFriends && i>=0;k++,i--){
            cost+=arr[i]*(j+1);
        }
        j++;
    }
    cout<<cost;
    return 0;
}