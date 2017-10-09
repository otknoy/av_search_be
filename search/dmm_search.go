package search

import (
	"github.com/otknoy/av_search_be/dmm"
)

func SearchItems(keyword string) Response {
	response := dmm.SearchItems(keyword)

	return mapResponse(response)
}

func mapResponse(dmm_response dmm.Response) Response {
	res := Response{
		ResultCount:   dmm_response.Result.ResultCount,
		TotalCount:    dmm_response.Result.TotalCount,
		FirstPosition: dmm_response.Result.FirstPosition,
	}

	items := []Item{}
	for _, i := range dmm_response.Result.Items {
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
