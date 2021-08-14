package cl.awakelab.reskilling.model.dao;

import cl.awakelab.reskilling.model.Conexion;
import cl.awakelab.reskilling.model.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements IEmpleadoDAO {
    @Override
    public void create(Empleado e) {
        String sql = "insert into empleado (employee_id, first_name, last_name, email, phone, hire_date, manager_id, job_title " +
                " values (" + e.getId() + ", '" + e.getNombre() + "', '" + e.getApellido() + "', '" + e.getEmail() + "', '" +
                e.getTel() + "', " + e.getFechaContratacion() + ", " + e.getJefe() + ", '" + e.getCargo() + "'";

        try {
            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            cn.setAutoCommit(true);
            s.execute(sql);
            s.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL INSERTAR UN NUEVO EMPLEADO");
            ex.printStackTrace();
        }

    }

    @Override
    public List<Empleado> readAll() {
        List<Empleado> lista = new ArrayList<Empleado>();

        try {

            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            String sql = "select employee_id, first_name, last_name, email, phone, hire_date, manager_id, job_title from employees";

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()){
                lista.add(new Empleado(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"), rs.getDate("hire_date").toString(), rs.getInt("manager_id"),
                        rs.getString("job_title")));

            }

        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR TODOS LOS EMPLEADOS");
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Empleado readOne(int id) {
        Empleado e = null;

        String sql = "select employee_id, first_name, last_name, email, phone, hire_date, manager_id, job_title from employees " +
                "where employee_id = " + id;

        try {
            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                e = new Empleado(rs.getInt("employee_id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"), rs.getDate("hire_date").toString(), rs.getInt("manager_id"),
                        rs.getString("job_title"));
            }


        } catch (SQLException ex) {
            System.out.println("ERROR AL LEER UN EMPLEADO");
            ex.printStackTrace();
        }
        return e;
    }

    @Override
    public void update(Empleado e) {

        String[] datos = e.getFechaContratacion().split("-");
        String fecha = datos[2] + "-" + datos[1] + "-" + datos[0];

        String sql = "update employees set first_name = '" + e.getNombre() + "', last_name='" + e.getApellido() + "', email = '" +
                e.getEmail() + "', phone = '" + e.getTel() + "', hire_date = '" + fecha + "', manager_id = " +
                e.getJefe() + ", job_title = '" + e.getCargo() + "' " +
                "where employee_id = " + e.getId();

        System.out.println(sql);
        try {
            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            cn.setAutoCommit(true);
            s.executeQuery(sql);
            s.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR UN EMPLEADO");
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Empleado e) {
        delete(e.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from employees where employee_id = " + id;
        try {
            Connection cn = Conexion.getInstance();
            Statement s = cn.createStatement();
            cn.setAutoCommit(true);
            s.execute(sql);
            s.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL BORRAR UN EMPLEADO");
            ex.printStackTrace();
        }
    }
}
