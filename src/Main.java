import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ticket[] tickets = new Ticket[20];

        for (int i = 0; i < 20; i++) {
            tickets[i] = new Ticket(
                    1950 + (int) (Math.random() * 70),
                    1 + (int) (Math.random() * 11),
                    0,
                    10.00 + (Math.random() * 5.00));
            if (tickets[i].getYear() % 4 == 0
                    && tickets[i].getYear() % 100 != 0
                    && tickets[i].getMonth() == 2) {
                tickets[i].setDate(1 + (int) (Math.random() * 27));
            } else if (tickets[i].getMonth() == 1
                    || tickets[i].getMonth() == 3
                    || tickets[i].getMonth() == 5
                    || tickets[i].getMonth() == 7
                    || tickets[i].getMonth() == 8
                    || tickets[i].getMonth() == 10
                    || tickets[i].getMonth() == 12) {
                tickets[i].setDate(1 + (int) (Math.random() * 30));
            } else {
                tickets[i].setDate(1 + (int) (Math.random() * 29));
            }
        }

        tickets[0].setYear(1600);
        tickets[1].setYear(1600);
        tickets[2].setYear(1600);
        tickets[3].setYear(1600);
        tickets[4].setYear(1600);
        tickets[5].setYear(1600);
        tickets[6].setYear(1600);
        tickets[7].setYear(1600);
        tickets[8].setYear(1600);
        tickets[9].setYear(1600);
        tickets[10].setYear(1600);
        tickets[11].setYear(1600);
        tickets[12].setYear(1600);
        tickets[13].setYear(1600);
        tickets[14].setYear(1600);
        tickets[15].setYear(1600);
        tickets[16].setYear(1600);
        tickets[17].setYear(1602);
        tickets[18].setYear(1601);
        tickets[19].setYear(1604);


        System.out.println("If you want know total price enter:  1 ");
        System.out.println("If you want know if the same year enter:  2 ");
        System.out.println("If you want know the most travelling month enter:  3 ");
        System.out.println("If you want to know haw much day between the first and the last tickets enter: 4");
        System.out.println("If you want to know haw much day between the first and the last tickets \n" +
                "without leap years enter: 5");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println(String.format("%.2f", totalPrice(tickets)));
                System.out.println(sameYear(tickets));
                System.out.println(mostTravelingMonth(tickets));
                howMuchTheDays(tickets);
                howMTDWithoutBigYear(tickets);
                for (Ticket t:tickets){
                    System.out.println(t.toString());
                }

                break;
            case 2:
                System.out.println(sameYear(tickets));
                break;
            case 3:
                System.out.println(mostTravelingMonth(tickets));
                break;
            case 4:
                howMuchTheDays(tickets);
                break;
            case 5:
                howMTDWithoutBigYear(tickets);
                break;
            default:
                System.out.println("the wrong number");
                break;
        }


    }

    public static double totalPrice(Ticket[] tickets) {
        double result = 0.0;
        for (int i = 0; i < tickets.length; i++) {
            result += tickets[i].getPrice();
        }
        return result;
    }

    public static String sameYear(Ticket[] tickets) {
        String s = "all the paying have done  in the same year:";
        String ns = "all the paying have Not done  in the same year:";
        int n = 0;
        int year = tickets[0].getYear();
        for (int i = 1; i < tickets.length; i++) {
            if (tickets[i].getYear() == year) {
                n++;
            }
        }
        if (n == tickets.length) {
            return s;
        } else {
            return ns;
        }
    }

    public static String mostTravelingMonth(Ticket[] tickets) {
        String s = "";
        int[] numbOfMonth = new int[12];
        for (int n : numbOfMonth) {
            n = 0;
        }
        for (int i = 0; i < tickets.length; i++) {
            numbOfMonth[tickets[i].getMonth() - 1]++;
        }
        int max = Integer.MIN_VALUE;
        for (int n : numbOfMonth) {
            if (n > max) {
                max = n;
            }
        }

        for (int i = 0; i < numbOfMonth.length; i++) {
            if (numbOfMonth[i] == max) {
                switch (i + 1) {
                    case 1:
                        s = "January";
                        break;
                    case 2:
                        s = "February";
                        break;
                    case 3:
                        s = "March";
                        break;
                    case 4:
                        s = "April";
                        break;
                    case 5:
                        s = "May";
                        break;
                    case 6:
                        s = "June";
                        break;
                    case 7:
                        s = "July";
                        break;
                    case 8:
                        s = "August";
                        break;
                    case 9:
                        s = "September";
                        break;
                    case 10:
                        s = "October";
                        break;
                    case 11:
                        s = "November";
                        break;
                    case 12:
                        s = "December";
                        break;
                }
            }
        }
        return s;
    }

    public static void howMuchTheDays(Ticket[] tickets) {
        Date[] dates = new Date[20];
        for (int i = 0; i < tickets.length; i++) {
            dates[i] = new Date();
            dates[i].setMonth(tickets[i].getMonth() - 1);
            dates[i].setYear(tickets[i].getYear());
            dates[i].setDate(tickets[i].getDate());
            // System.out.println(dates[i].getYear()+" "+dates[i].getMonth()+" "+dates[i].getDate());
        }

        long[] milisecunds = new long[20];
        for (int i = 0; i < dates.length; i++) {
            milisecunds[i] = dates[i].getTime();
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (long m : milisecunds) {
            if (m > max) {
                max = m;
            }
            if (m < min) {
                min = m;
            }
        }
        int maxDays = (int) (max / (24 * 60 * 60 * 1000));
        int minDays = (int) (min / (24 * 60 * 60 * 1000));
        int days = maxDays - minDays;
        System.out.println(days);

    }

    public static void howMTDWithoutBigYear(Ticket[] tickets) {
        Date[] dates = new Date[20];
        for (int i = 0; i < tickets.length; i++) {
            dates[i] = new Date();
            dates[i].setMonth(tickets[i].getMonth() - 1);
            dates[i].setYear(tickets[i].getYear());
            dates[i].setDate(tickets[i].getDate());
            // System.out.println(dates[i].getYear()+" "+dates[i].getMonth()+" "+dates[i].getDate());
        }

        ArrayList<Long> milisecundsArList = new ArrayList<>();
        for (Date d:dates) {
            if (d.getYear()%4>0||d.getTime()%100>0){
                milisecundsArList.add(d.getTime());
            }

        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (long m : milisecundsArList) {
            if (m > max) {
                max = m;
            }
            if (m < min) {
                min = m;
            }
        }
        int maxDays = (int) (max / (24 * 60 * 60 * 1000));
        int minDays = (int) (min / (24 * 60 * 60 * 1000));
        int days = maxDays - minDays;
        System.out.println(days);
        for (long l:milisecundsArList){
            System.out.println(l/(24*60*60*1000));
        }

    }
}

