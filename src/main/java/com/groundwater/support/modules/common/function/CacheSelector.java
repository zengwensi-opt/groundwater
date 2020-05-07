package com.groundwater.support.modules.common.function;

@FunctionalInterface
public interface CacheSelector<T> {
    T select() throws Exception;
}
