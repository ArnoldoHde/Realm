package com.example.arnoldo.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by arnoldo on 18/05/18.
 */
//se extiende y se sobre escribe el metodo para no tener que estar repitiendo en cada clase la configuracion
public class ConfiguracionRealm extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration=new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
    }
}
