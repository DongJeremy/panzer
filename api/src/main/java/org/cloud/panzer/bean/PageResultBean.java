package org.cloud.panzer.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class PageResultBean<T> implements Serializable {

    @JsonProperty("showapi_res_error")
    private String showApiResError;

    @JsonProperty("showapi_res_code")
    private int showApiResCode;

    @JsonProperty("showapi_res_id")
    private String showApiResId;

    @JsonProperty("showapi_res_body")
    private ShowApiResBody<T> showApiResBody;

    private int currentPage;
    private long allNum;
    private int maxResult;

    public String getShowApiResError() {
        return showApiResError;
    }

    public void setShowApiResError(String showApiResError) {
        this.showApiResError = showApiResError;
    }

    public int getShowApiResCode() {
        return showApiResCode;
    }

    public void setShowApiResCode(int showApiResCode) {
        this.showApiResCode = showApiResCode;
    }

    public String getShowApiResId() {
        return showApiResId;
    }

    public void setShowApiResId(String showApiResId) {
        this.showApiResId = showApiResId;
    }

    public ShowApiResBody<T> getShowApiResBody() {
        return showApiResBody;
    }

    public void setShowApiResBody(ShowApiResBody<T> showApiResBody) {
        this.showApiResBody = showApiResBody;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getAllNum() {
        return allNum;
    }

    public void setAllNum(long allNum) {
        this.allNum = allNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public PageResultBean() {
    }

    public PageResultBean(String showApiResId, int page, int maxResult, long allNum, List<T> jokeTexts) {
        int allPages = (int) Math.ceil((double) allNum / maxResult);
        ShowApiResBody<T> showApiResBody = new ShowApiResBody<>(allPages, 0, jokeTexts);
        this.showApiResError = "";
        this.showApiResId = showApiResId;
        this.showApiResBody = showApiResBody;
        this.currentPage = page;
        this.allNum = allNum;
        this.maxResult = maxResult;
    }
}
