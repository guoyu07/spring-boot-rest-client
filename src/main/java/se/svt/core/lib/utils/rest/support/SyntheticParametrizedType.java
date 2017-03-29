package se.svt.core.lib.utils.rest.support;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class SyntheticParametrizedType implements ParameterizedType, Serializable {

    private static final long serialVersionUID = -521679299810654826L;

    private final Type rawType;
    private final Type[] typeArguments;

    public SyntheticParametrizedType(Type rawType, Type... typeArguments) {
        this.rawType = rawType;
        this.typeArguments = typeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override
    public Type getRawType() {
        return this.rawType;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s<%s<%s>>", SyntheticParametrizedType.class.getName(), rawType.getTypeName(),
            Arrays.stream(typeArguments).map(Type::getTypeName).collect(Collectors.joining(",")));
    }
}