package com.dragos.financial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.dragos.financial.BaseResponse.Status.ERROR;
import static com.dragos.financial.BaseResponse.Status.LOADING;
import static com.dragos.financial.BaseResponse.Status.SUCCESS;

public class BaseResponse<T> {

    public enum Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    public final Status status;
    @Nullable
    public final T data;
    @Nullable
    public final String errorMsg;

    public BaseResponse(Status status, @Nullable T data, @Nullable String errorMsg) {
        this.status = status;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public static <T> BaseResponse<T> success(@NonNull T data) {
        return new BaseResponse<T>(SUCCESS, data, null);
    }

    public static <T> BaseResponse<T> error(@NonNull String error) {
        return new BaseResponse<>(ERROR, null, error);
    }

    public static <T> BaseResponse<T> loading() {
        return new BaseResponse<>(LOADING, null, null);
    }
}
