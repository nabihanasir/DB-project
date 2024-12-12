/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */



package com.mycompany.freshfoods;

  
public class products {
/*
    public products() {
    }

    @Override
    public String toString() {
        return "\nproducts{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }
     protected String name;
     protected int quantity;
     protected double price;
    
    public products(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public void add()
    {
          //inventory.productArray.add(this);
    }
    public void find(String s)
    {   
        for(products p:productArray)
        {
            if(p.name.equals(s))
            {
                System.out.println("product found successfully: "+p.toString());
                break;
            }
        }
}
    public static products search(String s)
    {
        products prod = new products();
        for(products p:productArray)
        {
            if(p.name.equalsIgnoreCase(s))
            {
                prod=p;
            }
        }
        return prod;
    }
    public void remove(String s)
    {
        for(products p :productArray)
        {
        if(p.name.equalsIgnoreCase(s))
        {
            //inventory.productArray.remove(p);
            System.out.println("product removed "+p.toString());
            break;
        }
        }
    }
  
  
}

class fruitandVeg extends products {

    public fruitandVeg() {
    }

    public fruitandVeg(String name, int quantity, double price) {
        super(name, quantity, price);
    }

    @Override
    public String toString() {
        return "\nfruitandVeg{" + "name=" + name + ", quantity=" + quantity + ", price=" + price +  '}';
    }
   
    @Override
    public void add()
    {
            inventory.fruitArray.add(this);
    }
    @Override
    public void find(String s)
    {   
        for(fruitandVeg p:fruitArray)
        {
            if(p.name.equalsIgnoreCase(s))
            {
                System.out.println("product found successfully: "+p.toString());
                break;
            }
        }
}
    @Override
       public void remove(String s)
    {
        for(fruitandVeg p :fruitArray)
        {
        if(p.name.equalsIgnoreCase(s))
        {
            inventory.fruitArray.remove(p);
            System.out.println("product removed "+p.toString());
            break;
        }
        }
    }


    
}
class meatandSeafood extends products{

    public meatandSeafood() {
    }

    @Override
    public String toString() {
        return "\nmeatandSeafood{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }

    public meatandSeafood(String name, int quantity, double price) {
        super(name, quantity, price);
    }
     @Override
     public void add()
    {
            inventory.meatArray.add(this);
    }
    @Override
    public void find(String s)
    {   
        for(meatandSeafood p:meatArray)
        {
            if(p.name.equalsIgnoreCase(s))
            {
                System.out.println("product found successfully: "+p.toString());
                break;
            }
        }

    } 
    @Override
       public void remove(String s)
    {
        for(meatandSeafood p :meatArray)
        {
        if(p.name.equalsIgnoreCase(s))
        {
            inventory.meatArray.remove(p);
            System.out.println("product removed "+p.toString());
            break;
        }
        }
    }
}
class breakfast extends products{

    public breakfast() {
    }

    @Override
    public String toString() {
        return "\nbreakfast{"+ "name=" + name + ", quantity=" + quantity + ", price=" + price  + '}';
    }

    public breakfast(String name, int quantity, double price) {
        super(name, quantity, price);
    }
    
    @Override
     public void add( )
    {
            inventory.breakfastArray.add(this);
    }
    @Override
    public void find(String s)
    {   
        for(breakfast p: breakfastArray)
        {
            if(p.name.equalsIgnoreCase(s))
            {
                System.out.println("product found successfully: "+p.toString());
                break;
            }
        }

}
    @Override
       public void remove(String s)
    {
        for(breakfast p :breakfastArray)
        {
        if(p.name.equalsIgnoreCase(s))
        {
            inventory.breakfastArray.remove(p);
            System.out.println("product removed "+p.toString());
            break;
        }
        }
    }
}
               
class grocery extends products{

    public grocery() {
    }

    @Override
    public String toString() {
        return "\ngrocery{" + "name=" + name + ", quantity=" + quantity + ", price=" + price + '}';
    }

    public grocery(String name, int quantity, double price) {
        super(name, quantity, price);
    }

    @Override
     public void add( )
    {
            inventory.groceryArray.add(this);
    }
    @Override
    public void find(String s)
    {   
        for(grocery p: groceryArray)
        {
            if(p.name.equalsIgnoreCase(s))
            {
                System.out.println("product found successfully: "+p.toString());
                break;
            }
        }

}
    @Override
       public void remove(String s)
    {
        for(grocery p :groceryArray)
        {
        if(p.name.equalsIgnoreCase(s))
        {
            inventory.groceryArray.remove(p);
            System.out.println("product removed "+p.toString());
            break;
        }
        }
    }


  */
}