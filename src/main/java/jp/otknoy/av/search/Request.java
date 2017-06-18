package jp.otknoy.av.search;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class Request {
    private String keyword;

    @Min(1)
    @Max(100)
    private int hits = 10;

    @Min(1)
    @Max(50000)
    private int offset = 1;

    @Pattern(regexp = "(rank|price|-price|date|review)")
    private String sort = "rank";
}
