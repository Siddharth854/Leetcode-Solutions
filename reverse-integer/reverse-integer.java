class Solution {
    public int reverse(int x) {
        int temp = x; 
      long rev = 0; //by using long we make sure to not allow overflow or underflow in 
      start
         
        while(temp!=0)  //for both negative and poistive number the reverse process 
        hapepns
        {
            rev=10*rev+ temp%10;
            temp=temp/10;
        }
        if(rev==(int)rev)   //this condition makes sure there has been no overflow
            return (int)rev;    //print output in required data type
        else
            return 0;
    }
}