package demo.eu.common;

import lombok.Data;

/**
 * @author alix.yang
 * @date 2022/4/21 14:55
 */
@Data
public class BaseResult<T> {

    private Integer code;

    private T data;

    private String message;

    public BaseResult(ErrorCode errorCode, T t) {
        this.code = errorCode.getCode();
        this.data = t;
    }

    public BaseResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
    }

    public static <T> BaseResult<T> success(T t) {
        return new BaseResult<>(ErrorCode.SUCCESS, t);
    }

    public static <T> BaseResult<T> success() {
        return success(null);
    }

    public static <T> BaseResult<T> fail() {
        return new BaseResult<>(ErrorCode.SYSTEM_ERROR);
    }

    public static <T> BaseResult<T> fail(String message) {
        BaseResult baseResult = new BaseResult<>(ErrorCode.SYSTEM_ERROR);
        baseResult.message = message;
        return baseResult;
    }

//    public String getMessage() {
//        return this.message;
//    }

    public BaseResult setMessage(String message) {
        this.message = message;
        return this;
    }

//    public T getData() {
//        return this.data;
//    }
//
//    public Integer getCode() {
//        return this.code;
//    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}