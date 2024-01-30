
#mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U

docker build -t cowave/nacos:2.3.0 .

