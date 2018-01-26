package cache

import (
	"testing"

	"time"
)

func TestSimpleCache(t *testing.T) {
	cr := NewSimpleCache(5*time.Minute, 10*time.Minute)
	if cr == nil {
		t.Fatal("Failed to create Cache")
	}

	testData := []int{
		1, 2, 3,
	}

	v, ok := cr.Get("foo")
	if ok {
		t.Fatal("failed to get empty cache")
	}

	cr.Set("foo", testData)

	v, ok = cr.Get("foo")

	if len(v.([]int)) != len(testData) {
		t.Fatal("failed to get cache")
	}

	for i, d := range testData {
		if v.([]int)[i] != d {
			t.Fatal("failed to get cache")
		}
	}
}
