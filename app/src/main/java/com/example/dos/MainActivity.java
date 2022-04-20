package com.example.dos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  // ATRIBUTOS => VARIABLE

    // atributos que repredenten cada elemento visual que diseñan
    //NOTA: elemneto visual que van a usar por codigo
    private TextView txtresultado;
    private Button BtnInvertir;
    private EditText TBNombre, TBCelular;

    //atributos de clase
    private String Nombre;
    private int Celular;

    //METODOS => FUNCIONES
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inicializarVistas();
        /*
        Para configura el boton y decirle que este pendiente al evento click que se haga sobre el boton usamos un metodo de tipo SETTER....
        y en realidd ustedes quieren configurar un concepto llamado Listener => algo que este pendiente a que pase cierto elemento
         */
        BtnInvertir.setOnClickListener(this);
    }

    private void inicializarVistas() {
        /*Se define el enlace de sus variables o atributos con sus componentes visuales que han diseñado en pantalla
        * inicializamos sus vistas-> referencia de View a una variable*/

        txtresultado = findViewById(R.id.txtresultado);
        TBNombre = findViewById(R.id.TBNombre);
        TBCelular = findViewById(R.id.TBCelular);
        BtnInvertir = findViewById(R.id.BtnInvertir);
    }

    private void ObtenerInformacionUsuario() {
      /*
      Para obtener la infromacion que el usuario introduce a campos de texto ustedes van a obtener esos valores del
      atributo text que esta presente en el diseñador de ese componente
      y para obtener algo POO con JAVA se usa su buen amigo GETTER
      obtener texto de EditText => .getText();
       */

        Nombre = TBNombre.getText().toString();
        String CelularText = TBCelular.getText().toString();

        Celular=Integer.parseInt(CelularText);
    }

    private void invertirNumero(){
        int resto =0, invertido =0;
        while(this.Celular > 0){
            resto = this.Celular %0;
            invertido = invertido * 10 + resto;
            this.Celular = this.Celular /10;
        }

        txtresultado.setText("Valor invertido: " + invertido);
    }

    /*Metodo para invertir una cadeni de Textoo"

     */

    private void invertirTexto(){
        String invertido ="";
        //metodo en los estrunf que les permite acceder a cada letra de la cadena y devuelve como un carrracter simple

        for(int i = this.Nombre.length()-1; i>=0; i--){
            invertido += this.Nombre.charAt((i));
        }

        txtresultado.setText(invertido);
    }

    @Override
    public void onClick(View view) {
        ObtenerInformacionUsuario();
        invertirNumero();
    }
}