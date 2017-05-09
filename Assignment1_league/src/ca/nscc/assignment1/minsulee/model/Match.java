package ca.nscc.assignment1.minsulee.model;

/**
 *
 * @author Minsu
 * This class represents Match
 */
public class Match
{
    /** list of Stadium.*/
    private Stadium stadiums;

    /** list of homeTeam.*/
    private Team homeTeam;
    /** list of awayTeam.*/
    private Team awayTeam;
    /** list of matchDate.*/
    private String matchDate;


    /**
     *
     * @return matchDate
     */
    public String getMatchDate()
    {
        return matchDate;
    }

    /**
     *
     * @param matchDate to
     */
    public void setMatchDate(final String matchDate)
    {
        this.matchDate = matchDate;
    }

    /**
     *
     * @return stadiums
     */
    public Stadium getStadiums()
    {
        return stadiums;
    }


    /**
     *
     * @param stadiums to
     */
    public void setStadiums(final Stadium stadiums)
    {
        this.stadiums = stadiums;
    }


    /**
     *
     * @return homeTeam
     */
    public Team getHomeTeam()
    {
        return homeTeam;
    }


    /**
     *
     * @param homeTeam to
     */
    public void setHomeTeam(final Team homeTeam)
    {
        this.homeTeam = homeTeam;
    }


    /**
     *
     * @return awayTeam
     */
    public Team getAwayTeam()
    {
        return awayTeam;
    }


    /**
     *
     * @param awayTeam to
     */
    public void setAwayTeam(final Team awayTeam)
    {
        this.awayTeam = awayTeam;
    }


    @Override
    public String toString()
    {
        return stadiums.getName() + "^" + homeTeam.getName() + "^" + awayTeam.getName() + "^"
            + homeTeam.getScore() + "-" + awayTeam.getScore() + "^" + this.getMatchDate();
    }

}
