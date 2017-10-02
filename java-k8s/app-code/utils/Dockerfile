FROM bitnami/minideb-extras:jessie-r15
LABEL maintainer "Bitnami <containers@bitnami.com>"

# Install related packages
RUN echo "deb http://http.debian.net/debian jessie-backports main" >> /etc/apt/sources.list && \
    install_packages ca-certificates-java/jessie-backports openjdk-8-jdk-headless bzip2

RUN mkdir /bitnami
WORKDIR /bitnami
ENTRYPOINT chown -R bitnami:bitnami /bitnami &&  su bitnami -c './mvnw -Pprod clean package'