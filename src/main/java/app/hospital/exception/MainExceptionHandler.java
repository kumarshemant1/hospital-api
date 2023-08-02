package app.hospital.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler extends ResponseEntityExceptionHandler {

	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<Object> globalExceptionHandler(Exception ex, WebRequest request) {
	    
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		 
	    return new ResponseEntity<>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
	  }

	 @ExceptionHandler(value = {NullPointerException.class})
	 public ResponseEntity<Object> nullPointerExceptionHandler(NullPointerException ex, WebRequest request) {
	    
		ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		 
	    return new ResponseEntity<>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
	  }
}