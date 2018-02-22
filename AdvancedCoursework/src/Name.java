
public class Name {

	private String FirstName;
	private String LastName;
	
	public Name(String first , String last)
	{
		this.FirstName = first;
		this.LastName = last;
	}
	
	public Name (String fullName)
	{
		 int space1 = fullName.indexOf(' ');
		 this.setFirstName(fullName.substring(0,space1));
		 this.setLastName(fullName.substring(space1));
		 
	  }
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String first) {
		this.FirstName = first;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public void setLastName(String last) {
		this.LastName = last;
	}
	
	public String getInitials()
	{
		String initials = ""+ FirstName.charAt(0) + LastName.charAt(0)+ " ";
		return initials.toUpperCase();//return the initials as capital latter 
	}
	
	public String getFullName()
	{
		String fullName = String.format("%s %s ", this.FirstName , this.LastName);
		return fullName;
	}
	
}
