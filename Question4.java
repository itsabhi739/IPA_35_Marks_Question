package IPA35marks;

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {

//        make an array of the object of the class
    HeadSets[] array = new HeadSets[4];
    Scanner scan = new Scanner(System.in);

//    for each element in the array
        for (int i = 0; i < array.length; i++) {
//            taken the input
            String a = scan.nextLine();
            String b = scan.nextLine();
            int c = scan.nextInt(); scan.nextLine();
            boolean d = scan.nextBoolean();scan.nextLine();

            array[i] = new HeadSets(a,b,c,d);
        }

        String brand = scan.nextLine();
        int totalPrice = findTotalPriceForGivenBrand(array,brand);
        if(totalPrice>0){
            System.out.println(totalPrice);
        }
        else {
            System.out.println("No headsets are available at given brand");
        }

        HeadSets res2 = findAvailableHeadSetsWithSecondMinPrice(array);
        if(res2 != null){
            System.out.println(res2.getHeadsetName());
            System.out.println(res2.getPrice());
        }
        else{
            System.out.println("no headsets are available");
        }
    }

    public static int findTotalPriceForGivenBrand(HeadSets[] array, String brand){
//        initialize the value
        int totalPrice=0;
        for (int i = 0; i < array.length; i++) {
//            Ignore the case while reading the brand
            if(array[i].getBrand().equalsIgnoreCase(brand)){
                totalPrice = totalPrice+array[i].getPrice();
            }
        }
//        if the total price is 0 then return 0
        if(totalPrice<=0){
            return 0;
        }
//        else return totalPrice or sum of the prices of boAt headsets available
        else return totalPrice;
    }


    public static HeadSets findAvailableHeadSetsWithSecondMinPrice(HeadSets[] array){
        int count = 0;

//        count the available devices
        for (int i = 0; i < array.length; i++) {
            if(array[i].isAvailable()){
                count++;
            }
        }

//       make the headset object
        HeadSets[] headSets = new HeadSets[count];

//        add it to the headset
        for (int i = 0; i < array.length; i++) {
            if(array[i].isAvailable()){
                headSets[i] = array[i];
            }
        }

//        sort it
        int k = 0;
        for (int i = 0; i < headSets.length; i++) {

        }

        return null;
    }
}

class HeadSets{
//    atrributes
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headsetName,String brand ,int price,boolean available){
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public void setHeadsetName(String headsetName) {
        this.headsetName = headsetName;
    }

    public String getHeadsetName() {
        return headsetName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}


//
//boat Bassheads
//boat
//1220
//true
//Over Ear Wired
//boat
//549
//true
//In Ear with Mic
//JBL
//450
//true
//Buds 2 Neo
//Realme
//500
//true
//boat