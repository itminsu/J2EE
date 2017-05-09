package ca.nscc.assignment1.minsulee.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.nscc.assignment1.minsulee.model.Match;
import ca.nscc.assignment1.minsulee.utility.FileHandler;

/**.
 * Servlet implementation class Position
 */
@WebServlet("/position")
public class Position extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Position()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     * @param config to
     * @throws ServletException to
     */
    public void init(final ServletConfig config) throws ServletException
    {
        // TODO Auto-generated method stub
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy()
    {
        // TODO Auto-generated method stub
    }
    /** list of Matches.*/
    private List<Match> matches;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * @param request to
     * @param response to
     * @throws ServletException to
     * @throws IOException to
     */
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        //get url to the file
        URL url = request.getServletContext().getResource(FileHandler.DATA_FILE);
        //get path to the file
        String path = url.getPath();

        String value = request.getParameter("team");
        if (value != null)
        {
            response.getWriter().write(searchTeams(value.toLowerCase()));
        }
        else
        {
            response.getWriter().write("message");
            printList(response);
        }

        buildMatches(path);

        printList(response);
    }
    /**
     * @param value to look for.
     * @return string representation of Team.
     */
    private String searchTeams(final String value)
    {
        String result = "The team doesn't exist";
        for (Match match : matches)
        {
            if (match.getHomeTeam().equals(value))
            {
                result = match.getHomeTeam().getName() + ":" + match.getHomeTeam().getRank();
                break;
            }
        }
        return result;
    }

    /**
    *
    * @param response to the request
    * @throws IOException when IO error occurs
    */
   private void printList(final HttpServletResponse response) throws IOException
   {
       PrintWriter writer = response.getWriter();
       for (Match match : matches)
       {
           writer.write(match.toString());
       }
   }

   /**
    *
    * @param path to
    * @return String path
    */
   private List<Match> buildMatches(final String path)
   {
        try
        {
            matches = FileHandler.loadFileData(path);
            for (Match match : matches)
            {
                if (match.getHomeTeam().getScore() > match.getAwayTeam().getScore())
                {
                    match.getHomeTeam().setPoint(match.getHomeTeam().getPoint() + 3);
                }
                else if (match.getHomeTeam().getScore() < match.getAwayTeam().getScore())
                {
                    match.getAwayTeam().setPoint(match.getAwayTeam().getPoint() + 3);
                }
                else
                {
                    match.getHomeTeam().setPoint(match.getHomeTeam().getPoint() + 1);
                    match.getAwayTeam().setPoint(match.getAwayTeam().getPoint() + 1);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return matches;
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * @param request to
     * @param response to
     * @throws ServletException to
     * @throws IOException to
     */
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
