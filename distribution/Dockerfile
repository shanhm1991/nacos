FROM openjdk:17-oracle

WORKDIR /home/nacos

ADD ./conf /home/nacos/conf/
ADD ./bin /home/nacos/bin/
ADD ./target /home/nacos/lib/

ENTRYPOINT ["/home/nacos/bin/startup.sh"]
