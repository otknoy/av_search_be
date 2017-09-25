package dmm

import (
	"log"

	"github.com/dmmlabo/dmm-go-sdk/api"
)

func SearchItems(keyword, dmmAffiliateId, dmmApiId string) (*api.ProductResponse, error) {
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
