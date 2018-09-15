/**
  Name: Nicholas Richardson
  Date: 10/9/2016
  Course/Section: IT 206.DL1
  Assignment: Programming Assignment 4
  
  Description:
  
  This program is designed to track positions for Human
  Resources(HR) and present a menu to the user displaying
  their options on what they wish to do with the positions.
  A user can add a position, delete one, display information
  about all current positions, find the highest starting salary,
  or exit the application.
  
  Each position will require the following input, at a minimum:
  
  1. Position Title
  2. Department Name
  3. Number of Direct Reports
  4. Status of Position
  
  
  If the position status is equal to "Position Filled" or "Interviewing Applicants",
  then it will prompt the user to enter their starting salary. When shown the
  positions as selected by the menu, the user will be shown all information about the
  position, including:
  
  1. Position Title
  2. Department Name
  3. Number of Direct Reports
  4. Status of Position
  
  If the position has a starting salary, it will also display that.
  
  
  If the user chooses to see the highest salary, they will be shown
  all positions that had the largest salary.
 */
 
 
import javax.swing.JOptionPane;

public class Positions{
   public static void main(String[] args){
      //Length of the array
      final int MAX_NUM_POSITIONS = 17;
      
      //Initializes the array of position objects of the Resources class
      Resources[] position = new Resources[MAX_NUM_POSITIONS];
      
      int menuOption = getMenuOption();
      
      /*
       The menu will be presented to the user after they
       have finished with a particular option. If the user
       enters '5', they will exit the application.
      */
      
      while (menuOption != 5) {
         switch(menuOption) {
            case 1:
               addPosition(position, MAX_NUM_POSITIONS);
               break;
               
            case 2:
               deletePosition(position);
               break;
               
            case 3:
               displayPositions(position);
               break;
            
            case 4:
               findHighest(position);
               break;
               
            default:
               JOptionPane.showMessageDialog(null, "Unknown Error");
               break;
         }
      
         menuOption = getMenuOption();
      }
     }
      
      
    /**
      Prompts the user to enter the position title, department name,
      number of reports, status, and if applicable, the starting
      salary for each position. A new object will be instantiated each
      time the user selects this method from the menu.
      
      
      @param position the object created from the Resources class, an array
      of position objects is passed.
      
      @param MAX_NUM_POSITIONS the maximum number of positions allowed to be
      tracked at a time
    */
    public static void addPosition(Resources[] position, int MAX_NUM_POSITIONS){
      int index = Resources.getNumPositions();
      String status= "";
      boolean isStatus= false;
      int numReports= 0;
      double salary = 0.0;
      String posTitle= "";
      String departName= "";
      
      
      if(index<position.length){
      
         position[index] = new Resources();
         
         /*
          Continually prompts the user to enter the position title
          and department name while the index is less than the 
          max length of the array
         */
         
         do{
           posTitle = JOptionPane.showInputDialog("Please enter the title of the position: ");
           if(!position[index].setPosTitle(posTitle)){
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid position title.");
          }
         }while(!position[index].setPosTitle(posTitle));
         
         
         do{
            
           departName =JOptionPane.showInputDialog("Please enter the name of the Department: ");
           if(!position[index].setDepartName(departName)){
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid department name.");
          }
         }while(!position[index].setDepartName(departName));
                     
         
         /*
          Continually prompts the user to enter the number of reports
          until the user enters a value greater than zero or a non-string.
         
         */
         
         do{
            try{
              numReports= Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of reports the position will supervise: "));
               }catch(NumberFormatException e){
                  numReports=-1;
               }
               
                  if(!position[index].setNumReports(numReports)){
                     JOptionPane.showMessageDialog(null, "Error: Please enter a valid number of reports for the position");
                  }
         }while(!position[index].setNumReports(numReports));
         
         
         do{
            status = JOptionPane.showInputDialog("Please enter the status of the position. The choices are: " + Resources.getStatus());
            if(!position[index].setStatus(status)){
               JOptionPane.showMessageDialog(null, "Error: Please enter a status from the list of options.");
            }
         }while(!position[index].setStatus(status));
         
       
         if((status.equalsIgnoreCase(Resources.STATUS[2]) || (status.equalsIgnoreCase(Resources.STATUS[3])))){ 
            
            do{
               try{
                   salary =  Double.parseDouble((JOptionPane.showInputDialog("Please enter the starting salary of "
                   + position[index].getPosTitle()+ ":")));
               }catch(NumberFormatException e){
                  salary= -1.0;
               }
               
               if(!position[index].setStartingSalary(salary)){
                  JOptionPane.showMessageDialog(null, "Error: Please enter a valid starting salary");
               }
               
              }while(!position[index].setStartingSalary(salary));
            } 
           }else{
          
         JOptionPane.showMessageDialog(null, "The number of positions reached the limit.");
      }
      
     }
      
