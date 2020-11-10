package org.cloud.panzer.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShowApiResBody<T> {
    private int allPages;

    @JsonProperty("ret_code")
    private int retCode;

    @JsonProperty("contentlist")
    private List<T> contentList;

    public ShowApiResBody() {
    }

    public ShowApiResBody(int allPages, int retCode, List<T> contentList) {
        this.allPages = allPages;
        this.retCode = retCode;
        this.contentList = contentList;
    }

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public List<T> getContentList() {
        return contentList;
    }

    public void setContentList(List<T> contentList) {
        this.contentList = contentList;
    }
}
