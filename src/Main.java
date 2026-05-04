import dao.KebabDAO;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.Kebab;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("kebabs.odb");
        KebabDAO dao = new KebabDAO(emf);
        System.out.println(dao.obtenerKebab(2));
        System.out.println(dao.obtenerKebab(3));
        System.out.println(dao.obtenerMedia());
        System.out.println(dao.obtenerTotalKebabs());
        System.out.println(dao.obtenerGruposPan());
        emf.close();
    }
}