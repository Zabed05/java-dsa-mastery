import java.util.Arrays;

public class ImageFliping {
    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};

        for (int[] img : image) {
            System.out.println(Arrays.toString(img));
        }
        System.out.println();
        int ans[][] = flipAndInvertImage(image);

        for (int[] img : ans) {
            System.out.println(Arrays.toString(img));
        }
    }


    // static int[][] flipAndInvertImage(int[][] image){

    //     for (int i = 0; i < image.length; i++) {

    //         for (int j = 0; j < (image[i].length + 1)/2; j++) {

    //             int temp = image[i][j] ^ 1;
    //             image[i][j] = image[i][image[i].length - j - 1] ^ 1;
    //             image[i][image[i].length - j - 1] = temp;
    //         }
    //     }
    //     return image;
    // }

    static int[][] flipAndInvertImage(int[][] image){

        for (int[] row : image) {
            // reverse the array
            for (int i = 0; i < (image[0].length + 1) / 2; i++) {
                //swap
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length - i - 1] ^ 1;
                row[image[0].length - i - 1] = temp;
            }
        }
        return image;
    }
}
