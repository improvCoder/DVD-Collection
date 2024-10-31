import java.io.*;
import java.util.Scanner;
public class DVDCollection {

    
    private int numdvds;

    private DVD[] dvdArray;

    private String sourceName;

    private boolean modified;

    private DVD movieObject;
   

    public DVDCollection()
    {
	numdvds = 0;
	dvdArray = new DVD[7];
    }

    public String toString()
    {
	System.out.println(numdvds);
        System.out.println(dvdArray.length);
	for(int i=0;i<numdvds;i++)
	    {
		System.out.println(dvdArray[i].getTitle());
	    }
    return null;
    }


    public void addOrModifyDVD(String title,String rating, String runningTime)
    {
	int num=999;
	if(numdvds==0)
	    {
		movieObject=new DVD();
		dvdArray[numdvds]=movieObject;
		movieObject.setTitle(title);
		movieObject.setRating(rating);
		movieObject.setRunningTime(runningTime);
		numdvds++;
	    }
	else
	    {
		for(int i=0;i<numdvds;i++)
		    {
		    if(title.compareTo(dvdArray[i].getTitle())==0)
			{
			    System.out.println("Title is repeated");
			
	    {
	       
		    
		if(dvdArray[i].getRating()!=null && dvdArray[i].getRunningTime()!=null){

		    Scanner scan=new Scanner(System.in);
		    System.out.println("Do you want to modify the values");
		    String option= scan.next();

		    if(option.compareTo("Y")==0)
			{
			    Scanner ratingMod=new Scanner(System.in);
			    System.out.print("Enter new rating");
			    String ratingModData= ratingMod.next();
		            dvdArray[i].setRating(ratingModData);

		    Scanner runningTimeMod=new Scanner(System.in);
			    System.out.print("Enter new runningTime");
			    String runningTimeModData= runningTimeMod.next();
		            dvdArray[i].setRunningTime(runningTimeModData);
			    }
		    }
		}
		num=1;
	    }
    }
    
		if(num!=1)
		    {
			movieObject=new DVD();
			dvdArray[numdvds]=movieObject;
			movieObject.setTitle(title);
			movieObject.setRating(rating);
			movieObject.setRunningTime(runningTime);
			numdvds++;
			for(int i=0;i<numdvds;i++)
			    {
				for(int j=i+1;i<numdvds;j++)
				    {
					if(dvdArray[i].getTitle().compareTo(dvdArray[j].getTitle())>0)
					    {
						DVD temp_max=dvdArray[i];
					dvdArray[i]=dvdArray[j];
					dvdArray[j]=temp_max;
				    }
			    }
		    }
	    }

    }
}

    public void removeDVD(String title)
    {
	int toDelete=0;
	
	for(int i=0;i<numdvds;i++)
	    {
		if(title.compareTo(dvdArray[i].getTitle())==0)
		    {
			System.out.print("Title to remove:");
			System.out.println(dvdArray[i].getTitle());
			dvdArray[i]=null;
			numdvds=numdvds-1;
			toDelete=i;
			break;
			
		    }
	    }

	for(int a=toDelete;a<7-toDelete;a++)
	    {
		dvdArray[a]=dvdArray[a+1];
	    }
    }


public String getDVDsByRating(String rating)
    {
	String ratingDuplicate;
	ratingDuplicate=rating.toUpperCase();

	for(int i=0;i<numdvds;i++)
	    {
		if(ratingDuplicate.compareTo(dvdArray[i].getRating())==0)
		    {
			System.out.println("Should print twice;");
		    }
	    }
	return ratingDuplicate;
    }

    public int getTotalRunningTime()
    {
	return 0; 
   }

    public void loadData(String filename)
    {
	try{
	BufferedReader br=new BufferedReader(new FileReader(filename));
	String s;
	while((s = br.readLine())!=null)
	    {
		//	if(s.compareTo(comma)==0)
		//  {
		//	System.out.println("there is comma");
		//  }
		//	else{
		    System.out.println(s);
		    //	}
	    }
	    br.close();
	}
	catch(Exception ex)
	    {
		System.out.println("Not Found!!");
		return;
	    }
    }

    /*    public void save()
    {
	
    }*/

    DVD[] getArray()
    {
	return dvdArray;
    }

    int getDVDS()
    {
	return numdvds;
    }

    
}
