package com.rumwei.base;


import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

import javax.annotation.Nullable;

@FunctionalInterface
@GwtCompatible
public interface ConvertGW<I,O> extends java.util.function.Function<I,O>{

    @CanIgnoreReturnValue
    @Nullable
    O apply(@Nullable I var1);

}
