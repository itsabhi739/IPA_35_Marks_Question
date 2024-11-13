package IPA35marks;

import java.util.Arrays;
import java.util.Scanner;

public class Question11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Course[] arr = new Course[4];
        for (int i = 0; i < arr.length; i++) {
            int a = scan.nextInt();scan.nextLine();
            String b = scan.nextLine();
            String c = scan.nextLine();
            int d = scan.nextInt();scan.nextLine();
            int e = scan.nextInt();scan.nextLine();

            arr[i] = new Course(a,b,c,d,e);
        }

        String courseAdmin = scan.nextLine();
        int handson = scan.nextInt();scan.nextLine();

        int avg = findAvgOfQuizByAdmin(arr,courseAdmin);

        if(avg>0){
            System.out.println("Average is : "+avg);
        }
        else{
            System.out.println("No Course found.");
        }

        Course[] arr2 = sortCourseByHandsOn(arr,handson);
       if(arr2!=null){
           for(Course course:arr2){
               System.out.println(course.getCourseName());
           }
       }
       else{
           System.out.println("No Course found with mentioned attribute.");
       }
    }


    public static int findAvgOfQuizByAdmin(Course[] arr,String courseAdmin){
        int avg = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getCourseAdmin().equalsIgnoreCase(courseAdmin)){
                count++;
                sum = sum+arr[i].getQuiz();
            }
        }

        if(count>0){
            avg = sum/count;
            return avg;
        }
        else{
            return 0;
        }
    }



    public static Course[] sortCourseByHandsOn(Course[] arr,int handson){
        Course[] arr2 = new Course[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getHandson()<handson){
//                length bdahao
                arr2 = Arrays.copyOf(arr2,arr2.length+1);
//                add kro element
                arr2[arr2.length-1] = arr[i];
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = i; j <arr2.length; j++) {
                if(arr2[i].getHandson()>arr2[j].getHandson()){
                    Course temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }

        if(arr2.length>0){
            return arr2;
        }else{
            return null;
        }
    }


}

class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;

    Course(int courseId,String courseName,String courseAdmin,int quiz,int handson){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAdmin() {
        return courseAdmin;
    }

    public void setCourseAdmin(String courseAdmin) {
        this.courseAdmin = courseAdmin;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getHandson() {
        return handson;
    }

    public void setHandson(int handson) {
        this.handson = handson;
    }
}


/*
create the class Course with the below Attributes.

courseId- int
courseName- String
courseAdmin- String
quiz- int
handson -int

The above methods should be private ,write getter and
setter and parametrized constructor as required.

create class courseProgram with main method.

implement two static methods-
findAvgOfQuizByAdmin method:this method will take array
of Course objects and a String value as input parameters.
This method will find out Average (as int) of Quiz questions
for given Course Admin (String parameter passed)
This method will return Average if found.if there is no course
that matches then the method should return 0.


    sortCourseByHandsOn method:
This method will take an Array of Course Objects and int
value as input parameters.
This methods should return an Array of Course objects in an
ascending-order of their hand-son which are less than the
given hands-on(int parameter passed) value. if there is no
such course then the method should return null.


The above-mentioned static methods should be called from
main methods.

for findAvgOfQuizByAdmin method: The main method
should print the average if the returned value is not 0.
if the returned value is e then it should print "No Course
found."

for sortCourseByHandsOn method:
the main method should print the name
of the Course from the returned Course object Array if the
returned value is not null.if the returned value is null then
it should print "No Course found with mentioned attribute."


111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Nisha
17



output:
35
kubernetes
Apache Spark
cassandra


input 2:
111
kubernetes
Nisha
40
10
321
cassandra
Roshini
30
15
457
Apache Spark
Nisha
30
12
987
site core
Tirth
50
20
Shubhamk
5


 */