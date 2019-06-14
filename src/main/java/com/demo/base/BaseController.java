/**
 *
 */
package com.demo.base;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一返回方法
 *
 * @author Administrator
 */
@Slf4j
public class BaseController {

    protected Result successResult(String msg, Object data) {
        Result result = new Result(Result.RESPCODE_SUCCESS, msg, data);
        return result;
    }

    protected Result successResult(Object data) {
        Result result = new Result(Result.RESPCODE_SUCCESS, Result.MSG_SUCCESS, data);
        return result;
    }

    protected Result failureResult(String msg, Object data) {
        Result result = new Result(Result.RESPCODE_FAILURE, msg, data);
        return result;
    }

    protected Result failureResult(Object data) {
        Result result = new Result(Result.RESPCODE_FAILURE, Result.MSG_SUCCESS, data);
        return result;
    }

}
