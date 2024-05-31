package com.transcomics.transcomics.model.wrapper;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Le-Hong-Quan
 * Date: 29/05/2024
 * Time: 13:07
 */
@Getter
@Setter
public class WrapResponse<T> {
    private boolean success;
    private T data;
    private List<String> message;


    public static <T> WrapResponse<T> error(String msg) {
        WrapResponse baseResponse = new WrapResponse();
        baseResponse.setData(null);
        baseResponse.setSuccess(false);
        baseResponse.setMessage(Collections.singletonList(msg));
        return baseResponse;
    }

    public static <T> WrapResponse<T> ok(T data) {
        WrapResponse baseResponse = new WrapResponse();
        baseResponse.setData(data);
        baseResponse.setSuccess(true);
        return baseResponse;
    }

    public static <T> CompletableFuture<WrapResponse<T>> okFuture(CompletableFuture<T> data) {
        return data.thenApply(rs -> WrapResponse.ok(rs));
    }

    @SneakyThrows
    public static <T> Class<? extends WrapResponse> getClass(Class<T> clazz) {
        return WrapResponse.ok(clazz.newInstance()).getClass();
    }
}

