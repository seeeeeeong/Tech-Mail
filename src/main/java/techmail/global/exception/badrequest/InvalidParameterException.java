package techmail.global.exception.badrequest;


import techmail.global.exception.BusinessException;
import techmail.global.exception.ErrorCode;

public class InvalidParameterException extends BusinessException {

    public InvalidParameterException(ErrorCode errorCode) {
        super(errorCode);
    }
}
