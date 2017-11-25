package main

import (
	"net/http"
	"net/http/httptest"
	"testing"

	"github.com/otknoy/av_search_be/search"
)

type TestCache struct {
}

func (c *TestCache) Set(key string, value interface{}) {
}

func (c *TestCache) Get(key string) (interface{}, bool) {
	return nil, false
}

type TestItemRepository struct {
}

func (tr *TestItemRepository) Search(keyword string) search.Response {
	return search.Response{}
}

func TestHandler(t *testing.T) {
	handler := &Handler{}
	handler.Cache = &TestCache{}
	handler.ItemRepository = &TestItemRepository{}

	ts := httptest.NewServer(http.HandlerFunc(handler.Search))
	defer ts.Close()

	res, err := http.Get(ts.URL + "?keyword=hoge")
	if err != nil {
		t.Error("unexpected")
		return
	}

	if res.StatusCode != 200 {
		t.Error("Status code error")
		return
	}
}
