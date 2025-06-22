package org.example;

public class LinearSearch {
    public Product search(Product[] prods,int id){
        System.out.println("searching for product with id "+id+" using linear search");
        for(Product prod : prods){
            if( prod.prodId == id){
                return prod ;
            }
        }
        return null ;
    }
}
