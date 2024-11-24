import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args){


        //nhap nam
        int iYear = getYear();


        //nhap thang va in ket qua so ngay
        System.out.println("nhap thang: ");
        int iMonth = getMonth();

        //System.out.println(iYear);
        //System.out.println(strMonth);

        //ham kiem tra leap year va in ra man hinh so ngay trong thang
        getDay(iYear,iMonth);

    }

    public static int getMonth(){
        Scanner keyboard = new Scanner(System.in);
        int iMonth;
        while(true) {
            String strMonth = keyboard.nextLine();
            switch (strMonth) {
                case "January":
                case "jan.":
                case "jan":
                case "1":
                    iMonth = 1;
                    break;
                case "February":
                case "Feb.":
                case "Feb":
                case "2":
                    iMonth = 2;
                    break;
                case "March":
                case "Mar.":
                case "Mar":
                case "3":
                    iMonth = 3;
                    break;
                case "April":
                case "Apr.":
                case "Apr":
                case "4":
                    iMonth = 4;
                    break;
                case "May":
                case "5":
                    iMonth = 5;
                    break;
                case "June":
                case "Jun":
                case "6":
                    iMonth = 6;
                    break;
                case "July":
                case "Jul":
                case "7":
                    iMonth = 7;
                    break;
                case "August":
                case "Aug.":
                case "Aug":
                case "8":
                    iMonth = 8;
                    break;
                case "September":
                case "Sept.":
                case "Sep":
                case "9":
                    iMonth = 9;
                    break;
                case "October":
                case "Oct.":
                case "Oct":
                case "10":
                    iMonth = 10;
                    break;
                case "November":
                case "Nov.":
                case "Nov":
                case "11":
                    iMonth = 11;
                    break;
                case "December":
                case "Dec.":
                case "Dec":
                case "12":
                    iMonth = 12;
                    break;
                default:
                    System.out.println("yeu cau nhap lai thang: ");
                    continue;
            }
            return iMonth;
        }
    }

    public static int getYear(){
        Scanner keyboard2 = new Scanner(System.in);
        int tempYear;
        do{
            System.out.println("yeu cau nhap nam khong am: ");
            while(!keyboard2.hasNextInt()){
                System.out.println("yeu cau nhap lai nam: ");
                keyboard2.next();
            }
            tempYear = keyboard2.nextInt();
        }while(tempYear <= 0);
        return tempYear;
    }

    public static void getDay(int iYear, int iMonth){
        int chiaDu1 = iYear%4;
        int chiaDu2 = iYear%100;
        int chiaDu3 = iYear%400;
        int res;

        //kiem tra nam nhuan: "1" la co; "0" la khong
        if(chiaDu3 == 0){
            res = 1;
        }else if(chiaDu1 == 0 && chiaDu2 != 0){
            res = 1;
        }else {
            res = 0;
        }


        switch (iMonth){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Co 30 ngay");
                break;
            case 2:
                if(res == 0){
                    System.out.println("Co 28 ngay");
                    break;
                }else{
                    System.out.println("Co 29 ngay");
                    break;
                }
        }
    }

}

