package main

import (
	"log"
	"net/http"
	"time"

	"github.com/otknoy/av_search_be/cache"
	"github.com/otknoy/av_search_be/search"
)

var port string = "8080"

func main() {
	handler := &search.Handler{}
	handler.Cache = cache.NewSimpleCacheRepository(5*time.Minute, 10*time.Minute)

	http.HandleFunc("/search", handler.Search)

	log.Print("start server: port=" + port)

	log.Fatal(http.ListenAndServe(":"+port, nil))
}
