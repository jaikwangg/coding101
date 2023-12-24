import requests

api_endpoint = 'YOUR_API_ENDPOINT'

response = requests.get(api_endpoint)

if response.status_code == 200:
    api_data = response.json()

    print(api_data)
else:
    print(f"Error: Unable to fetch data from the API. Status code: {response.status_code}")
