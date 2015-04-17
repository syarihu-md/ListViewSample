package net.syarihu.test.listviewsample;

import java.util.List;

/**
 * Created by usr0200500 on 2015/04/17.
 */
public class Weather {
    List<Detail> list;
    City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Detail> getList() {
        return list;
    }

    public void setList(List<Detail> list) {
        this.list = list;
    }

    public class City {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Detail {
        private String dt;
        private Temp temp;

        public String getDt() {
            return dt;
        }

        public void setDt(String dt) {
            this.dt = dt;
        }

        public Temp getTemp() {
            return temp;
        }

        public void setTemp(Temp temp) {
            this.temp = temp;
        }

        public List<WeatherDetail> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherDetail> weather) {
            this.weather = weather;
        }

        List<WeatherDetail> weather;

        public class Temp {
            String max;
            public String getMax() {
                return max;
            }

            public void setMax(String max) {
                this.max = max;
            }
        }

        public class WeatherDetail {
            String icon;
            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
