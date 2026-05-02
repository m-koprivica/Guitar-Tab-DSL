package visitors.handlers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Handlers {
    private static final Map<Class<? extends IHandler>, IHandler> INSTANCES =
            new ConcurrentHashMap<>();

    /** Return singleton instance of handler **/
    public static <T extends IHandler> T getHandler(Class<T> clazz) {
        return (T) INSTANCES.computeIfAbsent(clazz, Handlers::createInstance);
    }

    private static IHandler createInstance(Class<? extends IHandler> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create handler: " + clazz.getName(), e);
        }
    }
}