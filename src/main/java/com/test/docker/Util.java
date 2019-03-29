package com.test.docker;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.apache.commons.lang3.StringUtils.isBlank;


public class Util {
    public static Collection<String> splitIntoLinesAndTrimSpaces(String lines){
        if(isBlank(lines)) return Collections.emptyList();

        return Collections2.transform(Arrays.asList(lines.split("[\r\n]+")), new Function<String, String>() {
            @Nullable
            public String apply(@Nullable String input) {
                return input.trim();
            }
        });
    }
}
