import javax.swing.JOptionPane;

public class Caculator {
    public static void main(String[] args){
        String strNum1, strNum2; // khai bao bien string => thuoc tinh

        //nhap gia tri vao bien
        strNum1 = JOptionPane.showInputDialog(null,"plz input first number: ", "input first number ", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"plz input second number: ", "input second number ", JOptionPane.INFORMATION_MESSAGE);

        //chuyen doi 2 bien sang double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);


        //phuong thuc tinh toan
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1*num2;

        //in ra man hinh truong hop cong,tru,nhan
        System.out.println("kq cong: " + sum);
        System.out.println("kq tru: " + difference);
        System.out.println("kq nhan: " + product);

        //in ra man hinh truong hop chia
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("kq chia: " + quotient);
        }else {
            System.out.println("khong the chia voi 0");
        }
    }
}
