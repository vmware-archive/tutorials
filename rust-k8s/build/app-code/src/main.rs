#[macro_use] extern crate nickel;

use nickel::Nickel;

fn main() {
    let mut server = Nickel::new();

    server.utilize(router! {
        get "**" => |_req, _res| {
            "Congratulations! Your Rust application has been deployed on Kubernetes."
        }
    });

    server.listen("0.0.0.0:3000");
}
