package com.bullhornsdk.data.model.response.resume.standard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bullhornsdk.data.model.entity.core.standard.Candidate;
import com.bullhornsdk.data.model.entity.core.standard.CandidateEducation;
import com.bullhornsdk.data.model.entity.core.standard.CandidateWorkHistory;
import com.bullhornsdk.data.model.response.file.FileWrapper;
import com.bullhornsdk.data.model.response.resume.ParsedResume;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName(value = "data")
@JsonPropertyOrder({ "candidate", "candidateEducation", "candidateWorkHistory" })
public class StandardParsedResume implements ParsedResume {

	private Candidate candidate;
	private List<CandidateEducation> candidateEducation;
	private List<CandidateWorkHistory> candidateWorkHistory;
	private List<String> skillList;
	private FileWrapper fileWrapper;

	private String errorCode;
	private String errorMessage;

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	@JsonProperty("candidate")
	public Candidate getCandidate() {
		return candidate;
	}

	
	@JsonProperty("candidate")
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	
	@JsonProperty("candidateEducation")
	public List<CandidateEducation> getCandidateEducation() {
		return candidateEducation;
	}

	
	@JsonProperty("candidateEducation")
	public void setCandidateEducation(List<CandidateEducation> candidateEducation) {
		this.candidateEducation = candidateEducation;
	}

	
	@JsonProperty("candidateWorkHistory")
	public List<CandidateWorkHistory> getCandidateWorkHistory() {
		return candidateWorkHistory;
	}

	
	@JsonProperty("candidateWorkHistory")
	public void setCandidateWorkHistory(List<CandidateWorkHistory> candidateWorkHistory) {
		this.candidateWorkHistory = candidateWorkHistory;
	}

	
	@JsonProperty("skillList")
	public List<String> getSkillList() {
		return skillList;
	}

	
	@JsonProperty("skillList")
	public void setSkillList(List<String> skillList) {
		this.skillList = skillList;
	}

	
	@JsonIgnore
	public String getErrorCode() {
		return errorCode;
	}

	
	@JsonIgnore
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
	@JsonIgnore
	public String getErrorMessage() {
		return errorMessage;
	}

	
	@JsonIgnore
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	public boolean isError() {
		if (errorMessage != null && errorMessage.trim().length() > 0) {
			return true;
		}
		return false;
	}

	
	@JsonIgnore
	public FileWrapper getFileWrapper() {
		return fileWrapper;
	}

	
	@JsonIgnore
	public void setFileWrapper(FileWrapper fileWrapper) {
		this.fileWrapper = fileWrapper;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StandardParsedResume {\ncandidate=");
		builder.append(candidate);
		builder.append(", \ncandidateEducation=");
		builder.append(candidateEducation);
		builder.append(", \ncandidateWorkHistory=");
		builder.append(candidateWorkHistory);
		builder.append(", \nskillList=");
		builder.append(skillList);
		builder.append(", \nerrorCode=");
		builder.append(errorCode);
		builder.append(", \nerrorMessage=");
		builder.append(errorMessage);
		builder.append(", \nadditionalProperties=");
		builder.append(additionalProperties);
		builder.append("}");
		return builder.toString();
	}

}
