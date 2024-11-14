#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include<queue>
using namespace std;

void bfs( vector<int> Board[],int distance[], int parent[], int length){
    int array[length];
    for(int i=1;i<length;i++){
        array[i]=-1;
        distance[i]=-1;
        parent[i]=-1;
    }
    queue<int> Que;
    array[1]=0;
    distance[1]=0;
    Que.push(1);
    while(!Que.empty()){
        int i=Que.front();
        Que.pop();
        for(int j=0;j<Board[i].size();j++){
            if(array[Board[i][j]]<0){
                Que.push(Board[i][j]);
                array[Board[i][j]]=0;
                parent[Board[i][j]]=i;
                distance[Board[i][j]]=distance[i]+1;
                if(Board[Board[i][j]].size()==1){
                    int snakeOrLadder=Board[i][j];
                    int ladderEnd=Board[snakeOrLadder][0];
                    if(ladderEnd>snakeOrLadder){
                        Que.push(ladderEnd);
                        array[ladderEnd]=0;
                        parent[ladderEnd]=snakeOrLadder;
                        distance[ladderEnd]=distance[snakeOrLadder];
//                        cout<<snakeOrLadder<<"  "<<ladderEnd<<endl;
                    }
                }
            }
        }
        array[i]=1;
//
//
//
//
 //       cout<<i<<"     ";
//        for(int k=1;k<length;k++)
//            cout<<array[k]<<" ";
//        cout<<endl;
//
//        cout<<i<<"     ";
 //       for(int k=1;k<length;k++)
  //          cout<<distance[k]<<" ";
 //       cout<<endl;
//
 //       cout<<i<<"     ";
 //      for(int k=1;k<length;k++)
 //          cout<<parent[k]<<" ";
//       cout<<endl;
    }
}

int main() {
    freopen("D:\\Study\\2-1\\CSE 204\\CPP\\Read.txt","r",stdin);
   // freopen("D:\\Study\\2-1\\CSE 204\\CPP\\Write.txt","w",stdout);
    int testcase;
    cin>> testcase;
     while(testcase--){
//        cout<<" start of new taste case"<<endl;
        int  FaceOfDie,BoardSize,NumOfSnake,NumOfLadder;
        cin>>FaceOfDie>>BoardSize>>NumOfLadder;
        BoardSize++;
        vector<int> Board[BoardSize];
         int distance[BoardSize];
         int parent[BoardSize];

        for(int i=0;i<NumOfLadder;i++){
            int start,end;
            cin>> start>>end;
            Board[start].push_back(end);
         }
        cin>>NumOfSnake;

        for(int i=0;i<NumOfSnake;i++){
            int start,end;
            cin>> start>>end;
            Board[start].push_back(end);
         }

//        cout<< FaceOfDie<<" "<< BoardSize<< " "<< NumOfLadder <<"   "<<NumOfSnake<<endl;
         for(int i=1;i<BoardSize;i++){
             if(Board[i].size()==0){
                // cout<<"inside if"<<endl;
                 for(int j=1;j<=FaceOfDie;j++){
                        if((i+j)<BoardSize)
                            Board[i].push_back(i+j);
                 }
            }
         }

//prining for input check
//        for(int i=1;i<BoardSize;i++){
//            cout<<i <<"    ";
//             for(int j=0;j<Board[i].size();j++)
//                   cout<<Board[i][j]<<" ";
//             cout<<endl;
//        }



        bfs( Board,distance,parent,BoardSize);
        cout<<"ewWER"<< endl<<endl;
         cout<<distance[BoardSize-1]<<endl;
         if(distance[BoardSize-1]<0){
             cout<<"No solution"<<endl;
         }
         else{
             vector<int> path;
             path.push_back(BoardSize-1);
             while(path.back()!=1){
                 path.push_back(parent[path.back()]);
             }
             for(int i=path.size()-1;i>0;i--){
                 cout<<path[i]<<"->";
             }
             cout<<path[0];
             cout<<endl;
         }
         vector<int> unreachable;
         for(int i=1;i<BoardSize;i++){
             if(distance[i]<0)
                 unreachable.push_back(i);
         }
         if(unreachable.size()==0)
             cout<<"All reachable"<<endl;
         else{
             for(int i=0;i<unreachable.size();i++){
                 cout<<unreachable[i]<<" ";
             }

         }
     }
    fclose(stdin);
  //  fclose(stdout);
    return 0;
}
