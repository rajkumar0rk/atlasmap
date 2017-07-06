/*
 * Salesforce DTO generated by camel-salesforce-maven-plugin
 * Generated on: Mon Mar 02 02:58:34 EST 2015
 */
package org.apache.camel.salesforce.dto;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * Salesforce Enumeration DTO for picklist Location
 */
public enum LocationEnum {

    // Monitoring
    MONITORING("Monitoring"),
    // Profiling
    PROFILING("Profiling"),
    // SystemLog
    SYSTEMLOG("SystemLog"),
    // HeapDump
    HEAPDUMP("HeapDump"),
    // Preserved
    PRESERVED("Preserved");

    final String value;

    private LocationEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static LocationEnum fromValue(String value) {
        for (LocationEnum e : LocationEnum.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException(value);
    }

}
