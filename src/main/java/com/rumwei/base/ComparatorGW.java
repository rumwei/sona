package com.rumwei.base;

import com.google.common.annotations.GwtCompatible;

import javax.annotation.Nonnull;

@FunctionalInterface
@GwtCompatible
public interface ComparatorGW<T> {
    int compare(@Nonnull T t1, @Nonnull T t2);
}
