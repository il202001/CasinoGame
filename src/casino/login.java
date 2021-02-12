package casino;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class login {
    
    private static ArrayList<String[]> loginData = new ArrayList<>();
    
    private static void readFile(){
        ArrayList<String> loginDataHold = new ArrayList<>();
        //loginData.get(0).add(null);loginDataHold.add(null);loginDataHold.add(null);    //fills the list with notheing ready to be changed
        
        
        try{
            File textFile = new File("Passwords.txt");
            Scanner read = new Scanner(textFile);
//            int j = 0;
//            loginData.add(j, "null");
//            loginData.get(j).add("null");
//            loginData.get(j).add("null");
//            loginData.get(j).add("null");
            while (read.hasNextLine()) {                                                //Checks to see if there is more in the file
                
                //loginData.add(loginDataHold);
                String[] loginDataHoldTemp =read.nextLine().split(",");
                loginData.add(loginDataHoldTemp);
//                for (int i = 0;i<loginDataHoldTemp.length;i++){                         //poo
//                    loginData.get(j).set(i,loginDataHoldTemp[i]);                       //turns the String[] into ArrayList[]
//                }
//                j++;
            }
            read.close();
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
        //System.out.println(loginData);
    }
    
    public static int login() {
        Scanner input = new Scanner(System.in);
        readFile();
        //System.out.println(loginData);
        int player = -1;
        while (player==-1){
            System.out.print("\nWhat is your Username: ");
            String username = input.next().toLowerCase();
            System.out.print("What is your Password: ");
            String password = input.next();
            for (int i = 0; i<loginData.size();i++){
                if (loginData.get(i)[0].toLowerCase().equals(username)){
                    if (loginData.get(i)[1].equals(password)){
                        player = i;
                    }
                    break;
                }
            }
            if (player != -1){
                System.out.println("\nYou are loged in");
            }else{
                System.out.println("\nFaild to login\nTry again");
            }
        }
        //System.out.println(player);
        return(player);
    }
    
    public static int signUp(){
        readFile();
        Scanner input = new Scanner(System.in);
        
        System.out.print("What do you want your username to be: ");
        String username = input.next();
        System.out.print("What do you want your password to be: ");
        String password = input.next();
        String[] signUpHold = {username,password,"1000"};
//        signUpHold.add(username);
//        signUpHold.add(password);
//        signUpHold.add("1000");
        loginData.add(signUpHold);
        return(loginData.size()-1);
    }
    
    public static long getCoins(int userPosition){
        return(Long.parseLong(loginData.get(userPosition)[2]));
    } 
    
    public static void logOut(int userPosition,long coins){
        try{
            FileWriter myWrite = new FileWriter("Passwords.txt");
            for (int i = 0;i<loginData.size();i++){
                if (userPosition!=i){
                    myWrite.write((loginData.get(i)[0])+","+(loginData.get(i)[1])+","+(loginData.get(i)[2])+"\n");
                }else{
                    myWrite.write((loginData.get(i)[0])+","+(loginData.get(i)[1])+","+(coins)+"\n");
                }
                
            }
            myWrite.close();
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }
        
    }
}


 