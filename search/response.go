package search

type Response struct {
	ResultCount   int    `json:"result_count"`
	TotalCount    int    `json:"total_count"`
	FirstPosition int    `json:"first_position"`
	Items         []Item `json:"items"`
}

type Item struct {
	Title    string    `json:"title"`
	URL      string    `json:"url"`
	ImageURL string    `json:"image_url"`
	Date     string    `json:"date"`
	Genre    []Genre   `json:"genre"`
	Actress  []Actress `json:"actress"`
}

type Genre struct {
	ID   int    `json:"id"`
	Name string `json:"name"`
}

type Actress struct {
	ID   int    `json:"id"`
	Name string `json:"name"`
	Ruby string `json:"ruby"`
}
