#include<bits/stdc++.h>

using namespace std;

int mat[10][10];
int mem[2048];
int n;

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

void Visit( int Curr, int record)
{
    int temp=cost(Curr,record);
    int update = turnOn(record,Curr);
    if(mem[update]<0)
    {
        mem[update]=temp+mem[record];
    }
    else
    {
        mem[update]=min(temp+mem[record],mem[update]);
    }

    for(int i=0; i<n; i++)
    {
        if(isOff(update,i))
        {
            Visit(i,update);
        }
    }
}


int main()
{
//inputs and memory setup
    for(int i=0; i<10; i++)
    {
        for(int j=0; j<10; j++)
            mat[i][j]=0;
    }

    cin>>n;
    int test=(1<<n)-1;
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<n; j++)
            cin>>mat[i][j];
    }
//inputs and memory setup_end

    int res=INT32_MAX;
    for(int i=0; i<n; i++)
    {
        for(int j=0; j<2048; j++)
            mem[j]=-1;
        mem[0]=0;
        Visit(i,0);
        res=min(mem[test],res);
    }
    cout<<res<<endl;
    return 0;
}
