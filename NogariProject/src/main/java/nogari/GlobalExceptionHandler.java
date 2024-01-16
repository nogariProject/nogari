//package nogari;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import lombok.extern.slf4j.Slf4j;
//
//@ControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleException(Exception e) {
//    	log.error("@@Exeption Handle");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exeption Handle");
//    }
//}