/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.test;
import java.util.*;

public class MentorAG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAG Attributes
  private String name;

  //MentorAG Associations
  private List<MentorAG> friend;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAG(String aName)
  {
    name = aName;
    friend = new ArrayList<MentorAG>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public MentorAG getFriend(int index)
  {
    MentorAG aFriend = friend.get(index);
    return aFriend;
  }

  public List<MentorAG> getFriend()
  {
    List<MentorAG> newFriend = Collections.unmodifiableList(friend);
    return newFriend;
  }

  public int numberOfFriend()
  {
    int number = friend.size();
    return number;
  }

  public boolean hasFriend()
  {
    boolean has = friend.size() > 0;
    return has;
  }

  public int indexOfFriend(MentorAG aFriend)
  {
    int index = friend.indexOf(aFriend);
    return index;
  }

  public static int minimumNumberOfFriend()
  {
    return 0;
  }

  public boolean addFriend(MentorAG aFriend)
  {
    boolean wasAdded = false;
    if (friend.contains(aFriend)) { return false; }
    friend.add(aFriend);
    if (aFriend.indexOfFriend(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFriend.addFriend(this);
      if (!wasAdded)
      {
        friend.remove(aFriend);
      }
    }
    return wasAdded;
  }

  public boolean removeFriend(MentorAG aFriend)
  {
    boolean wasRemoved = false;
    if (!friend.contains(aFriend))
    {
      return wasRemoved;
    }

    int oldIndex = friend.indexOf(aFriend);
    friend.remove(oldIndex);
    if (aFriend.indexOfFriend(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFriend.removeFriend(this);
      if (!wasRemoved)
      {
        friend.add(oldIndex,aFriend);
      }
    }
    return wasRemoved;
  }

  public void delete()
  {
    ArrayList<MentorAG> copyOfFriend = new ArrayList<MentorAG>(friend);
    friend.clear();
    for(MentorAG aFriend : copyOfFriend)
    {
      aFriend.removeFriend(this);
    }
  }

}