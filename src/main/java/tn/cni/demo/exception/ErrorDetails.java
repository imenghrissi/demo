package tn.cni.demo.exception;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date timestamp;
	private String message;
	private String details;
	private String code; /**type de l'exception**/
	private String codeDetails; /**details de l'exception**/

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public ErrorDetails(Date timestamp, String message, String details,String code) {

		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.code=code;
	}
	public ErrorDetails(Date timestamp, String message, String details,String code, String codeDetails) {

		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.code=code;
		this.codeDetails=codeDetails;
	}
	public Date getTimestamp() {

		return timestamp;
	}

	public String getMessage() {

		return message;
	}

	public String getDetails() {

		return details;
	}
	
	public String getCode() {
	
		return code;
	}
	
	public String getCodeDString() {
		
		return codeDetails;
	}
	
}
