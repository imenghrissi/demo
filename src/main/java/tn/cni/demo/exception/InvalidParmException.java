package tn.cni.demo.exception;
public class InvalidParmException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author khalil
	 */
	private Object obj;

	public InvalidParmException(Object ob, String message) {

		super(message);
		obj = ob;
	}

	public Object getObj() {

		return obj;
	}
}
