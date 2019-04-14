package com.rumwei.base;

import com.google.common.annotations.GwtCompatible;
import com.sun.istack.internal.NotNull;

@FunctionalInterface
@GwtCompatible
public interface ComparatorGW<T> {
    int compare(@NotNull T t1, @NotNull T t2);
}
