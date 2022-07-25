package ir.civilization.initializer;

import ir.civilization.dao.user.UserDao;

import java.util.Collection;
import java.util.HashSet;

public class ClassInitializer {

    public static final ClassInitializer INSTANCE = new ClassInitializer();

    private final Collection<Initializable> INITIALIZABLES = new HashSet<>();

    private ClassInitializer() {
        INITIALIZABLES.add(UserDao.INSTANCE);
    }

    public void initializeAllClasses() {
        INITIALIZABLES.forEach(Initializable::initialize);
    }

}
