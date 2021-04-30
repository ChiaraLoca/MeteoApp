using MeteoAppSkeleton.Models;
using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace MeteoAppSkeleton.Controller
{
    public class ConnectionController
    {

        private static ConnectionController connectionController = null;
        private OpenWeatherMapUrl weatherUrl = new OpenWeatherMapUrl();
        private ConnectionController() { }
        public static ConnectionController getConnectionController()
        {
            if (connectionController == null)
                connectionController = new ConnectionController();
            return connectionController;
        }
        public String getWeatherByCoordinates(double lat, double lon)
        {
            return send(weatherUrl.getUrlByCoordinates(lat, lon));
        }
        public String getWeatherByCityName(String cityName)
        {
            return send(weatherUrl.getUrlByCityNames(cityName));
        }


        private String send(String urlstr)
        {

            String str = "";
            
            Task task = new Task(() => {
                str = AccessTheWebAsync(urlstr).Result;
            });
            task.Start();
            task.Wait();
            return str;

        }

        async Task<String> AccessTheWebAsync(String url)
        {
            /*Task<string> getStringTask = null;
            HttpClient client = new HttpClient();
            /*Task<string> getStringTask = client.GetStringAsync(url);
            string urlContents = await getStringTask;

            HttpResponseMessage response = null;
            response = await client.GetAsync(url);
            if (response.StatusCode == HttpStatusCode.OK)
                getStringTask= response;
            return null;*/

            HttpClient client = new HttpClient();
            HttpResponseMessage response = null;
            response = await client.GetAsync(url);
            if (response.StatusCode == HttpStatusCode.OK)
            {
                Task<string> getStringTask = client.GetStringAsync(url);
                string urlContents = await getStringTask;
                return urlContents;
                //return response.Content.ReadAsStringAsync().ToString();
            }
            return "";

        }




    }
}