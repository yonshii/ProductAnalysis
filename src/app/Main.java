package app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1399),
                new Product("Headphones", "Electronics", 210),
                new Product("Coffee Maker", "Appliances", 155),
                new Product("Telephone", "Electronics", 530),
                new Product("Blender", "Appliances", 135),
                new Product("Mixer", "Appliances", 272),
                new Product("Shovel", "Garden Supplies", 27),
                new Product("Garden pruner", "Garden Supplies", 15),
                new Product("lawnmower", "Garden Supplies", 599)
        );

        Map<String, Double> averagePrices = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println("The average price of products by category:");
        averagePrices.forEach((category, avgPrice) ->
                System.out.printf("Category: %s -> Average Price: %.2f%n", category, avgPrice));

        Optional<Map.Entry<String, Double>> maxCategory = averagePrices.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        maxCategory.ifPresent(entry ->
                System.out.printf("The category with the highest average price: %s -> Average Price: %.2f%n",
                        entry.getKey(), entry.getValue()));
    }
}