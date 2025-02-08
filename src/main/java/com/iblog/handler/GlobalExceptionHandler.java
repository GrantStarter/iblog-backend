package com.iblog.handler;

import com.iblog.controller.ex.FileSizeException;
import com.iblog.controller.ex.FileUploadException;
import com.iblog.service.ex.*;
import com.iblog.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Map<Class<? extends Exception>,Integer> EXCEPTION_STATUS_MAP = new HashMap<>();

    static {
        EXCEPTION_STATUS_MAP.put(UsernameDuplicateException.class, 400);
        EXCEPTION_STATUS_MAP.put(UserNotFoundException.class, 404);
        EXCEPTION_STATUS_MAP.put(LoginException.class, 401);
        EXCEPTION_STATUS_MAP.put(InsertException.class, 500);
        EXCEPTION_STATUS_MAP.put(FileSizeException.class, 402);
    }

    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Exception e) {
        int state = EXCEPTION_STATUS_MAP.getOrDefault(e.getClass(), 500);
        return new JsonResult<>(state, e.getMessage());
    }
}
