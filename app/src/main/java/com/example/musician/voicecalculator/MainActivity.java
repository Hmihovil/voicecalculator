package com.example.musician.voicecalculator;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private EditText textView2;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private TextView textView3;
    String str,string="";
    String res,prevans="";
    int[] number;
    int len;
    TextToSpeech textToSpeech;
    private Button b1,b2,b0,b00,b3,b4,b5,b6,b7,b8,b9,bc,bdel,bplus,bmin,be,bmul,bdiv;
    private Button imageButton;
    Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if ( Build.VERSION.SDK_INT >= 23) {
            CheckUserPermsions();
           // checkpermission();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2=(EditText) findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        imageButton=(Button)findViewById(R.id.imageButton);
        textView2.setRawInputType(InputType.TYPE_CLASS_TEXT);
        textView2.setTextIsSelectable(true);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b0=(Button)findViewById(R.id.b0);
        b00=(Button)findViewById(R.id.b00);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b7=(Button)findViewById(R.id.b7);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        bc=(Button)findViewById(R.id.bc);
        bdel=(Button)findViewById(R.id.bdel);
        bplus=(Button)findViewById(R.id.bplus);
        bmin=(Button)findViewById(R.id.bmin);
        be=(Button)findViewById(R.id.be);
        bmul=(Button)findViewById(R.id.bmul);
        bdiv=(Button)findViewById(R.id.bdiv);
        aSwitch=(Switch)findViewById(R.id.switch1);

        final sharedpref yourPrefrence = sharedpref.getInstance(getApplicationContext());
        boolean b=yourPrefrence.getData("switch");
        if(b==true){
            aSwitch.setChecked(true);
        }
        if(b=false){
            aSwitch.setChecked(false);
        }

        textView2.setShowSoftInputOnFocus(false);
        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("0", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"0" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("dot", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"." +str2);
                textView2.setSelection(curPos+1);
                textView2.setSelection(curPos+1);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("1", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"1" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("2", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();

                String str1 = (String) str.substring(0, curPos);


                String str2 = (String) str.substring(curPos);


                textView2.setText(str1+"2" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("3", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"3" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("4", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"4" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("5", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"5" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("6", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"6" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("7", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"7" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("8", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"8" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("9", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"9" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("+", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"+" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        bmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("Subtract", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"-" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("Multiply", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"*" +str2);
                textView2.setSelection(curPos+1);
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("divide", TextToSpeech.QUEUE_FLUSH, null);
                }
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+"/" +str2);
                textView2.setSelection(curPos+1);
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("Clear", TextToSpeech.QUEUE_FLUSH, null);
                }
                textView2.setText("");
                textView3.setText("");
                str="";
                string="";
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    yourPrefrence.checked();

                }
                if(isChecked==false){
                    yourPrefrence.nochecked();

                }
                // do something, the isChecked will be
                // true if the switch is in the On position
            }
        });
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("delete", TextToSpeech.QUEUE_FLUSH, null);
                }
                if(!(TextUtils.isEmpty(textView2.getText().toString()))){
                int curPos = textView2.getSelectionStart();
                String str = textView2.getText().toString();
                String str1 = (String) str.substring(0, curPos-1);
                String str2 = (String) str.substring(curPos);
                textView2.setText(str1+str2);
                textView2.setSelection(curPos-1);}
            }
        });

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aSwitch.isChecked()) {
                    textToSpeech.speak("answer", TextToSpeech.QUEUE_FLUSH, null);
                }
                start();
                textView2.setSelection(textView2.getText().length());
                textView2.setText("");
                str="";
                res="";
                string="";
            }
        });


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("");
                textView2.setHint("speak something....");
                str="";
                string="";
               btntopenmic();
            }
        });


    }

    private void btntopenmic(){

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"speech to Text");
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault());
        startActivityForResult(intent,100);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 100:{
                if(resultCode==RESULT_OK&&null!=data){
                    ArrayList<String> match = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    str=match.get(0);
                }
                break;
            }
        }
        str.replaceAll("answer",prevans);
        str.replaceAll("devided","/");
        str.replaceAll("plus","+");
        str.replaceAll("minus","-");
        str.replaceAll("devided by","/");
        str.replaceAll("multiplied by","*");
        textView2.setText(str);
        start();

    }
    public void start(){

        str = textView2.getText().toString();

        len = str.length();
        space();
        str=string;

        if(check(str)){
            Toast.makeText(getApplicationContext(),"please ...try again",Toast.LENGTH_LONG).show();

        }
        else {
            textView2.setText(str);
            len = str.length();

            MyAndroidThread myTask = new MyAndroidThread(MainActivity.this,str);
            Thread t1 = new Thread(myTask, "Bajrang");
            t1.start();


        }
    }










    void CheckUserPermsions(){

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) !=
                    PackageManager.PERMISSION_GRANTED  ){
                requestPermissions(new String[]{
                                Manifest.permission.RECORD_AUDIO},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return ;
            }


    }





    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    break;
                } else {
                    // Permission Denied
                    Toast.makeText( this,"permission denied" , Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


















    public int toint(String a){

        return (Integer.parseInt(a));

    }

    public boolean check(String a){
        int l =a.length();
        for(int b=0;b<l;b++){
            if(Character.isLetter(a.charAt(b))||a.charAt(0)=='+'||a.charAt(0)=='-'||a.charAt(0)=='*'||a.charAt(0)=='/'){
                return true;

            }
        }
        return false;
    }




    public void space(){
        for(int c=0;c<len;c++){
            if(!(str.charAt(c)==' ')){
                string=string+str.charAt(c);
            }

        }
    }









    class MyAndroidThread implements Runnable
    {
        String equation;
        Activity activity;
        public MyAndroidThread(Activity activity,String equation)
        {
            this.activity = activity;
            this.equation = equation;
        }

        @Override
        public void run()
        {
            Double result = 0.0;

            String noMinus = equation.replace("-", "+-");
            String[] byPluses = noMinus.split("\\+");

            for (String multipl : byPluses) {
                String[] byMultipl = multipl.split("\\*");
                double multiplResult = 1.0;
                for (String operand : byMultipl) {
                    if (operand.contains("/")) {
                        String[] division = operand.split("\\/");
                        double divident = Double.parseDouble(division[0]);
                        for (int i = 1; i < division.length; i++) {
                            divident /= Double.parseDouble(division[i]);
                        }
                        multiplResult *= divident;
                    } else {
                        multiplResult *= Double.parseDouble(operand);
                    }
                }
                result += multiplResult;
            }

            //perform heavy task here and finally update the UI with result this way -
            final Double finalResult = result;
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    res = Double.toString(finalResult);

                    textView3.setText(res);
                    if (aSwitch.isChecked()) {
                        textToSpeech.speak(res, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }

    }

    @Override
    protected void onPause() {
        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}





