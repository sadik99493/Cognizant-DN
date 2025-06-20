package org.example;

public class BinarySearch {
    public Product search(Product[] prods,int id){
        System.out.println("searching for product with id "+id+" using binary search");
        int l = 0;
        int r = prods.length - 1;
        int mid;
        while(l<=r){
            mid = (l+r)/2 ;
            if (prods[mid].prodId==id) {
                return prods[mid];
            }

            else if (prods[mid].prodId<id){
                r = mid-1;
            }

            else{
                l = mid+1;
            }
        }
        return null ;
    }
}
