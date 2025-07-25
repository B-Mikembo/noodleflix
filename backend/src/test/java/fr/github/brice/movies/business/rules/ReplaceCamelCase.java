package fr.github.brice.movies.business.rules;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;
import java.util.List;

public class ReplaceCamelCase extends DisplayNameGenerator.Standard {
    @Override
    public String generateDisplayNameForMethod(List<Class<?>> enclosingInstanceTypes, Class<?> testClass, Method testMethod) {
        return replaceCapitals(testMethod.getName());
    }

    private String replaceCapitals(String name) {
        return name.replaceAll("([A-Z])", " $1")
                .replaceAll("([0-9]+)", " $1")
                .toLowerCase();
    }
}
