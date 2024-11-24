import javax.swing.JOptionPane;
import java.lang.Math;

public class MathEquation {

    public static void linearEquation(double a, double b){
        if(a == 0){
            if(b == 0){
                JOptionPane.showMessageDialog(null,"phuong trinh vo so nghiem");
            }else{
                JOptionPane.showMessageDialog(null, "phuong trinh vo nghiem");
            }
        }else{
            double res = -b/a;
            JOptionPane.showMessageDialog(null,"phuong trinh co nghiem la: " + res);
        }
    }

    public static void linearSystem(double a11, double a12, double b1, double a21, double a22, double b2){
        double d = a11*a22 - a21*a12;
        double dx = b1*a22 - b2*a12;
        double dy = a11*b2 - a21*b1;

        if(d == 0){
            if(dx == 0 && dy == 0) {
                JOptionPane.showMessageDialog(null, "he phuong trinh co vo so nghiem");
            }else {
                JOptionPane.showMessageDialog(null, "he phuong trinh vo nghiem");
            }
        }else{
            double res1 = dx/d;
            double res2 = dy/d;
            JOptionPane.showMessageDialog(null,"he co hai nghiem la: " + res1 + " va " + res2);
        }
    }

    public static void quadraticEquation(double a, double b, double c){
        double delta = b*b-4*a*c;
        if(delta < 0){
            JOptionPane.showMessageDialog(null, "phuong trinh vo nghiem");
        }else if(delta == 0){
            double res3 = -b/(2*a);
            JOptionPane.showMessageDialog(null, "phuong trinh co nghiem kep la: " + res3);
        }else{
            double sqrtDelta = Math.sqrt(delta);
            double res4 = (-b + sqrtDelta)/(2*a);
            double res5 = (-b - sqrtDelta)/(2*a);
            JOptionPane.showMessageDialog(null, "phuong trinh co 2 nghiem la: " + res4 + " va " + res5);
        }
    }


    public static void main(String[] args){
        JOptionPane.showMessageDialog(null,"nhap '1' neu la pt bac 1; '2' neu la pt bac 2; '3' neu la he pt");
        String userInput = JOptionPane.showInputDialog(null,"vui long nhap loai phuong trinh","loai phuong trinh: ",JOptionPane.INFORMATION_MESSAGE);
        if(userInput.equals("1")){
            //lay data
            String temp1 = JOptionPane.showInputDialog(null, "nhap a:","ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
            String temp2 = JOptionPane.showInputDialog(null, "nhap b:","ax + b = 0",JOptionPane.INFORMATION_MESSAGE);

            //chuyen doi sang double
            double a = Double.parseDouble(temp1);
            double b = Double.parseDouble(temp2);

            //cho vao phuong thuc de giai
            linearEquation(a,b);

        }else if(userInput.equals("2")){
            //lay data
            String temp1 = JOptionPane.showInputDialog(null, "nhap a11:","a11x1 + a12x2 = b1",JOptionPane.INFORMATION_MESSAGE);
            String temp2 = JOptionPane.showInputDialog(null, "nhap a12:","a11x1 + a12x2 = b1",JOptionPane.INFORMATION_MESSAGE);
            String temp3 = JOptionPane.showInputDialog(null, "nhap b1:","a11x1 + a12x2 = b1",JOptionPane.INFORMATION_MESSAGE);
            String temp4 = JOptionPane.showInputDialog(null, "nhap a21:","a21x1 + a22x2 = b2",JOptionPane.INFORMATION_MESSAGE);
            String temp5 = JOptionPane.showInputDialog(null, "nhap a22:","a21x1 + a22x2 = b2",JOptionPane.INFORMATION_MESSAGE);
            String temp6 = JOptionPane.showInputDialog(null, "nhap b2:","a21x1 + a22x2 = b2",JOptionPane.INFORMATION_MESSAGE);

            //chuyen doi sang double
            double a11 = Double.parseDouble(temp1);
            double a12 = Double.parseDouble(temp2);
            double b1 = Double.parseDouble(temp3);
            double a21 = Double.parseDouble(temp4);
            double a22 = Double.parseDouble(temp5);
            double b2 = Double.parseDouble(temp6);

            //cho vao phuong thuc de giai
            linearSystem(a11,a12,b1,a21,a22,b2);

        }else if(userInput.equals("3")){
            //lay data
            String temp1 = JOptionPane.showInputDialog(null, "nhap a:","ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
            String temp2 = JOptionPane.showInputDialog(null, "nhap b:","ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);
            String temp3 = JOptionPane.showInputDialog(null, "nhap c:","ax^2 + bx + c = 0",JOptionPane.INFORMATION_MESSAGE);

            //chuyen doi sang double
            double a = Double.parseDouble(temp1);
            double b = Double.parseDouble(temp2);
            double c = Double.parseDouble(temp3);

            //neu a = 0 thi la pt bac 1 khong thi la pt bac 2
            if(a == 0){
                linearEquation(b,c);
            }else{
                quadraticEquation(a,b,c);
            }
        }else{
            JOptionPane.showMessageDialog(null,"error","error input",JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
}
