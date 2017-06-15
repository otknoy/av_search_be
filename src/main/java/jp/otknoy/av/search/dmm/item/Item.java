package jp.otknoy.av.search.dmm.item;

import lombok.Data;

@Data
public class Item {
    private String title;
    private String affiliateURL;
    private ImageUrl imageURL;
    private Prices prices;
    private String date;
    private Iteminfo iteminfo;
}
