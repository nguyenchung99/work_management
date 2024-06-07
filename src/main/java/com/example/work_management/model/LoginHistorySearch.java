package com.example.work_management.model;

import com.example.work_management.common.Strings;

import java.util.Map;

public class LoginHistorySearch extends SearchBase{
    private String usename;
    private String type;
    private Long fromDate;
    private Long toDate;

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getFromDate() {
        return fromDate;
    }

    public void setFromDate(Long fromDate) {
        this.fromDate = fromDate;
    }

    public Long getToDate() {
        return toDate;
    }

    public void setToDate(Long toDate) {
        this.toDate = toDate;
    }

    public void setParam(Map<String, String> params){
        this.usename = params.getOrDefault("usename", "");
        this.type = params.getOrDefault("type", "");
        String toDate = params.getOrDefault("toDate", "");
        this.toDate = Strings.isNullOrEmpty(toDate) ? Long.valueOf(toDate) : null;
        String fromDate = params.getOrDefault("fromDate", "");
        this.fromDate = Strings.isNullOrEmpty(fromDate) ? Long.valueOf(fromDate) : null;
        this.setParamCommon(params);
    }
}
