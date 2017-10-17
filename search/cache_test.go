package search

import (
	"testing"
)

func TestCache(t *testing.T) {
	c := NewCache()
	if c == nil {
		t.Fatal("Failed to create Cache")
	}

	res := Response{
		1,
		2,
		3,
		[]Item{},
	}

	var v Response
	var ok bool

	v, ok = c.Get("foo")
	if ok {
		t.Fatal("failed to get empty cache")
	}

	c.Set("foo", res)

	v, ok = c.Get("foo")
	if v.FirstPosition != res.FirstPosition &&
		v.ResultCount != res.ResultCount &&
		v.TotalCount != res.TotalCount {
		t.Fatal("failed to get cache")
	}
}
