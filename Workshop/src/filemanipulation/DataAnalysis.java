package filemanipulation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataAnalysis {

    public static void main(String[] args) {
        try {
            System.out.println(mostProfitableYear("east"));
            System.out.println(topProducts("west", 2));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int mostProfitableYear(String regionName) throws FileNotFoundException {
        Map<Integer, Integer> revenues = new HashMap<>();
        List<Sale> sales = getSales(regionName);

        for (Sale sale : sales) {
            if (!revenues.containsKey(sale.getYear())) {
                revenues.put(sale.getYear(), sale.getRevenue());
            } else {
                revenues.put(sale.getYear(), revenues.get(sale.getYear()) + sale.getRevenue());
            }
        }

        int max = Integer.MIN_VALUE;
        int year = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : revenues.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                year = entry.getKey();
            }
        }

        return year;
    }

    public static List<String> topProducts(String regionName, int n) throws FileNotFoundException {
        Map<String, Integer> products = new HashMap<>();
        List<Sale> sales = getSales(regionName);
        List<String> output = new ArrayList<>();

        for (Sale sale : sales) {
            if (!products.containsKey(sale.getProduct())) {
                products.put(sale.getProduct(), sale.getRevenue());
            } else {
                products.put(sale.getProduct(), products.get(sale.getProduct()) + sale.getRevenue());
            }
        }

        if (products.keySet().size() < n) {
            output = new ArrayList<>(products.keySet());
        } else {
            HashSet<Integer> uniqueProductRevenues = new HashSet<>(products.values());
            List<Integer> sortedProductRevenues = new ArrayList<>(uniqueProductRevenues);
            Collections.sort(sortedProductRevenues);

            for (int i = 0; i < n; i++) {
                for (Map.Entry<String, Integer> entry : products.entrySet()) {
                    if (entry.getValue().equals(sortedProductRevenues.get(sortedProductRevenues.size() - 1 - i))) {
                        output.add(entry.getKey());
                    }
                }
            }
        }

        return output;
    }

    private static List<Sale> getSales(String regionName) throws FileNotFoundException {
        List<Sale> sales = new ArrayList<>();
        List<String> file;

        try {
            file = Files.readAllLines(Paths.get(regionName + ".csv"));
        } catch (IOException e) {
            throw new FileNotFoundException("Cannot find sales data for " + regionName + ", please try again.");
        }

        for (int i = 1; i < file.size(); i++) {
            String[] line = file.get(i).split(",");
            sales.add(new Sale(line[0], line[2], Integer.parseInt(line[1]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
        }
        return sales;
    }

}
