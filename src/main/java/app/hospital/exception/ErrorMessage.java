package app.hospital.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
	private Date date;
	private String message;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(Date date, String message) {
		this.date = date;
		this.message = message;
	}
}
