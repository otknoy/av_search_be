package jp.otknoy.av.dmm.item;

import lombok.Data;

import java.io.Serializable;

@Data
public class Maker implements Serializable {
    private String name;
    private int id;
}
