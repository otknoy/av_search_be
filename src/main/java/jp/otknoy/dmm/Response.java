package jp.otknoy.dmm;

import java.util.List;

public class Response {

    public Result result;

    public class Result {
	public int status;
	public int resultCount;
	public int totalCount;
	public int firstPosition;

	public List<Item> items;
    }
}
