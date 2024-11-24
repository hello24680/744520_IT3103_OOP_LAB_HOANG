import java.util.Scanner;
public class TriangleStars {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter n: ");
        int iLine = keyboard.nextInt();
        System.out.println("Triangle: ");
        for (int k = 1; k <= iLine; k++) {
            String strOutLine ="";
            for (int i = 1; i <= (iLine - k); i++) {
                strOutLine += " ";
            }
            for (int i = 1; i <= 2*k -1 ; i++) {
                    strOutLine += "*";
            }
            System.out.println(strOutLine);
        }
    }
}
