package com.rumwei.base;


import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

import javax.annotation.Nullable;

@FunctionalInterface
@GwtCompatible
public interface ConditionGW<E,Boolean> extends java.util.function.Function<E,Boolean>{

    @CanIgnoreReturnValue
    @Nullable
    Boolean apply(@Nullable E var1);

}
