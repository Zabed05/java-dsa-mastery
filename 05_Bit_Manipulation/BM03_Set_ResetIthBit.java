//Q: Set & Reset ith bit

public class BM03_Set_ResetIthBit {
    public static void main(String[] args) {
        int n = 10; //1010
        int i = 0; // here we want to set 0th bit means (1010 --> 0) so 0 become 1

        int result = n|(1 << i); // this is for SET
        // int result = n & ~(1 << i); //this is for RESET

        System.out.println(result); //for SET: output should be 11 (1011) //RESET: 10
    }
}
