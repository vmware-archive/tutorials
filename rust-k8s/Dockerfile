FROM gcr.io/bitnami-containers/minideb-extras:jessie-r19
LABEL Bitnami <containers@bitnami.com>

COPY build/binary/http_server /app/http_server

USER bitnami

WORKDIR /app

EXPOSE 3000

CMD ["/app/http_server"]
