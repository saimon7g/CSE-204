#include <bits/stdc++.h>

using namespace std;

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
        int res = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j])
                    res++;
        cout << res<<endl;
    }
    return 0;
}
