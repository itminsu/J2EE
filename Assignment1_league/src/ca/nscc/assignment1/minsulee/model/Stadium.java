package ca.nscc.assignment1.minsulee.model;

/**
 *
 * @author Minsu
 * This class represents Stadium
 */
public class Stadium
{
    /**name of Stadium.*/
    private String name;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Stadium [name=" + name + "]";
    }

}
