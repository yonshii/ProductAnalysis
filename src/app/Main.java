package app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1300),
                new Product("Headphones", "Electronics",200),
                new Product("Coffee Maker", "Appliances", 150),
                new Product("Telephone", "Electronics", 500),
                new Product("Blender", "Appliances", 135),
                new Product("Mixer", "Appliances", 200)
        );

        Map<String, Double> averagePrices = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("The average price of products by category: " + averagePrices);

        Optional<Map.Entry<String, Double>> maxCategory = averagePrices.entrySet().stream().max(Map.Entry.comparingByValue());

        maxCategory.ifPresent(entry -> System.out.println("The category with the highest average price: " +  entry.getKey() + ", with an average price:  " + entry.getValue()));
    }
}