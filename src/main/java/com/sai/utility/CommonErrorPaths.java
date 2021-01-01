package com.sai.utility;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class CommonErrorPaths  implements ErrorController { 
 
    @GetMapping("/error")
    public ResponseEntity<ErrorInfo> handleError(HttpServletRequest request) {
    	ErrorInfo err=new ErrorInfo();
    	
		
		err.setTimestamp(LocalDate.now());
		
		
         
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
         System.out.println(status);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
             
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                // handle HTTP 404 Not Found error
            	err.setErrorCode(HttpStatus.NOT_FOUND.value()); 
            	err.setErrorMessage("Ur Required Page Not Present");
                 
            } 
            else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                // handle HTTP 403 Forbidden error
            	err.setErrorCode(HttpStatus.NOT_FOUND.value()); 
            	err.setErrorMessage("U r not Authorized");
                 
            } 
            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) { 
                // handle HTTP 500 Internal Server error
            	err.setErrorCode(HttpStatus.NOT_FOUND.value()); 
            	err.setErrorMessage("There is Some Error u r looking for..Please Conatct Admin");  
                 
            }
            else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                // handle HTTP 403 Forbidden error
            	err.setErrorCode(HttpStatus.NOT_FOUND.value()); 
            	err.setErrorMessage("Request Method is Not Present. Kindly CHeck back later");
                 
            }
        }
         
        return new ResponseEntity<ErrorInfo>(err,HttpStatus.OK);
    }
     
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
