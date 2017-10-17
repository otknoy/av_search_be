package search

import (
	"encoding/json"
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
	if ok {
		json.NewEncoder(w).Encode(response)
		return
	}

	response = SearchItems(keyword)

	h.Cache.Set(cacheKey, response)

	json.NewEncoder(w).Encode(response)
}
