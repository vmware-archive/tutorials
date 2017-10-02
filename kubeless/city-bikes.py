import urllib2
import json

def find(request):
    term = request.json["term"]
    url = "https://feeds.capitalbikeshare.com/stations/stations.json"    
    response = urllib2.urlopen(url)
    stations = json.loads(response.read())
    
    hits = []
    
    for station in stations["stationBeanList"]    :
        if station["stAddress1"].find(term) > -1:
            hits.append(station)

    return json.dumps(hits)
