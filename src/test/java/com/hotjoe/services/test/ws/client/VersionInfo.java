
package com.hotjoe.services.test.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for versionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="versionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildUserEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitIdAbbrev" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitIdDescribe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitIdDescribeShort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitMessageFull" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitMessageShort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitUserEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commitUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dirty" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="remoteOriginUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalCommitCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionInfo", propOrder = {
    "branch",
    "buildHost",
    "buildTime",
    "buildUserEmail",
    "buildUserName",
    "buildVersion",
    "commitId",
    "commitIdAbbrev",
    "commitIdDescribe",
    "commitIdDescribeShort",
    "commitMessageFull",
    "commitMessageShort",
    "commitTime",
    "commitUserEmail",
    "commitUserName",
    "dirty",
    "remoteOriginUrl",
    "tags",
    "totalCommitCount"
})
public class VersionInfo {

    protected String branch;
    protected String buildHost;
    protected String buildTime;
    protected String buildUserEmail;
    protected String buildUserName;
    protected String buildVersion;
    protected String commitId;
    protected String commitIdAbbrev;
    protected String commitIdDescribe;
    protected String commitIdDescribeShort;
    protected String commitMessageFull;
    protected String commitMessageShort;
    protected String commitTime;
    protected String commitUserEmail;
    protected String commitUserName;
    protected Boolean dirty;
    protected String remoteOriginUrl;
    protected String tags;
    protected Integer totalCommitCount;

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranch(String value) {
        this.branch = value;
    }

    /**
     * Gets the value of the buildHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildHost() {
        return buildHost;
    }

    /**
     * Sets the value of the buildHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildHost(String value) {
        this.buildHost = value;
    }

    /**
     * Gets the value of the buildTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildTime() {
        return buildTime;
    }

    /**
     * Sets the value of the buildTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildTime(String value) {
        this.buildTime = value;
    }

    /**
     * Gets the value of the buildUserEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildUserEmail() {
        return buildUserEmail;
    }

    /**
     * Sets the value of the buildUserEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildUserEmail(String value) {
        this.buildUserEmail = value;
    }

    /**
     * Gets the value of the buildUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildUserName() {
        return buildUserName;
    }

    /**
     * Sets the value of the buildUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildUserName(String value) {
        this.buildUserName = value;
    }

    /**
     * Gets the value of the buildVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildVersion() {
        return buildVersion;
    }

    /**
     * Sets the value of the buildVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildVersion(String value) {
        this.buildVersion = value;
    }

    /**
     * Gets the value of the commitId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitId() {
        return commitId;
    }

    /**
     * Sets the value of the commitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitId(String value) {
        this.commitId = value;
    }

    /**
     * Gets the value of the commitIdAbbrev property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitIdAbbrev() {
        return commitIdAbbrev;
    }

    /**
     * Sets the value of the commitIdAbbrev property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitIdAbbrev(String value) {
        this.commitIdAbbrev = value;
    }

    /**
     * Gets the value of the commitIdDescribe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitIdDescribe() {
        return commitIdDescribe;
    }

    /**
     * Sets the value of the commitIdDescribe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitIdDescribe(String value) {
        this.commitIdDescribe = value;
    }

    /**
     * Gets the value of the commitIdDescribeShort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitIdDescribeShort() {
        return commitIdDescribeShort;
    }

    /**
     * Sets the value of the commitIdDescribeShort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitIdDescribeShort(String value) {
        this.commitIdDescribeShort = value;
    }

    /**
     * Gets the value of the commitMessageFull property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitMessageFull() {
        return commitMessageFull;
    }

    /**
     * Sets the value of the commitMessageFull property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitMessageFull(String value) {
        this.commitMessageFull = value;
    }

    /**
     * Gets the value of the commitMessageShort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitMessageShort() {
        return commitMessageShort;
    }

    /**
     * Sets the value of the commitMessageShort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitMessageShort(String value) {
        this.commitMessageShort = value;
    }

    /**
     * Gets the value of the commitTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitTime() {
        return commitTime;
    }

    /**
     * Sets the value of the commitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitTime(String value) {
        this.commitTime = value;
    }

    /**
     * Gets the value of the commitUserEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitUserEmail() {
        return commitUserEmail;
    }

    /**
     * Sets the value of the commitUserEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitUserEmail(String value) {
        this.commitUserEmail = value;
    }

    /**
     * Gets the value of the commitUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommitUserName() {
        return commitUserName;
    }

    /**
     * Sets the value of the commitUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommitUserName(String value) {
        this.commitUserName = value;
    }

    /**
     * Gets the value of the dirty property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirty() {
        return dirty;
    }

    /**
     * Sets the value of the dirty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirty(Boolean value) {
        this.dirty = value;
    }

    /**
     * Gets the value of the remoteOriginUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteOriginUrl() {
        return remoteOriginUrl;
    }

    /**
     * Sets the value of the remoteOriginUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteOriginUrl(String value) {
        this.remoteOriginUrl = value;
    }

    /**
     * Gets the value of the tags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTags() {
        return tags;
    }

    /**
     * Sets the value of the tags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTags(String value) {
        this.tags = value;
    }

    /**
     * Gets the value of the totalCommitCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalCommitCount() {
        return totalCommitCount;
    }

    /**
     * Sets the value of the totalCommitCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalCommitCount(Integer value) {
        this.totalCommitCount = value;
    }

}
