/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static Utils.Utils.sdf;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Tasks;
import models.Users;
import repositories.TasksRepository;
import repositories.UsersRepository;

/**
 *
 * @author Dell
 */
@WebServlet(name = "TasksController", urlPatterns = {"/tasks"})
public class TasksController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String controller = (String) request.getAttribute("controller");
            String action = (String) request.getAttribute("action");
            TasksRepository tr = new TasksRepository();
            switch (action) {
                case "listOf":
                    listOf(request, response);
                    break;
                case "create":
                    create(request, response);
                    break;
                case "create_handler":
                    create_handler(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "update_handler":
                    update_handler(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
            }

        }
    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TasksRepository tr = new TasksRepository();
        try {
            List<Tasks> list = tr.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TasksRepository tr = new TasksRepository();
        UsersRepository ur = new UsersRepository();
        try {
            List<Users> list = ur.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TasksRepository tr = new TasksRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
                    String name = request.getParameter("name");
                    Date start_date = sdf.parse(request.getParameter("start_date"));
                    Date end_date = sdf.parse(request.getParameter("end_date"));
                    int user_id = Integer.parseInt(request.getParameter("user_id"));
                    int job_id = Integer.parseInt(request.getParameter("job_id"));
                    int status_id = Integer.parseInt(request.getParameter("status_id"));
                    Tasks tasks = new Tasks(name, start_date, end_date, user_id, job_id, status_id);
                    request.setAttribute("tasks", tasks);
                    tr.create(tasks);
                    response.sendRedirect(request.getContextPath() + "/tasks/listOf.do");
                } catch (Exception ex) {
                    //Hiện lại create form để nhập lại dữ liệu
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/tasks/listOf.do");
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TasksRepository tr = new TasksRepository();
        UsersRepository ur = new UsersRepository();
        try {
//             List<Users> list = ur.select();
//            request.setAttribute("list", list);
            int id = Integer.parseInt(request.getParameter("id"));
//            System.out.println("Hello");
            Tasks tasks = tr.read(id);
            request.setAttribute("tasks", tasks);
//            System.out.println("Hello E");
           
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TasksRepository tr = new TasksRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    System.out.println(id);
                    String name = request.getParameter("name");
                    Date start_date = sdf.parse(request.getParameter("start_date"));
                    Date end_date = sdf.parse(request.getParameter("end_date"));
                    int user_id = Integer.parseInt(request.getParameter("user_id"));
                    int job_id = Integer.parseInt(request.getParameter("job_id"));
                    int status_id = Integer.parseInt(request.getParameter("status_id"));
                    Tasks tasks = new Tasks(id, name, start_date, end_date, user_id, job_id, status_id);
                    tr.update(tasks);
                    request.setAttribute("tasks", tasks);
                    response.sendRedirect(request.getContextPath() + "/tasks/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/tasks/listOf.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TasksRepository tr = new TasksRepository();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            tr.delete(id);
            response.sendRedirect(request.getContextPath() + "/tasks/listOf.do");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
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
