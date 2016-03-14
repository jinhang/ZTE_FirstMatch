package jins.start;  
  
  
import jins.start.Person;  
import jins.start.Vote;  
import jins.start.Loader;  
import java.util.*;  
  
  
public class Activity  
{  
  
  
    private HashMap femaleMap;  
    private HashMap maleMap;  
    private ArrayList playerList;  
    private HashMap randomFemaleMap;  
    private HashMap randomMaleMap;  
  
  
    public Activity()  
    {  
    }  
  
  
    public void init()  
    {  
        femaleMap = Loader.loadSampleMap("./conf/female.txt", 0);  
        maleMap = Loader.loadSampleMap("./conf/male.txt", 1);  
        playerList = Loader.loadPlayerList("./conf/players.txt");  
    }  
  
  
    public String generate(int gender)  
    {  
        randomFemaleMap = new HashMap();  
        randomMaleMap = new HashMap();  
        StringBuilder sb = new StringBuilder();  
        sb.append("男生                           \t女生 \n");  
        for (int i = 0; i < 99; i++)  
        {  
            int fortune = (int)(Math.random() * 98D + 1.0D);  
            int appearance = (int)(Math.random() * 98D + 1.0D);  
            int charactor = (int)(Math.random() * 98D + 1.0D);  
            int requireFortune = (int)(Math.random() * 98D + 1.0D);  
            int requireAppearance = (int)(Math.random() * 98D + 1.0D);  
            int requireCharactor = 100 - requireFortune - requireAppearance;  
            Person male = new Person(i + 1, 1, fortune, appearance, charactor, requireFortune, requireAppearance, requireCharactor);  
            randomMaleMap.put(Integer.valueOf(i + 1), male);  
            sb.append((new StringBuilder()).append(male).append("\t").toString());  
            fortune = (int)(Math.random() * 98D + 1.0D);  
            appearance = (int)(Math.random() * 98D + 1.0D);  
            charactor = (int)(Math.random() * 98D + 1.0D);  
            requireFortune = (int)(Math.random() * 98D + 1.0D);  
            requireAppearance = (int)(Math.random() * 98D + 1.0D);  
            requireCharactor = 100 - requireFortune - requireAppearance;  
            Person female = new Person(i + 1, 0, fortune, appearance, charactor, requireFortune, requireAppearance, requireCharactor);  
            randomFemaleMap.put(Integer.valueOf(i + 1), female);  
            sb.append((new StringBuilder()).append(female).append("\n").toString());  
        }  
  
  
        if (gender == 1)  
        {  
            int fortune = (int)(Math.random() * 98D + 1.0D);  
            int appearance = (int)(Math.random() * 98D + 1.0D);  
            int charactor = (int)(Math.random() * 98D + 1.0D);  
            int requireFortune = (int)(Math.random() * 98D + 1.0D);  
            int requireAppearance = (int)(Math.random() * 98D + 1.0D);  
            int requireCharactor = 100 - requireFortune - requireAppearance;  
            Person female = new Person(100, 0, fortune, appearance, charactor, requireFortune, requireAppearance, requireCharactor);  
            randomFemaleMap.put(Integer.valueOf(100), female);  
            sb.append((new StringBuilder("              \t       \t")).append(female).append("\n").toString());  
        } else  
        {  
            int fortune = (int)(Math.random() * 98D + 1.0D);  
            int appearance = (int)(Math.random() * 98D + 1.0D);  
            int charactor = (int)(Math.random() * 98D + 1.0D);  
            int requireFortune = (int)(Math.random() * 98D + 1.0D);  
            int requireAppearance = (int)(Math.random() * 98D + 1.0D);  
            int requireCharactor = 100 - requireFortune - requireAppearance;  
            Person male = new Person(100, 1, fortune, appearance, charactor, requireFortune, requireAppearance, requireCharactor);  
            randomMaleMap.put(Integer.valueOf(100), male);  
            sb.append((new StringBuilder()).append(male).append("\n").toString());  
        }  
        return sb.toString();  
    }  
  
  
    public String join(Person player)  
    {  
        StringBuilder sb = new StringBuilder();  
        for (Iterator iterator = randomMaleMap.keySet().iterator(); iterator.hasNext();)  
        {  
            Integer maleId = (Integer)iterator.next();  
            Person male = (Person)randomMaleMap.get(maleId);  
            Person female;  
            for (Iterator iterator5 = randomFemaleMap.keySet().iterator(); iterator5.hasNext(); female.judgePerson(male))  
            {  
                Integer femaleId = (Integer)iterator5.next();  
                female = (Person)randomFemaleMap.get(femaleId);  
                male.judgePerson(female);  
            }  
  
  
        }  
  
  
        HashSet maleGodSet;  
        HashSet femaleGodSet;  
        HashMap votes;  
        if (player.getGender() == 1)  
        {  
            randomMaleMap.put(Integer.valueOf(player.getId()), player);  
            maleGodSet = new HashSet();  
            femaleGodSet = new HashSet();  
            Person female;  
            for (Iterator iterator1 = randomFemaleMap.keySet().iterator(); iterator1.hasNext(); female.changePlayer(player))  
            {  
                Integer femaleId = (Integer)iterator1.next();  
                female = (Person)randomFemaleMap.get(femaleId);  
                player.judgePerson(female);  
            }  
  
  
            Person male;  
            for (Iterator iterator2 = randomMaleMap.keySet().iterator(); iterator2.hasNext(); male.buildBackupPriorityQueue())  
            {  
                Integer maleId = (Integer)iterator2.next();  
                male = (Person)randomMaleMap.get(maleId);  
            }  
  
  
            votes = new HashMap();  
            for (Iterator iterator6 = randomMaleMap.keySet().iterator(); iterator6.hasNext();)  
            {  
                Integer maleId = (Integer)iterator6.next();  
                Person male1 = (Person)randomMaleMap.get(maleId);  
                int femaleGodId = male1.peekGod();  
                if (votes.containsKey(Integer.valueOf(femaleGodId)))  
                {  
                    Vote vote = (Vote)votes.get(Integer.valueOf(femaleGodId));  
                    vote.addVoter(male1);  
                } else  
                {  
                    Vote vote = new Vote();  
                    vote.setId(femaleGodId);  
                    vote.addVoter(male1);  
                    votes.put(Integer.valueOf(femaleGodId), vote);  
                }  
            }  
  
  
            do  
            {  
                int maxVote = 0x80000000;  
                int femaleGodId = 0x80000000;  
                for (Iterator iterator8 = votes.keySet().iterator(); iterator8.hasNext();)  
                {  
                    Integer key = (Integer)iterator8.next();  
                    int voteNum = ((Vote)votes.get(key)).getVoters().size();  
                    if (voteNum > maxVote)  
                    {  
                        maxVote = voteNum;  
                        femaleGodId = key.intValue();  
                    } else  
                    if (voteNum == maxVote)  
                    {  
                        int competitorQuality = ((Person)randomFemaleMap.get(key)).getTotalQuality();  
                        int femaleGodQuality = ((Person)randomFemaleMap.get(Integer.valueOf(femaleGodId))).getTotalQuality();  
                        if (competitorQuality > femaleGodQuality)  
                        {  
                            maxVote = voteNum;  
                            femaleGodId = key.intValue();  
                        } else  
                        if (competitorQuality == femaleGodQuality && key.intValue() < femaleGodId)  
                        {  
                            maxVote = voteNum;  
                            femaleGodId = key.intValue();  
                        }  
                    }  
                }  
  
  
                femaleGodSet.add(Integer.valueOf(femaleGodId));  
                Person femaleGod = (Person)randomFemaleMap.get(Integer.valueOf(femaleGodId));  
                int maleGodId;  
                for (maleGodId = femaleGod.pollGod(); maleGodSet.contains(Integer.valueOf(maleGodId)) || ((Person)randomMaleMap.get(Integer.valueOf(maleGodId))).peekGod() != femaleGodId; maleGodId = femaleGod.pollGod());  
                maleGodSet.add(Integer.valueOf(maleGodId));  
                if (maleGodId == -1)  
                {  
                    sb.append((new StringBuilder()).append(randomMaleMap.get(Integer.valueOf(maleGodId))).append(" <--> ").append(randomFemaleMap.get(Integer.valueOf(femaleGodId))).append("\n").toString());  
                    return sb.toString();  
                }  
                ArrayList voters = ((Vote)votes.get(Integer.valueOf(femaleGodId))).getVoters();  
                for (Iterator iterator10 = voters.iterator(); iterator10.hasNext();)  
                {  
                    Person voter = (Person)iterator10.next();  
                    if (voter.getId() != maleGodId)  
                    {  
                        voter.pollGod();  
                        int nextGodId;  
                        for (nextGodId = voter.peekGod(); femaleGodSet.contains(Integer.valueOf(nextGodId)); nextGodId = voter.peekGod())  
                            voter.pollGod();  
  
  
                        if (votes.containsKey(Integer.valueOf(nextGodId)))  
                        {  
                            Vote vote = (Vote)votes.get(Integer.valueOf(nextGodId));  
                            vote.addVoter(voter);  
                        } else  
                        {  
                            Vote vote = new Vote();  
                            vote.setId(nextGodId);  
                            vote.addVoter(voter);  
                            votes.put(Integer.valueOf(nextGodId), vote);  
                        }  
                    }  
                }  
  
  
                votes.remove(Integer.valueOf(femaleGodId));  
            } while (true);  
        }  
        randomFemaleMap.put(Integer.valueOf(player.getId()), player);  
        maleGodSet = new HashSet();  
        femaleGodSet = new HashSet();  
        Person male;  
        for (Iterator iterator3 = randomMaleMap.keySet().iterator(); iterator3.hasNext(); male.changePlayer(player))  
        {  
            Integer maleId = (Integer)iterator3.next();  
            male = (Person)randomMaleMap.get(maleId);  
            player.judgePerson(male);  
        }  
  
  
        Person female;  
        for (Iterator iterator4 = randomFemaleMap.keySet().iterator(); iterator4.hasNext(); female.buildBackupPriorityQueue())  
        {  
            Integer femaleId = (Integer)iterator4.next();  
            female = (Person)randomFemaleMap.get(femaleId);  
        }  
  
  
        HashMap femaleId = new HashMap();  
        for (Iterator iterator7 = randomMaleMap.keySet().iterator(); iterator7.hasNext();)  
        {  
            Integer maleId = (Integer)iterator7.next();  
            Person male1 = (Person)randomMaleMap.get(maleId);  
            int femaleGodId = male1.peekGod();  
            if (femaleId.containsKey(Integer.valueOf(femaleGodId)))  
            {  
                Vote vote = (Vote)femaleId.get(Integer.valueOf(femaleGodId));  
                vote.addVoter(male1);  
            } else  
            {  
                Vote vote = new Vote();  
                vote.setId(femaleGodId);  
                vote.addVoter(male1);  
                femaleId.put(Integer.valueOf(femaleGodId), vote);  
            }  
        }  
  
  
        do  
        {  
            int maxVote = 0x80000000;  
            int femaleGodId = 0x80000000;  
            for (Iterator iterator9 = femaleId.keySet().iterator(); iterator9.hasNext();)  
            {  
                Integer key = (Integer)iterator9.next();  
                int voteNum = ((Vote)femaleId.get(key)).getVoters().size();  
                if (voteNum > maxVote)  
                {  
                    maxVote = voteNum;  
                    femaleGodId = key.intValue();  
                } else  
                if (voteNum == maxVote)  
                {  
                    int competiorQuality = ((Person)randomFemaleMap.get(key)).getTotalQuality();  
                    int femaleGodQuality = ((Person)randomFemaleMap.get(Integer.valueOf(femaleGodId))).getTotalQuality();  
                    if (competiorQuality > femaleGodQuality)  
                    {  
                        maxVote = voteNum;  
                        femaleGodId = key.intValue();  
                    } else  
                    if (competiorQuality == femaleGodQuality && key.intValue() < femaleGodId)  
                    {  
                        maxVote = voteNum;  
                        femaleGodId = key.intValue();  
                    }  
                }  
            }  
  
  
            femaleGodSet.add(Integer.valueOf(femaleGodId));  
            Person god = (Person)randomFemaleMap.get(Integer.valueOf(femaleGodId));  
            int maleGodId;  
            for (maleGodId = god.pollGod(); maleGodSet.contains(Integer.valueOf(maleGodId)) || ((Person)randomMaleMap.get(Integer.valueOf(maleGodId))).peekGod() != femaleGodId; maleGodId = god.pollGod());  
            maleGodSet.add(Integer.valueOf(maleGodId));  
            if (femaleGodId == -1)  
            {  
                sb.append((new StringBuilder()).append(randomMaleMap.get(Integer.valueOf(maleGodId))).append(" <--> ").append(randomFemaleMap.get(Integer.valueOf(femaleGodId))).append("\n").toString());  
                return sb.toString();  
            }  
            ArrayList voters = ((Vote)femaleId.get(Integer.valueOf(femaleGodId))).getVoters();  
            for (Iterator iterator11 = voters.iterator(); iterator11.hasNext();)  
            {  
                Person voter = (Person)iterator11.next();  
                if (voter.getId() != maleGodId)  
                {  
                    voter.pollGod();  
                    int nextGodId;  
                    for (nextGodId = voter.peekGod(); femaleGodSet.contains(Integer.valueOf(nextGodId)); nextGodId = voter.peekGod())  
                        voter.pollGod();  
  
  
                    if (femaleId.containsKey(Integer.valueOf(nextGodId)))  
                    {  
                        Vote vote = (Vote)femaleId.get(Integer.valueOf(nextGodId));  
                        vote.addVoter(voter);  
                    } else  
                    {  
                        Vote vote = new Vote();  
                        vote.setId(nextGodId);  
                        vote.addVoter(voter);  
                        femaleId.put(Integer.valueOf(nextGodId), vote);  
                    }  
                }  
            }  
  
  
            femaleId.remove(Integer.valueOf(femaleGodId));  
        } while (true);  
    }  
  
  
    public String play()  
    {  
        StringBuilder sb = new StringBuilder();  
        for (Iterator iterator = maleMap.keySet().iterator(); iterator.hasNext();)  
        {  
            Integer maleId = (Integer)iterator.next();  
            Person male = (Person)maleMap.get(maleId);  
            Person female;  
            for (Iterator iterator2 = femaleMap.keySet().iterator(); iterator2.hasNext(); female.judgePerson(male))  
            {  
                Integer femaleId = (Integer)iterator2.next();  
                female = (Person)femaleMap.get(femaleId);  
                male.judgePerson(female);  
            }  
  
  
        }  
  
  
        int num = 1;  
        for (Iterator iterator1 = playerList.iterator(); iterator1.hasNext();)  
        {  
            Person player = (Person)iterator1.next();  
            if (player.getGender() == 1)  
            {  
                maleMap.put(Integer.valueOf(player.getId()), player);  
                HashSet maleGodSet = new HashSet();  
                HashSet femaleGodSet = new HashSet();  
                Person female;  
                for (Iterator iterator3 = femaleMap.keySet().iterator(); iterator3.hasNext(); female.changePlayer(player))  
                {  
                    Integer femaleId = (Integer)iterator3.next();  
                    female = (Person)femaleMap.get(femaleId);  
                    player.judgePerson(female);  
                }  
  
  
                Person male;  
                for (Iterator iterator4 = maleMap.keySet().iterator(); iterator4.hasNext(); male.buildBackupPriorityQueue())  
                {  
                    Integer maleId = (Integer)iterator4.next();  
                    male = (Person)maleMap.get(maleId);  
                }  
  
  
                HashMap votes = new HashMap();  
                for (Iterator iterator7 = maleMap.keySet().iterator(); iterator7.hasNext();)  
                {  
                    Integer maleId = (Integer)iterator7.next();  
                    Person male1 = (Person)maleMap.get(maleId);  
                    int femaleGodId = male1.peekGod();  
                    if (votes.containsKey(Integer.valueOf(femaleGodId)))  
                    {  
                        Vote vote = (Vote)votes.get(Integer.valueOf(femaleGodId));  
                        vote.addVoter(male1);  
                    } else  
                    {  
                        Vote vote = new Vote();  
                        vote.setId(femaleGodId);  
                        vote.addVoter(male1);  
                        votes.put(Integer.valueOf(femaleGodId), vote);  
                    }  
                }  
  
  
                do  
                {  
                    int maxVote = 0x80000000;  
                    int femaleGodId = 0x80000000;  
                    for (Iterator iterator9 = votes.keySet().iterator(); iterator9.hasNext();)  
                    {  
                        Integer key = (Integer)iterator9.next();  
                        int voteNum = ((Vote)votes.get(key)).getVoters().size();  
                        if (voteNum > maxVote)  
                        {  
                            maxVote = voteNum;  
                            femaleGodId = key.intValue();  
                        } else  
                        if (voteNum == maxVote)  
                        {  
                            int competitorQuality = ((Person)femaleMap.get(key)).getTotalQuality();  
                            int femaleGodQuality = ((Person)femaleMap.get(Integer.valueOf(femaleGodId))).getTotalQuality();  
                            if (competitorQuality > femaleGodQuality)  
                            {  
                                maxVote = voteNum;  
                                femaleGodId = key.intValue();  
                            } else  
                            if (competitorQuality == femaleGodQuality && key.intValue() < femaleGodId)  
                            {  
                                maxVote = voteNum;  
                                femaleGodId = key.intValue();  
                            }  
                        }  
                    }  
  
  
                    femaleGodSet.add(Integer.valueOf(femaleGodId));  
                    Person femaleGod = (Person)femaleMap.get(Integer.valueOf(femaleGodId));  
                    int maleGodId;  
                    for (maleGodId = femaleGod.pollGod(); maleGodSet.contains(Integer.valueOf(maleGodId)) || ((Person)maleMap.get(Integer.valueOf(maleGodId))).peekGod() != femaleGodId; maleGodId = femaleGod.pollGod());  
                    maleGodSet.add(Integer.valueOf(maleGodId));  
                    if (maleGodId == -1)  
                    {  
                        sb.append((new StringBuilder("[")).append(num++).append("] ").append(maleMap.get(Integer.valueOf(maleGodId))).append(" <--> ").append(femaleMap.get(Integer.valueOf(femaleGodId))).append("\n").toString());  
                        break;  
                    }  
                    if (maleGodSet.size() >= 100)  
                    {  
                        sb.append((new StringBuilder("[")).append(num++).append("] ").append("配对失败").append("\n").toString());  
                        break;  
                    }  
                    ArrayList voters = ((Vote)votes.get(Integer.valueOf(femaleGodId))).getVoters();  
                    for (Iterator iterator11 = voters.iterator(); iterator11.hasNext();)  
                    {  
                        Person voter = (Person)iterator11.next();  
                        if (voter.getId() != maleGodId)  
                        {  
                            voter.pollGod();  
                            int nextGodId;  
                            for (nextGodId = voter.peekGod(); femaleGodSet.contains(Integer.valueOf(nextGodId)); nextGodId = voter.peekGod())  
                                voter.pollGod();  
  
  
                            if (votes.containsKey(Integer.valueOf(nextGodId)))  
                            {  
                                Vote vote = (Vote)votes.get(Integer.valueOf(nextGodId));  
                                vote.addVoter(voter);  
                            } else  
                            {  
                                Vote vote = new Vote();  
                                vote.setId(nextGodId);  
                                vote.addVoter(voter);  
                                votes.put(Integer.valueOf(nextGodId), vote);  
                            }  
                        }  
                    }  
  
  
                    votes.remove(Integer.valueOf(femaleGodId));  
                } while (true);  
                maleMap.remove(Integer.valueOf(player.getId()));  
            } else  
            {  
                femaleMap.put(Integer.valueOf(player.getId()), player);  
                HashSet maleGodSet = new HashSet();  
                HashSet femaleGodSet = new HashSet();  
                Person male;  
                for (Iterator iterator5 = maleMap.keySet().iterator(); iterator5.hasNext(); male.changePlayer(player))  
                {  
                    Integer maleId = (Integer)iterator5.next();  
                    male = (Person)maleMap.get(maleId);  
                    player.judgePerson(male);  
                }  
  
  
                Person female;  
                for (Iterator iterator6 = femaleMap.keySet().iterator(); iterator6.hasNext(); female.buildBackupPriorityQueue())  
                {  
                    Integer femaleId = (Integer)iterator6.next();  
                    female = (Person)femaleMap.get(femaleId);  
                }  
  
  
                HashMap votes = new HashMap();  
                for (Iterator iterator8 = maleMap.keySet().iterator(); iterator8.hasNext();)  
                {  
                    Integer maleId = (Integer)iterator8.next();  
                    Person male1 = (Person)maleMap.get(maleId);  
                    int femaleGodId = male1.peekGod();  
                    if (votes.containsKey(Integer.valueOf(femaleGodId)))  
                    {  
                        Vote vote = (Vote)votes.get(Integer.valueOf(femaleGodId));  
                        vote.addVoter(male1);  
                    } else  
                    {  
                        Vote vote = new Vote();  
                        vote.setId(femaleGodId);  
                        vote.addVoter(male1);  
                        votes.put(Integer.valueOf(femaleGodId), vote);  
                    }  
                }  
  
  
                do  
                {  
                    int maxVote = 0x80000000;  
                    int femaleGodId = 0x80000000;  
                    for (Iterator iterator10 = votes.keySet().iterator(); iterator10.hasNext();)  
                    {  
                        Integer key = (Integer)iterator10.next();  
                        int voteNum = ((Vote)votes.get(key)).getVoters().size();  
                        if (voteNum > maxVote)  
                        {  
                            maxVote = voteNum;  
                            femaleGodId = key.intValue();  
                        } else  
                        if (voteNum == maxVote)  
                        {  
                            int competiorQuality = ((Person)femaleMap.get(key)).getTotalQuality();  
                            int femaleGodQuality = ((Person)femaleMap.get(Integer.valueOf(femaleGodId))).getTotalQuality();  
                            if (competiorQuality > femaleGodQuality)  
                            {  
                                maxVote = voteNum;  
                                femaleGodId = key.intValue();  
                            } else  
                            if (competiorQuality == femaleGodQuality && key.intValue() < femaleGodId)  
                            {  
                                maxVote = voteNum;  
                                femaleGodId = key.intValue();  
                            }  
                        }  
                    }  
  
  
                    femaleGodSet.add(Integer.valueOf(femaleGodId));  
                    Person god = (Person)femaleMap.get(Integer.valueOf(femaleGodId));  
                    int maleGodId;  
                    for (maleGodId = god.pollGod(); maleGodSet.contains(Integer.valueOf(maleGodId)) || ((Person)maleMap.get(Integer.valueOf(maleGodId))).peekGod() != femaleGodId; maleGodId = god.pollGod());  
                    maleGodSet.add(Integer.valueOf(maleGodId));  
                    if (femaleGodId == -1)  
                    {  
                        sb.append((new StringBuilder("[")).append(num++).append("] ").append(maleMap.get(Integer.valueOf(maleGodId))).append(" <--> ").append(femaleMap.get(Integer.valueOf(femaleGodId))).append("\n").toString());  
                        break;  
                    }  
                    if (maleGodSet.size() >= 100)  
                    {  
                        sb.append((new StringBuilder("[")).append(num++).append("] ").append("配对失败").append("\n").toString());  
                        break;  
                    }  
                    ArrayList voters = ((Vote)votes.get(Integer.valueOf(femaleGodId))).getVoters();  
                    for (Iterator iterator12 = voters.iterator(); iterator12.hasNext();)  
                    {  
                        Person voter = (Person)iterator12.next();  
                        if (voter.getId() != maleGodId)  
                        {  
                            voter.pollGod();  
                            int nextGodId;  
                            for (nextGodId = voter.peekGod(); femaleGodSet.contains(Integer.valueOf(nextGodId)); nextGodId = voter.peekGod())  
                                voter.pollGod();  
  
  
                            if (votes.containsKey(Integer.valueOf(nextGodId)))  
                            {  
                                Vote vote = (Vote)votes.get(Integer.valueOf(nextGodId));  
                                vote.addVoter(voter);  
                            } else  
                            {  
                                Vote vote = new Vote();  
                                vote.setId(nextGodId);  
                                vote.addVoter(voter);  
                                votes.put(Integer.valueOf(nextGodId), vote);  
                            }  
                        }  
                    }  
  
  
                    votes.remove(Integer.valueOf(femaleGodId));  
                } while (true);  
                femaleMap.remove(Integer.valueOf(player.getId()));  
            }  
        }  
  
  
        return sb.toString();  
    }  
}  

