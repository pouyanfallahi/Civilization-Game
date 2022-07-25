package ir.civilization.utils;

import ir.civilization.dto.DtoLoader;
import lombok.SneakyThrows;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class DtoUtils {

    public static <E, D extends DtoLoader<E>> D createAndLoad(E e, Class<D> clazz) {
        D d = newInstance(clazz);
        d.loadFrom(e);
        return d;
    }

    public static <E, D extends DtoLoader<E>> D createAndLoad(E e, Factory<D> dtoFactory) {
        if (e == null)
            return null;
        D dto = dtoFactory.create();
        dto.loadFrom(e);
        return dto;
    }

    public static <E, D extends DtoLoader<E>> Collection<D> createAndLoadList(Collection<E> entities, Class<D> clazz) {
        if (CollectionUtils.isEmpty(entities))
            return Collections.emptyList();

        return entities.stream()
                .map(entity -> createAndLoad(entity, clazz))
                .collect(Collectors.toList());
    }

    public static <E, D extends DtoLoader<E>> Collection<D> createAndLoadList(Collection<E> entities, Factory<D> dtoFactory) {
        if (CollectionUtils.isEmpty(entities))
            return Collections.emptyList();

        return entities.stream()
                .map(entity -> createAndLoad(entity, dtoFactory))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    private static <D extends DtoLoader<?>> D newInstance(Class<D> clazz) {
        return clazz.newInstance();
    }

}
