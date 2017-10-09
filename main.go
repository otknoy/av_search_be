package main

import (
	"log"
	"net/http"

	"github.com/otknoy/av_search_be/search"
)

var port string = "8080"

func main() {
	http.HandleFunc("/search", search.Search)

	log.Print("start server: port=" + port)

	log.Fatal(http.ListenAndServe(":"+port, nil))
}
