package dmm

import (
	"testing"
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

	// for i, e := range expected {
	// 	if e != actual[i] {
	// 		t.Fatal("failed test")
	// 	}
	// }
}
