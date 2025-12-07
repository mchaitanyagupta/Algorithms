//it is a simple sliding window problem with a litle trick 
//we have to acces the array from both instead of middle so we remove the window from the total answer we are getting
// or window we know that you can only take k elements from end or begining of the array
//we check thwe window with minimum sum the subtract from the total sum
//we get answer
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tsum = 0;
        for(int i : cardPoints){
            tsum += i;
        }
        if(k == cardPoints.length)return tsum;
        int st = 0, e = 0, res = 0;
        int csum = 0;
        for(e = 0; e < cardPoints.length; e++){
            csum += cardPoints[e];
            if(e - st + 1 == (cardPoints.length - k)){
                res = Math.max(res, tsum - csum);
                csum -= cardPoints[st];
                st++;
            }
            
        }
        return res;
    }
}
