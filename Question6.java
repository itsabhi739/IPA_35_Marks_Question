package IPA35marks;

import java.util.Objects;
import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Institution[] arr = new Institution[4];
        for (int i = 0; i < arr.length; i++) {
            int a = scanner.nextInt();scanner.nextLine();
            String b = scanner.nextLine();
            int c = scanner.nextInt();scanner.nextLine();
            int d = scanner.nextInt();scanner.nextLine();
            String e = scanner.nextLine();

            arr[i] = new Institution(a,b,c,d,e);
        }

        String location = scanner.nextLine();
        String institutionName = scanner.nextLine();
        int sum = findNumClearanceByLoc(arr,location);
        if(sum>0){
            System.out.println(sum);
        }
        else {
            System.out.println("There are no cleared students in this particular location");
        }
        Institution res = updateInstitutionGrade(arr,institutionName);
        if(res != null){
            System.out.println(res.getInstitutionName()+" :: "+res.getGrade());
        }else{
            System.out.println("No Institute is available with the specified name");
        }
    }

    public static int findNumClearanceByLoc(Institution[] arr,String location){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getLocation().equalsIgnoreCase(location)){
                sum = sum+arr[i].getNoOfStudentCleared();
            }
        }
        return sum;
    }

    public static Institution updateInstitutionGrade(Institution[] arr,String institutionName) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getInstitutionName().equalsIgnoreCase(institutionName)){
               int rating=(arr[i].getNoOfStudentPlaced() * 100)/arr[i].getNoOfStudentCleared();
               if(rating>=80){
                   arr[i].setGrade("A");
               }else{
                   arr[i].setGrade("B");
               }

               return arr[i];
            }
        }
        return null;
    }
}

class Institution{
    private int institutionId;
    private String institutionName;
    private int  noOfStudentPlaced;
    private int noOfStudentCleared;
    private String location;
    private String grade;

    Institution(int institutionId,String institutionName,int noOfStudentPlaced,int noOfStudentCleared,String location){
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentPlaced = noOfStudentPlaced;
        this.noOfStudentCleared = noOfStudentCleared;
        this.location = location;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getNoOfStudentPlaced() {
        return noOfStudentPlaced;
    }

    public void setNoOfStudentPlaced(int noOfStudentPlaced) {
        this.noOfStudentPlaced = noOfStudentPlaced;
    }

    public int getNoOfStudentCleared() {
        return noOfStudentCleared;
    }

    public void setNoOfStudentCleared(int noOfStudentCleared) {
        this.noOfStudentCleared = noOfStudentCleared;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}

 /*
institutionId - int
institutionName - String
no0fStudentsPlaced - int
no0fStudentsCleared- int
location - String
grade - String


Write getters, setters for the above attributes.
Create constructor which takes parameter in the above sequence except grade.

Create class Solution with main method. Implement two static methods -
findNumClearanceByLoc
updateInstitutionGrade

in Solution class.

findNumClearanceByLoc method:
This method will take two input parameters - array of Institution objects and string parameter location.
The method will return the sum of the noOfStudentsCleared attribute from institution objects
for the location passed as parameter. If no institution with the given location is present in
the array of institution objects, then the method should return 0.

updateInstitutionGrade method:
This method will take a String parameter institutionName, along with the array of Institution objects.
The method will return the institution object, if the input String parameter matches with the
institutionName attribute of the institution object.

Before returning the object, the grade should be
arrived based on the rating calculation mentioned below.
This grade value should be assigned to the object.
If any of the above conditions are not met, then the method should return null.


The grade attribute should be calculated as follows

rating=(no0fStudentsPlaced * 100)/no0fStudentsCleared
If the rating gt= 80 , then grade should be 'A'. Else, then grade should be 'B'

Note: No institution object would have the same value for institutionName attribute.
All institution object would have the no0fStudentsPlaced value lesser than noOfStudentsCleared value.
All the searches should be case-insensitive.

The above-mentioned static methods should be called from the main method.

for findNumClearedByLoc method -
The main method should print the no0fClearance as it is, if the returned value is greater than e,
or it should print "There are no cleared students in this particular location".

For updateInstitutionGrade method -
The main method should print the institutionName and grade of the returned Institution object.




For updateInstitutionGrade method
The main method should print the institutionName and grade of the returned Institution object.
The institutionName and grade should be concatenated with :: while printing.
eg :- TCS :: A, where TCS is the institution name and A is the grade.
If the returned   value is null then it should print "No Institute is available with the specified name".

Before calling these static methods in main,
use Scanner object to read the values of four phone objects referring
attributes in the above-mentioned attribute sequence (except grade attribute).
Next, read the value for location and institutionName.




















_________________________
input
_________________________


111
Amrita
5000
10000
Chennai
222
Karunya
16000
20000
Coimbatore
333
AppleTech
10000
12000
Chennai
444
Aruna
6000
10000
Vellore
Chennai
Karunya


_______________________________
output:
_______________________________
22000
Karunya :: A
 */