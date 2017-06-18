package jp.otknoy.av.dmm.item;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
    private String title;
    private String affiliateURL;
    private ImageUrl imageURL;
    private Prices prices;
    private String date;
    private Iteminfo iteminfo;
}
