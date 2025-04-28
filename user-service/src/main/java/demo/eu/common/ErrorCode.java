package demo.eu.common;

import lombok.Data;

@Data
public class ErrorCode {
    public static final ErrorCode SUCCESS = new ErrorCode(200, "success");
    public static final ErrorCode SYSTEM_ERROR = new ErrorCode(1001, "fail");

    private Integer code;

    private String message;


    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
