IMAGE_NAME=socket-backend

# 1. docker stop - ignore error for not running
docker stop $IMAGE_NAME

# 2. docker rmi
docker rmi $IMAGE_NAME