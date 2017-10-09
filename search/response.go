package search

type Response struct {
	ResultCount   int    `json:"result_count"`
	TotalCount    int    `json:"total_count"`
	FirstPosition int    `json:"first_position"`
	Items         []Item `json:"items"`
}

type Item struct {
	Title    string    `json:"title"`
	Url      string    `json:"url"`
	ImageUrl string    `json:"image_url"`
	Date     string    `json:"date"`
	Genre    []Genre   `json:"genre"`
	Actress  []Actress `json:"actress"`
}

type Genre struct {
	Id   int    `json:"id"`
	Name string `json:"name"`
}

type Actress struct {
	Id   int    `json:"id"`
	Name string `json:"name"`
	Ruby string `json:"ruby"`
}
