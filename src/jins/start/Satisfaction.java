package jins.start;  
  
public class Satisfaction implements Comparable  
{  
    private Person person;  
    private int satisfaction;  
  
  
    public Satisfaction()  
    {  
    }  
  
  
    public Person getPerson()  
    {  
        return person;  
    }  
  
  
    public void setPerson(Person person)  
    {  
        this.person = person;  
    }  
  
  
    public int getSatisfaction()  
    {  
        return satisfaction;  
    }  
  
  
    public void setSatisfaction(int satisfaction)  
    {  
        this.satisfaction = satisfaction;  
    }  
  
  
    public int compareTo(Satisfaction other)  
    {  
        if (satisfaction > other.satisfaction)  
            return -1;  
        if (satisfaction < other.satisfaction)  
            return 1;  
        if (person.getTotalQuality() > other.person.getTotalQuality())  
            return -1;  
        if (person.getTotalQuality() < other.person.getTotalQuality())  
            return 1;  
        return person.getId() >= other.person.getId() ? 1 : -1;  
    }  
  
  
    public int compareTo(Object obj)  
    {  
        return compareTo((Satisfaction)obj);  
    }  
}  