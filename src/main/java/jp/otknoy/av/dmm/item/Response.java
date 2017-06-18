package jp.otknoy.av.dmm.item;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private Result result;
}
