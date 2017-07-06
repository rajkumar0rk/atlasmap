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
 * Salesforce DTO for SObject Group
 */
@XStreamAlias("Group")
public class Group extends AbstractSObjectBase {

    // DeveloperName
    private String DeveloperName;

    @JsonProperty("DeveloperName")
    public String getDeveloperName() {
        return this.DeveloperName;
    }

    @JsonProperty("DeveloperName")
    public void setDeveloperName(String DeveloperName) {
        this.DeveloperName = DeveloperName;
    }

    // RelatedId
    private String RelatedId;

    @JsonProperty("RelatedId")
    public String getRelatedId() {
        return this.RelatedId;
    }

    @JsonProperty("RelatedId")
    public void setRelatedId(String RelatedId) {
        this.RelatedId = RelatedId;
    }

    // Type
    @XStreamConverter(PicklistEnumConverter.class)
    private TypeEnum Type;

    @JsonProperty("Type")
    public TypeEnum getType() {
        return this.Type;
    }

    @JsonProperty("Type")
    public void setType(TypeEnum Type) {
        this.Type = Type;
    }

    // Email
    private String Email;

    @JsonProperty("Email")
    public String getEmail() {
        return this.Email;
    }

    @JsonProperty("Email")
    public void setEmail(String Email) {
        this.Email = Email;
    }

    // DoesSendEmailToMembers
    private Boolean DoesSendEmailToMembers;

    @JsonProperty("DoesSendEmailToMembers")
    public Boolean getDoesSendEmailToMembers() {
        return this.DoesSendEmailToMembers;
    }

    @JsonProperty("DoesSendEmailToMembers")
    public void setDoesSendEmailToMembers(Boolean DoesSendEmailToMembers) {
        this.DoesSendEmailToMembers = DoesSendEmailToMembers;
    }

    // DoesIncludeBosses
    private Boolean DoesIncludeBosses;

    @JsonProperty("DoesIncludeBosses")
    public Boolean getDoesIncludeBosses() {
        return this.DoesIncludeBosses;
    }

    @JsonProperty("DoesIncludeBosses")
    public void setDoesIncludeBosses(Boolean DoesIncludeBosses) {
        this.DoesIncludeBosses = DoesIncludeBosses;
    }

}
