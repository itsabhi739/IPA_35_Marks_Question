package IPA35marks;

import java.util.Arrays;
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] arr = new Player[4];
        for (int i = 0; i < arr.length; i++) {
            int a = scanner.nextInt();scanner.nextLine();
            String b = scanner.nextLine();
            int c = scanner.nextInt();scanner.nextLine();
            String d = scanner.nextLine();
            String e = scanner.nextLine();

            arr[i] = new Player(a,b,c,d,e);
        }
        String playerType = scanner.nextLine();
        String matchType = scanner.nextLine();
        int minimumRuns = findPlayerWithLowestRuns(arr,playerType);
        Player[] res = findPlayerByMatchType(arr,matchType);

        if(minimumRuns>0){
            System.out.println(minimumRuns);
        }
        else{
            System.out.println("No such player");
        }
        if(res != null){
            for (int i = 0; i < res.length; i++) {
                for (int j = i; j < res.length; j++) {
                    if(res[i].getPlayerId()<res[j].getPlayerId()){
                        Player temp = res[i];
                        res[i] = res[j];
                        res[j] = temp;
                    }
                }
            }

            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i].getPlayerId());
            }
        }
        else{
            System.out.println("No Player with given matchType");
        }

    }

    public static int  findPlayerWithLowestRuns(Player[] arr,String playerType){
        int minRuns = arr[0].getRuns();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getPlayerType().equalsIgnoreCase(playerType)){
                if(arr[i].getRuns()<minRuns){
                    minRuns = arr[i].getRuns();
                }
            }
        }
        if(minRuns>0){
            return minRuns;
        }
        else{
            return 0;
        }

    }

    public static Player[] findPlayerByMatchType(Player[] arr,String matchType){
        Player[] arr2 = new Player[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getMatchType().equalsIgnoreCase(matchType)){
                arr2 = Arrays.copyOf(arr2,arr2.length+1);
                arr2[arr2.length-1] = arr[i];
            }
        }

        if(arr2 != null){
            return arr2;
        }
        else{
            return null;
        }
    }
}

class Player{
    private int playerId;
    private String playerName;
    private int  runs;
    private String playerType;
    private String matchType;

    public Player(int playerId, String playerName, int runs, String playerType, String matchType) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
}


/*
Create a class Player with below attributes:
 playerId - int
   playerName - String
    runs - int
      playerType - String
      matchType - String


  The above attributes should be private, write getters, setters and parameterized constructor
  as required.

Create class Solution with main method.
 Implement two static methods - findPlayerWithLowestRuns and findPlayerByMatchType in Solution class.

findPlayerWithLowestRuns method:
This method will take array of Player objects and a String value as input parameters. The method will
return the least runs of the Player from array of Player objects for the given player type.
 (String parameter passed). If no Player with the above condition are present in array of Player objects,
  then the method should return 0.

   findPlayerByMatchType method: This method will take array of Player objects and String value as
   input parameters and return the array of Player objects  belonging to the match type passed as input
   parameter in Descending order of playerId. If no Player with the above condition are present in the
   array of Player objects, then the method should return null.


    Note : No two Players will have the same playerId and runs. All the searches should be case
    insensitive.
    The above mentioned static methods should be called from the main method.

     For findPlayerWithLowestRuns method - The main method should print the returned runs as it is if the
     returned value is greater than 0 or it should print "No such player". Eg: 25 where 25 is the lowest
     runs of the Player.

     For findPlayerByMatchType method - The main method should print the playerId from the returned
     Player array for each Player if the returned value is not null. If the returned value is null
     then it should print "No Player with given matchType".

     Eg: 13 11 where 13 and 11 are the playerId's. Before calling these static methods in main,
     use Scanner object to read the values of four Player  objects referring attributes in the
      above mentioned attribute sequence.

     Next, read the value of two String parameter for capturing player type and match Type.
     Consider below sample input and output:

  Input1:
 11
 Sachin
  100
  International
One day
 12
 Shewag
 133
  International
Test
 13
 Varun
 78
State
Test
14
Ashwin
67
State
One day
State
One day


 Output:
 67
 14
 11



 Input2:
11
 Sachin
 100
 International
 One day
 12
 Shewag
  133
 International
  Test
  13
 Varun
  78
 State
Test
 14
  Ashwin
   67
   State
    One day
    District
    T20
     Output:  No such player   No Player with given matchType
 */