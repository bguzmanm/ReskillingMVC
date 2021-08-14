package cl.awakelab.reskilling.controller;

import cl.awakelab.reskilling.model.Empleado;
import cl.awakelab.reskilling.model.dao.EmpleadoDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmpleadoController", value = "/EmpleadoController")
public class EmpleadoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmpleadoDAOImpl eDAO = new EmpleadoDAOImpl();
        Empleado e = null;
        String id = "";
        String accion = request.getParameter("accion");
        if (accion == null){
            accion = "verTodos";
        }

        switch (accion){
            case "verUno":
                id = request.getParameter("id");
                e = eDAO.readOne(Integer.parseInt(id));
                request.setAttribute("e", e);
                getServletContext().getRequestDispatcher("/view/empleado.jsp").forward(request, response);
            case "editar":
                id = request.getParameter("id");
                e = eDAO.readOne(Integer.parseInt(id));
                request.setAttribute("e", e);
                getServletContext().getRequestDispatcher("/view/editarEmpleado.jsp").forward(request, response);
            default:
                List<Empleado> empleados = eDAO.readAll();
                request.setAttribute("empleados", empleados);
                getServletContext().getRequestDispatcher("/view/empleados.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null){
            accion = "verTodos";
        }

        EmpleadoDAOImpl eDAO = new EmpleadoDAOImpl();

        switch (accion){
            case "editar":
                Empleado e = new Empleado();
                e.setId(Integer.parseInt(request.getParameter("id")));
                e.setNombre(request.getParameter("nombre"));
                e.setApellido(request.getParameter("apellido"));
                e.setEmail(request.getParameter("email"));
                e.setTel(request.getParameter("tel"));
                e.setFechaContratacion(request.getParameter("fechaContratacion"));

                e.setJefe(Integer.parseInt(request.getParameter("jefe")));
                e.setCargo(request.getParameter("cargo"));
                eDAO.update(e);
                request.removeAttribute("accion");


                request.setAttribute("accion" , "verTodos");
                List<Empleado> empleados = eDAO.readAll();
                request.setAttribute("empleados", empleados);
                getServletContext().getRequestDispatcher("/view/empleados.jsp").forward(request, response);


                break;
            case "borrar":
                break;
            default:
                doGet(request, response);
                break;

        }
    }


}
