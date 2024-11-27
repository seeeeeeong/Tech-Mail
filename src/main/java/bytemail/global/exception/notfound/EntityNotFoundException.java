package bytemail.global.exception.notfound;


import bytemail.global.exception.BusinessException;
import bytemail.global.exception.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
    public EntityNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
