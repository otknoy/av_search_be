package main

import (
	"log"
	"net/http"
	"os"
)

var dmmApiId string = os.Getenv("DMM_API_ID")
var dmmAffiliateId string = os.Getenv("DMM_AFFILIATE_ID")
var port string = "8080"

func main() {
	http.HandleFunc("/search", Search)

	log.Print("start server: port=" + port)

	log.Fatal(http.ListenAndServe(":"+port, nil))
}
