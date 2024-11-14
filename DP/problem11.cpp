#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int tc=1;
   // cin>>tc;
    while(tc--){
    int n,x;
    cin >> n;
    vector <int> pos(n + 1);
    for(int i = 1; i <= n; i++){
        cin >> x;
        pos[x] = i;
    }
    int res = 1;
    for(int i = 2; i <= n; i++){
        if(pos[i] < pos[i - 1]) res++;
    }
    cout << res << '\n';
    }
    return 0;
}
