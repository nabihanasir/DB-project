/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.freshfoods;

import java.util.ArrayList;

public class order {
/*
public static int noItems;    
public static final ArrayList<products > cart =new ArrayList<>();
public static final void addToCart(products p,int a)
{
    
    if(a<=p.quantity)
    {
        for(int i=1;i<=a;i++){
        cart.add(p);
        }
        p.quantity-=a;
        
        System.out.println("Product added");
    }
    else
    {
        System.out.println("out of stock");
    }
}
public static final void removeFromCart(products p,int a)
{
    cart.remove(p);
    p.quantity+=a;
}
public static final String printCart()
{   
    String s="name\tprice";
    for(products c :cart)
    {
        s+="\n"+ c.name+"\t"+c.price;
    }
    return s;
}
public static final double createBill()
{
    double total=0.0;
    for(products c:cart)
    {
        total+=c.price;
    }
    return total;
}
public static final String printBill()
{
    String s="----------- INVOICE -----------\nProduct\tPrice\n";
    for(products c :cart)
    {
        s+="\n"+ c.name+"\t"+c.price;
    }
    double totalbill_int=createBill();
    String totalbill_str = String.valueOf(totalbill_int);
    s+="\n-------------------------------";
    s+="\n\nTotal:\t"+totalbill_str+"\n-------------------------------";
    return s;
    
    /*
    System.out.println("----------- INVOICE -----------");
    for (int i = 0; i < items.size(); i++) {
        Product item = items.get(i);
        System.out.println((i + 1) + ". " + item.getName() + "\t$" + item.getPrice() + "\tQty: " + item.getQuantity());
    }
    System.out.println("-------------------------------");
    System.out.println("Total: $" + calculateTotal());
    System.out.println("Discount: $" + discount);
    System.out.println("-------------------------------");*/
}

