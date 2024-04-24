package com.inn.qms.utils;

public class StringUtils {

    // Private constructor to prevent instantiation
    private StringUtils() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    // Method to check if a string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Method to check if a string is null, empty, or contains only whitespace
    public static boolean isNullOrWhitespace(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Method to check if a string is not null and not empty
    public static boolean isNotEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    // Method to check if a string is empty
    public static boolean isEmpty(String str) {
        return str != null && str.isEmpty();
    }

    // Method to concatenate strings with a separator
    public static String joinWithSeparator(String separator, String... strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            if (isNotEmpty(str)) { // Using the isNotEmpty method
                if (result.length() > 0) {
                    result.append(separator);
                }
                result.append(str);
            }
        }
        return result.toString();
    }

    // Add more custom utility methods as needed
}