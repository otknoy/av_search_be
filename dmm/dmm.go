package dmm

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
)

type Response struct {
	Result Result `json:"result"`
}

type Result struct {
	Items []Item `json:"items"`
}

type Item struct {
	Title    string   `json:"title"`
	Url      string   `json:"affiliateURL"`
	ImageUrl ImageUrl `json:"imageURL"`
}

type ImageUrl struct {
	List  string
	Small string
	Large string
}

func Search(query string, dmmApiId string, dmmAffiliateId string) Response {
	v := url.Values{}
	v.Set("api_id", dmmApiId)
	v.Set("affiliate_id", dmmAffiliateId)
	v.Set("site", "DMM.R18")
	v.Set("service", "digital")
	v.Set("floor", "videoa")
	v.Set("hits", "20")
	v.Set("offset", "1")
	v.Set("keyword", query)
	v.Set("sort", "rank")

	u := "https://api.dmm.com/affiliate/v3/ItemList" + "?" + v.Encode()
	log.Print(u)

	res, err := http.Get(u)
	if err != nil {
		panic(err.Error())
	}
	defer res.Body.Close()

	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		panic(err.Error())
	}

	var response Response
	json.Unmarshal(body, &response)

	return response
}
