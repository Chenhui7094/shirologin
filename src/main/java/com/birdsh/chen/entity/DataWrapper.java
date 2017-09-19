package com.birdsh.chen.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据通讯返回类
 * 
 * @author three
 *
 */
@ApiModel(description = "返回结果集")
public class DataWrapper<T> implements java.io.Serializable {

	/**
	 * SID
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "返回码")
	private String resultCode;

	@ApiModelProperty(value = "返回提示信息")
	private String message;

	@ApiModelProperty(value = "返回结果")
	private T resultData;

	public void setReturnSg(RespCodeConstant rs) {
		this.resultCode = rs.code;
		this.message = rs.name;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
