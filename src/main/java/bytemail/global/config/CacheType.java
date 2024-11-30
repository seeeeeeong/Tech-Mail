package bytemail.global.config;

import lombok.Getter;

@Getter
public enum CacheType {

    QUESTION("questions", 1L);

    private final String name;
    private final Long expiredAfterWrite;

    CacheType(String name, Long expiredAfterWrite) {
        this.name = name;
        this.expiredAfterWrite = expiredAfterWrite;
    }
}
