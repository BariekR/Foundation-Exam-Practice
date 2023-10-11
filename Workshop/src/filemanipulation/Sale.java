package filemanipulation;

public class Sale {
    private String month, product;
    private int year, unitsSold, revenue;

    public Sale(String month, String product, int year, int unitsSold, int revenue) {
        this.month = month;
        this.product = product;
        this.year = year;
        this.unitsSold = unitsSold;
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public String getProduct() {
        return product;
    }

    public int getYear() {
        return year;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public int getRevenue() {
        return revenue;
    }
}
