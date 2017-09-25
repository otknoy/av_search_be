package main

type Item struct {
	Title    string `json:"title"`
	Url      string `json:"url"`
	ImageUrl string `json:"image_url"`
}

type Items []Item

type Response struct {
	ResultCount   int64 `json:"result_count"`
	TotalCount    int64 `json:"total_count"`
	FirstPosition int64 `json:"first_position"`
	Items         Items `json:"items"`
}
