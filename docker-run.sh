IMAGE_NAME=socket-backend

# 1. docker stop - ignore error for not running
docker stop $IMAGE_NAME

# 2. docker rmi
docker rmi $IMAGE_NAME

# 3. docker build
docker build -t $IMAGE_NAME .

# 4. docker run daemon
docker run --rm -d -p 8080:8080 --name $IMAGE_NAME $IMAGE_NAME
