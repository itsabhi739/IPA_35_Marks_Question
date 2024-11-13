package IPA35marks;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TravelAgencies[] arr = new TravelAgencies[4];
        for (int i = 0; i < arr.length; i++) {

            int a  = scan.nextInt();scan.nextLine();
            String b = scan.nextLine();
            String c = scan.nextLine();
            int d  = scan.nextInt();scan.nextLine();
            boolean e = scan.nextBoolean();scan.nextLine();
            arr[i] = new TravelAgencies(a,b,c,d,e);
        }

        int regNo = scan.nextInt();scan.nextLine();
        String packageType = scan.nextLine();

        int maxPackage = findAgencyWithHighestPackagePrice(arr);
        System.out.println(maxPackage);

        TravelAgencies res = agencyDetailsForGivenIdAndType(arr,regNo,packageType);

        if(res !=null){
            System.out.println(res.getAgencyName()+" :: "+res.getPrice());
        }
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr){
        int highestPackage = 0;
        for (int i = 0; i < arr.length; i++) {
            if(highestPackage<arr[i].getPrice()){
                highestPackage = arr[i].getPrice();
            }
        }
        return highestPackage;
    }


    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] arr,int regNo,String packageType){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].isFlightFacility()){
                if(arr[i].getRegNo() == regNo){
                    if(arr[i].getPackageName().equalsIgnoreCase(packageType)){
                        return arr[i];
                    }
                }
            }
        }
        return null;
    }
}
class TravelAgencies{
    private int regNo;
    private String agencyName;
    private String packageName;
    private int price;
    private boolean flightFacility;

    public TravelAgencies(int regNo, String agencyName, String packageName, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageName = packageName;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}

/*


Create a class TravelAgencies with below attributes:
regNo - int
agencyName - String
packageType - String
price - int
flightFacility - boolean


Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence.

Create class Solution with main method. Implement two static methods - findAgencyWithHighestPackagePrice and agencyDetailsforGivenIdAndType in Solution class.

findAgencyWithHighestPackagePrice method:
__________________________________________

This method will take array of TravelAgencies objects as an input parameter and return the highest package price from the given array of objects.

agencyDetailsForGivenIdAndType method:
__________________________________________

This method will take three input parameters -array of TravelAgencies objects, int parameter regNo and String parameter packageType. The method will return the TravelAgencies object b

FlightFacility should be available.
The input parameters(regNo and packageType) should matched with the regNo and packageType of TravelAgencies object.

If any of the above conditions are not met, then the method should return null. Note : Same Travel agency can have more than one package type. Travel agency and package type combinatic

The above mentioned static methods should be called from the main method.

For findAgencyWithHighestPackagePrice method - The main method should print the highestPackagePrice as it is. For agencyDetailsForGivenldAndType method -The main method should print
Input

input:-

123
A2Z Agency
Platinum
50000
true
345
SSS Agency
Gold
30000
false
987
Cox and Kings
Daimond
40000
true
888
Global Tours
silver
20000
false

987
Daimond


output:
50000
Cox and Kings : 40000

*/




