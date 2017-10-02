FROM bitnami/minideb-extras:jessie-r14-buildpack

RUN bitnami-pkg install go-1.8.3-0 --checksum 557d43c4099bd852c702094b6789293aed678b253b80c34c764010a9449ff136

ENV GOPATH=/gopath
ENV PATH=$GOPATH/bin:/opt/bitnami/go/bin:$PATH

RUN go get github.com/urfave/negroni

COPY server.go /
RUN go build /server.go

FROM bitnami/minideb:latest

COPY --from=0 /server /

COPY page.html /

ENV PORT=80

CMD /server
