import requests


BASE_URL = "https://dcy.gdcatalog.go.th"
INITIAL_URL = "api/3/action/datastore_search?limit=5&resource_id=504dd5e8-ddf3-40c4-9f50-eee3825768b4&q=title:jones'"
LIMIT = 10


def get_all() -> list:
    result = []
    resp = requests.get(f"{BASE_URL}{INITIAL_URL}&limit={LIMIT}")
    js = resp.json()["result"]
    result.extend(js["records"])
    while "_links" in js and "next" in js["_links"]:
        resp = requests.get(BASE_URL + js["_links"]["next"])
        js = resp.json()["result"]
        result.extend(js["records"])
        print(js["_links"]["next"]) # just so you know it's actually doing stuff
        if len(js["records"]) < LIMIT:
            # if it returned less records than the limit, the end has been reached
            break
    return result

l = get_all()
len(l)
# print(len(get_all()))
