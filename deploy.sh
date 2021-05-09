if [ -d /root/Market ]; then
    rm -d -R /root/Market
fi
cd /root/
git clone https://github.com/iaSokolov/Market.git
cd /root/Market
./mvnw package

docker stop $(docker ps -q)
docker rm $(docker ps -aq)
docker rmi $(docker images -q)

/root/app/docker-compose up -d