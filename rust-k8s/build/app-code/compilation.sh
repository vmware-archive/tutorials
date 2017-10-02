
# Move the code from the volume
cp -rf /app-code/* /app
# Compile the code
cargo build --release
# Move the resulting binary to the output volume
mv /app/target/release/http_server /binary
