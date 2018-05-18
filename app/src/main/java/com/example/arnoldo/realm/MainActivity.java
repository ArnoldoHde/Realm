package com.example.arnoldo.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
EditText edtUserName,edtAge;
Button btnSave,btnBuscar;
Realm myRealm;//definimos el objeto Realm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRealm= Realm.getDefaultInstance();//algo me sale mal aqui
         /*instanciamos la variable creada
        y le decimos pasame la instancia ya que tenemos ya definida*/
        btnBuscar=findViewById(R.id.btnBuscar);
        edtUserName=findViewById(R.id.edtUserName);
        edtAge=findViewById(R.id.edtAge);
        btnSave=findViewById(R.id.btnSave);

        //metodo para realizar la busqueda
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
   /*muestrame los resultados que tengas en la clase Usuario..lo toma de clase generica por
                que especifica que los resuktados seran de tipo usuario..el ultimo metodo es p
                perteneciente a la clase realm y le especifica que se los muestre todos*/
                RealmResults<Usuario> usuarios= myRealm.where(Usuario.class).findAll();
                StringBuilder builder=new StringBuilder();/*es una forma de ir agregando cadenas a
                aalgunos elementos...que nos servira para mostrar los datos*/
                for (Usuario usuario:usuarios){
                    builder.append("Nombre del usuario"+usuario.getNombre());//obtenemos numero del usuario
                    builder.append("Edad del Usuario"+usuario.getEdad());

                }
                Log.e("TAG",builder.toString());

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

   //creamos la transaccion para que realm peda guardar los datos
               myRealm.executeTransaction(new Realm.Transaction() {
                   @Override
                   public void execute(Realm realm) {
                       Usuario myUsuario=myRealm.createObject(Usuario.class);
                       //creamos la instancia para acceder al metodo realm y crear un objeto, le paso como parametro la clase Uusario
                       myUsuario.setNombre(edtUserName.getText().toString());
                       //envimos el nombre del usuario desde la consola ha el modelo
                       myUsuario.setEdad(String.valueOf(Integer.parseInt(edtAge.getText().toString())));
                       //para enviarlo debemos convertirlo de cadena a entero por que el modelo asi lo espera
                       Toast.makeText(MainActivity.this, "Guaradao con Exito", Toast.LENGTH_SHORT).show();
                   }

               });
            }
        });
    }
}
