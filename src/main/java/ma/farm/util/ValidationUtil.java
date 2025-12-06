package ma.farm.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    // Email validation regex pattern
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates if a string is a valid email format
     * @param email The email string to validate
     * @return true if valid email format, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    /**
     * Checks if a string is null or empty (after trimming)
     * @param str The string to check
     * @return true if string is null or empty, false otherwise
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Validates password meets minimum requirements
     * @param password The password to validate
     * @return true if password is valid (at least 6 characters)
     */
    public static boolean isValidPassword(String password) {
        return !isEmpty(password) && password.length() >= 6;
    }

    /**
     * Sanitizes input by trimming whitespace
     * @param input The input string to sanitize
     * @return Trimmed string or empty string if null
     */
    public static String sanitize(String input) {
        return input == null ? "" : input.trim();
    }
}