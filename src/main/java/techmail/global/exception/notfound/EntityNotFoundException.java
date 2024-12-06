package techmail.global.exception.notfound;


import techmail.global.exception.BusinessException;
import techmail.global.exception.ErrorCode;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
    public EntityNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
