package bytemail.global.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageResponse<T> {

    private final List<T> content;
    private final int currentPage;
    private final int size;
    private final long totalPages;
    private final long totalElements;
    private final boolean first;
    private final boolean last;

    public PageResponse(Page<T> pageContent) {
        this.content = pageContent.getContent();
        this.currentPage = pageContent.getNumber();
        this.size = pageContent.getSize();
        this.totalPages = pageContent.getTotalPages();
        this.totalElements = pageContent.getTotalElements();
        this.first = pageContent.isFirst();
        this.last = pageContent.isLast();
    }

    @JsonCreator
    public PageResponse(
            @JsonProperty("content") List<T> content,
            @JsonProperty("currentPage") int currentPage,
            @JsonProperty("size") int size,
            @JsonProperty("totalPages") long totalPages,
            @JsonProperty("totalElements") long totalElements,
            @JsonProperty("first") boolean first,
            @JsonProperty("last") boolean last) {
        this.content = content;
        this.currentPage = currentPage;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.first = first;
        this.last = last;
    }
}
