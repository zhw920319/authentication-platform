package com.taiji.authenticationplatform.common;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * @author zhw
 * @Maill
 * 规范返回值
 * 编码过程中，返回给前端的数据都会统一规范起来，用一个泛型来作为响应对象
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse<T> implements Serializable {
    /**
     * 业务表示代码
     */
    private Integer status;
    /**
     * 业务提示信息
     */
    private String msg;

    /**
     * 业务操作返回结果
     */
    private T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    //    使之不在JSON序列化结果当中
    @JsonIgnore
    // 可以快速进行成功与否的条件判断
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    @JsonIgnore
    // 可以快速进行成功与否的条件判断，判断false时，不用加!。囧
    public boolean isFail() {
        return this.status != ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
    // 快速构建返回结果
    //    成功时的调用
    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    //    失败时的调用
    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServerResponse<T>(errorCode, errorMessage);
    }
}
