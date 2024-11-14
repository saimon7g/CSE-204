#include <iostream>

using namespace std;

int main()
{
    int tc=1;
    //  cin>>tc;
    while(tc--)
    {
        long long int weight;
        cin>>weight;
        int dpTable[weight+1];
        dpTable[0]=0;
        dpTable[1]=1;
        for( int i=2;i<=weight;i++){
            dpTable[i]=i;
            for(int j=1;j*j<=i;j++)
                dpTable[i]=min(dpTable[i],1+dpTable[i- j*j]);
        }


        cout << dpTable[weight]<<endl;
    }
    return 0;
}
