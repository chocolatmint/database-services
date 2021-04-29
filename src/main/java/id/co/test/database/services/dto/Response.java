package id.co.test.database.services.dto;

public class Response {

	public String message;
	
	public static Response newSuccessResponse() {
		Response response = new Response();
		response.setMessage("SUCCESS");
		
		return response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
