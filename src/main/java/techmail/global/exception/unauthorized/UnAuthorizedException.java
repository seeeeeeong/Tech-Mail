package techmail.global.exception.unauthorized;


import techmail.global.exception.BusinessException;
import techmail.global.exception.ErrorCode;

public class UnAuthorizedException extends BusinessException {

    public UnAuthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
