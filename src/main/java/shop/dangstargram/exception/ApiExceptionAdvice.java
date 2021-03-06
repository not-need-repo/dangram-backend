package shop.dangstargram.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdvice {
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionDto> apiExceptionHandler(HttpServletRequest request, final ApiException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(new ApiExceptionDto(e.getError().getCode(), e.getError().getMessage()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiExceptionDto> methodArgumentNotValidExceptionHandler(HttpServletRequest request, final MethodArgumentNotValidException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.REQUEST_PARAMETER_MISMATH_EXCEPTION.getStatus())
                .body(new ApiExceptionDto(ExceptionEnum.REQUEST_PARAMETER_MISMATH_EXCEPTION.getCode(), ExceptionEnum.REQUEST_PARAMETER_MISMATH_EXCEPTION.getMessage()));
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ApiExceptionDto> httpRequestMethodNotSupportedExceptionHandler(HttpServletRequest request, final HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.REQUEST_PARAMETER_MISMATH_EXCEPTION.getStatus())
                .body(new ApiExceptionDto(ExceptionEnum.REQUEST_METHOD_MISMATH_EXCEPTION.getCode(), ExceptionEnum.REQUEST_METHOD_MISMATH_EXCEPTION.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionDto> defaultExceptionHandler(HttpServletRequest request, final Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.NOT_DEFINE_EXCEPTION.getStatus())
                .body(new ApiExceptionDto(ExceptionEnum.NOT_DEFINE_EXCEPTION.getCode(), e.getMessage()));
    }
}