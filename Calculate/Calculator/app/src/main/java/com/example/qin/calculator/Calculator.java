package com.example.qin.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends ActionBarActivity {

    private Button []num =new Button[10];
    private Button rid,add,sub,result,exc,clear,as,mod,rad;
    private TextView str ;
    private int option = 0;//运算符状态
    private boolean newdigital=true;//标记是否是新输入的数字
    private double firstNum=0,secondNum=0;//两个相加的数
    private double c;//表示取正负

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_view);
        rad =(Button)findViewById(R.id.rad);
        str = (TextView)findViewById(R.id.textView);
        rid =(Button)findViewById(R.id.rid);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        result = (Button)findViewById(R.id.result);
        exc = (Button)findViewById(R.id.exc);
        clear = (Button)findViewById(R.id.clear);
        as = (Button)findViewById(R.id.as);
        mod = (Button)findViewById(R.id.mod);
        num[0] = (Button)findViewById(R.id.button0);
        num[1] = (Button)findViewById(R.id.button1);
        num[2] = (Button)findViewById(R.id.button2);
        num[3] = (Button)findViewById(R.id.button3);
        num[4] = (Button)findViewById(R.id.button4);
        num[5] = (Button)findViewById(R.id.button5);
        num[6] = (Button)findViewById(R.id.button6);
        num[7] = (Button)findViewById(R.id.button7);
        num[8] = (Button)findViewById(R.id.button8);
        num[9] = (Button)findViewById(R.id.button9);
        ButtonListener listener = new ButtonListener();
        rad.setOnClickListener(listener);
        str.setOnClickListener(listener);
        rid.setOnClickListener(listener);
        add.setOnClickListener(listener);
        sub.setOnClickListener(listener);
        result.setOnClickListener(listener);
        exc.setOnClickListener(listener);
        clear.setOnClickListener(listener);
        as.setOnClickListener(listener);
        mod.setOnClickListener(listener);
        num[0].setOnClickListener(listener);
        num[1].setOnClickListener(listener);
        num[2].setOnClickListener(listener);
        num[3].setOnClickListener(listener);
        num[4].setOnClickListener(listener);
        num[5].setOnClickListener(listener);
        num[6].setOnClickListener(listener);
        num[7].setOnClickListener(listener);
        num[8].setOnClickListener(listener);
        num[9].setOnClickListener(listener);
    }
    class ButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            Button btu = (Button)v;
            String s = str.getText().toString();//获取文本框显示的字符串
            String t = (String)btu.getText().toString();
            if(btu.getId() == R.id.button0
                    || btu.getId() == R.id.button1
                    || btu.getId() == R.id.button2
                    || btu.getId() == R.id.button3
                    || btu.getId() == R.id.button4
                    || btu.getId() == R.id.button5
                    || btu.getId() == R.id.button6
                    || btu.getId() == R.id.button7
                    || btu.getId() == R.id.button8
                    || btu.getId() == R.id.button9 ){
                if(newdigital){
                    str.setText("");
                    str.setText(t);
                    newdigital = false;
                }
                else{
                    str.setText(s+t);
                    newdigital = false;
                }return;
            }
            if(btu.getId()==R.id.as)//改变数的正负性
            {
                if(s.length() == 0){
                    firstNum = 0;
                    secondNum = 0;
                    newdigital = true;
                    option = 0;
                    return ;
                }
                else if (s !=""){
                    c=Double.parseDouble(s);
                    str.setText(String.valueOf(-c));
                    return;
                }
            }
            if(btu.getId() == R.id.add){
                firstNum = Double.parseDouble(s);
                option=1;
                newdigital = true;
                return;
            }
            if(btu.getId() == R.id.sub){
                firstNum = Double.parseDouble(s);
                option = 2;
                newdigital = true;
                return;
            }
            if(btu.getId() == R.id.rid){
                firstNum = Double.parseDouble(s);
                option = 3;
                newdigital = true;
                return;
            }
            if(btu.getId() == R.id.exc){
                firstNum = Double.parseDouble(s);
                option = 4;
                newdigital = true;
                return;
            }
            if(btu.getId() == R.id.mod){
                firstNum = Double.parseDouble(s);
                option = 5;
                newdigital = true;
                return;
            }
            if(btu.getId() == R.id.clear){
                firstNum = 0;
                secondNum = 0;
                newdigital = true;
                option = 0;
                str.setText("");
                return;
            }
            if(btu.getId() == R.id.rad){
                if(s.length() == 0)
                {
                    str.setText("0.");
                    newdigital=false;
                }
                else if(s.indexOf(".") == -1)
                {
                    str.setText(s+".");
                }
                return;
            }
            if(btu.getId() == R.id.result){
                secondNum=Double.parseDouble(s);
                switch(option)
                {
                    case 1:
                        str.setText(String.valueOf(firstNum+secondNum));break;
                    case 2:
                        str.setText(String.valueOf(firstNum-secondNum));break;
                    case 3:
                        str.setText(String.valueOf(firstNum*secondNum));break;
                    case 4:
                    {
                        if(secondNum!=0){
                            str.setText(String.valueOf(firstNum/secondNum));}
                        else
                        {
                            Toast.makeText(Calculator.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                            str.setText("");
                            firstNum=0;
                            secondNum=0;
                            option=0;
                            newdigital=true;
                            return;
                        }
                        break;
                    }
                    case 5:
                        str.setText(String.valueOf(firstNum%secondNum));
                        break;

                }
                return;
            }
        }

    }

}