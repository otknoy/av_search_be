NAME := av_search_be

clean:
	rm -rf ./bin

build:
	GOOS=linux   GOARCH=amd64 go build -o ./bin/linux/${NAME}
	GOOS=windows GOARCH=amd64 go build -o ./bin/windows/${NAME}.exe
	GOOS=darwin  GOARCH=amd64 go build -o ./bin/darwin/${NAME}

test:
	go test -v -race ./...
