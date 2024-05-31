package com.transcomics.transcomics.handle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.transcomics.transcomics.utils.MessageSourceUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Le-Hong-Quan
 * Date: 28/05/2024
 * Time: 14:52
 */
@Getter
@Setter
public class ServiceException extends RuntimeException {
    protected String errorCode;

    protected String message;

    public ServiceException() {
    }

    public ServiceException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.message = MessageSourceUtils.getMessage(errorCode, args);
    }

}
