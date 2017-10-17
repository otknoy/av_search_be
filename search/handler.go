package search

import (
	"encoding/json"
	"log"
	"net/http"
	"strings"
)

type Handler struct {
	Cache *Cache
}

func (h *Handler) Search(w http.ResponseWriter, r *http.Request) {
	qs := r.URL.Query()
	keyword := strings.Join(qs["keyword"], " ")

	cacheKey := keyword

	response, ok := h.Cache.Get(cacheKey)
	log.Println(ok)
	if ok {
		json.NewEncoder(w).Encode(response)
		return
	}

	response = SearchItems(keyword)

	h.Cache.Set(cacheKey, response)

	json.NewEncoder(w).Encode(response)
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
