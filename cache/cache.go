package cache

import (
	"time"

	"github.com/patrickmn/go-cache"
)

type Cache interface {
	Set(key string, value interface{})
	Get(key string) (interface{}, bool)
}

type SimpleCache struct {
	c *cache.Cache
}

func NewSimpleCache(defaultExpire, cleanupInterval time.Duration) Cache {
	cr := &SimpleCache{}
	cr.c = cache.New(defaultExpire, cleanupInterval)

	return cr
}

func (cr *SimpleCache) Set(key string, value interface{}) {
	cr.c.Set(key, value, cache.DefaultExpiration)
}

func (cr *SimpleCache) Get(key string) (interface{}, bool) {
	return cr.c.Get(key)
}
