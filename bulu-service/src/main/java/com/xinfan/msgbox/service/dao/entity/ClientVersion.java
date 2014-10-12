package com.xinfan.msgbox.service.dao.entity;

public class ClientVersion {
    private Long id;

    private String clientCode;

    private String version;

    private String isNewest;

    private String incrDownloadUrl;

    private String fullDownloadUrl;

    private String introduceUrl;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode == null ? null : clientCode.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getIsNewest() {
        return isNewest;
    }

    public void setIsNewest(String isNewest) {
        this.isNewest = isNewest == null ? null : isNewest.trim();
    }

    public String getIncrDownloadUrl() {
        return incrDownloadUrl;
    }

    public void setIncrDownloadUrl(String incrDownloadUrl) {
        this.incrDownloadUrl = incrDownloadUrl == null ? null : incrDownloadUrl.trim();
    }

    public String getFullDownloadUrl() {
        return fullDownloadUrl;
    }

    public void setFullDownloadUrl(String fullDownloadUrl) {
        this.fullDownloadUrl = fullDownloadUrl == null ? null : fullDownloadUrl.trim();
    }

    public String getIntroduceUrl() {
        return introduceUrl;
    }

    public void setIntroduceUrl(String introduceUrl) {
        this.introduceUrl = introduceUrl == null ? null : introduceUrl.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}