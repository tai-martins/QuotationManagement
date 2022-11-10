package br.inatel.idp.quotationmanagement.validation;

/**
 * FormErrorDto Class. 
 * 
 * @author Tainara Martins.
 * @since November 2022
 */
public class FormErrorDto {
	
	/** creation of the field and error variables */
	private String field;
	private String error;
	
	/**
	 * Constructor that receives all parameters
	 * 
	 * @param field
	 * @param error
	 */
	public FormErrorDto(String field, String error) {
		this.field = field;
		this.error = error;
	}

	/**
	 * Gets the field
	 * 
	 * @return field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Sets the field
	 * 
	 * @param field the new field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * Gets the Error
	 * 
	 * @return error
	 */
	public String getError() {
		return error;
	}

	/**
	 * Sets the error
	 * 
	 * @param error the new error
	 */
	public void setError(String error) {
		this.error = error;
	}	

}
