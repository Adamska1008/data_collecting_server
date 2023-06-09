package com.web_programming.data_collecting_server.util.result;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
  SUCCESS(200,"成功"),
  FAIL(201,"失败"),
  SERVICE_ERROR(2012,"服务异常"),
  DATA_ERROR(204,"数据异常"),

  LOGIN_AUTH(208,"未登录"),
  PERMISSION(209,"没有权限")
  ;
  private Integer code;
  private String message;

  private ResultCodeEnum(Integer code,String message){
    this.code = code;
    this.message=message;
  }
}
