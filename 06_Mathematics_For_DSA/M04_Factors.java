public class M04_Factors {
    public static void main(String[] args) {
        int n = 15;

        //Brute force approach       TC=> o(n)
        // for (int i = 1; i <= n; i++) {
        //     if(n % i == 0){
        //         System.out.println(i + " ");
        //     }
        // }

        //Optimal         TC = o(sqrt(n))
        for (int i = 1; i < Math.sqrt(n); i++) {
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                }
                System.out.print(i + " " + n/i + " ");
            }
        }
    }
}