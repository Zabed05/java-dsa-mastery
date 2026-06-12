public class M05_HCF_LCM {
    public static void main(String[] args) {
        int a = 4, b = 6;

        System.out.println("Highest Common Factor: " + hcf(a, b));
        System.out.println("Least Common Multiple: " + lcm(a, b));
    }
    
    static int hcf(int a, int b){
        if(a == 0){ // base case
            return b;
        }

        return hcf((b%a), a); //Euclidean Algo. [gcd(a,b) = gcd(rem(b,a), a)]
    }

    static int lcm(int a, int b){

        int lcm = (a*b)/(hcf(a, b));

        return lcm;
    }

}