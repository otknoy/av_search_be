package search

import (
	"github.com/otknoy/av_search_be/dmm"
)

type ItemRepository interface {
	Search(keyword string) Response
}

type DmmItemRepository struct {
}

func NewDmmItemRepository() ItemRepository {
	ir := &DmmItemRepository{}
	return ir
}

func (repo *DmmItemRepository) Search(keyword string) Response {
	response := dmm.SearchItems(keyword)

	return mapResponse(response)
}

func mapResponse(dmmResponse dmm.Response) Response {
	res := Response{
		ResultCount:   dmmResponse.Result.ResultCount,
		TotalCount:    dmmResponse.Result.TotalCount,
		FirstPosition: dmmResponse.Result.FirstPosition,
	}

	items := []Item{}
	for _, i := range dmmResponse.Result.Items {
		item := Item{
			Title:    i.Title,
			Url:      i.URL,
			ImageUrl: i.ImageURL.Large,
			Date:     i.Date,
		}

		genres := []Genre{}
		for _, g := range i.Iteminfo.Genre {
			genres = append(genres, Genre{g.ID, g.Name})
		}
		item.Genre = genres

		actresses := []Actress{}
		for _, a := range i.Iteminfo.Actresses {
			actresses = append(
				actresses,
				Actress{a.ID, a.Name, a.Ruby},
			)
		}
		item.Actress = actresses

		items = append(items, item)
	}
	res.Items = items

	return res
}
