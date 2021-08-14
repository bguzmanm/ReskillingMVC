package cl.awakelab.reskilling.model.dao;

import cl.awakelab.reskilling.model.Empleado;

import java.util.List;

public interface IEmpleadoDAO {
    public void create(Empleado e);
    public List<Empleado> readAll();
    public Empleado readOne(int id);
    public void update(Empleado e);
    public void delete(Empleado e);
    public void delete(int id);
}
