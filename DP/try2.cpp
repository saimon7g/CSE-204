#include<bits/stdc++.h>

using namespace std;

int mat[10][10];
int mem[10][2048];
int n;
int test;

int turnOn(int x,int pos)
{
    return x | (1<<(n-pos-1));
}
bool isOff(int N,int pos)
{
    return !(bool)(N & (1<<(n-pos-1)));
}

int cost(int curr,int mask)
{
    int val=mat[curr][curr];
    for(int i=0; i<n; i++)
    {
        if(!isOff(mask,i) && i!=curr)
        {
            val+=mat[curr][i];
        }
    }
    return val;
}

int Visit( int Curr, int record)
{
    if(mem[Curr][record]!=-1)
        return  mem[Curr][record];

    int temp=cost(Curr,record);
    int update = turnOn(record,Curr);
    int temp2=INT32_MAX;
    for(int i=0; i<n; i++)
    {
        if(isOff(record,i))
        {
            int x= Visit(i,update);
            mem[i][update]=x+temp;
            temp2=min(temp2,x);
        }
    }
    temp+=temp2;
    return temp;
}


int main()
{
//inputs and memory setup
    for(int i=0; i<10; i++)
    {
        for(int j=0; j<10; j++)
            mat[i][j]=0;
    }
    for(int i=0; i<10; i++)
    {
        for(int j=0; j<2048; j++)
            mem[i][j]=0;
    }
    cin>>n;
    test=(1<<n)-1;
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
            cin>>mat[i][j];
    }
//inputs and memory setup_end

    int res=INT32_MAX;
    for(int i=0; i<n; i++)
    {
        int temp=Visit(i,0);
        res=min(temp,res);
    }
    cout<<res<<endl;
    return 0;
}

