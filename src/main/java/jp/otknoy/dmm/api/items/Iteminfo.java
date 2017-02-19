package jp.otknoy.dmm.api.items;

import java.util.List;
import lombok.Data;

@Data
public class Iteminfo {
    private List<Genre> genre;
    private List<Series> series;
    private List<Maker> maker;
    private List<Actress> actress;
}
