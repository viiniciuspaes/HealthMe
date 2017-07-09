package mpoo.gui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import dao.UserDao;

public class RegisterActivity extends AppCompatActivity {
    EditText et_user = (EditText) findViewById(R.id.editText_register_login);
    EditText et_password = (EditText) findViewById(R.id.editText_register_password);
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

    }
    private void initViews() {
        resources = getResources();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        et_password.addTextChangedListener(textWatcher);
        et_user.addTextChangedListener(textWatcher);
    }
    public void clickInsert(){
        UserDao crud = new UserDao(getBaseContext());
        String userString = et_user.getText().toString();
        String passwordString = et_password.getText().toString();
        String output;

        //output = crud.insertRegister(userString,passwordString);


    }
}
