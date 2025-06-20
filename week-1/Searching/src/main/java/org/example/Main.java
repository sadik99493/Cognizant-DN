package org.example;
import java.lang.reflect.Array;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        Product[] prods = { new Product(51,"shampoo","dove"),
                new Product(101,"laptop","macbook"),
                new Product(27,"mobile","moto"),
                new Product(49,"tv","samsung"),
                new Product(36,"washing machine","whirlpool"),
                new Product(14,"book","clasmate")};

        System.out.println("Enter product id to search : ");
        int tar = sc.nextInt();
        //doing linear search
        LinearSearch linSearcher = new LinearSearch();
        Product lin_res = linSearcher.search(prods,tar);
        if (lin_res==null){
            System.out.println("Product not found through linear search");
        }
        else{
            System.out.println("Required product category : "+lin_res.category);
            System.out.println("Required product name :" + lin_res.prodName);
        }
        BinarySearch binSearcher = new BinarySearch();
        //doing binary search on sorted array
        Product[] sortedprods = Arrays.copyOf(prods,prods.length);
        Arrays.sort(sortedprods, Comparator.comparingInt(p -> p.prodId));
        Product bin_res = binSearcher.search(prods,tar);
        if (bin_res==null){
            System.out.println("Product not found through binary search");
        }
        else{
            System.out.println("Required product category : "+bin_res.category);
            System.out.println("Required product name :" + bin_res.prodName);
        }
    }
}