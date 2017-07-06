/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Mon Mar 02 02:58:34 EST 2015
 */
package org.apache.camel.salesforce.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.apache.camel.component.salesforce.api.PicklistEnumConverter;
import org.apache.camel.component.salesforce.api.dto.AbstractSObjectBase;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Salesforce DTO for SObject AsyncApexJob
 */
@XStreamAlias("AsyncApexJob")
public class AsyncApexJob extends AbstractSObjectBase {

    // JobType
    @XStreamConverter(PicklistEnumConverter.class)
    private JobTypeEnum JobType;

    @JsonProperty("JobType")
    public JobTypeEnum getJobType() {
        return this.JobType;
    }

    @JsonProperty("JobType")
    public void setJobType(JobTypeEnum JobType) {
        this.JobType = JobType;
    }

    // ApexClassId
    private String ApexClassId;

    @JsonProperty("ApexClassId")
    public String getApexClassId() {
        return this.ApexClassId;
    }

    @JsonProperty("ApexClassId")
    public void setApexClassId(String ApexClassId) {
        this.ApexClassId = ApexClassId;
    }

    // Status
    @XStreamConverter(PicklistEnumConverter.class)
    private StatusEnum Status;

    @JsonProperty("Status")
    public StatusEnum getStatus() {
        return this.Status;
    }

    @JsonProperty("Status")
    public void setStatus(StatusEnum Status) {
        this.Status = Status;
    }

    // JobItemsProcessed
    private Integer JobItemsProcessed;

    @JsonProperty("JobItemsProcessed")
    public Integer getJobItemsProcessed() {
        return this.JobItemsProcessed;
    }

    @JsonProperty("JobItemsProcessed")
    public void setJobItemsProcessed(Integer JobItemsProcessed) {
        this.JobItemsProcessed = JobItemsProcessed;
    }

    // TotalJobItems
    private Integer TotalJobItems;

    @JsonProperty("TotalJobItems")
    public Integer getTotalJobItems() {
        return this.TotalJobItems;
    }

    @JsonProperty("TotalJobItems")
    public void setTotalJobItems(Integer TotalJobItems) {
        this.TotalJobItems = TotalJobItems;
    }

    // NumberOfErrors
    private Integer NumberOfErrors;

    @JsonProperty("NumberOfErrors")
    public Integer getNumberOfErrors() {
        return this.NumberOfErrors;
    }

    @JsonProperty("NumberOfErrors")
    public void setNumberOfErrors(Integer NumberOfErrors) {
        this.NumberOfErrors = NumberOfErrors;
    }

    // CompletedDate
    private org.joda.time.DateTime CompletedDate;

    @JsonProperty("CompletedDate")
    public org.joda.time.DateTime getCompletedDate() {
        return this.CompletedDate;
    }

    @JsonProperty("CompletedDate")
    public void setCompletedDate(org.joda.time.DateTime CompletedDate) {
        this.CompletedDate = CompletedDate;
    }

    // MethodName
    private String MethodName;

    @JsonProperty("MethodName")
    public String getMethodName() {
        return this.MethodName;
    }

    @JsonProperty("MethodName")
    public void setMethodName(String MethodName) {
        this.MethodName = MethodName;
    }

    // ExtendedStatus
    private String ExtendedStatus;

    @JsonProperty("ExtendedStatus")
    public String getExtendedStatus() {
        return this.ExtendedStatus;
    }

    @JsonProperty("ExtendedStatus")
    public void setExtendedStatus(String ExtendedStatus) {
        this.ExtendedStatus = ExtendedStatus;
    }

    // ParentJobId
    private String ParentJobId;

    @JsonProperty("ParentJobId")
    public String getParentJobId() {
        return this.ParentJobId;
    }

    @JsonProperty("ParentJobId")
    public void setParentJobId(String ParentJobId) {
        this.ParentJobId = ParentJobId;
    }

    // LastProcessed
    private String LastProcessed;

    @JsonProperty("LastProcessed")
    public String getLastProcessed() {
        return this.LastProcessed;
    }

    @JsonProperty("LastProcessed")
    public void setLastProcessed(String LastProcessed) {
        this.LastProcessed = LastProcessed;
    }

    // LastProcessedOffset
    private Integer LastProcessedOffset;

    @JsonProperty("LastProcessedOffset")
    public Integer getLastProcessedOffset() {
        return this.LastProcessedOffset;
    }

    @JsonProperty("LastProcessedOffset")
    public void setLastProcessedOffset(Integer LastProcessedOffset) {
        this.LastProcessedOffset = LastProcessedOffset;
    }

}
