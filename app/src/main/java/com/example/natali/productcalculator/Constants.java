package com.example.natali.productcalculator;

public class Constants {
    public static final int TAB_CUT = 0;
    public static final int TAB_BR  = 1;
    public static final int TAB_MAN = 2;

    public static class URL{
        private static final String HOST = "http://86.62.72.22:8444/";//пока пишем локальный ip. Затем вынесем в настройку
        private static final String BASE = "Razrabotka/";
        public static final String CALC  = HOST + BASE + "hs/ListProducts/GETList";
    }

}
