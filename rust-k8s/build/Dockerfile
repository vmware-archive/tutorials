FROM gcr.io/bitnami-containers/minideb-extras:jessie-r19
LABEL Bitnami <containers@bitnami.com>

WORKDIR /app

RUN install_packages build-essential && \
    curl https://sh.rustup.rs -sSf | bash -s -- -y

ENV RUSTFLAGS -Awarnings
ENV PATH "/root/.cargo/bin:$PATH"

VOLUME ["/app-code", "/binary"]

CMD ["/app-code/compilation.sh"]
