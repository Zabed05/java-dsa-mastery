public class S04_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(); // StringBuilder is mutable unlike String

        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
