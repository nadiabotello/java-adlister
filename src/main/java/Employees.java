import java.util.List;

//- save(Employee employee)
//- update(long id)
//- findOne(long id)
//- findAll()
//- delete(long id)

public interface Employees {

    List<Employee> findOne(long id);
    List<Employee> findAll();
    long update(long id);
    long save (Employee employee);
    long delete (long id);

}
