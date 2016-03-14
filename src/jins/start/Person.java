package jins.start;  
  
  
import java.util.Iterator;  
import java.util.PriorityQueue;  
  
  
// Referenced classes of package cn.gucas.dsp.pengf.mg.model:  
//          Satisfaction  
  
  
public class Person  
{  
  
  
    private int id;  
    private int gender;  
    private int fortune;  
    private int appearance;  
    private int character;  
    private int requireFortune;  
    private int requireAppearance;  
    private int requireCharacter;  
    private PriorityQueue satisfactionQueue;  
    private PriorityQueue backupSatisfactionQueue;  
  
  
    public Person(int id, int gender, int fortune, int appearance, int character, int requireFortune, int requireAppearance,   
            int requireCharacter)  
    {  
        satisfactionQueue = new PriorityQueue();  
        backupSatisfactionQueue = new PriorityQueue();  
        this.id = id;  
        this.gender = gender;  
        this.fortune = fortune;  
        this.appearance = appearance;  
        this.character = character;  
        this.requireFortune = requireFortune;  
        this.requireAppearance = requireAppearance;  
        this.requireCharacter = requireCharacter;  
    }  
  
  
    private int getSatisfaction(Person person)  
    {  
        return requireFortune * person.fortune + requireAppearance * person.appearance + requireCharacter * person.character;  
    }  
  
  
    public void judgePerson(Person person)  
    {  
        Satisfaction satisfaction = new Satisfaction();  
        satisfaction.setPerson(person);  
        satisfaction.setSatisfaction(getSatisfaction(person));  
        satisfactionQueue.add(satisfaction);  
    }  
  
  
    public void buildBackupPriorityQueue()  
    {  
        backupSatisfactionQueue.clear();  
        Satisfaction satisfaction;  
        for (Iterator iterator = satisfactionQueue.iterator(); iterator.hasNext(); backupSatisfactionQueue.add(satisfaction))  
            satisfaction = (Satisfaction)iterator.next();  
  
  
    }  
  
  
    public void changePlayer(Person person)  
    {  
        buildBackupPriorityQueue();  
        Satisfaction satisfaction = new Satisfaction();  
        satisfaction.setPerson(person);  
        satisfaction.setSatisfaction(getSatisfaction(person));  
        backupSatisfactionQueue.add(satisfaction);  
    }  
  
  
    public int getTotalQuality()  
    {  
        return fortune + appearance + character;  
    }  
  
  
    public int peekGod()  
    {  
        return ((Satisfaction)backupSatisfactionQueue.peek()).getPerson().getId();  
    }  
  
  
    public int pollGod()  
    {  
        return ((Satisfaction)backupSatisfactionQueue.poll()).getPerson().getId();  
    }  
  
  
    public int getId()  
    {  
        return id;  
    }  
  
  
    public void setId(int id)  
    {  
        this.id = id;  
    }  
  
  
    public int getGender()  
    {  
        return gender;  
    }  
  
  
    public void setGender(int gender)  
    {  
        this.gender = gender;  
    }  
  
  
    public int getFortune()  
    {  
        return fortune;  
    }  
  
  
    public void setFortune(int fortune)  
    {  
        this.fortune = fortune;  
    }  
  
  
    public int getAppearance()  
    {  
        return appearance;  
    }  
  
  
    public void setAppearance(int appearance)  
    {  
        this.appearance = appearance;  
    }  
  
  
    public int getCharacter()  
    {  
        return character;  
    }  
  
  
    public void setCharacter(int character)  
    {  
        this.character = character;  
    }  
  
  
    public int getRequireFortune()  
    {  
        return requireFortune;  
    }  
  
  
    public void setRequireFortune(int requireFortune)  
    {  
        this.requireFortune = requireFortune;  
    }  
  
  
    public int getRequireAppearance()  
    {  
        return requireAppearance;  
    }  
  
  
    public void setRequireAppearance(int requireAppearance)  
    {  
        this.requireAppearance = requireAppearance;  
    }  
  
  
    public int getRequireCharacter()  
    {  
        return requireCharacter;  
    }  
  
  
    public void setRequireCharacter(int requireCharacter)  
    {  
        this.requireCharacter = requireCharacter;  
    }  
  
  
    public String toString()  
    {  
        return (new StringBuilder("[")).append(id).append(":").append(fortune).append(",").append(appearance).append(",").append(character).append(",").append(requireFortune).append(",").append(requireAppearance).append(",").append(requireCharacter).append("]").toString();  
    }  
}  