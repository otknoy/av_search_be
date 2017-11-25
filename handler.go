package main

import (
	"encoding/json"
	"net/http"
	"strings"

	"github.com/otknoy/av_search_be/cache"
	"github.com/otknoy/av_search_be/search"
)

type Handler struct {
	Cache cache.Cache
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

	response = search.SearchItems(keyword)

	h.Cache.Set(cacheKey, response)

	json.NewEncoder(w).Encode(response)
}
