docker build . -t movie-api
docker stop movie-api
docker rm movie-api
docker run -d -p 8080:8080 --name=movie-api movie-api