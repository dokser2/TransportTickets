public class Ticket {
    private int year;
    private int month;
    private int date;
    private double price;

    public Ticket() {
    }

    public Ticket(int year, int month, int date, double price) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "year=" + year +
                ", month=" + month +
                ", date=" + date +
               ", price=" + String.format("%.2f", price) +
                '}';
    }

//    public double TotalPrice(Ticket[] tickets){
//        double result = 0.0;
//        for (int i = 0; i < tickets.length ; i++) {
//           result+= tickets[i].getPrice();
//        }
//        return result;
//    }
}

