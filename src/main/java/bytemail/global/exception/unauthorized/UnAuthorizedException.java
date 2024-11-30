package bytemail.global.exception.unauthorized;


import bytemail.global.exception.BusinessException;
import bytemail.global.exception.ErrorCode;

public class UnAuthorizedException extends BusinessException {

    public UnAuthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }
}
