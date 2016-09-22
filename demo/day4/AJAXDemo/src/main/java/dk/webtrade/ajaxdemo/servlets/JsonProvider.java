package dk.webtrade.ajaxdemo.servlets;

/*

 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tha
 */
@WebServlet(urlPatterns = {"/JsonProvider"})
public class JsonProvider extends HttpServlet {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String insert = request.getParameter("insert");
        String name = request.getParameter("name");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<Person> persons = new ArrayList();
            persons.add(new Person("Peter", 12, "09808080"));
            persons.add(new Person("Rikke", 43, "49395454"));
            persons.add(new Person("Hanne", 38, "43045043"));
            persons.add(new Person("Frede", 22, "49349222"));
            persons.add(new Person("Mikkel", 94, "09008080"));
            persons.add(new Person("Bertha", 25, "32344555"));
            if(name == null)
                out.print(gson.toJson(persons));
            else
                out.print("The name is: "+name);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
