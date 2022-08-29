import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    private static SessionFactory factory;

    private Hibernate(){}

    public static SessionFactory getFactory(){
        if(factory == null){
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            factory = config.buildSessionFactory();
        }
        return factory;
    }
}