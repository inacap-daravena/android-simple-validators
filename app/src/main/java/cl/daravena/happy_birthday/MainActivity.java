package cl.daravena.happy_birthday;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    // 1. Creamos la variable
    TextView textView;
    EditText txtNombre;
    EditText txtFecha;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date mydate = new Date(2023,12,16);
    // 2. Le asignamos la instancia
        textView = findViewById(R.id.textView);
        txtNombre = findViewById(R.id.txtNombre);
        txtFecha = findViewById(R.id.txtFecha);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            //validarFecha();
            validarCorreo();
        });
    }

    public void validarNombre() {
        String nombre = txtNombre.getText().toString();

        if (nombre.equals("Diego Aravena")) {
            Toast.makeText(this, "Saludos a Diego Aravena!", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(this, "Usuario no reconocido", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private Pattern formatoFecha = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}");

    public void validarFecha() {
        if (formatoFecha.matcher(txtFecha.getText().toString()).matches()) {
            Toast.makeText(this, "Fecha valida", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(this, "Fecha no valida :c", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private Pattern formatoCorreo = Pattern.compile("^(.+)@(.+)");

    public void validarCorreo() {
        if(formatoCorreo.matcher(txtNombre.getText().toString()).matches()) {
            Toast.makeText(this, "Es un correo valido", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(this, "Es un correo no valido :c", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void onClickBoton(View view) {
        Toast.makeText(this, "Saludos al usuario!", Toast.LENGTH_SHORT)
                .show();
        //3. Alteramos sus atributos
        textView.setText("Hola Mundo");
    }

    // NO COPIAR
    public Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        return cal;
    }

    public int getDifferenceYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);

        int diff = Math.abs(b.get(YEAR) - a.get(YEAR));
        if (a.get(MONTH) > b.get(MONTH) ||
        (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }

        return diff;
    }
}