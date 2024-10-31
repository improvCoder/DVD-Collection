public class DVD {


    // Fields:
    private String title; // Title of this DVD
    private String rating; // Rating of this DVD
    private String runningTime; // Running time of this DVD in minutes

    public DVD()
    {
    }

    public DVD(String dvdTitle, String dvdRating, String dvdRunningTime)
    {
	
	title=dvdTitle;
	rating=dvdRating;
	runningTime=dvdRunningTime;
    }

    public String getTitle()

    {
        toString();
        return title;
    }

    public String getRating()
    {
	return rating;
    }

    public String getRunningTime()
    {
	return runningTime;
    }

    public void setTitle(String newTitle)
    {

	title=newTitle;
       	toString();
    }

    public void setRating(String newRating)
    {
	rating=newRating;
    }

    public void setRunningTime(String newRunningTime)
    {
	runningTime=newRunningTime;
    }

    
    public String toString()
    {
	title= title.toUpperCase();
	return title;
    }
}
