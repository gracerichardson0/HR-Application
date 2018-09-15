public class Resources{
   public static final String[] STATUS = {"Position Posted", "Receiving Resumes", "Interviewing Applicants", "Position Filled"};
   private String posTitle;
   private String status;
   private String departName;
   private int numReports;
   private double startingSalary;
   private int delete;
   private static int numPositions;
   
   /*
   Increments the number of positions (numPositions)
   each time that the constructor is instantiated
   */
   public Resources(){
   ++numPositions;
   
   }
   
   public Resources(double startingSalary){
   
   }
   
   public String getPosTitle(){
      return this.posTitle;
   }
   
   public boolean setDelete(int delete){
      if(delete>0){
         this.delete=delete;
         return true;
      }else{
         return false;
      }
    }
      
   
   public String getDepartName(){
      return this.departName;
   }
   
   public int getNumReports(){
      return this.numReports;
   }
   
   public static int getNumPositions(){
      return numPositions;
   }
   
   public double getStartingSalary(){
      return this.startingSalary;
   }
   
   public boolean setPosTitle(String posTitle){
      if(!posTitle.equalsIgnoreCase("")){
         this.posTitle=posTitle;
         return true;
      }else{
         return false;
    }
   }
   
   public boolean setDepartName(String departName){
      if(!departName.equalsIgnoreCase("")){
         this.departName=departName;
         return true;
      }else{
         return false;
      }
    } 
    
   /**
     Validating mutator that checks that the number of
     reports is greater than zero (a positive integer)
     If so, it will return a boolean true value. Otherwise,
     false.
   
     @param numReports the number of reports
   
     @return a boolean value of true or false is returned
   */
   public boolean setNumReports(int numReports){
      if(numReports>0){
         this.numReports=numReports;
         return true;
      }else{
         return false;
      }
   }
   
   /**
     Accessor that returns the string
     status to show the user the list of 
     different statuses available to choose from,
     which are all pulled from the STATUS[] array
     instance variable. Cycles through the entire
     array, concatenating each time to the status
     variable.
   */
   public static String getStatus() {
		String status = "";
		for(int i=0; i<STATUS.length; i++) {
			status += STATUS[i];
         if(i<STATUS.length-1) {
            status += ", ";
         }         
      }
		return status;
	}
   
   public String getStatusName(){
      return this.status;
   }
   
   
   public boolean setStatusName(String status){
      if(!status.equalsIgnoreCase("")){
         this.status=status;
         return true;
      }else{
         return false;
      }
   }
      
   /**
     Validating mutator that checks to see
     if the user input for the status i
     equal to any of the strings in the
     array. 
     
     If valid and equal, then the method
     will return a boolean true value.
   
   
     @param status the status of the position
     
     @return the boolean true or false value
   
   
   */
   
   public boolean setStatus(String status) {
      boolean posStatus = false;
      int i=0;
      
      while(!posStatus && i<STATUS.length) {
         if(STATUS[i].equalsIgnoreCase(status)) {
            this.status=status;
            posStatus=true;
         }
         else {
            i++;
         }
      }
      
      return posStatus;
   } 
   
   public boolean setStartingSalary(double startingSalary){
      if(startingSalary>0.0){
         this.startingSalary=startingSalary;
         return true;
      }else{
         return false;
      }
   }
   
   /**
     Returns a string representation of the current object
     and contains information about the position
   
     @return the information about the position
   
   */

   public String toString(){
     
     return "\n Position Title: " + this.getPosTitle() + "\n Department Name: " + this.getDepartName() 
     + "\n Number of Reports: " + this.getNumReports() + "\n Status: " + this.getStatusName();
   }
  }
  
 