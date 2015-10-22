package com.rentflat.controller.exception.handler;

import com.rentflat.controller.model.response.ErrorEnum;
import com.rentflat.controller.model.response.Response;
import org.apache.log4j.Logger;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Processor for exception on API endpoint
 */
@ControllerAdvice(basePackages = {"com.rentflat.controller"})
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RestExceptionProcessor {

    private static final Logger LOGGER = Logger.getLogger(RestExceptionProcessor.class);

    /**
     * Exception handler for 500 error
     *
     * @param ex exception
     * @return Response
     */
    @ExceptionHandler({
            Exception.class,
            NestedRuntimeException.class
    })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Response runtimeExceptionHandler(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ErrorEnum.E0001, ex.getMessage());
    }
}
