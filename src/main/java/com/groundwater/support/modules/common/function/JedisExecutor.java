package com.groundwater.support.modules.common.function;

import com.groundwater.support.modules.common.exception.RedisConnectException;

@FunctionalInterface
public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}
