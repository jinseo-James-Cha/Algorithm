// two matrices
/*
arr1(M * K)      arr2()
   K   K   K       N1   N2   N3
M1 2 , 3 , 2     K 5  , 4  , 3
M2 4 , 2 , 4     K 2  , 4  , 1
M3 3 , 1 , 4     K 3  , 1  , 1

# HAVE TO THE SAME NUM OF K

return 
(
    (2*5)+(3*2)+(2*3) , (2*4)+(3*4)+(2*1) , (2*3)+(3*1)+(2*1)
    (4*5)+(2*2)+(4*3) , (4*4)+(2*4)+(4*1) , (4*3)+(2*1)+(4*1)
    (3*5)+(1*2)+(4*3) , (3*4)+(1*4)+(4*1) , (3*3)+(1*1)+(4*1)
)

return
(
    (1행 * 1열) , (1행 * 2열), (1행 * 3열)
    (2행 * 1열) , (2행 * 2열), (2행 * 3열)
    (3행 * 1열) , (3행 * 2열), (3행 * 3열)
)

따라서, 첫번째 matrix의 행의 갯수가 정답의 행의 갯수를 결정짓고
두번째 matrix의 열의 갯수가 정답의 열의 갯수를 결정지음

answer matrix = M * N

이중배열에서 length는 행의 갯수를 리턴함
*/


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length; // M
        int mK = arr1[0].length; // K 
            
        int n = arr2[0].length; // N
        int nK = arr2.length; // K
        
        // Must be mK == nK
        
        int[][] answer = new int[m][n]; // M * N
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < mK; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
     
        
        return answer;
    }
}