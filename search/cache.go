package search

import (
	"sync"
)

type Cache struct {
	sync.RWMutex
	m map[string]Response
}

func NewCache() *Cache {
	cache := Cache{}
	cache.m = map[string]Response{}

	return &cache
}

func (c *Cache) Get(key string) (Response, bool) {
	c.RLock()
	v, ok := c.m[key]
	c.RUnlock()
	return v, ok
}

func (c *Cache) Set(key string, res Response) {
	c.Lock()
	c.m[key] = res
	c.Unlock()
}
