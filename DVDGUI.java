import javax.swing.*;

/**
 *  This class is an implementation of DVDUserInterface
 *  that uses JOptionPane to display the menu of command choices. 
 */

public class DVDGUI implements DVDUserInterface {
	 
	 private DVDCollection dvdlist;
	 
	 public DVDGUI(DVDCollection dl)
	 {
		 dvdlist = dl;
	 }
	 
	 public void processCommands()
	 {
		 String[] commands = {"Add/Modify DVD",
				 	"Remove DVD",
				 	"Get DVDs By Rating",
				 	"Get Total Running Time",
					"DVD List",
				 	"Exit and Save"};
		 
		 int choice;
		 
		 do {
			 choice = JOptionPane.showOptionDialog(null,
					 "Select a command", 
 					 "DVD Collection", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 commands,
					 commands[commands.length - 1]);
		 
			 switch (choice) {
			 	case 0: doAddOrModifyDVD(); break;
			 	case 1: doRemoveDVD(); break;
			 	case 2: doGetDVDsByRating(); break;
			 	case 3: doGetTotalRunningTime(); break;
			        case 4: doDVDList();break;
			 	case 5: doSave(); break;
			 	default:  // do nothing
			 }
			 
		 } while (choice != commands.length-1);
		 System.exit(0);
	 }

	private void doAddOrModifyDVD() {


	    int answer=JOptionPane.showConfirmDialog(null,"EDIT!!");
	    if(answer==0)
		{
		    JOptionPane.showMessageDialog(null,"YOu are about the ratings");
		    DVD[] array= dvdlist.getArray();
		    String change_ratings=JOptionPane.showInputDialog("Enter rating");
		    array[0].setRating(change_ratings);
		     String change_runningTime=JOptionPane.showInputDialog("Enter Running Time");
		     array[0].setRunningTime(change_runningTime);
		   
		}
	    if(answer==1){
		// Request the title
		String title = JOptionPane.showInputDialog("Enter title");
		if (title == null) {
			return;		// dialog was cancelled
		}
		title = title.toUpperCase();
		
		// Request the rating
		String rating = JOptionPane.showInputDialog("Enter rating for " + title);
		if (rating == null) {
			return;		// dialog was cancelled
		}
		rating = rating.toUpperCase();
		
		// Request the running time
		String time = JOptionPane.showInputDialog("Enter running time for " + title);
		if (time == null) {
		}
		
                // Add or modify the DVD (assuming the rating and time are valid
		dvdlist.addOrModifyDVD(title,rating,time);
		//, rating, time);
                
                // Display current collection to the console for debugging
                System.out.println("Adding/Modifying: " + title + "," + rating + "," + time);
                System.out.println(dvdlist);
	    }
	}

    private void doDVDList()
    {
	if(dvdlist.getDVDS()==0)
	    {
		JOptionPane.showMessageDialog(null,"Collection Empty!!","alert",JOptionPane.ERROR_MESSAGE);
	    }

	else{
	DVD[] array= dvdlist.getArray();
	Object[] selectionValues=array;

	
	Object selection=JOptionPane.showInputDialog(null,"DVD List","Menu",JOptionPane.INFORMATION_MESSAGE,null,selectionValues,selectionValues[0]);

	// ask the user to either view or edit the selection with yes or no message

	int select= JOptionPane.showConfirmDialog(null,"View");

	if(select==0)

	    {
	for(int i=0;i<dvdlist.getDVDS();i++)
	    {
		if(selection==array[i])
		    {
			JOptionPane.showMessageDialog(null,array[i].getRunningTime(),"RUN TIME",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,array[i].getRating(),"RATINGS",JOptionPane.INFORMATION_MESSAGE);
		   
		    }
	    }
	    }
	if(select==1)
	    {
		JOptionPane.showMessageDialog(null,"You are about to edit","alert",JOptionPane.ERROR_MESSAGE);
		String title1= JOptionPane.showInputDialog(null,"Enter title to Edit");
		title1=title1.toUpperCase();
		for(int i=0;i<dvdlist.getDVDS();i++)
		    {
			if(title1.compareTo(array[i].getTitle())==0){
			    String ratings=JOptionPane.showInputDialog(null,"Enter new rating");
			    array[i].setRating(ratings);
			    String runTime=JOptionPane.showInputDialog(null,"Enter new runTime");
			    array[i].setRunningTime(runTime);
			}
		    }

		
	    }
	
    }
    }	
	private void doRemoveDVD() {

		// Request the title
		String title = JOptionPane.showInputDialog("Enter title");
		if (title == null) {
			return;		// dialog was cancelled
		}
		title = title.toUpperCase();
		
                // Remove the matching DVD if found
                dvdlist.removeDVD(title);
                
                // Display current collection to the console for debugging
                System.out.println("Removing: " + title);
                System.out.println(dvdlist);

	}
	
	private void doGetDVDsByRating() {

		// Request the rating
		String rating = JOptionPane.showInputDialog("Enter rating");
		if (rating == null) {
			return;		// dialog was cancelled
		}
		rating = rating.toUpperCase();
		
                String results = dvdlist.getDVDsByRating(rating);
                System.out.println("DVDs with rating " + rating);
                System.out.println(results);

	}

        private void doGetTotalRunningTime() {
                 
                int total = dvdlist.getTotalRunningTime();
                System.out.println("Total Running Time of DVDs: ");
                System.out.println(total);
                
        }

	private void doSave() {
		
		dvdlist.save();
		
	}
		
}
