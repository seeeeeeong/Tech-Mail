package bytemail.global.exception.badrequest;


import bytemail.global.exception.BusinessException;
import bytemail.global.exception.ErrorCode;

public class InvalidParameterException extends BusinessException {

    public InvalidParameterException(ErrorCode errorCode) {
        super(errorCode);
    }
}
