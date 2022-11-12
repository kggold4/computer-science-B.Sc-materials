import requests

from kg_logger.kg_logger import KGLogger


class GooglePlacesAPI:
    def __init__(self):
        self.logger = KGLogger()

    def geocode_api(self):
        output_format = "json"
        parameters = "address=24%20Sussex%20Drive%20Ottawa%20ON"
        try:
            r = requests.get(f"https://maps.googleapis.com/maps/api/geocode/{output_format}?{parameters}")
            if r.status_code == 200:
                print(r.json())
            else:
                self.logger.warning(f"Status code is {r.status_code}")
        except Exception as e:
            self.logger.error(f"Error requests to geocode api - {str(e)}")


if __name__ == '__main__':
    gp_api = GooglePlacesAPI()
    gp_api.geocode_api()
