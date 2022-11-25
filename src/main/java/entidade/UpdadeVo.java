package entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class UpdadeVo {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name= "IdUpdate")
	private String idUpdate;
	
	@Column (name= "CurrentReleaseDate")
	private Date currentReleaseDate;
	
	@Column (name= "CvrfUrl")
	private String cvrfUrl;
	
	@Column (name= "DocumentTitle")
	private String documentTitle;
	
	@Column (name= "InitialReleaseDate")
	private Date initialReleaseDate;
	
	@Column (name= "Severity")
	private boolean severity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(String idUpdate) {
		this.idUpdate = idUpdate;
	}

	public Date getCurrentReleaseDate() {
		return currentReleaseDate;
	}

	public void setCurrentReleaseDate(Date currentReleaseDate) {
		this.currentReleaseDate = currentReleaseDate;
	}

	public String getCvrfUrl() {
		return cvrfUrl;
	}

	public void setCvrfUrl(String cvrfUrl) {
		this.cvrfUrl = cvrfUrl;
	}

	public String getDocumentTitle() {
		return documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	public Date getInitialReleaseDate() {
		return initialReleaseDate;
	}

	public void setInitialReleaseDate(Date initialReleaseDate) {
		this.initialReleaseDate = initialReleaseDate;
	}

	public boolean isSeverity() {
		return severity;
	}

	public void setSeverity(boolean severity) {
		this.severity = severity;
	}
	
}
