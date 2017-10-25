package cache

import (
	"time"

	"github.com/patrickmn/go-cache"
)

type CacheRepository interface {
	Set(key string, value interface{})
	Get(key string) (interface{}, bool)
}

type SimpleCacheRepository struct {
	c *cache.Cache
}

func NewSimpleCacheRepository(defaultExpire, cleanupInterval time.Duration) *SimpleCacheRepository {
	cr := &SimpleCacheRepository{}
	cr.c = cache.New(defaultExpire, cleanupInterval)

	return cr
}

func (cr *SimpleCacheRepository) Set(key string, value interface{}) {
	cr.c.Set(key, value, cache.DefaultExpiration)
}

func (cr *SimpleCacheRepository) Get(key string) (interface{}, bool) {
	return cr.c.Get(key)
}
