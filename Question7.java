package IPA35marks;

import java.util.Arrays;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory[]arr = new Inventory[4];
        for (int i = 0; i <arr.length ; i++) {

            int a = scanner.nextInt();scanner.nextLine();
            int b = scanner.nextInt();scanner.nextLine();
            int c = scanner.nextInt();scanner.nextLine();
            int d = scanner.nextInt();scanner.nextLine();

            arr[i] = new Inventory(a,b,c,d);
        }

        int limit  = scanner.nextInt();scanner.nextLine();

        Inventory[] res = replenish(arr,limit);

        for (int i = 0; i < res.length; i++) {
            if(res[i].getThreshold()>75){
                System.out.println(res[i].getInventoryId()+" : Critical Filling");
            }
            else if(res[i].getThreshold()<=75 && res[i].getThreshold()>=50){
                System.out.println(res[i].getInventoryId()+" : Moderate Filling");
            }
            else{
                System.out.println(res[i].getInventoryId()+" : Non-Critical Filling");
            }
        }

    }
    public static Inventory[] replenish(Inventory[]arr,int limit) {
        Inventory[] res = new Inventory[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getThreshold()<=limit){
                //length badhao
                res = Arrays.copyOf(res,res.length+1);
//                add kro element
                res[res.length-1] = arr[i];
            }
        }
        return res;
    }


    }

class Inventory{
    private int inventoryId;
    private int maximumQuantity;
    private  int currentQuantity;
    private int threshold;

    Inventory(int inventoryId,int maximumQuantity,int currentQuantity,int threshold){
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity  = currentQuantity;
        this.threshold = threshold;
    }

    public void setInventoryId(int inventoryId){
        this.inventoryId = inventoryId;
    }
    public void setMaximumQuantity(int maximumQuantity){
        this.maximumQuantity = maximumQuantity;
    }

    public void setCurrentQuantity(int currentQuantity){
        this.currentQuantity = currentQuantity;
    }

    public  void setThreshold(int threshold){
        this.threshold = threshold;
    }



    public int getInventoryId(){
        return inventoryId;
    }

    public int getMaximumQuantity(){
        return maximumQuantity;
    }

    public int getCurrentQuantity(){
        return currentQuantity;
    }

    public int getThreshold(){
        return threshold;
    }
}

/*
Create class Inventory with below attributes:
inventoryId - int
maximumQuantity - int
currentQuantity - int
threshold - int


Write necessary getters and setters and Constructors.

Create class Solution and implement static method "replenish" in the Solution class.
I

This method will take array of Inventory objects and a limit int as parameters.
And will return another array of Inventory objects where the limit int is lesser than or equal to the
original array of Inventory object's threshold attribute.

Before calling "replenish" method in the main method, read values for four Inventory objects
referring the attributes in above sequence along with a int limit.

Then call the "replenish" method and write logic in
main method to print inventoryId and "Critical Filling", if the threshold attribute is greater than 75.
Else if the threshold attribute is between 50 and 75 then print "Moderate Filling".
Else print "Non-Critical Filling"


Input:
1
108
50
50
2
200
60
40
3
158
35
45
4
80
45
40
45


output:
2 : Non-Critical Filling
3 : Non-Critical Filling
4 : Non-Critical Filling
 */