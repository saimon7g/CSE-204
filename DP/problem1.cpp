#include<bits/stdc++.h>

using namespace std;

void LCS(string &s1, string &s2, vector<vector<int>>&dpTable,vector<vector<int>>&dirr)
{
    int m = s1.length();
    int n = s2.length();

    for(int i=0; i<=m; i++)
    {
        for(int j=0; j<=n; j++)
        {

            if(i==0||j==0)
            {
                dpTable[i][j]=0;
                dirr[i][j]=0;
            }
            else if(s1[i-1] == s2[j-1])
            {
                dpTable[i][j] = dpTable[i-1][j-1] + 1;
                dirr[i][j]=1;
            }
            else if(dpTable[i][j-1] >dpTable[i-1][j])
            {
                dpTable[i][j] = dpTable[i][j-1];
                dirr[i][j]=2;
            }
            else
            {
                dpTable[i][j] = dpTable[i-1][j];
                dirr[i][j]=3;
            }
        }
    }
}
void printLCS(vector<vector<int>>&dirr, string &s1,string &s2,int k)
{
    char s[k+1];
    s[k]='\0';
    k--;
    int i=s1.length();
    int j=s2.length();
    while(i>0 && j>0)
    {
        if(dirr[i][j]==1)
        {
            s[k--]=s1[i-1];
            i--;
            j--;
        }
        else if(dirr[i][j]==2)
        {
            j--;
        }
        else if(dirr[i][j]==3)
        {
            i--;
        }
    }
    cout<<s<<endl;

}

int main()
{
    string s1,s2;
    cin>>s1>>s2;
    int m = s1.length();
    int n = s2.length();
    vector<vector<int>>  dpTable(m+1,vector<int> (n+1));
    vector<vector<int>>  dirr(m+1,vector<int> (n+1));
    LCS(s1,s2,dpTable,dirr);
    cout<<dpTable[m][n]<<endl;
    printLCS(dirr,s1,s2,dpTable[m][n]);
    return 0;
}
