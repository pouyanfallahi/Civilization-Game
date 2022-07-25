package ir.civilization.dao;

import ir.civilization.initializer.Initializable;

import java.io.File;

/**
 * Abstract dao class
 *
 * @param <E> entity type
 */
public abstract class AbstractDao<E> implements Initializable {

    public static final String BASE_DIR_PATH = "/tmp";

    public abstract String getDirName();

    public abstract void save(E e);
    public abstract void update(E e);

    public String getDirPath() {
        return BASE_DIR_PATH + "/" + this.getDirName();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public File getUserFile(String id) {
        File baseDir = new File(this.getDirPath());
        if (!baseDir.exists())
            baseDir.mkdir();

        return new File(baseDir, id);
    }

}
