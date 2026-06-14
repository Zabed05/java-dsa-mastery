public class S02_Comparison {
    public static void main(String[] args) {
        String s1 = "Zabed";
        String s2 = "Zabed";
        //this s1 and s2 are pointing the same object 
        // by == comparator (use for checking if variables are pointing to same object)
        System.out.println(s1 == s2);  // op: true (bcz its compare values and also the reference)
 
        String name1 = new String("Java");
        String name2 = new String("Java");

        System.out.println(name1 == name2); //op: false (bcz name1 and name2 are two different object)

        // by .equals() method (when we only need to check value)
        System.out.println(name1.equals(name2)); //op: true(bcz its only check avlues is equal or not)
    }
}
