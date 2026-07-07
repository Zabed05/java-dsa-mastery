import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        // subSeq("", "abc");
        // System.out.println(subSeqReturn("", "abc"));

        subSeqAscii("", "abc");
    }

    public static void subSeq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subSeq(p + ch, up.substring(1)); // here we add the first chracter
        subSeq(p, up.substring(1)); // here we ignore it
    }

    // Now lets return it on an Arraylist
    public static ArrayList<String> subSeqReturn(String p, String up){
        
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeqReturn(p + ch, up.substring(1)); // here we add the first chracter
        ArrayList<String> right = subSeqReturn(p, up.substring(1)); // here we ignore it

        left.addAll(right);
        //now return one any of them (left/right) (two are same)
        return left;
    }

    // Print ASCII value of all subsequence character
    public static void subSeqAscii(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        
        subSeqAscii(p + ch , up.substring(1));
        subSeqAscii(p, up.substring(1));
        subSeqAscii(p + (ch+0), up.substring(1)); // for getting ascii value
    }
}
