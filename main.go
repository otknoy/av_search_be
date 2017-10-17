package main

import (
	"log"
	"net/http"

	"github.com/otknoy/av_search_be/search"
)

var port string = "8080"

func main() {
	handler := &search.Handler{}
	handler.Cache = search.NewCache()

	http.HandleFunc("/search", handler.Search)

	log.Print("start server: port=" + port)

	log.Fatal(http.ListenAndServe(":"+port, nil))
}
