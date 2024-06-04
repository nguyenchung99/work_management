package com.example.work_management.response;

public class ResponseBase {
    public Integer errorCode;
    public String errorMessage;
    public Object body;

    public static ResponseBase getSuccess(Object body){
        ResponseBase responseBase = new ResponseBase();
        responseBase.errorCode = 200;
        responseBase.errorMessage = "Success";
        responseBase.body = body;
        return responseBase;
    }

    public static ResponseBase getInternalServerError(){
        ResponseBase responseBase = new ResponseBase();
        responseBase.errorCode = 500;
        responseBase.errorMessage = "Internal Server Error";
        return responseBase;
    }

    public static ResponseBase getDuplicateError(){
        ResponseBase responseBase = new ResponseBase();
        responseBase.errorCode = 409;
        responseBase.errorMessage = "Record already exists";
        return responseBase;
    }
}
