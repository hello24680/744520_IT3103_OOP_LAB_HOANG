import java.util.Scanner;

public class SortArray {
    //mang hang so neu can dung de kiem tra
    //int[] iArray = new int[]{3123,132,4142,532,653,1211,63345};

    public static void main(String[] args){

       //khoi tao va lay length cua array
       Scanner keyboard = new Scanner(System.in);
       System.out.println("nhap so phan tu mang: ");
       int arrLength = keyboard.nextInt();
       int[] iArray = new int[arrLength];

       //lay gia tri phan tu array user nhap vao
        System.out.println("nhap gia tri phan tu mang: ");
        for(int k = 0; k < iArray.length; k++){
           iArray[k] = keyboard.nextInt();
       }

       //sap xep lai mang theo thu tu tang dan va in ra man hinh
        sortArr(iArray);

       //in ra man hinh tong va trung binh cua array
        sumAndAverage(iArray);


    }

    //ham tinh tong va gia tri trung binh
    public static void sumAndAverage(int[] iArray){
        int sum =0;
        for(int k=0; k < iArray.length; k++){
            sum += iArray[k];
        }
        double average = (double)sum/iArray.length;
        System.out.println("\nsum: " + sum);
        System.out.println("average: " + average);
    }

    //su dung Bubble sort de sap xep array
    public static void sortArr(int[] iArray){

        //in man hinh mang chua sap sep
        System.out.println("mang chua sap sep: ");
        for(int i =0; i < iArray.length ;i++) {
            System.out.print(iArray[i] + " ");
        }

        //thuat toan sap sep mang
        for(int j=0 ;j < iArray.length;j++) {
            int countSwap = 0;
            for (int k = 0; k < (iArray.length-1 -j); k++) {
                if (iArray[k] > iArray[k + 1]) {
                    int temp = iArray[k];
                    iArray[k] = iArray[k + 1];
                    iArray[k + 1] = temp;
                    countSwap += 1;
                }
            }
            if(countSwap == 0){
                break;
            }
        }

        //in ra man hinh mang da sap xep
        System.out.println("\nmang da sap sep: ");
        for(int i =0; i < iArray.length ;i++) {
            System.out.print(iArray[i] + " ");
        }
    }
}
