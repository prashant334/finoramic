public class Solution {
	public int pow(int x, int n, int d) {
	      if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        if(n == 1){
            if(x < 0)
                return (x+d) % d;
            else
                return x % d;
        }
        //implementation of euler totient function to remove lossy modulation
        int pn = n > 0 ? n : (-1) * n;
        int pn2 = pn;
        
        int px = x > 0 ? x : -x;
        int result = px;
        
        int k = 1;
        while(pn/2 > 0){
            result = result * result;
            pn = pn /2;
            k = k * 2;
        }
        result = result * pow(px, pn2 - k, d);
        
        if(x < 0 && n % 2 == 1) {            
            result = -result;
        }        
        if(n < 0)
            result = 1/result;
        
       
        result = result % d;
        
return result < 0 ? (result + d) % d : result;
	}
}
