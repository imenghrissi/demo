package tn.cni.demo.exception;

public class InvalidResponseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author inaam
	 */
	private final Object obj;
	private Integer codeDetail;

	public InvalidResponseException(Object ob, String message, Integer cd) {

		super(message);
		obj = ob;
		codeDetail = cd;
	}
	
	public InvalidResponseException(Object ob, String message) {

		super(message);
		obj = ob;
		
	}

	public Object getObj() {

		return obj;
	}

	public Integer getCodeDetail() {

		return codeDetail;
	}
}
