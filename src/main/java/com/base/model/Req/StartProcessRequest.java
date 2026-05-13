package com.base.model.Req;

import java.util.List;

public class StartProcessRequest {
    private String documentId;
    private String createdBy;
    private String position;
    private List<String> approvers;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<String> getApprovers() {
        return approvers;
    }

    public void setApprovers(List<String> approvers) {
        this.approvers = approvers;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}