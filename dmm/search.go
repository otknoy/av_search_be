package dmm

import (
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
	"net/url"
	"os"
)

var dmmAPIID = os.Getenv("DMM_API_ID")
var dmmAffiliateID = os.Getenv("DMM_AFFILIATE_ID")

func SearchItems(keyword string) Response {
	u := buildURL(keyword)

	log.Print(u.String())

	resp, err := http.Get(u.String())
	if err != nil {
		log.Print(err)
	}
	defer resp.Body.Close()

	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Print(err)
	}

	r := Response{}
	err = json.Unmarshal(body, &r)
	if err != nil {
		log.Print("failed to unmarshal response json")
		log.Print(err)
	}

	return r
}

func buildURL(keyword string) url.URL {
	q := url.Values{}
	q.Add("api_id", dmmApiId)
	q.Add("affiliate_id", dmmAffiliateId)
	q.Add("site", "DMM.R18")
	q.Add("service", "digital")
	q.Add("floor", "videoa")
	q.Add("hits", "20")
	q.Add("offset", "1")
	q.Add("keyword", keyword)
	q.Add("sort", "date")

	u := url.URL{}
	u.Scheme = "https"
	u.Host = "api.dmm.com"
	u.Path = "affiliate/v3/ItemList"
	u.RawQuery = q.Encode()

	return u
}
