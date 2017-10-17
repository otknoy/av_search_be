package dmm

import (
	"testing"

	"encoding/json"
)

func TestUnmarshalJSON(t *testing.T) {
	b := []byte(`[
{
"id": 1019890,
"name": "湊莉久"
},
{
"id": "1019890_ruby",
"name": "みなとりく"
},
{
"id": "1019890_classify",
"name": "av"
},
{
"id": 1029718,
"name": "なつめ愛莉"
},
{
"id": "1029718_ruby",
"name": "なつめあいり"
},
{
"id": "1029718_classify",
"name": "av"
}
]`)

	var actual Actresses
	actual.UnmarshalJSON(b)

	expected := Actresses{
		Actress{
			ID:   1019890,
			Name: "湊莉久",
			Ruby: "みなとりく",
		},
		Actress{
			ID:   1029718,
			Name: "なつめ愛莉",
			Ruby: "なつめあいり",
		},
	}

	if len(expected) != len(actual) {
		t.Fatal("failed test")
	}

	for i, e := range expected {
		if e != actual[i] {
			t.Fatal("failed test")
		}
	}
}

func TestChunkArray(t *testing.T) {
	b := []byte(`[
{
"id": 1234,
"name": "foo"
},
{
"id": "1234",
"name": "foo_bar"
},
{
"id": 5678,
"name": "foo"
},
{
"id": "5678",
"name": "foo_bar"
}
]`)

	ary := []interface{}{}
	err := json.Unmarshal(b, &ary)
	if err != nil {
		t.Fatal("failed to unmarshal test data")
	}

	chunks := chunkArray(ary, 2)

	if ary[0].(map[string]interface{})["id"] != chunks[0][0].(map[string]interface{})["id"] {
		t.Fatal("fail test")
	}
	if ary[0].(map[string]interface{})["name"] != chunks[0][0].(map[string]interface{})["name"] {
		t.Fatal("fail test")
	}

	if ary[1].(map[string]interface{})["id"] != chunks[0][1].(map[string]interface{})["id"] {
		t.Fatal("fail test")
	}
	if ary[1].(map[string]interface{})["name"] != chunks[0][1].(map[string]interface{})["name"] {
		t.Fatal("fail test")
	}

	if ary[2].(map[string]interface{})["id"] != chunks[1][0].(map[string]interface{})["id"] {
		t.Fatal("fail test")
	}
	if ary[2].(map[string]interface{})["name"] != chunks[1][0].(map[string]interface{})["name"] {
		t.Fatal("fail test")
	}

	if ary[3].(map[string]interface{})["id"] != chunks[1][1].(map[string]interface{})["id"] {
		t.Fatal("fail test")
	}
	if ary[3].(map[string]interface{})["name"] != chunks[1][1].(map[string]interface{})["name"] {
		t.Fatal("fail test")
	}

}
