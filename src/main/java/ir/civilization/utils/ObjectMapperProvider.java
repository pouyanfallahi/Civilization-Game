//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ir.civilization.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {
    private static ObjectMapper objectMapper = null;
    private static ObjectMapper forgivingObjectMapper = null;

    public ObjectMapperProvider() {
    }

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }

    public static ObjectMapper getForgivingObjectMapper() {
        if (forgivingObjectMapper == null) {
            forgivingObjectMapper = new ObjectMapper();
            forgivingObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        return forgivingObjectMapper;
    }

    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
