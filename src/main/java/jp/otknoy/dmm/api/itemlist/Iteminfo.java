package jp.otknoy.dmm.api.itemlist;

import java.util.List;
import lombok.Data;

@Data
public class Iteminfo {
    private List<Genre> genre;
    private List<Series> series;
    private List<Maker> maker;
    private List<Actress> actress;
}
