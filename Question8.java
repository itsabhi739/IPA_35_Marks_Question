package IPA35marks;

import PracticeJavaTPoint.Numbers.SumofDigits;

import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cricketer[] arr = new Cricketer[4];

        for (int i = 0; i < arr.length; i++) {
            int a  = scan.nextInt();scan.nextLine();
            int b  = scan.nextInt();scan.nextLine();
            int c  = scan.nextInt();scan.nextLine();
            String d = scan.nextLine();
            String e = scan.nextLine();

            arr[i] = new Cricketer(a,b,c,d,e);
        }
        int id = scan.nextInt();scan.nextLine();
        Cricketer res1 = findCricketerWithMinimumMatchesPlayed(arr);
        if(res1 != null){
        System.out.println(res1.getCricketerId()+" : "+ res1.getMatchesPlayed());
        }

        Cricketer res2 = searchCricketerByld(arr,id);
        if(res2 != null){
            System.out.println(res2.getCricketerId()+" : "+res2.getCricketerName());
        }
        else {
            System.out.println("no such cricketer is found");
        }


    }

    public static Cricketer findCricketerWithMinimumMatchesPlayed(Cricketer[] arr){
        int min = arr[0].getMatchesPlayed();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getMatchesPlayed()<min){
                min = arr[i].getMatchesPlayed();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getMatchesPlayed() == min){
                return arr[i];
            }
        }
        return null;
    }

    public static Cricketer searchCricketerByld(Cricketer[] arr,int id){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getCricketerId() == id){
                return arr[i];
            }
        }
        return null;
    }
}

class Cricketer{
    private int cricketerId;
    private int matchesPlayed;
    private int totalRuns;
    private String cricketerName;
    private String team;



    Cricketer(int cricketerId, int matchesPlayed, int totalRuns, String cricketerName, String team){
        this.cricketerId = cricketerId;
        this.matchesPlayed = matchesPlayed;
        this.totalRuns = totalRuns;
        this.cricketerName = cricketerName;
        this.team = team;
    }

    public void setCricketerId(int cricketerId){
        this.cricketerId = cricketerId;
    }
    public void setMatchesPlayed(int matchesPlayed){
        this.matchesPlayed = matchesPlayed;
    }
    public void setTotalRuns(int totalRuns){
        this.totalRuns = totalRuns;
    }

    public void setCricketerName(String cricketerName){
        this.cricketerName = cricketerName;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getCricketerId(){
        return cricketerId;
    }

    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    public int getTotalRuns(){
        return totalRuns;
    }

    public String getCricketerName(){
        return cricketerName;
    }

    public String getTeam(){
        return team;
    }


}

/*
Cricketer ManagementSystem

Create a class Cricketer with below

attributes:



cricketerld - int
matchesPlayed - int
totalRuns - int
cricketerName - String
team - String



Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with main method

Implement two static methods - findCricketerWithMinimumMatchesPlayed and searchCricketerByld in Solution class.

 findCricketerWithMinimum Matches Played in the Solution class:
  This method will take array of Cricketer objects and returns the Cricketer object
  having the minimum Matches Played.

searchCricketerByld:
Create a static method searchCricketerByld in the Solution class.
This method will take array of Cricketer objects and Id as input and
returns the Cricketer object having the mentioned Id. If the mentioned Id is not
 found then method should return null.

These methods should be called from the
main method
Write code to perform the following

tasks:


1. Take necessary input variable and call findCricketerWithMinimumMatchesPlayed. For this method - The main method should print the Cricketer ID with minimum of mentioned attribute(matchesPlayed).

2. Take necessary input variable and call searchCricketer Byld. For this method -
The main method should print the Cricketer ID and Name(as shown in the sample output)
if the returned value is not null. If the returned value is null then it should print
"No such Cricketer".
The above mentioned static methods should be called from the main method. Also write
the code for accepting the inputs and printing the outputs. Don't use any static test
or formatting for printing the result. Just invoke the method and print the result

Note:

All String comparison needs to be case in-sensitive

You can use/refer the below given sample input and output to verify your solution. No two object will have the same number of matches played


Sample Input (below) description:

The 1st input taken in the main section is the number of Cricketer objects to be added to the list of Cricketer.

The next set of inputs are id,matches Played,totalRuns,name,team for each Cricketer object taken one after other and is repeated for number of Cricketer objects given in the first line of input.

The last line of inputs will be the arguments which needs to be passed as parameter to the methods.

Consider below sample input and output to test your code:

Sample Input 1 - public:

1001
100
7000
Kohli
India
1002
120
4700
Yuvi
India
1003
80
3200
Smith
Australia
1004
130
5800
Gayle
Westindies
1004

Sample output 1
1003
1004
Gayle

Sample Input 2 -

4
1001
100
7000
Kohli
India
1002
120
4700
Yuvi
India
1003
80
3200
Smith
Australia
1004
130
5800
Gayle
WestIndies
1005


Sample Output 2:
1003
No such Cricketer

 */
