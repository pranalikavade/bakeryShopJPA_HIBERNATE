package config;
import jakarta.persistence.*;

public class JPAUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bakeryshop-jpa");
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static void shutdown() {
        if (emf.isOpen()) emf.close();
    }
}
