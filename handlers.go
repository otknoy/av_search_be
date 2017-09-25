package main

import (
	"encoding/json"
	"log"
	"net/http"
	"strings"

	"github.com/dmmlabo/dmm-go-sdk/api"

	"github.com/otknoy/av_search_be/dmm"
)

func Search(w http.ResponseWriter, r *http.Request) {
	qs := r.URL.Query()
	keyword := strings.Join(qs["keyword"], " ")

	result, err := dmm.SearchItems(keyword)
	if err != nil {
		log.Print(err)
	}

	response := buildResponse(result)
	json.NewEncoder(w).Encode(response)
}

func buildResponse(response *api.ProductResponse) Response {
	res := Response{
		ResultCount:   response.ResultCount,
		TotalCount:    response.TotalCount,
		FirstPosition: response.FirstPosition,
	}

	res.Items = Items{}
	for _, v := range response.Items {
		item := Item{
			Title:    v.Title,
			Url:      v.URL,
			ImageUrl: v.ImageURL.Large,
		}

		res.Items = append(res.Items, item)
	}

	return res
}
