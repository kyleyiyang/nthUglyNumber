class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int index1=0,index2=0,index3=0;
        int factor2=2,factor3=3,factor5=5;
        ugly[0]=1;
        for (int i=1;i<n;i++) {
            int min=Math.min(Math.min(factor2,factor3),factor5);
            ugly[i]=min;
            if (factor2==min) factor2=2*ugly[++index1];
            if (factor3==min) factor3=3*ugly[++index2];
            if (factor5==min) factor5=5*ugly[++index3];
        }
        return ugly[n-1];
    }
}
************************************

class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set=new TreeSet<>();
        set.add(1L);
        for (int i=0;i<n-1;i++) {
            long temp=set.pollFirst();
            set.add(temp*2);
            set.add(temp*3);
            set.add(temp*5);
        }
        return set.first().intValue();
    }
}
