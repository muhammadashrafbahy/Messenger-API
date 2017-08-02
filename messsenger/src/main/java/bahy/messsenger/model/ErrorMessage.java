package bahy.messsenger.model;

public class ErrorMessage {
private String error_message;
private int error_code;
private String documention;
public ErrorMessage() {

}
public ErrorMessage(String error_message, int error_code, String documention) {
	super();
	this.error_message = error_message;
	this.error_code = error_code;
	this.documention = documention;
}
public String getError_message() {
	return error_message;
}
public void setError_message(String error_message) {
	this.error_message = error_message;
}
public int getError_code() {
	return error_code;
}
public void setError_code(int error_code) {
	this.error_code = error_code;
}
public String getDocumention() {
	return documention;
}
public void setDocumention(String documention) {
	this.documention = documention;
}



}
