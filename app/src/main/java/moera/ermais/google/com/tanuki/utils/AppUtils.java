package moera.ermais.google.com.tanuki.utils;

import android.app.Application;

import moera.ermais.google.com.tanuki.API;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppUtils extends Application {

    private static API api;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.dev2.tanuki.ru/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        api = retrofit.create(API.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static API getApi() {
        return api;
    }
}