    /**
      Continually prompts the user to enter the number corresponding
      to the element in the array. If the element is equal to the 
      integer entered, then it will remove the element from the array
      and shift every element up by one.
      
      @param position the object created from the Resources class, an array
      of position objects is passed.
    */
    
    public static void deletePosition(Resources[] position){
    String output="ID" + "                  Position Title ";
      int i=0;
      int delete=0;

         for(i=0;i<position.length;i++){
            if(position[i]==null){
               break;
            }
            
            output+="\n" + i +"                   "+ position[i].getPosTitle();
         }
     

            delete = Integer.parseInt(JOptionPane.showInputDialog(null, output, "Enter the ID you want to remove: "));
            for(i=0; i<position.length;i++){
               if(position[i]!=null){
     
            if(delete==i){
               position[i]= position[i+1];
             }
            }      
           } 
       }
       
    /**
      Displays all information about every position to the user.
      The method loops through the entire array of objects and concatenates
      to an output string. If the status of a position is 'Interviewing Applicants'
      or 'Position Filled', then the user will be shown the starting salary in
      addition.
      
      @param position the object created from the Resources class, an array
      of position objects is passed.
    */   

    public static void displayPositions(Resources[] position){
    String output = "";
      
      for(int i = 0; i < Resources.getNumPositions(); i++) {
      
         if(position[i].getStartingSalary()>0.0){
         
         output += position[i].toString() + "\n" + "Starting Salary: "+ position[i].getStartingSalary()+ "\n";
         }else{
            output+=position[i].toString() + "\n\n";
        }
      }
      JOptionPane.showMessageDialog(null, "Position Report" + "\n"+ output);
   }
    
    
    /**
      Loops through the entire array of objects and displays
      the largest starting salary to the user. If there is a tie,
      or more than one person with the largest starting salary,
      then it will display all positions that are tied.
    
      @param position the object created from the Resources class, an array
      of position objects is passed.
    */
    
    
    public static void findHighest(Resources[] position){
    double largest = 0.0;
    int count = 0;
    String output="";
    int l=0;
    
      int index=0;
      int index2=0;
      
      String moreThanOne= "";
      
      while(index<Resources.getNumPositions()){
         if(position[index].getStartingSalary()>largest){
            largest = position[index].getStartingSalary();  
         }
         
         output= "\n" + "Position Title: " +  "'"+position[index].getPosTitle()+"'"+ " had the largest starting salary in " + 
           "\nDepartment Name: "+ "'"+position[index].getDepartName()+"'" + "\nwith a Starting Salary of : " + String.format("$%.2f",largest);

         index++;
         
         while(index2<Resources.getNumPositions()){
            if(position[index2].getStartingSalary()==largest){
               count++;
               moreThanOne= output+ " and was tied with " + "'"+ position[index2].getPosTitle()+ "'"+ " from department name: "+ "'"+ position[index2].getDepartName()+
               "'"+ " with a starting salary of " + String.format("$%.2f",largest);
            }
            
            index2++;
          }
        }
       
       
       //If more than one position has the largest
       //salary, it will print all of the positions.
       if(count<2){
         JOptionPane.showMessageDialog(null, output);
       }else if(count>=2){
         JOptionPane.showMessageDialog(null, moreThanOne);
       }
     }
     
     /**
       Displays the menu to the user with each choice they have.
       If the user enters a value less than or greater than the numbers
       listed on the menu, an error message will be displayed to the user.
       
       @return menuOption the choice that the user selects from the menu
       which will redirect to a case and switch statement in the main method.
     */
     
     private static int getMenuOption() {
      int menuOption;
      
      do {
         try {
            menuOption = Integer.parseInt(JOptionPane.showInputDialog(
               "Please enter your choice:"
               + "\n(1) Add a Position"
               + "\n(2) Delete a Position"
               + "\n(3) Display All positions"
               + "\n(4) Find Highest Starting Salary"
               + "\n(5) Exit Application"
               ));
         }
         catch (NumberFormatException e) {
            menuOption = 0;
         }
         if (menuOption < 1 || menuOption > 5) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuOption < 1 || menuOption > 5);
      
      return menuOption;
    }
   }