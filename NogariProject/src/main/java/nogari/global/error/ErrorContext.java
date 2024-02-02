package nogari.global.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorContext {
    private static final ThreadLocal<List<String>> threadContext = ThreadLocal.withInitial(ArrayList::new);

    public static String getErrorContext() {
        return String.join("\n", threadContext.get());
    }

    public static void setErrorContext(String componentName) {
        List<String> errorContext = threadContext.get();
        errorContext.add(componentName);
    }

    public static void clear() {
        threadContext.remove();
    }
}
