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

        System.out.println("If you want know total price enter:  1 ");
        System.out.println("If you want know if the same year enter:  2 ");
        System.out.println("If you want know the most travelling month enter:  3 ");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println(String.format("%.2f", totalPrice(tickets)));
                break;
            case 2:
                System.out.println(sameYear(tickets));
                break;
            case 3:
                System.out.println(mostTravelingMonth(tickets));
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
}

