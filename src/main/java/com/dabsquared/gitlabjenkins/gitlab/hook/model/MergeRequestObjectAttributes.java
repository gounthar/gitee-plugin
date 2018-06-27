package com.dabsquared.gitlabjenkins.gitlab.hook.model;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

/**
 * @author Robin Müller
 * @author Yashin
 */
@GeneratePojoBuilder(intoPackage = "*.builder.generated", withFactoryMethod = "*")
public class MergeRequestObjectAttributes {

    private Integer id;
    private Integer iid;
    private Integer authorId;
    private Integer assigneeId;
    private String title;
    private Date createdAt;
    private Date updatedAt;
    private String description;
    private BranchData head;
    private BranchData base;
    private String mergeStatus;
    private String mergeCommitSha;
    private String url;
    private Action action;
    private Boolean workInProgress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIid() {
        return iid;
    }

    public void setNumber(Integer iid) {
        this.iid = iid;
    }

    public String getSourceBranch() {
        return head.getRef();
    }

    public String getTargetBranch() {
        return base.getRef();
    }

    public Integer getSourceProjectId() {
        return head.getProject().getId();
    }

    public Integer getTargetProjectId() {
        return base.getProject().getId();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getSource() {
        return head.getProject();
    }

    public BranchData getHead() {
        return head;
    }

    public void setHead(BranchData head) {
        this.head = head;
    }

    public BranchData getBase() {
        return base;
    }

    public void setBase(BranchData base) {
        this.base = base;
    }

    public Project getTarget() {
        return base.getProject();
    }


    public String getMergeCommitSha() {
        return mergeCommitSha;
    }

    public void setMergeCommitSha(String mergeCommitSha) {
        this.mergeCommitSha = mergeCommitSha;
    }

    public String getMergeStatus() {
        return mergeStatus;
    }

    public void setMergeStatus(String mergeStatus) {
        this.mergeStatus = mergeStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Boolean getWorkInProgress() {
        return workInProgress;
    }

    public void setWorkInProgress(Boolean workInProgress) {
        this.workInProgress = workInProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MergeRequestObjectAttributes that = (MergeRequestObjectAttributes) o;
        return new EqualsBuilder()
            .append(id, that.id)
            .append(iid, that.iid)
            .append(authorId, that.authorId)
            .append(assigneeId, that.assigneeId)
            .append(title, that.title)
            .append(createdAt, that.createdAt)
            .append(updatedAt, that.updatedAt)
            .append(description, that.description)
            .append(head, that.head)
            .append(base, that.base)
            .append(mergeCommitSha, that.mergeCommitSha)
            .append(mergeStatus, that.mergeStatus)
            .append(url, that.url)
            .append(action, that.action)
            .append(workInProgress, that.workInProgress)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(iid)
            .append(authorId)
            .append(assigneeId)
            .append(title)
            .append(createdAt)
            .append(updatedAt)
            .append(description)
            .append(head)
            .append(base)
            .append(mergeStatus)
            .append(mergeCommitSha)
            .append(url)
            .append(action)
            .append(workInProgress)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("iid", iid)
            .append("authorId", authorId)
            .append("assigneeId", assigneeId)
            .append("title", title)
            .append("createdAt", createdAt)
            .append("updatedAt", updatedAt)
            .append("description", description)
            .append("head", head)
            .append("base", base)
            .append("mergeCommitSha", mergeCommitSha)
            .append("mergeStatus", mergeStatus)
            .append("url", url)
            .append("action", action)
            .append("workInProgress", workInProgress)
            .toString();
    }
}
