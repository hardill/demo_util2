/**
 * 
 */
package com.demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 控制层统一返回数据格式
 * 
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
	/** 状态码0 */
	public static final int RESPCODE_SUCCESS = 0;
	/** 状态码1 */
	public static final int RESPCODE_FAILURE = 1;
	/** 权限不足 */
	public static final int RESPCODE_NO_AUTH = -1;
	/**返回成功信息*/
	public static final String MSG_SUCCESS = "OK";
	/** 失败信息FAIL */
	public static final String MSG_FAIL = "FAIL";
	/**权限不足返回信息*/
	public static final String MSG_NO_AUTH = "权限不足";

	/** 返回码 */
	private int code;
	/** 返回信息 */
	private String msg;
	/** 返回数据 */
	private Object data;

	/**
	 * 构造错误result
	 * 
	 * @return
	 */
	public static Result buildErrorResult() {
		return new Result(RESPCODE_FAILURE, MSG_FAIL, "");
	}

	/**
	 * 构造空result
	 * 
	 * @return 200 ok
	 */
	public static Result buildEmptyResult() {
		return new Result(RESPCODE_SUCCESS, MSG_SUCCESS, "");
	}

}
