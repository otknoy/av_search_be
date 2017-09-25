package main

import (
	"log"
	"net/http"
)

func main() {
	port := "8080"

	http.HandleFunc("/search", Search)

	log.Print("start server: port=" + port)

	log.Fatal(http.ListenAndServe(":"+port, nil))
}
