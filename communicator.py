import requests
import serial
import random

API_ENDPOINT_FARM = "http://80.240.21.133:7777/farm/save"
API_ENDPOINT_ILLNESS = "http://80.240.21.133:7777/illness/save"

STREAM_PATH = "/dev/ttyUSB0"
STREAM_PORT = 9600

def generate_pressure():
    pressure = round(random.uniform(100.0, 102.0), 4)
    return pressure

serial_object = serial.Serial(STREAM_PATH, STREAM_PORT)
serials = {}
while True:
    data = serial_object.readline()
    data = data.decode("utf-8")
    if data:
        index_of_equal = data.find('=')
        key = data[0:index_of_equal]
        value = data[index_of_equal+1:]
        serials[key] = float(value)
    if len(serials) == 5:
        serials['pressure'] = generate_pressure()
        req = requests.post(url=API_ENDPOINT_FARM, json=serials)
        response = req.text
        print(response)
        serials = {}

