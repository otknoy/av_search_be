package jp.otknoy.av.dmm.item;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImageUrl implements Serializable {
    private String list;
    private String small;
    private String large;
}
