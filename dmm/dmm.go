package dmm

import (
	"log"
	"os"

	"github.com/dmmlabo/dmm-go-sdk/api"
)

var dmmApiId string = os.Getenv("DMM_API_ID")
var dmmAffiliateId string = os.Getenv("DMM_AFFILIATE_ID")

func SearchItems(keyword string) (*api.ProductResponse, error) {
	s := api.NewProductService(dmmAffiliateId, dmmApiId)
	s.SetSite("DMM.R18")
	s.SetService("digital")
	s.SetFloor("videoa")
	s.SetLength(20)
	s.SetOffset(1)
	s.SetKeyword(keyword)
	s.SetSort("date")

	url, err := s.BuildRequestURL()
	if err == nil {
		log.Print(url)
	}

	result, err := s.Execute()
	return result, err
}
