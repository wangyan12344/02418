package com.repast.weixin.fastweixin.exception;

/**
 * 微信API处理异常
 *
 * @author 栾冬
 */
public class WeixinException extends RuntimeException {

    public WeixinException() {
        super();
    }

    public WeixinException(String message) {
        super(message);
    }

    public WeixinException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeixinException(Throwable cause) {
        super(cause);
    }
}
