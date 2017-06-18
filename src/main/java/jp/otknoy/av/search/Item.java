package jp.otknoy.av.search;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Item {
    private String title;
    private String url;
    private String imageUrl;
    private String date;
    private List<String> genre;
    private List<String> maker;
    private List<String> series;
    private List<Actress> actress;
}