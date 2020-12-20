package taco.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import taco.exception.ParamException;
import taco.utils.ResultBean;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ControllerAop {

    private static final String PARAM_ERROR = "param error, url: {}, msg: {}";

    @ExceptionHandler({ParamException.class})
    public ResultBean<Object> handelException(HttpServletRequest request, ParamException ex) {
        log.warn(PARAM_ERROR, request.getRequestURL(), ex.getMessage());
        return new ResultBean<>(ex.getMessage());
    }

}
