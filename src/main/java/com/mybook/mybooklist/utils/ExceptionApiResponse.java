package com.mybook.mybooklist.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ExceptionApiResponse {
    private boolean isSuccessful;
    private Object data;
}
