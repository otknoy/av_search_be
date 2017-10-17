package dmm

import (
	"encoding/json"
	"log"
)

type Actress struct {
	ID   int    `json:"id"`
	Name string `json:"name"`
	Ruby string `json:"ruby"`
}

type Actresses []Actress

func (a *Actresses) UnmarshalJSON(b []byte) error {
	var ary []interface{}
	err := json.Unmarshal(b, &ary)
	if err != nil {
		log.Print("failed to unmarshal Actresses")
		return err
	}

	chunks := chunkArray(ary, 3)
	var actresses Actresses
	for _, c := range chunks {
		id := c[0].(map[string]interface{})["id"].(float64)
		name := c[0].(map[string]interface{})["name"].(string)
		ruby := c[1].(map[string]interface{})["name"].(string)

		actresses = append(actresses, Actress{int(id), name, ruby})
	}

	*a = actresses

	return nil
}

func chunkArray(array []interface{}, size int) [][]interface{} {
	var chunks [][]interface{}
	n := len(array)
	for i := 0; i < n; i += size {
		end := i + size
		if n < end {
			end = size
		}
		chunks = append(chunks, array[i:end])
	}

	return chunks
}
