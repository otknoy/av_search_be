package main

import (
	"./dmm"
	"encoding/json"
	"log"
	"net/http"
	"os"
)

type Item struct {
	Title    string `json:"title"`
	Url      string `json:"url"`
	ImageUrl string `json:"image_url"`
}

type Response struct {
	Items []Item `json:"items"`
}

var dmmApiId string = os.Getenv("DMM_API_ID")
var dmmAffiliateId string = os.Getenv("DMM_AFFILIATE_ID")
var port string = "8080"

func main() {
	http.HandleFunc("/search", search)

	log.Print("start server: port=" + port)

	log.Fatal(http.ListenAndServe(":"+port, nil))
}

func search(w http.ResponseWriter, r *http.Request) {
	qs := r.URL.Query()
	keyword := qs["keyword"][0]

	res := dmm.Search(keyword, dmmApiId, dmmAffiliateId)
	response := buildResponse(res.Result.Items)

	json.NewEncoder(w).Encode(response)
}

func buildResponse(dmmItems []dmm.Item) []Item {
	items := []Item{}
	for _, v := range dmmItems {
		item := Item{
			Title:    v.Title,
			Url:      v.Url,
			ImageUrl: v.ImageUrl.Large,
		}

		items = append(items, item)
	}

	return items
}
