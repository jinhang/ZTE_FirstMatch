package jins.start;  


import java.util.ArrayList;  
/**
 * Ä£ÄâÍ¶Æ±
 * @author jinhang
 *
 */
public class Vote  
{  
	private int id;  
	private ArrayList voters;  

	public Vote()  
	{  
		voters = new ArrayList();  
	}  
	public void addVoter(Person person)  
	{  
		voters.add(person);  
	}  
	public int getId()  
	{  
		return id;  
	}  
	public void setId(int id)  
	{  
		this.id = id;  
	}  
	public ArrayList getVoters()  
	{  
		return voters;  
	}  
	public void setVoters(ArrayList voters)  
	{  
		this.voters = voters;  
	}  
}  