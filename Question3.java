package IPA35marks;

import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Resort[] arr = new Resort[4];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            int a = scan.nextInt();
            scan.nextLine();
            String b = scan.nextLine();
            String c = scan.nextLine();
            double d = scan.nextDouble();
            double e = scan.nextDouble();
            scan.nextLine();

            arr[i] = new Resort(a, b, c, d, e);
        }

        System.out.println("Enter the category: ");
        String category = scan.nextLine();

        int avg = findAvgPriceByCategory(arr, category);
        if (avg > 0) {
            System.out.println(avg);
        } else {
            System.out.println("there is no such available resort");
        }

    }


    public static int findAvgPriceByCategory(Resort[] arr, String category) {
        int avgAmount = 0;
        int avgPrice = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getCategory().equalsIgnoreCase(category) && arr[i].getRating() > 4) {
                avgPrice = avgPrice + (int) arr[i].getPrice();
                count++;
            }
            if (count > 0) {
                avgAmount = avgPrice / count;
            }
        }
        return avgAmount;

    }

}

    class Resort {

        private int resortId;
        private String resortName;
        private String category;
        private double price;
        private double rating;

        public Resort(int resortId, String resortName, String category, double price, double rating) {
            this.resortId = resortId;
            this.resortName = resortName;
            this.category = category;
            this.rating = rating;
            this.price = price;
        }

        public void setResortId(int resortId) {
            this.resortId = resortId;
        }

        public void setResortName(String resortName) {
            this.resortName = resortName;
        }

        public void setResortId(String resortId) {
            this.category = category;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }


        public int getResortId() {
            return resortId;
        }

        public String getResortName() {
            return resortName;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public double getRating() {
            return rating;
        }

    }



//
//1005
//Samudra
//3 star
//3500.00
//3.5
//1001
//O by Tamara
//5 Star
//7500.00
//4
//1007
//Edens resort
//3 Star
//2500.00
//4.7
//1003
//Tea Valley
//3 Star
//4600.00
//4.3

//3 Star

//3500 answer
