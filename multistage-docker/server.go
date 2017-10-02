package main

import (
  "fmt"
  "io/ioutil"
  "net/http"
  "github.com/urfave/negroni"
)

func main() {
  mux := http.NewServeMux()
  mux.HandleFunc("/", func(w http.ResponseWriter, req *http.Request) {
    t, _ := ioutil.ReadFile("page.html")
    fmt.Fprintf(w, string(t))
  })

  n := negroni.Classic()
  n.UseHandler(mux)

  n.Run()
}
