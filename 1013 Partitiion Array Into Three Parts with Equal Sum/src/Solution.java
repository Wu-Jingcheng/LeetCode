
public class Solution {
  // ˼·�ϻ����Ͼ���Ѱ��sum/3���зֵ�
  public boolean canThreePartsEqualSum(int[] A) {
    if (A.length < 3)
      return false;
    int left = A.length, right = 0, sum = 0, leftSum = 0, rightSum,i;
    for (i = 0; i < A.length; i++)
      sum += A[i];
    rightSum=sum;
    if (sum % 3 != 0)
      return false;
    int sum3 = sum / 3;
    for(i=0;i<A.length-1;i++) {//���ұ�û�п��ǵı�Ҫ��������{1,-1,1,-1}����case����
      if(left==A.length) {
        leftSum+=A[i];
        if(leftSum==sum3)left=i;
      }
      rightSum-=A[i];
      if(rightSum==sum3&&i>right)
        right=i;
    }
    return left<right;
  }

  public static void main(String[] args) {
    int[] arr1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
    int[] arr2 = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
    int[] arr3 = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};

    Solution s = new Solution();
    System.out.println("Checking arr1: " + s.canThreePartsEqualSum(arr1));
    System.out.println("Checking arr2: " + !s.canThreePartsEqualSum(arr2));
    System.out.println("Checking arr3: " + s.canThreePartsEqualSum(arr3));
  }

}
