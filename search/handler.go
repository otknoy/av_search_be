package search

import (
	"encoding/json"
	"net/http"
	"strings"
)

func Search(w http.ResponseWriter, r *http.Request) {
	qs := r.URL.Query()
	keyword := strings.Join(qs["keyword"], " ")

	result := SearchItems(keyword)

	json.NewEncoder(w).Encode(result)
}

// func buildResponse(response *api.ProductResponse) Response {
// 	res := Response{
// 		ResultCount:   response.ResultCount,
// 		TotalCount:    response.TotalCount,
// 		FirstPosition: response.FirstPosition,
// 	}

// 	res.Items = Items{}
// 	for _, v := range response.Items {
// 		item := Item{
// 			Title:    v.Title,
// 			Url:      v.URL,
// 			ImageUrl: v.ImageURL.Large,
// 		}

// 		res.Items = append(res.Items, item)
// 	}

// 	return res
// }
