package com.example.edwin.beeradviser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin on 1/23/2018.
 */

public class BeerExpert {
    List<String> getBrands(String color){
        List<String> brands = new ArrayList<>();
        if (color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else if (color.equals("light")) {
            brands.add("Carlsberg");
            brands.add("Tiger");
        } else if (color.equals("dark")){
            brands.add("Royal Stout");
            brands.add("Guiness Stout");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
