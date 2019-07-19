FROM bitnami/minideb-extras:jessie
LABEL maintainer "Bitnami <containers@bitnami.com>"

# Install related packages
RUN echo "deb [check-valid-until=no] http://ftp.debian.org/debian/ stretch  main" > /etc/apt/sources.list.d/jessie.list
#RUN apt-get -o Acquire::Check-Valid-Until=false update -- if repo does create issue
RUN apt-get update
RUN apt-get install bzip2 -y
RUN apt install -t stretch ca-certificates-java -y
RUN apt install -t stretch --no-install-recommends openjdk-8-jdk-headless openjdk-8-jre-headless  -y 
RUN mkdir /bitnami
WORKDIR /bitnami
ENTRYPOINT chown -R bitnami:bitnami /bitnami &&  su bitnami -c './mvnw -Pprod clean package
