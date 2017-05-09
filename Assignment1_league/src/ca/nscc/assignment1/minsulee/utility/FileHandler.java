package ca.nscc.assignment1.minsulee.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.nscc.assignment1.minsulee.model.Match;
import ca.nscc.assignment1.minsulee.model.Stadium;
import ca.nscc.assignment1.minsulee.model.Team;

/**
 *
 * @author Minsu
 * Responsible for handling data file.
 *
 */
public final class FileHandler
{
    /** private constructor to prevent instantiation.*/
    private FileHandler()
    {
    }
    /** file delimiter.*/
    private static final String FILE_DELIMITER = "\\^";

    /** data file.*/
    public static final String DATA_FILE = "league.txt";

    /**
     *
     * @param fileName to load
     * @return map of lines read
     * @throws IOException when an error is thrown while reading the data file.
     */
    public static List<Match> loadFileData(final String fileName) throws IOException
    {
        String temp;
        List<Match> map = new ArrayList<Match>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName)))
        {
            Match match;
            Team homeTeam;
            Team awayTeam;
            while ((temp = bfr.readLine()) != null)
            {
                String[] data = temp.split(FILE_DELIMITER);

                match = new Match();

                match.setMatchDate(data[4] == null ? "" : data[4]);
                Stadium sd = new Stadium();
                sd.setName(data[0] == null ? "" : data[0]);

                match.setStadiums(sd);

                homeTeam = new Team();
                awayTeam = new Team();

                homeTeam.setName(data[1] == null ? "" : data[1]);
                awayTeam.setName(data[2] == null ? "" : data[2]);

                String[]ts = data[3].split("-");
                homeTeam.setScore(Integer.parseInt(ts[0] == null ? "0" : ts[0]));
                awayTeam.setScore(Integer.parseInt(ts[1] == null ? "0" : ts[1]));

                match.setHomeTeam(homeTeam);
                match.setAwayTeam(awayTeam);

                map.add(match);
            }
        }
        return map;
    }
}
