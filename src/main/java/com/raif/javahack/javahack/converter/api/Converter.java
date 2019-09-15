package com.raif.javahack.javahack.converter.api;

public interface Converter<S, D> {
    D convert(S s);
}
