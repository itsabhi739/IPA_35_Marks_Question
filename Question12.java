package IPA35marks;

import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Employee[] arr = new Employee[4];

        for (int i = 0; i < arr.length; i++) {

            int a = scan.nextInt();scan.nextLine();
            String b = scan.nextLine();
            int c = scan.nextInt();scan.nextLine();
            char d = scan.next().charAt(0);
            double e = scan.nextDouble();scan.nextLine();

            arr[i] = new Employee(a,b,c,d,e);
        }
        int age = scan.nextInt();scan.nextLine();
        Employee res1 = getEmployeeWithSecondLowestSalary(arr);
        if(res1 !=null){
            System.out.println(res1.getEmployeeId()+"#"+res1.getEmployeeName());
        }
        else{
            System.out.println("no second min found");
        }

        int count = countEmployeesBasedOnAge(arr,age);
        if(count>0){
            System.out.println(count);
        }
        else{
            System.out.println("No employee found for the given age");
        }


    }

    public static Employee getEmployeeWithSecondLowestSalary(Employee[] arr){
        double min = arr[0].getSalary();
        double secondMin = arr[1].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if(arr.length<2){
                return null;
            }
            else {
                if(arr[i].getSalary()<min){
                    min = arr[i].getSalary();
                    secondMin = min;
                }
                else if(arr[i].getSalary()>min && arr[i].getSalary()<secondMin){
                    secondMin = arr[i].getSalary();
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getSalary() == secondMin){
                return arr[i];
            }
        }

        return null;
    }

    public static int countEmployeesBasedOnAge(Employee[] arr,int age){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getAge() == age){
                count++;
            }
        }

        if(count>0){
            return count;
        }
        else {
        return 0;
        }
    }
}
class Employee{
private int employeeId;
private String employeeName;
private int age;
private char gender;
private double salary;

Employee(int employeeId,String employeeName,int age,char gender,double salary){
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.age = age;
    this.gender = gender;
    this.salary = salary;
}

public void setEmployeeId(int id){
    this.employeeId = id;
}

public void setEmployeeName(String name){
    this.employeeName = name;
}
public void setAge(int age){
    this.age = age;
}

public void setGender(char gender){
    this.gender = gender;
}

public void setSalary(double salary){
    this.salary = salary;
}

public int getEmployeeId(){
    return employeeId;
}
public String getEmployeeName(){
    return employeeName;
}
public int getAge(){
    return age;
}public char getGender(){
    return gender;
}

public double getSalary(){
    return salary;
}


}

/*
Create a class Employee with below attributes:

employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of
Employee objects referring attributes in the above mentioned attribute sequence.

Consider below sample input and output:

Input:
-------------
101
John
30
M
10000.00
102
Samantha
25
F
15000.00
103
Alex
28
M
12000.00
104
Lisa
30
F
15000.00
30

Output:
----------------
103#Alex
2
 */