import java.util.HashSet;

public class PowerSet
{
    private HashSet<String> elements;

    public PowerSet() {
        elements = new HashSet<>();
    }

    
    public int size()
    {
        return elements.size();
    }


    public void put(String value)
    {
        elements.add(value);
    }


    public boolean get(String value)
    {
        return elements.contains(value);
    }


    public boolean remove(String value)
    {
      return elements.remove(value);    
    }


    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        if (this.size() == 0 && set2.size() == 0 || this.size() != 0 && set2.size() == 0 || this.size() == 0 && set2.size() != 0) {
            return result;
        }

        for (String element : elements) {
            if (set2.get(element)) {
                result.put(element);
            }
        }

        if(result.size() != 0) {
            return result;
        }
        return null;
    }


    public PowerSet union(PowerSet set2)
    {
        if (set2 == null) {
            return null;
        }
        
        if (this.size() != 0 && set2.size() == 0) {
            return this;
        }

        if (this.size() == 0 && set2.size() != 0) {
            return set2;
        }

        if(this.size() == 0 && set2.size() == 0) {
            return this;
        }

        PowerSet result = new PowerSet();
        
        for (String element : elements) {
            result.put(element);
        }
        
        for (String element : set2.elements) {
            result.put(element);
        }
        
        if(result.size() != 0) {
            return result;
        }
        
        return null;
    }


    public PowerSet difference(PowerSet set2)
    {
        if (set2 == null || this.size() == 0 && set2.size() != 0) {
            return null;
        }
        
        if (this.size() == 0 && set2.size() == 0 || this.size() != 0 && set2.size() == 0) {
            return this;
        }
        
        PowerSet result = new PowerSet();

        for (String element : elements) {
            if (!set2.get(element)) {
                result.put(element);
            }
        }

        if(result.size() != 0) {
            return result;
        }

        return null;
    }

    public boolean isSubset(PowerSet set2)
    {
        if (set2 == null || this.size() == 0 && set2.size() != 0 || this.size() < set2.size()) {
            return false;
        }
        
        if (this.size() == 0 && set2.size() == 0 || this.size() != 0 && set2.size() == 0) {
            return true;
        }

        boolean flag = true;

        for (String element : set2.elements) {
            if (!this.get(element)) {
                flag = false;
                break;
            }
        }
            
        if(flag) {
            return true;
        }
        return false;
    }


    public boolean equals(PowerSet set2)
    {
        if (this.size() == set2.size() && this.isSubset(set2)) {
            return true;
        }
        return false;
    }
}




