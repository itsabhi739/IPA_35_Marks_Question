package IPA35marks;

import java.util.Scanner;

public class Question9{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel[] arr = new Hotel[4];
        for (int i = 0; i < arr.length; i++) {
            int a = scanner.nextInt();scanner.nextLine();
            String b = scanner.nextLine();
            String c = scanner.nextLine();
            int d = scanner.nextInt();scanner.nextLine();
            int e = scanner.nextInt();scanner.nextLine();

            arr[i] = new Hotel(a,b,c,d,e);
        }
        String cabFacility = scanner.nextLine();
        int maxRating  = hotelByHighestRating(arr,cabFacility);
        if(maxRating<=5){
            System.out.println("NO HOTEL WITH GIVEN FACILITY");
        }
        else{
            System.out.println(maxRating);
        }

    }

    public static  int hotelByHighestRating(Hotel[] arr, String cabfacility){
        int max;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getCabFacility().equalsIgnoreCase(cabfacility)){
                if(arr[i].getHotelRating() >= 5){
                    max = arr[i].getHotelRating();
                    return max;
                }
            }
        }
        return 0;
    }
}

class Hotel{
    private int hotelId;
    private String hotelName;
    private String cabFacility;
    private int hotelRating;
    private int hotelFees;

    Hotel(int hotelId,String hotelName,String cabFacility,int hotelRating,int hotelFees){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.cabFacility = cabFacility;
        this.hotelRating = hotelRating;
        this.hotelFees = hotelFees;
    }

    public void setHotelId(int hotelId){
        this.hotelId = hotelId;
    }
    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
    public void setCabFacility(String cabFacility){
        this.cabFacility = cabFacility;
    }
    public void setHotelRating(int hotelRating){
        this.hotelRating = hotelRating;
    }
    public void setHotelFees(int hotelFees){
        this.hotelFees = hotelFees;
    }


    public int getHotelId() {
        return hotelId;
    }
    public String getHotelName() {
        return hotelName;
    }
    public String getCabFacility() {
        return cabFacility;
    }
    public int getHotelRating() {
        return hotelRating;
    }
    public int getHotelFees() {
        return hotelFees;
    }
}
/*
HOTEL MANAGEMENT QUESTION

CREATE A CLASS HOTEL WITH BELOW ATTRIBUTE

HOTEL-ID - INT
HOTEL-NAME - STRING
HOTEL-CABFACILITY - STRING
HOTEL-RATING - INT
HOTEL-FEES - INT

WRITE GETTER , SETTER AND PARAMETERISED CONSTRUTOR AS REQUIRED .


CREATE A CLASS SOLUTION AND WRITE MAIN METHOD IN IT INSIDE  MAIN METHOD WRITE 1. STATIC METHOD-- { hotelByHighestRating }

1. hotelByHighestRating  -- in this method two input are taken one is array of HOTEL objects and second is string
input which is cabficility of HOTEL if rating is greater than 5 and cabfacuility is availble then output the
highest rating if it is not greater than 5 then it should return 0 ;

condition 1 --> if hotel rating below 5 then it should be zero so print ----> "NO HOTEL WITH GIVEN FACILITY"
condition 2 --> if hoteL rating greater than 5 and CABFACILITY is yes then print hotel rating

Take 4 HOTEL objects as input and one String cabfacility


INPUT 1.

101
TAJ
YES
7
70000
102
RAJ
NO
5
30000
103
J&J
NO
6
40000
104
ITC
YES
5
50000
YES

OUTPUT 1 .

7


INPUT 2.

101
TAJ
YES
5
70000
102
RAJ
NO
5
30000
103
J&J
NO
6
40000
104
ITC
YES
5
50000
YES

OUTPUT 2.

NO HOTEL WITH GIVEN FACILITY

 */