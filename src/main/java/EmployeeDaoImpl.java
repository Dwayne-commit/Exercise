import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory factory = Hibernate.getFactory();

    public EmployeeDaoImpl() {}

    @Override
    public void saveEmployee(Employee employee) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public Employee getEmployeeById(int id) {
        Transaction transaction = null;
        Employee employee= null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Transaction transaction = null;
        List<Employee> employees= null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            employees = session.createQuery("from Employee").list();
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try(Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Transaction transaction = null;
        try(Session session = factory.openSession()){
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}