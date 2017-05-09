package ca.nscc.assignment1.minsulee.model;

/**
 *
 * @author Minsu
 * This class represents Team
 */
public class Team
{
    /**name of Team.*/
    private String name;

    /**score of Team.*/
    private int score;

    /**point(Winning point) of Team.*/
    private int point;

    /**rank of Team.*/
    private int rank;

    /**
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @param name to
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     *
     * @return score
     */
    public int getScore()
    {
        return score;
    }

    /**
     *
     * @param score to
     */
    public void setScore(final int score)
    {
        this.score = score;
    }

    /**
     *
     * @return point
     */
    public int getPoint()
    {
        return point;
    }

    /**
     *
     * @param point to
     */
    public void setPoint(final int point)
    {
        this.point = point;
    }

    /**
     *
     * @return rank
     */
    public int getRank()
    {
        return rank;
    }

    /**
     *
     * @param rank to
     */
    public void setRank(final int rank)
    {
        this.rank = rank;
    }

    @Override
    public String toString()
    {
        return "Team [name=" + name + ", score=" + score + ", point=" + point + ", rank=" + rank + "]";
    }



}
