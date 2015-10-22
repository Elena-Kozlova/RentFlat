package com.rentflat.controller.model.response;

/**
 * Response for validation requests.
 */
public class Response {

    private String type;
    private ErrorEnum code;
    private String message;

    /**
     * Default constructor
     */
    public Response() {
        // Default for initialization
    }

    /**
     * Response for validation request constructor
     *
     * @param type    response type
     * @param code    error code
     * @param message response message
     */
    public Response(String type, ErrorEnum code, String message) {
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ErrorEnum getCode() {
        return code;
    }

    public void setCode(ErrorEnum code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
