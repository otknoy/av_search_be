package jp.otknoy.av.dmm.item;

import lombok.Data;

import java.io.Serializable;

@Data
public class Series implements Serializable {
    private String name;
    private int id;
}
