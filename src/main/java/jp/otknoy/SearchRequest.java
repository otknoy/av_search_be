package jp.otknoy;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.AssertTrue;

@Data
public class SearchRequest {
    @NotNull
    private String keyword;

    @NotNull
    @Min(1)
    @Max(100)
    private int hits;

    @NotNull
    @Min(1)
    @Max(50000)
    private int offset;

    @NotNull
    private String sort;
}
