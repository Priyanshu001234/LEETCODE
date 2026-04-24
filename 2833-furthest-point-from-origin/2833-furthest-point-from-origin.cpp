class Solution {
public:
    int furthestDistanceFromOrigin(string moves) {

        int n = moves.length();
        int lCnt = 0, rCnt=0,bCnt=0;

       for(char &x:moves){
        if(x=='L') lCnt++;
        if(x=='R') rCnt++;
        if(x=='_') bCnt++;
       }

       if(lCnt>rCnt){
        return lCnt + bCnt - rCnt;
       }

       return rCnt + bCnt - lCnt;

        
    }
};