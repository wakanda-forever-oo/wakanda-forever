from datetime import datetime

import socket
import requests
import json

kelvin_const = 273.15

def get_ip_address():
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.connect(("8.8.8.8", 80))
    return s.getsockname()[0]

ip = get_ip_address()
ip = '94.156.233.107'

url= 'http://api.ipstack.com/'
access_key = 'de92f5b74f05708579a54a1d7e7d51d6'

req = requests.post(url=url+ip+'?access_key='+access_key)
resp = json.loads(req.text)
latitude = resp['latitude']
longitude = resp['longitude']

api_key='c05a0fdbcc41f026e1e949437b7fd824'

weather_api_url = 'http://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&APPID=%s' % (latitude, longitude, api_key)
#print(weather_api_url)
#api_key = 'c28d619cf8a8fe9bd61021e7df11e204'
#weather_api_url = 'https://api.darksky.net/forecast/%s/%s,%s' % (api_key, latitude, longitude)

weather_req = requests.get(url=weather_api_url)
data = json.loads(weather_req.text)

def convert_timestamp(timestamp):
    return datetime.utcfromtimestamp(timestamp).strftime('%d-%m-%Y %H:%M:%S')

def convert_to_celsius(kelvin):
    return round(kelvin - kelvin_const, 2)

def construct_weather_dict(dictionary):
    result = []
    for wobject in dictionary['list']:
        temp_object = {}
        temp_object['datetime'] = convert_timestamp(float(wobject['dt']))
        temp_object['temperature'] = convert_to_celsius(wobject['main']['temp'])
        temp_object['temperature_min'] = convert_to_celsius(wobject['main']['temp_min'])
        temp_object['temperature_max'] = convert_to_celsius(wobject['main']['temp_max'])
        temp_object['pressure'] = wobject['main']['pressure']
        temp_object['sea_level'] = wobject['main']['sea_level']
        temp_object['grnd_level'] = wobject['main']['grnd_level']
        temp_object['humidity'] = wobject['main']['humidity']
        temp_object['wind_speed'] = wobject['wind']['speed']
        result.append(temp_object)
    return result

def get_five_day_forecast(weather_data):
    result = []
    for index in range(0, len(weather_data), 8):
        result.append(weather_data[index])
    return result

print(get_five_day_forecast(construct_weather_dict(data)))


