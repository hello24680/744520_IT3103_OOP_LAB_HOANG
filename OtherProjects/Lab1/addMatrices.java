import java.util.Scanner;

public class addMatrices {
    public static void main(String[] args){
        //nhap hang so cho ma tran neu can kiem tra
        //int[][] iArray1 = new int[][]{{0,1},{0,2}};
        //int[][] iArray2 = new int[][]{{2,3},{3,4}};


        System.out.println("nhap so hang va so cot cho ma tran: ");
        Scanner keyboard = new Scanner(System.in);

        //lay so hang va cot cua ma tran
        int row = keyboard.nextInt();
        int collumn = keyboard.nextInt();


        //khai bao 2 ma tran cung size
        int[][] iArray1 = new int[row][collumn];
        int[][] iArray2 = new int[row][collumn];

        //nhap gia tri cho ma tran 1
        System.out.println("nhap phan tu cho ma tran 1: ");
        for(int i = 0; i < row; i++){
            System.out.println("nhap phan tu hang " + (i+1) + " :");
            for(int k =0; k < collumn; k++){
                iArray1[i][k] = keyboard.nextInt();
            }
        }

        //nhap gia tri cho ma tran 2
        System.out.println("nhap phan tu cho ma tran 2: ");
        for(int i = 0; i < row; i++){
            System.out.println("nhap phan tu hang " + (i+1) + " :");
            for(int k =0; k < collumn; k++){
                iArray2[i][k] = keyboard.nextInt();
            }
        }

        //tinh sum 2 ma tran, luu vao iArraySum va in ra man hinh
        System.out.println("ma tran tong la: ");
        int[][] iArraySum = new int[row][collumn];
        addMatric(iArray1,iArray2,iArraySum);

        System.exit(0);
    }

    public static void addMatric(int[][] iArray1, int[][] iArray2, int[][] iArraySum){
        for(int i = 0; i < iArray1.length ; i++){
            for(int k =0; k < iArray1[0].length ; k++){
                iArraySum[i][k] = iArray1[i][k] + iArray2[i][k];
                System.out.print(iArraySum[i][k] + " ");
            }
            System.out.println(); //su dung de xuong dong
        }
    }
}
