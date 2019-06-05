package se.jensim.reflekt.internal;

import se.jensim.reflekt.ReflektAllMethods;
import se.jensim.reflekt.ReflektMethodsWithAnyParamAnnotated;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ReflektMethodsWithAnyParamAnnotatedImpl implements ReflektMethodsWithAnyParamAnnotated {

    private final Map<Boolean, Map<String, Set<Method>>> keeper = new ConcurrentHashMap<>();
    private final ReflektAllMethods reflektAllMethods;
    private Set<Method> defaultValue = Collections.emptySet();

    ReflektMethodsWithAnyParamAnnotatedImpl(ReflektAllMethods reflektAllMethods) {
        this.reflektAllMethods = reflektAllMethods;
    }

    @Override
    public Set<Method> getMethodsWithAnyParamAnnotated(Class<Annotation> annotation) {
        return keeper.computeIfAbsent(false, b -> init())
                .getOrDefault(annotation.getCanonicalName(), defaultValue);
    }

    private Map<String, Set<Method>> init() {
        throw new UnsupportedOperationException("Not yet implemented"); // TODO
}
}
