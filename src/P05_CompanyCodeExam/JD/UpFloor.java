package P05_CompanyCodeExam.JD;

public class UpFloor {
    public static void main(String[] args){
        int m = 17;
        long sum = 1;
        long temp = 0;
        for(int i =1; i<= m-1/2;i++){
            temp = fact(i+(m-1-i*2))/fact(i)/fact(m-1-i*2);
            sum+= temp ;

        }

        System.out.println(sum%1000000007);
        System.out.println(intcountWays(m));

    }
    public static long fact(int m){
        long sum = 1;
        for(int i = 1;i <=m;i++)
            sum*=i;
        return sum;
    }

    public static long  intcountWays(int n) {

        int s[] = new int[101];
        s[0]=0;
        s[1]=0;
        s[2]=1;
        s[3]=2;
        for(int i=4;i<=n;i++)
        {
            s[i]=(s[i-2]+s[i-1])%1000000007;
        }
        return s[n];
    }

}
