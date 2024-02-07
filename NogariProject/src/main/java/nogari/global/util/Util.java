package nogari.global.util;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Util {
    private static String reg = "\\b(public\\s[^\\s]+)\\s([^\\(]+)\\(([^\\)]*)\\):";
    private static Pattern pattern = Pattern.compile(reg);

    public static String extractInfoFromException(@NotNull String message, @NotNull MatcherResult matcherResult) {

        Matcher matcher = pattern.matcher(message);


        if (matcher.find()) {

            String returnType = matcher.group(1).trim();
            String methodSignature = matcher.group(2).trim();
            String parameters = matcher.group(3).trim();

            // 메소드명과 클래스명 분리
            int lastDotIndex = methodSignature.lastIndexOf(".");
            String className = methodSignature.substring(0, lastDotIndex);
            String methodName = methodSignature.substring(lastDotIndex + 1);

            switch (matcherResult) {
                case CLASS_NAME:
                    return className;
                case METHOD_NAME:
                    return methodName;
                case PARAMETERS:
                    return parameters;
                case RETURN_TYPE:
                    return returnType;
            }
        }
        return "";
    }

    public static enum MatcherResult {
        CLASS_NAME, METHOD_NAME, PARAMETERS, RETURN_TYPE
    }
}
