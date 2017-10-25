package search

import (
	"encoding/json"
	"net/http"
	"strings"

	"github.com/otknoy/av_search_be/cache"
)

type Handler struct {
	Cache cache.CacheRepository
}

func (h *Handler) Search(w http.ResponseWriter, r *http.Request) {
	qs := r.URL.Query()
	keyword := strings.Join(qs["keyword"], " ")

	cacheKey := keyword

	h.Cache.Get(cacheKey)

	response, ok := h.Cache.Get(cacheKey)
	if ok {
		json.NewEncoder(w).Encode(response)
		return
	}

	response = SearchItems(keyword)

	h.Cache.Set(cacheKey, response)

	json.NewEncoder(w).Encode(response)
}
