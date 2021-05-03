package com.example.myapplication;

import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    RadioGroup radioGroup;
    RadioButton radioButton;// 选中的单选按钮
    EditText editText_username;
    EditText editText_password;
    EditText editText_password_validate;
    TextWatcher textWatcher;

    CheckBox checkbox_obj_swimming;
    CheckBox checkbox_obj_music;
    CheckBox checkbox_obj_reading;

    String spinner_value;
    String radioGroup_gender_value;
    String editText_text_username;
    String editText_text_password;
    String editText_text_validate;


    String checkbox_hobby_swimming;
    String checkbox_hobby_music;
    String checkbox_hobby_reading;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 获取组件并绑定布局文件对象
        FloatingActionButton fab = findViewById(R.id.fab);
        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup);
        editText_username = findViewById(R.id.editText_username);
        editText_password = findViewById(R.id.editText_password);
        editText_password_validate = findViewById(R.id.editText_password_validate);
        // CheckBox多选框——爱好栏对象
        checkbox_obj_swimming = findViewById(R.id.checkbox_swimming);
        checkbox_obj_music = findViewById(R.id.checkbox_music);
        checkbox_obj_reading = findViewById(R.id.checkbox_reading);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String[] academic = getResources().getStringArray(R.array.academic);
        //第二个参数是显示数据使用的布局文件的id
        //第三个参数是显示每个数据使用的布局中的TextView的 id
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, academic);

        /*
        * EditText获取数据的相关配置
        * */
        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Toast.makeText(MainActivity.this, "输入改变了1", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                Toast.makeText(MainActivity.this, "输入改变了2", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {

                editText_text_username = editText_username.getText().toString();
                editText_text_password = editText_password.getText().toString();
                editText_text_validate = editText_password.getText().toString();
                Toast.makeText(MainActivity.this, "输入改变了3", Toast.LENGTH_SHORT).show();

            }

        };
        /*
        * TextWatcher可以用来监听EditText的输入框内的所有改变，只要输入框内输入一个字符或者删除一
        *个字符都会执行下面的三个方法，输入或者删除n次执行n次监听，也就是输入或者删除n次，下面的
        *三个方法都会执行n次。
        * */
        editText_username.addTextChangedListener(textWatcher);
        editText_password.addTextChangedListener(textWatcher);
        editText_password_validate.addTextChangedListener(textWatcher);


        /*
        * RadioGroup的获取数据的相关配置
        * */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
                radioGroup_gender_value = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, radioGroup_gender_value, Toast.LENGTH_SHORT).show();
            }
        });

        /*
        *   spinner监听的相关设置
        **/
        spinner.setAdapter(adapter);
        //让第一个数据项已经被选中
        spinner.setSelection(0, true);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?>  adapterView, View view, int position, long id) {
                String[] academic = getResources().getStringArray(R.array.academic);

                spinner_value = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "你点击的是："+academic[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
                String sInfo = "什么都没有选";
                Toast.makeText(MainActivity.this, sInfo, Toast.LENGTH_SHORT).show();
            }

        });


        checkbox_obj_swimming.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    checkbox_hobby_swimming = checkbox_obj_swimming.getText().toString();
                    Toast.makeText(MainActivity.this, checkbox_hobby_swimming, Toast.LENGTH_SHORT).show();
                } else {
                    checkbox_hobby_swimming = " ";
                }
            }
        });

        checkbox_obj_music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    checkbox_hobby_music = checkbox_obj_music.getText().toString();
                    Toast.makeText(MainActivity.this, checkbox_hobby_music, Toast.LENGTH_SHORT).show();
                } else {
                    checkbox_hobby_music = " ";

                }
            }
        });


        checkbox_obj_reading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    checkbox_hobby_reading = checkbox_obj_reading.getText().toString();
                    Toast.makeText(MainActivity.this, checkbox_hobby_reading, Toast.LENGTH_SHORT).show();
                } else {
                    checkbox_hobby_reading = " ";

                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonSubmit(View view) {

        switch (view.getId()) {

            case R.id.button_second:
                Toast.makeText(MainActivity.this, "你的用户名:"+editText_text_username +
                        "\n"+"密码:"+editText_text_password+"\n"+"确认密码"+editText_text_validate+"\n"+
                        "你的学历是"+spinner_value+"\n"+"性别是："+radioGroup_gender_value+"\n"+"你的爱好是："+
                        checkbox_hobby_music+checkbox_hobby_swimming+checkbox_hobby_reading, Toast.LENGTH_LONG).show();

                break;

        }
    }


}
